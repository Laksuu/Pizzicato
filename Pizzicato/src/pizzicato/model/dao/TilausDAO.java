package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pizzicato.model.Asiakas;
import pizzicato.model.Pizza;
import pizzicato.model.Tilaus;
import pizzicato.model.Tilausrivi;

public class TilausDAO extends DataAccessObject {
	
	public void addTilaus(Tilaus tilaus) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		try {
			connection = getConnection();
			//uusi tilaus tietokantaan
			String sqlInsert = "INSERT INTO tilaus(asiakas_id, toimitus, maksu) VALUES (?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			Asiakas asiakas = tilaus.getAsiakas();
			stmtInsert.setInt(1, asiakas.getAsiakas_id());
			stmtInsert.setBoolean(2, tilaus.isToimitus());
			stmtInsert.setBoolean(3, tilaus.isMaksu());
			stmtInsert.executeUpdate();
			
			for (int i = 0; i < tilaus.getTilausrivit().size(); i++) {
				
				Tilausrivi tilausrivi = tilaus.getTilausrivi(i);
				Pizza pizza = tilausrivi.getPizza();
				//yläpuolella jotain hämmää... 
				
				sqlInsert = "INSERT INTO tilausrivi(pizza_id, tilaus_id, maara, extramauste) VALUES (?,last_insert_id(),?.?)";
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtInsert.setInt(1, pizza.getPizza_id());
				stmtInsert.setInt(3, tilausrivi.getMaara());
				stmtInsert.setInt(4, tilausrivi.getExtramauste());
				stmtInsert.executeUpdate();
			}
			
			System.out.println("tilaus ja tilausrivit lisätty");
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection);
		}
		
	}
	
	//findAll

}
