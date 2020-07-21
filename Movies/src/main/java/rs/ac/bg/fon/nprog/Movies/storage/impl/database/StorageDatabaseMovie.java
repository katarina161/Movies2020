package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.Movies.database.connection.ConnectionFactory;
import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.storage.StorageMovie;

public class StorageDatabaseMovie implements StorageMovie{

	@Override
	public List<Movie> getAll() throws Exception {
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "SELECT id, title, year, duration, rating, reviews, image FROM movie";
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String title  = rs.getString("title");
				int year = rs.getInt("year");
				int duration = rs.getInt("duration");
				double rating = rs.getDouble("rating");
				int reviews = rs.getInt("reviews");
				String image = rs.getString("image");
				
				Movie movie = new Movie();
				movie.setId(id);
				movie.setTitle(title);
				movie.setYear(year);
				movie.setDuration(duration);
				movie.setRating(rating);
				movie.setReviews(reviews);
				movie.setImage(image);
				
				movies.add(movie);
			}
			
			rs.close();
			statement.close();
			
			return movies;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return movies;
	}

	@Override
	public List<Genre> findGenres(Long movieId) throws Exception {
		List<Genre> genres =  new ArrayList<>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "SELECT id,name FROM genre WHERE id IN (SELECT genre_id FROM movie_genre WHERE movie_id=?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, movieId);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				
				Genre genre = new Genre();
				genre.setId(id);
				genre.setName(name);
				
				genres.add(genre);
			}
			
			rs.close();
			preparedStatement.close();
			
			return genres;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return genres;
	}

}
