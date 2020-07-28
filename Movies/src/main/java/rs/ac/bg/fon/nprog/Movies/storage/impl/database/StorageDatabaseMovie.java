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
import rs.ac.bg.fon.nprog.Movies.domain.User;
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
	public List<Movie> getSpecificGenre(Genre searchGenre) throws Exception {
		List<Movie> movies = new ArrayList<>();
		
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "SELECT id, title, year, duration, rating, reviews, image FROM movie "
					+ "WHERE id IN (SELECT movie_id FROM movie_genre WHERE genre_id=?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, searchGenre.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
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
			preparedStatement.close();
			
			return movies;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return movies;
	}


	@Override
	public void saveUserRating(User user, Movie movie, int userRating) throws Exception {
		try {
			if(getUserRating(user, movie) == 0)
				insertUserRating(user, movie, userRating);
			else
				updateUserRating(user, movie, userRating);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	@Override
	public void deleteUserRating(User user, Movie movie) throws Exception {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "DELETE FROM review WHERE user_id=? AND movie_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.setLong(2, movie.getId());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	@Override
	public int getUserRating(User user, Movie movie) throws Exception {
		int userRating = 0;
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "SELECT rating FROM review WHERE user_id=? AND movie_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.setLong(2, movie.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
				userRating = rs.getInt("rating");
			
			rs.close();
			preparedStatement.close();
			return userRating;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userRating;
	}
	
	public void insertUserRating(User user, Movie movie, int userRating) throws Exception {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "INSERT INTO review (user_id, movie_id, rating) VALUES (?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.setLong(2, movie.getId());
			preparedStatement.setInt(3, userRating);
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUserRating(User user, Movie movie, int userRating) throws Exception {
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String query = "UPDATE review SET rating=? WHERE user_id=? AND movie_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userRating);
			preparedStatement.setLong(2, user.getId());
			preparedStatement.setLong(3, movie.getId());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
