package rs.ac.bg.fon.nprog.Movies.storage;

import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface StorageUser {
	
	User login(String username, String password) throws Exception;

}
