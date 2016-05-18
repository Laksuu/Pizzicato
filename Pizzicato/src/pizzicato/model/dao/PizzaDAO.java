package pizzicato.model.dao;

import java.sql.Connection;
// import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pizzicato.model.Ostos;
import pizzicato.model.Pizza;
import pizzicato.model.Tayte;

public class PizzaDAO extends DataAccessObject {

	public void addPizza(Pizza pizza) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			// Luodaan uusi pizza tietokantaan:
			String sqlInsert = "INSERT INTO pizza(nimi, hinta) VALUES (?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, pizza.getNimi());
			stmtInsert.setDouble(2, pizza.getHinta());
			stmtInsert.executeUpdate();

			for (int i = 0; i < pizza.getTaytteet().size(); i++) {

				Tayte tayte = pizza.getTaytteet().get(i);

				sqlInsert = "INSERT INTO pizzantayte(pizza_id, tayte_id) VALUES (last_insert_id(), ?)";
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtInsert.setInt(1, tayte.getTayte_id());
				stmtInsert.executeUpdate();

			}

			System.out.println("Rows inserted succesfully!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

	// hakee kaikki pizzat t‰ytteineen
	public ArrayList<Pizza> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		Pizza pizza = null;
		int edellinenPizzaId = 0;
		int nykyinenPizzaId = 0;
		Tayte tayte = null;

		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit -taulusta
			String sqlSelect = "SELECT p.pizza_id, p.nimi, p.hinta, t.tayte_id, t.tayte FROM pizza p JOIN pizzantayte x ON x.pizza_id = p.pizza_id JOIN tayte t ON t.tayte_id = x.tayte_id WHERE p.piilotettu = '0';";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery(sqlSelect);
			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			while (rs.next()) {
				nykyinenPizzaId = rs.getInt("pizza_id");

				// -> jos pizza_id vaihtuu tee uusi pizzaolio
				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(rs);
					// lis‰t‰‰n pizza listaan
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
				}
				// -> tee uusi t‰yteolio
				tayte = readTayte(rs);
				// -> lis‰‰ t‰yteolio pizzan t‰ytelistaan (arraylist pizza.java
				// -> add metodi pizzaluokassa)
				pizza.addTayte(tayte);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return pizzat;
	}

	public List<Pizza> findAllHidden() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		Pizza pizza = null;
		int edellinenPizzaId = 0;
		int nykyinenPizzaId = 0;
		Tayte tayte = null;
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit -taulusta
			String sqlSelect = "SELECT p.pizza_id, p.nimi, p.hinta, t.tayte_id, t.tayte FROM pizza p JOIN pizzantayte x ON x.pizza_id = p.pizza_id JOIN tayte t ON t.tayte_id = x.tayte_id WHERE p.piilotettu = '1';";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery(sqlSelect);
			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			while (rs.next()) {
				nykyinenPizzaId = rs.getInt("pizza_id");

				// -> jos pizza_id vaihtuu tee uusi pizzaolio
				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(rs);
					// lis‰t‰‰n pizza listaan
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
				}
				// -> tee uusi t‰yteolio
				tayte = readTayte(rs);
				// -> lis‰‰ t‰yteolio pizzan t‰ytelistaan (arraylist pizza.java
				// -> add metodi pizzaluokassa)
				pizza.addTayte(tayte);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return pizzat;
	}

	private Pizza readPizza(ResultSet rs) {
		try {
			// Haetaan yhden pizzan tiedot kyselyn tulostaulun
			// (ResultSet-tyyppinen rs-olion) aktiiviselta tietorivilt‰
			int pizza_id = rs.getInt("pizza_id");
			String nimi = rs.getString("nimi");
			double hinta = rs.getDouble("hinta");

			return new Pizza(pizza_id, nimi, hinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void piilota(int pizza_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "UPDATE pizza SET piilotettu = '1' WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);
			if (pstmt.executeUpdate() != 1) {
				throw new RuntimeException("Paska SQL piilottaminen");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}

	public void poistaPiilotus(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "UPDATE pizza SET piilotettu = '0' WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() != 1) {
				throw new RuntimeException(
						"Paska SQL piilottamisen poistaminen");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}

	public void poista(Integer pizza_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int p;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			String sql = "DELETE FROM pizzantayte WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);
			p = pstmt.executeUpdate();
			System.out.println("pizzan poisto ep‰onnistui virhekoodi on" + p);
			if (p == 0) { // 0 tarkoittaa pizzantaytteen (ja pizzan) poisto
							// ep‰onnistui
				System.out.print("virhe");
			}

			sql = "DELETE FROM pizza WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);
			p = pstmt.executeUpdate();
			if (p == 0) {
				System.out.print("virhe");
			}

			conn.commit();
			pstmt.close();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(pstmt, conn);
		}
	}

	public void muokkaa(Pizza pizza) {
		// alustetaan tiedot tietokantayhteyden luomista varten
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// luodaan yhteys tietokantaan
			conn = getConnection();
			// p‰ivitet‰‰n valitunpizzan nimi ja hintatiedot tietokantaan
			String sql = "UPDATE pizza SET nimi=?, hinta=? WHERE pizza_id=?";
			// preparedstatement p‰ivitt‰‰ tiedot ? kerrallaan
			pstmt = conn.prepareStatement(sql);
			int p = 1;
			pstmt.setString(1, pizza.getNimi());
			pstmt.setDouble(2, pizza.getHinta());
			pstmt.setInt(3, pizza.getPizza_id());

			// preparedstatement sulkee tietojen lis‰yksen ja est‰‰
			// tietop‰ivityslis‰ykset,
			// eli kantaan ei p‰‰se k‰siksi "ulkoa" t‰m‰n kautta
			p = pstmt.executeUpdate();

			// poistetaan muokattavana olevan pizzan t‰ytteet kannasta
			sql = "DELETE FROM pizzantayte WHERE pizza_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza.getPizza_id());
			pstmt.executeUpdate(); // preparedstatement sulkee kannan
									// p‰ivityksen

			// lis‰t‰‰n muokatulle pizzalle uudet t‰ytteet
			// for silmukka pyˆr‰ht‰‰ niin kauan kun t‰ytteit‰ valittuna
			for (int i = 0; i < pizza.getTaytteet().size(); i++) {
				// luodaan pizzan t‰yteolio ja lis‰t‰‰n siihen t‰ytteit‰
				Tayte tayte = pizza.getTaytteet().get(i);

				// preparedstatement vahtii taas uusien t‰ytteiden lis‰‰mist‰
				// ja pizzant‰yte tauluun lis‰t‰‰n tietueita
				// samalla kun t‰yteolio saa t‰ytteit‰ yll‰
				sql = "INSERT INTO pizzantayte(pizza_id, tayte_id) VALUES (?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pizza.getPizza_id());
				pstmt.setInt(2, tayte.getTayte_id());
				pstmt.executeUpdate(); // preparedstatement sulkee kannan
										// p‰ivityksen

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn); // Suljetaan statement ja myˆs yhteys
		}

		close(pstmt, conn);

	}

	// read tayte ilman hintaa, koska hintaa ei t‰ss‰ haeta
	private Tayte readTayte(ResultSet rs) {
		try {
			// yhden tiedot haetaan
			int tayte_id = rs.getInt("tayte_id");
			double tayte_hinta = 0.00;
			String tayte = rs.getString("tayte");
			// luodaan uusi ja palautetaan
			return new Tayte(tayte_id, tayte_hinta, tayte);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Pizza etsiPizza(int pizza_id) {

		Pizza pizza = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int edellinenPizzaId = 0;
		int nykyinenPizzaId = 0;
		Tayte tayte = null;
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		ResultSet rs = null;

		try {
			// avataan yhteys tietokantaan
			conn = getConnection();

			// Luodaan sql stringist‰ statement ja suoritetaan sql haku
			String sql = "SELECT p.pizza_id, p.nimi, p.hinta, t.tayte_id, t.tayte FROM pizza p JOIN pizzantayte x ON x.pizza_id = p.pizza_id JOIN tayte t ON t.tayte_id = x.tayte_id where p.pizza_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				nykyinenPizzaId = rs.getInt("pizza_id");

				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(rs);
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
				}

				tayte = readTayte(rs);
				pizza.addTayte(tayte);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		} // Suljetaan statement ja yhteys

		close(pstmt, conn);
		// palautetaan saatu tulos

		return pizza;
	}
}
