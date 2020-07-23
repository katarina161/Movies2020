package rs.ac.bg.fon.nprog.Movies.storage;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;

public interface StorageMovie {
	
	List<Movie> getAll() throws Exception;

	List<Movie> getSpecificGenre(Genre searchGenre) throws Exception;

}
