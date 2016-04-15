package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pizzicato.model.Kayttaja;

public class KayttajaDAO extends DataAccessObject {
	private static KayttajaDAO instance = new KayttajaDAO();

	public static KayttajaDAO getInstance() {
		return instance;
	}

	private Kayttaja read(ResultSet rs) throws SQLException {
		Long id = new Long(rs.getLong("id"));
		String username = rs.getString("username");
		String password = rs.getString("password");
		String logtype = rs.getString("logtype");
		Kayttaja kayttaja = new Kayttaja();
		kayttaja.setId(id);
		kayttaja.setUsername(username);
		kayttaja.setPassword(password);
		kayttaja.setLogtype(logtype);
		return kayttaja;
	}

	public Kayttaja find(Long id) {
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM kayttaja WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id.longValue());
			rs = statement.executeQuery();
			if (!rs.next()) {
				return null;
			}
			return read(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, statement, connection);
		}
	}

	public Kayttaja findByUsername(String username) {
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM kayttaja WHERE username=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			rs = statement.executeQuery();
			if (!rs.next()) {
				return null;
			}
			return read(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, statement, connection);
		}
	}

	public List<Kayttaja> findAll() {
		LinkedList<Kayttaja> kayttajat = new LinkedList<Kayttaja>();
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM kayttaja ORDER BY id";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Kayttaja kayttaja = read(rs);
				kayttajat.add(kayttaja);
			}
			return kayttajat;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, statement, connection);
		}
	}

	public void update(Kayttaja kayttaja) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "UPDATE kayttaja SET " + "password=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, kayttaja.getPassword());
			statement.setLong(2, kayttaja.getId().longValue());
			statement.setString(3, kayttaja.getLogtype());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statement, connection);
		}
	}

	public void create(Kayttaja kayttaja) {
		Long id = (long) getUniqueId(); // Tässä Long vielä vähän kyseenalainen,
										// muttta kokeillaan, testataan
		kayttaja.setId(id);
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO kayttaja "
					+ "(id, username, password, logtype) "

					+ "values (?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id.longValue());
			statement.setString(2, kayttaja.getUsername());
			statement.setString(3, kayttaja.getPassword());
			statement.setString(4, kayttaja.getLogtype());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statement, connection);
		}
	}

	// Tämä vielä vähä kyseenalainen, mutta kattellahan
	int uniqueId = 0;

	int getUniqueId() {
		return uniqueId++;
	}

	//
	public void delete(Kayttaja kayttaja) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "DELETE FROM kayttaja WHERE id=?";
			statement = connection.prepareStatement(sql);
			Long id = kayttaja.getId();
			statement.setLong(1, id.longValue());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(statement, connection);
		}
	}
}