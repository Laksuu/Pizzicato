package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import pizzicato.model.Asiakas;
import pizzicato.model.Pizza;
import pizzicato.model.Tilaus;
import pizzicato.model.Tilausrivi;

public class TilausDAO extends DataAccessObject {
	
	public void addTilaus(Tilaus tilaus) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		// Muokkaa vielä findAll ja read uuden kannan mukaisiksi. poista kommentti kun tehty
		
		try {
			connection = getConnection();
			//uusi tilaus tietokantaan
			String sqlInsert = "INSERT INTO tilaus(toimitus, maksu, nimi, osoite, puh, sposti) VALUES (?, ?, ?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			/* Kaksi allaolevaa jos asiakkaalle rekisteröityminen, tallessa jos muutos, älä poista
			 Samoin import asiakas kommenttina. Älä poista tätä kommenttia kun DAO korjattu, vaan vasta
			 jos asiakas tippuu kokonaan pois.
			 
			 Asiakas asiakas = tilaus.getAsiakas();
			 stmtInsert.setInt(1, asiakas.getAsiakas_id());
			 */
			stmtInsert.setBoolean(1, tilaus.isToimitus());
			stmtInsert.setBoolean(2, tilaus.isMaksu());
			stmtInsert.setString(3, tilaus.getNimi());
			stmtInsert.setString(4, tilaus.getOsoite());
			stmtInsert.setInt(5, tilaus.getPuh());
			stmtInsert.setString(6, tilaus.getSposti());
			stmtInsert.executeUpdate();
			
			for (int i = 0; i < tilaus.getTilausrivit().size(); i++) {
				
				Tilausrivi tilausrivi = tilaus.getTilausrivi(i);
				Pizza pizza = tilausrivi.getPizza();
				 
				
				sqlInsert = "INSERT INTO tilausrivi(pizza_id, tilaus_id, maara, extramauste, rivihinta) VALUES (?,last_insert_id(),?.?,?)";
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtInsert.setInt(1, pizza.getPizza_id());
				stmtInsert.setInt(3, tilausrivi.getMaara());
				stmtInsert.setInt(4, tilausrivi.getExtramauste());
				stmtInsert.setDouble(5, tilausrivi.getRivihinta());
				stmtInsert.executeUpdate();
				
			
			}
			
			System.out.println("tilaus ja tilausrivit lisätty");
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection);
		}
		
	}
	
	//findAll hakee tilaukset
	public ArrayList<Tilaus> findAll(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>();
		Tilaus tilaus = null;
		int edellinenTilausId = 0;
		int nykyinenTilausId = 0;
		Tilausrivi tilausrivi = null;
		
		
		try{
			conn = getConnection();
			String sqlSelect = "SELECT t.tilaus_id, t.pvm, t.toimitus, t.maksu, t. nimi, t.osoite, t.puh, t.sposti, r.tilausrivi_id, r.pizza_id, r.tilaus_id, r.maara, r.extramauste FROM tilaus t JOIN tilausrivi r ON r.tilaus_id = t.tilaus_id;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery(sqlSelect);
			while (rs.next()){
				nykyinenTilausId = rs.getInt("tilaus_id");
				
				if (nykyinenTilausId != edellinenTilausId){
					tilaus = readTilaus(rs);
					tilaukset.add(tilaus);
					edellinenTilausId = nykyinenTilausId;
				}
				tilausrivi = readTilausrivi(rs);
				tilaus.addTilausrivi(tilausrivi);
					
				}
			}catch (SQLException e){
				throw new RuntimeException(e);
			}finally {
				close(rs, stmt, conn);
			}
		
		return tilaukset;
		}

	
	private Tilaus readTilaus(ResultSet rs){
		try {
			int tilaus_id = rs.getInt("tilaus_id");
			
			/*Säilytä tämä kommentti toistaiseksi, jos asiakasrekisteröityminen tulee
			  int asiakas_id = rs.getInt("asiakas_id");
			Asiakas asiakas = new Asiakas();
			asiakas.setAsiakas_id(asiakas_id);
			*/
			
			Date pvm = rs.getDate("pvm");
			boolean toimitus = rs.getBoolean("toimitus");
			boolean maksu = rs.getBoolean("maksu");
			String nimi = rs.getString("nimi");
			String osoite = rs.getString("osoite");
			int puh = rs.getInt("puh");
			String sposti = rs.getString("sposti");

			
			
			return new Tilaus(tilaus_id, pvm, toimitus, maksu, nimi, osoite, puh, sposti);
		
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void poista(Integer tilaus_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM tilaus WHERE tilaus_id = ?";
			pstmt = conn.prepareStatement(sql);
			int p;
			pstmt.setInt(1, tilaus_id);
			p = pstmt.executeUpdate();
			if (p != 1){
				System.out.println("noup");
				
			}
			
			sql = "DELETE FROM tilausrivi WHERE tilaus_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tilaus_id);
			p = pstmt.executeUpdate();
			if (p != 1) {
				System.out.println("noup");
			}
			
			pstmt.close();
			
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}
	
	private Tilausrivi readTilausrivi(ResultSet rs){
		try {
			int tilausrivi_id = rs.getInt("tilausrivi_id");
			int maara = rs.getInt("maara");
			int pizza_id = rs.getInt("pizza_id");
			Pizza pizza = new Pizza();
			pizza.setPizza_id(pizza_id);
			int extramauste = rs.getInt("extramauste");
			double rivihinta = rs.getDouble("rivihinta");
			
			return new Tilausrivi(tilausrivi_id, maara, pizza, extramauste, rivihinta);
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}


