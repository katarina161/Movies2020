package rs.ac.bg.fon.nprog.Movies.service;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface ServiceMovie {
	
	public List<Movie> getAll() throws Exception;

	public List<Movie> getSpecificGenre(Genre searchGenre) throws Exception;

	public void saveUserRating(User user, Movie movie, int userRating) throws Exception;

	public void deleteUserRating(User user, Movie movie) throws Exception;

	public int getUserRating(User user, Movie movie) throws Exception;

}
