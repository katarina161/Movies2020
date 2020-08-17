package rs.ac.bg.fon.nprog.Movies.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.service.ServiceGenre;
import rs.ac.bg.fon.nprog.Movies.service.ServiceMovie;
import rs.ac.bg.fon.nprog.Movies.service.ServiceUser;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceGenreImpl;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceMovieImpl;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceUserImpl;

public class Controller {
	
	private static Controller instance;
	private final ServiceUser serviceUser;
	private final ServiceMovie serviceMovie;
	private final ServiceGenre serviceGenre;
	private final Map<String, Object> map;
	
	private Controller() {
		serviceUser = new ServiceUserImpl();
		serviceMovie = new ServiceMovieImpl();
		serviceGenre = new ServiceGenreImpl();
		map = new HashMap<>();
	}
	
	public static Controller getInstance() {
		if (instance == null)
			instance = new Controller();
		
		return instance;
	}
	
	public void login(String username, String password) throws Exception {
		User user = serviceUser.login(username, password);
		
		map.put("currentUser", user);
	}
	
	public void registrate(User user) throws Exception {
		serviceUser.registrate(user);
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public List<Movie> getAllMovies() throws Exception {
		return serviceMovie.getAll();
	}

	public List<Genre> findMovieGenres(Long id) throws Exception{
		return serviceGenre.findGenres(id);
	}

	public List<Genre> getAllGenres() throws Exception {
		return serviceGenre.getAll();
	}

	public List<Movie> getSpecificGenre(Genre searchGenre) throws Exception{
		return serviceMovie.getSpecificGenre(searchGenre);
	}

	public void saveUserRating(Movie movie, int userRating) throws Exception {
		if(movie == null)
			throw new RuntimeException("That movie does not exist!");
		if(userRating == 0) {
			throw new RuntimeException("The rating must be a number between 1 and 10");
		}
		User user = (User)map.get("currentUser");
		serviceMovie.saveUserRating(user, movie, userRating);
	}

	public void deleteUserRating(Movie movie) throws Exception{
		if(movie == null)
			throw new RuntimeException("This movie does not exist!");
		User user = (User)map.get("currentUser");
		serviceMovie.deleteUserRating(user, movie);
	}

	public int getUserRating(Movie movie) throws Exception{
		if(movie == null)
			throw new RuntimeException("This movie does not exist!");
		User user = (User)map.get("currentUser");
		return serviceMovie.getUserRating(user, movie);
	}

	public double getRating(Long movieId) throws Exception {
		return serviceMovie.getRating(movieId);
	}

	public int getReviews(Long movieId) throws Exception{
		return serviceMovie.getRevies(movieId);
	}

	public void addToWatchList(Movie movie) throws Exception{
		if(movie == null)
			throw new RuntimeException("This movie does not exist!");
		User user = (User)map.get("currentUser");
		serviceMovie.addToWatchList(movie, user);
	}

	public boolean findMovieInWatchlist(Movie movie) throws Exception{
		User user = (User)map.get("currentUser");
		return serviceMovie.findMovieInWatchlist(user, movie);
	}

	public void removeFromWatchList(Movie movie) throws Exception{
		User user = (User)map.get("currentUser");
		serviceMovie.removeFromWatchlist(user, movie);
	}

	public List<Movie> getSpecificGenreWatchlist(Genre searchGenre) throws Exception{
		User user = (User)map.get("currentUser");
		return serviceMovie.getSpecificGenreWatchlist(searchGenre, user);
	}

	public List<Movie> getAllFromWatchlist() throws Exception{
		User user = (User)map.get("currentUser");
		return serviceMovie.getAllFromWatchlist(user);
	}

	public void generateJSON() throws Exception{
		serviceMovie.generateJSON();
	}

}
