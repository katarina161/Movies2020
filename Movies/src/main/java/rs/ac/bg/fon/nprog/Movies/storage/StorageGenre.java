package rs.ac.bg.fon.nprog.Movies.storage;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;

public interface StorageGenre {

	List<Genre> getAll() throws Exception;

}
