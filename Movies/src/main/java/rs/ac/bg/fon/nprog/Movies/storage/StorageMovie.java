package rs.ac.bg.fon.nprog.Movies.storage;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface StorageMovie {
	
	List<Movie> getAll() throws Exception;

	List<Movie> getSpecificGenre(Genre searchGenre) throws Exception;

	void saveUserRating(User user, Movie movie, int userRating) throws Exception;

	void deleteUserRating(User user, Movie movie) throws Exception;

	int getUserRating(User user, Movie movie) throws Exception;

}
