package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import rs.ac.bg.fon.nprog.Movies.database.connection.ConnectionFactory;
import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.storage.StorageUser;

public class StorageDatabaseUser implements StorageUser {

	@Override
	public User login(String username, String password) throws Exception {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		
		String query = "SELECT * FROM user WHERE username=? AND password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setGender(rs.getString("gender"));
			user.setBirthday(rs.getString("birthday"));
			
			rs.close();
			preparedStatement.close();
			return user;
		}
		
		rs.close();
		preparedStatement.close();
		throw new Exception("No such user");
	}

	@Override
	public void registrate(User user) throws Exception {
		if(findUser(user))
			throw new RuntimeException("That username is already taken.");
		
		Connection connection = ConnectionFactory.getInstance().getConnection();
		String query = "INSERT INTO user (username,password,firstname,lastname,gender,birthday) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getFirstName());
		preparedStatement.setString(4, user.getLastName());
		preparedStatement.setString(5, user.getGender());
		preparedStatement.setString(6, user.getBirthday());
		preparedStatement.executeUpdate();
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if(rs.next()) {
			Long id = rs.getLong(1);
			user.setId(id);
		}
		
		connection.commit();
		rs.close();
		preparedStatement.close();
	}
	
	public boolean findUser(User user) throws Exception {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		String query = "SELECT id FROM user WHERE username=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next()) {
			rs.close();
			preparedStatement.close();
			return true;
		}
		
		rs.close();
		preparedStatement.close();
		return false;
	}

}
