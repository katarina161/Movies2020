package rs.ac.bg.fon.nprog.Movies.service;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;

public interface ServiceMovie {
	
	public List<Movie> getAll() throws Exception;

	public List<Genre> findGenres(Long id) throws Exception;

}
