package rs.ac.bg.fon.nprog.Movies.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private Connection connection;
	private static ConnectionFactory instance;
	
	private ConnectionFactory() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/movies";
		String username = "root";
		String passwod = "";
		
		try {
			connection = DriverManager.getConnection(url, username, passwod);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new SQLException("Connection is not created");
		}
	}
	
	public static ConnectionFactory getInstance() throws SQLException {
		if (instance == null)
			instance = new ConnectionFactory();
		
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}

}
