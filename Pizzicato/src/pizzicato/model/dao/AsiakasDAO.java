package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pizzicato.model.Asiakas;
import pizzicato.model.dao.DataAccessObject;

public class AsiakasDAO extends DataAccessObject {

	public void addAsiakas(Asiakas asiakas) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys ja aloitetaan transaktio:
			connection = getConnection();
			// Luodaan uusi asiakas tietokantaan:
			String sqlInsert = "INSERT INTO asiakas(nimi, osoite, puh, sposti) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, asiakas.getNimi());
			stmtInsert.setString(2, asiakas.getOsoite());
			stmtInsert.setInt(3, asiakas.getPuh());
			stmtInsert.setString(4, asiakas.getSposti());

			stmtInsert.executeUpdate();

			System.out.println("Rows inserted succesfully!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

	public ArrayList<Asiakas> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Asiakas> asiakkaat = new ArrayList<Asiakas>();
		Asiakas asiakas = null;
		try {
			// Luodaan yhteys
			conn = getConnection();
			// Luodaan komento: haetaan kaikki rivit -taulusta
			String sqlSelect = "SELECT asiakas_id, nimi, osoite, puh, sposti FROM asiakas;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// Lähetetään komento:
			rs = stmt.executeQuery(sqlSelect);
			// Käydään tulostaulun rivit läpi ja luetaan read()-metodilla:
			while (rs.next()) {
				asiakas = readAsiakas(rs);
				// lisätään henkilö listaan
				asiakkaat.add(asiakas);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return asiakkaat;
	}

	private Asiakas readAsiakas(ResultSet rs) {
		try {
			// Haetaan yhden henkilön tiedot kyselyn tulostaulun
			// (ResultSet-tyyppinen rs-olion) aktiiviselta tietoriviltä
			int asiakas_id = rs.getInt("asiakas_id");
			String nimi = rs.getString("nimi");
			String osoite = rs.getString("osoite");
			int puh = rs.getInt("puh");
			String sposti = rs.getString("sposti");

			// asiakas_id, nimi, osoite, puh, sposti

			// Luodaan ja palautetaan uusi asiakas
			return new Asiakas(asiakas_id, nimi, osoite, puh, sposti);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
