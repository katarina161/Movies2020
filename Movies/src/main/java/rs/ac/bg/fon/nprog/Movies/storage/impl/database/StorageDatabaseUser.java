package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			
			rs.close();
			preparedStatement.close();
			return user;
		}
		
		rs.close();
		preparedStatement.close();
		throw new Exception("No such user");
	}

}
