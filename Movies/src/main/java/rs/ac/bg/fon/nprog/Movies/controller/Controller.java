package rs.ac.bg.fon.nprog.Movies.controller;

import java.util.HashMap;
import java.util.Map;

import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.service.ServiceUser;
import rs.ac.bg.fon.nprog.Movies.service.impl.ServiceUserImpl;

public class Controller {
	
	private static Controller instance;
	private final ServiceUser serviceUser;
	private final Map<String, Object> map;
	
	private Controller() {
		serviceUser = new ServiceUserImpl();
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

	public Map<String, Object> getMap() {
		return map;
	}
	

}
