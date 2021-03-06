package rs.ac.bg.fon.nprog.Movies.service;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface ServiceMovie {
	
	public List<Movie> getAll();

	public List<Movie> getSpecificGenre(Genre searchGenre) throws Exception;

	public void saveUserRating(User user, Movie movie, int userRating) throws Exception;

	public void deleteUserRating(User user, Movie movie) throws Exception;

	public int getUserRating(User user, Movie movie) throws Exception;

	public double getRating(Long movieId) throws Exception;

	public int getRevies(Long movieId) throws Exception;

	public void addToWatchList(Movie movie, User user) throws Exception;

	public boolean findMovieInWatchlist(User user, Movie movie) throws Exception;

	public void removeFromWatchlist(User user, Movie movie) throws Exception;

	public List<Movie> getSpecificGenreWatchlist(Genre searchGenre, User user) throws Exception;

	public List<Movie> getAllFromWatchlist(User user) throws Exception;

	public void generateJSON() throws Exception;

	public Movie findMovieById(Long id) throws Exception;

}
