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
			String sqlInsert = "INSERT INTO asiakas(etunimi, sukunimi, osoite, postinmr, puh, sposti) VALUES (?, ?, ?, ?, ?,?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, asiakas.getEtunimi());
			stmtInsert.setString(2, asiakas.getSukunimi());
			stmtInsert.setString(3, asiakas.getOsoite());
			stmtInsert.setString(4, asiakas.getPostinmr());
			stmtInsert.setString(5, asiakas.getPuh());
			stmtInsert.setString(6, asiakas.getSposti());

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
			String sqlSelect = "SELECT etunimi, sukunimi, osoite, postinmr, puh, sposti FROM asiakas;";
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
			String etunimi = rs.getString("etunimi");
			String sukunimi = rs.getString("sukunimi");
			String osoite = rs.getString("vastaaja");
			String postinmr = rs.getString("kysymys_id");
			String puh = rs.getString("puh");
			String sposti = rs.getString("sposti");

			// etunimi, sukunimi, osoite, postinmr, puh

			// Luodaan ja palautetaan uusi asiakas
			return new Asiakas(etunimi, sukunimi, osoite, postinmr, puh, sposti);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
