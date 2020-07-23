package rs.ac.bg.fon.nprog.Movies.service.impl;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
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

}
