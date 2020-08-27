package rs.ac.bg.fon.nprog.Movies.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import rs.ac.bg.fon.nprog.Movies.configuration.Configuration;

public class ConnectionFactory {
	
	private Connection connection;
	private static ConnectionFactory instance;
	String url = "";
	String user = "root";
	String password = "";
	
	private ConnectionFactory() throws SQLException {
		url = Configuration.getInstance().getUrl();
		user = Configuration.getInstance().getUsername();
		password = Configuration.getInstance().getPassword();
		
		connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
	}
	
	public static ConnectionFactory getInstance() throws SQLException {
		if(instance == null)
			instance = new ConnectionFactory();
		
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setUrl(String url) {
		this.url = url;
		setUrlConnection();
	}
	
	public void setUrlConnection() {
		try {
			connection.close();
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
}
