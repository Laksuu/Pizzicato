package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pizzicato.model.Tayte;

public class TayteDAO extends DataAccessObject{
	
	public void addTayte(Tayte tayte) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		try {
			//yhteyden luonti, transaktion alku:
			connection = getConnection();
			//luodaan uusi t‰yte
			String sqlInsert = "INSERT INTO tayte(hinta, tayte) VALUES (?,?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setDouble(1, tayte.getTayte_hinta());
			stmtInsert.setString(2, tayte.getTayte());
			stmtInsert.executeUpdate();
			
			System.out.println("Tayte inserted succesfully!");
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); //suljetaan statement & yhteys
		}
	}
	
	public ArrayList<Tayte> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		Tayte tayte = null;
		try {
			// luodaan yhteys
			conn = getConnection();
			//luodaan komento: haetaan rivit taulusta
			String sqlSelect = "SELECT tayte_id, hinta, tayte FROM tayte WHERE piilotettu = '0';";
			// valmistellaan komento
			stmt = conn.prepareStatement(sqlSelect);
			// l‰hetet‰‰ komento
			rs = stmt.executeQuery(sqlSelect);
			//k‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read
			while (rs.next()){
				tayte = readTayte(rs);
				//lisataan listaan
				taytteet.add(tayte);
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); //suljetaan
		}
		return taytteet;
	}
	
	public List<Tayte> findAllHidden(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Tayte> taytteet = new ArrayList<Tayte>();
		Tayte tayte = null;
		try {
			//luodaan yhteys, komento jne..
			conn = getConnection();
			String sqlSelect = "SELECT tayte_id, hinta, tayte FROM tayte WHERE piilotettu = 1;";
			stmt = conn.prepareStatement(sqlSelect);
			rs = stmt.executeQuery(sqlSelect);
			//k‰yd‰‰n l‰pi ja luetaan read
			while (rs.next()){
				tayte = readTayte(rs);
				taytteet.add(tayte);
			}}
			catch (SQLException e){
				throw new RuntimeException(e);
			} finally {
				close(rs, stmt, conn);
			}
			return taytteet;
			
	}
	
	private Tayte readTayte(ResultSet rs) {
		try {
			//yhden tiedot haetaan
			int tayte_id = rs.getInt("tayte_id");
			double tayte_hinta = rs.getDouble("tayte_hinta");
			String tayte = rs.getString("tayte");
			//luodaan uusi ja palautetaan
			return new Tayte(tayte_id, tayte_hinta, tayte);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void piilotatayte(int tayte_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "UPDATE tayte SET piilotettutayte = '1' WHERE tayte_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tayte_id);
			if (pstmt.executeUpdate() != 1) {
				throw new RuntimeException("Leolta kopsittu ns paska SQL piilotus");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void poistaPiilotustayte(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "UPDATE tayte SET piilotettutayte = '0' WHERE tayte_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() != 1){
				throw new RuntimeException("taasen leolta napsittu ns paska SQL piilotuksen poisto");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void poista(Integer tayte_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "DELETE FROM tayte WHERE tayte_id = ?";
			pstmt = conn.prepareStatement(sql);
			int p;
			pstmt.setInt(1, tayte_id);
			p = pstmt.executeUpdate();
			if (p != 1) {
				System.out.println("virhe");
			}
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt, conn);
		}
	}
	
	public void muokkaa (Tayte tayte){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "UPDATE tayte SET hinta=?, tayte=? WHERE tayte_id=?";
			pstmt = conn.prepareStatement(sql);
			int p = 1;
				pstmt.setInt(p++, tayte.getTayte_id());
				pstmt.setDouble(1, tayte.getTayte_hinta());
				pstmt.setString(2, tayte.getTayte());
				p = pstmt.executeUpdate();
				if (p != 1) {
					System.out.println("virhe");
				}
				System.out.println("Tayterows inserted succesfully!");
				} catch (SQLException e){
					throw new RuntimeException(e);
		} finally {
			close(pstmt, conn); //suljetaan statement ja yhteys
		}
		
					close(pstmt, conn);
	}
}
