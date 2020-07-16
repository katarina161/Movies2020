package rs.ac.bg.fon.nprog.Movies.service.impl;

import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.service.ServiceUser;
import rs.ac.bg.fon.nprog.Movies.storage.StorageUser;
import rs.ac.bg.fon.nprog.Movies.storage.impl.database.StorageDatabaseUser;

public class ServiceUserImpl implements ServiceUser {
	
	private final StorageUser storageUser;
	
	public ServiceUserImpl() {
		storageUser = new StorageDatabaseUser();
	}

	@Override
	public User login(String username, String password) throws Exception{
		return storageUser.login(username, password);
	}

}
