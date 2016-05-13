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

	// hakee kaikki pizzat täytteineen
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
			// Lähetetään komento:
			rs = stmt.executeQuery(sqlSelect);
			// Käydään tulostaulun rivit läpi ja luetaan read()-metodilla:
			while (rs.next()) {
				nykyinenPizzaId = rs.getInt("pizza_id");

				// -> jos pizza_id vaihtuu tee uusi pizzaolio
				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(rs);
					// lisätään pizza listaan
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
				}
				// -> tee uusi täyteolio
				tayte = readTayte(rs);
				// -> lisää täyteolio pizzan täytelistaan (arraylist pizza.java
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
			// Lähetetään komento:
			rs = stmt.executeQuery(sqlSelect);
			// Käydään tulostaulun rivit läpi ja luetaan read()-metodilla:
			while (rs.next()) {
				nykyinenPizzaId = rs.getInt("pizza_id");

				// -> jos pizza_id vaihtuu tee uusi pizzaolio
				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(rs);
					// lisätään pizza listaan
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
				}
				// -> tee uusi täyteolio
				tayte = readTayte(rs);
				// -> lisää täyteolio pizzan täytelistaan (arraylist pizza.java
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
			// (ResultSet-tyyppinen rs-olion) aktiiviselta tietoriviltä
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

			String sql = "DELETE FROM pizzantayte WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);
			p = pstmt.executeUpdate();
			if (p != 1) {
				System.out.print("virhe");
			}

			sql = "DELETE FROM pizza WHERE pizza_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza_id);
			p = pstmt.executeUpdate();
			if (p != 1) {
				System.out.print("virhe");
			}

			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}

	public void muokkaa(Pizza pizza) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "UPDATE pizza SET nimi=?, hinta=? WHERE pizza_id=?";

			pstmt = conn.prepareStatement(sql);
			int p = 1;
			pstmt.setString(1, pizza.getNimi());
			pstmt.setDouble(2, pizza.getHinta());
			pstmt.setInt(3, pizza.getPizza_id());
			p = pstmt.executeUpdate();
			if (p != 1) {
				System.out.print("virhe");
			}
			System.out.println("Rows inserted succesfully!");

			sql = "DELETE FROM pizzantayte WHERE pizza_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pizza.getPizza_id());
			pstmt.executeUpdate();
			for (int i = 0; i < pizza.getTaytteet().size(); i++) {

				Tayte tayte = pizza.getTaytteet().get(i);

				sql = "INSERT INTO pizzantayte(pizza_id, tayte_id) VALUES (?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pizza.getPizza_id());
				pstmt.setInt(2, tayte.getTayte_id());
				pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn); // Suljetaan statement ja yhteys
		}

		close(pstmt, conn);

	}

	// read tayte ilman hintaa, koska hintaa ei tässä haeta
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

			// Luodaan sql stringistä statement ja suoritetaan sql haku
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

// String sql = "UPDATE pizza SET nimi='?', hinta='?' WHERE pizza_id='?'";

/*
 * Connection connection = null; PreparedStatement stmtInsert = null;
 * 
 * try { // Luodaan yhteys ja aloitetaan transaktio: connection =
 * getConnection(); //Luodaan uusi pizza tietokantaan: String sqlInsert =
 * "INSERT INTO pizza(nimi, hinta) VALUES (?, ?)"; stmtInsert =
 * connection.prepareStatement(sqlInsert); stmtInsert.setString(1,
 * pizza.getNimi()); stmtInsert.setDouble(2, pizza.getHinta());
 * stmtInsert.executeUpdate();
 * 
 * System.out.println("Rows inserted succesfully!");
 */
/*
 * Connection conn = null; PreparedStatement pstmt = null;
 * 
 * try { conn = getConnection(); String sql =
 * "UPDATE pizza SET nimi='?', hinta='?' WHERE pizza_id='?'"; pstmt =
 * conn.prepareStatement(sql); int p = 1; pstmt.setInt(p++,
 * pizza.getPizza_id()); pstmt.setString(p++, pizza.getNimi());
 * pstmt.setDouble(p++, pizza.getHinta()); p = pstmt.executeUpdate(); if (p !=
 * 1) { System.out.print("virhe"); }
 * System.out.println("Rows inserted succesfully!");
 * 
 * } catch (SQLException e) { throw new RuntimeException(e); } finally {
 * close(pstmt, conn); // Suljetaan statement ja yhteys }
 * 
 * close(pstmt, conn);
 * 
 * }
 */
