package rs.ac.bg.fon.nprog.Movies.service.impl;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.service.ServiceGenre;
import rs.ac.bg.fon.nprog.Movies.storage.StorageGenre;
import rs.ac.bg.fon.nprog.Movies.storage.impl.database.StorageDatabaseGenre;

public class ServiceGenreImpl implements ServiceGenre{
	
	private final StorageGenre storageGenre;
	
	public ServiceGenreImpl() {
		storageGenre = new StorageDatabaseGenre();
	}

	@Override
	public List<Genre> getAll() throws Exception {
		return storageGenre.getAll();
	}

	@Override
	public List<Genre> findGenres(Long id) throws Exception {
		return storageGenre.findGenres(id);
	}
}
