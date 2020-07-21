package rs.ac.bg.fon.nprog.Movies.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.service.ServiceMovie;
import rs.ac.bg.fon.nprog.Movies.service.ServiceUser;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceMovieImpl;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceUserImpl;

public class Controller {
	
	private static Controller instance;
	private final ServiceUser serviceUser;
	private final ServiceMovie serviceMovie;
	private final Map<String, Object> map;
	
	private Controller() {
		serviceUser = new ServiceUserImpl();
		serviceMovie = new ServiceMovieImpl();
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
		return serviceMovie.findGenres(id);
	}


}
