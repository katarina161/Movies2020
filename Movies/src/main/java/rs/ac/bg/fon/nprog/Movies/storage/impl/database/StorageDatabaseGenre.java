package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.Movies.database.connection.ConnectionFactory;
import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.storage.StorageGenre;

public class StorageDatabaseGenre implements StorageGenre{

	@Override
	public List<Genre> getAll() throws Exception {
		List<Genre> genres = new ArrayList<Genre>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "SELECT id,name FROM genre";
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				
				Genre genre = new Genre();
				genre.setId(id);
				genre.setName(name);
				
				genres.add(genre);
			}
			
			rs.close();
			statement.close();
			
			return genres;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return genres;
	}

}
