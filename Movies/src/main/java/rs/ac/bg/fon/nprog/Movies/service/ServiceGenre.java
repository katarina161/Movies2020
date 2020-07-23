package rs.ac.bg.fon.nprog.Movies.service;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;

public interface ServiceGenre {

	List<Genre> getAll() throws Exception;
	
	public List<Genre> findGenres(Long id) throws Exception;

}
