package rs.ac.bg.fon.nprog.Movies.service.impl;

import java.util.List;

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

}
