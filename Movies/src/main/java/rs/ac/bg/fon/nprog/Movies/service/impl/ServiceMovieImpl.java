package rs.ac.bg.fon.nprog.Movies.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.service.ServiceMovie;
import rs.ac.bg.fon.nprog.Movies.storage.StorageMovie;
import rs.ac.bg.fon.nprog.Movies.storage.impl.database.StorageDatabaseMovie;

public class ServiceMovieImpl implements ServiceMovie{
	
	private final StorageMovie storageMovie;
	
	public ServiceMovieImpl() {
		storageMovie = new StorageDatabaseMovie();
	}
	
	@Override
	public List<Movie> getAll() throws Exception {
		return storageMovie.getAll();
	}

	@Override
	public List<Movie> getSpecificGenre(Genre searchGenre) throws Exception {
		return storageMovie.getSpecificGenre(searchGenre);
	}

	@Override
	public void saveUserRating(User user, Movie movie, int userRating) throws Exception {
		if(user == null)
			throw new RuntimeException("That user does not exist");
		storageMovie.saveUserRating(user, movie, userRating);
	}

	@Override
	public void deleteUserRating(User user, Movie movie) throws Exception {
		if(user == null)
			throw new RuntimeException("Rating from this user does not exist!");
		storageMovie.deleteUserRating(user, movie);
	}

	@Override
	public int getUserRating(User user, Movie movie) throws Exception {
		if(user == null)
			throw new RuntimeException("Rating from this user does not exist!");
		return storageMovie.getUserRating(user, movie);
	}

	@Override
	public double getRating(Long movieId) throws Exception {
		return storageMovie.getRating(movieId);
	}

	@Override
	public int getRevies(Long movieId) throws Exception {
		return storageMovie.getReviews(movieId);
	}

	@Override
	public void addToWatchList(Movie movie, User user) throws Exception {
		storageMovie.addToWatchlist(movie, user);
	}

	@Override
	public boolean findMovieInWatchlist(User user, Movie movie) throws Exception {
		return storageMovie.findMovieInWatchlist(user, movie);
	}

	@Override
	public void removeFromWatchlist(User user, Movie movie) throws Exception {
		storageMovie.removeFromWatchlist(user, movie);
	}

	@Override
	public List<Movie> getSpecificGenreWatchlist(Genre searchGenre, User user) throws Exception {
		return storageMovie.getSpecificGenreWatchlist(searchGenre, user);
	}

	@Override
	public List<Movie> getAllFromWatchlist(User user) throws Exception {
		return storageMovie.getAllFromWatchlist(user);
	}

	@Override
	public void generateJSON() throws Exception {
		List<Movie> movies = storageMovie.getAll();
		
		try(FileWriter out = new FileWriter("movies.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			gson.toJson(movies, out);
		} catch (IOException e) {
			throw e;
		}
	}

}
