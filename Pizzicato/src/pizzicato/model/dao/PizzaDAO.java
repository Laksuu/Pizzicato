
package pizzicato.model.dao;

import java.sql.Connection;
// import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pizzicato.model.Pizza;

public class PizzaDAO extends DataAccessObject {

	public void addPizza(Pizza pizza) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;	
	
		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			//Luodaan uusi pizza tietokantaan:
			String sqlInsert = "INSERT INTO pizza(nimi, hinta) VALUES (?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, pizza.getNimi());
			stmtInsert.setDouble(2, pizza.getHinta());
			stmtInsert.executeUpdate();
			
			System.out.println("Rows inserted succesfully!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}
	
	public ArrayList<Pizza> findAll() {	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		Pizza pizza = null; 
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit -taulusta
			String sqlSelect = "SELECT pizza_id, nimi, hinta FROM pizza WHERE piilotettu = '0';";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery(sqlSelect);
			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			while (rs.next()) {
				pizza = readPizza(rs);
				// lis‰t‰‰n pizza listaan
				pizzat.add(pizza);
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
		List<Pizza> pizzat = new ArrayList<Pizza>();
		Pizza pizza = null; 
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit -taulusta
			String sqlSelect = "SELECT pizza_id, nimi, hinta FROM pizza WHERE piilotettu = 1;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery(sqlSelect);
			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			while (rs.next()) {
				pizza = readPizza(rs);
				// lis‰t‰‰n pizza listaan
				pizzat.add(pizza);
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
				// Haetaan yhden pizzan tiedot kyselyn tulostaulun (ResultSet-tyyppinen rs-olion) aktiiviselta tietorivilt‰
				int pizza_id = rs.getInt("pizza_id");
				String nimi = rs.getString("nimi");
				double hinta = rs.getDouble("hinta");
				//  Luodaan ja palautetaan uusi pizza
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
					throw new RuntimeException("Paska SQL piilottamisen poistaminen");
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
			try {
				conn = getConnection();
				String sql = "DELETE FROM pizza WHERE pizza_id = ?";
				pstmt = conn.prepareStatement(sql);
				int p;
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
		
		   public void muokkaa (Pizza pizza) {
			      Connection conn = null;
			      PreparedStatement pstmt = null;
			      
			     try {
			      conn = getConnection();
			      String sql = "UPDATE pizza SET " + 
			      "nimi=?, hinta=? WHERE pizza_id=?";
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
			    
			   } catch (SQLException e) {
			    throw new RuntimeException(e);
			   } finally {
			    close(pstmt, conn); // Suljetaan statement ja yhteys
			   }
			  
			             close(pstmt, conn);
			          
			   }
			    
			}

//  String sql = "UPDATE pizza SET nimi='?', hinta='?' WHERE pizza_id='?'";
		
/*		Connection connection = null;
		PreparedStatement stmtInsert = null;	
	
		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			//Luodaan uusi pizza tietokantaan:
			String sqlInsert = "INSERT INTO pizza(nimi, hinta) VALUES (?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, pizza.getNimi());
			stmtInsert.setDouble(2, pizza.getHinta());
			stmtInsert.executeUpdate();
			
			System.out.println("Rows inserted succesfully!");
			*/
/*
Connection conn = null;
PreparedStatement pstmt = null;

try {
conn = getConnection();
String sql = "UPDATE pizza SET nimi='?', hinta='?' WHERE pizza_id='?'";
pstmt = conn.prepareStatement(sql);
int p = 1;
	pstmt.setInt(p++, pizza.getPizza_id());
  pstmt.setString(p++, pizza.getNimi());
  pstmt.setDouble(p++, pizza.getHinta());
	p = pstmt.executeUpdate();
	if (p != 1) {
		System.out.print("virhe");
	}  
System.out.println("Rows inserted succesfully!");

} catch (SQLException e) {
throw new RuntimeException(e);
} finally {
close(pstmt, conn); // Suljetaan statement ja yhteys
}

       close(pstmt, conn);
    
}*/
