package rs.ac.bg.fon.nprog.Movies.service;

import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface ServiceUser {
	
	User login(String username, String password) throws Exception;

}
