package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.database.connection.ConnectionFactory;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public class StorageDatabaseUserTest {
	private static Connection connection;
	private static Controller controller;
	User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = ConnectionFactory.getInstance("moviestest").getConnection();
		
		controller = Controller.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection.close();
		controller = null;
	}

	@Before
	public void setUp() throws Exception {
		user = new User();
		
		String query = "INSERT INTO user (username,password,firstname,lastname,gender,birthday) "
				+ "VALUES ('katarina96','Kaca1234.','Katarina','Novakovic','Female','22-08-1996')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		connection.commit();
		statement.close();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
		
		String query = "DELETE FROM user";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		connection.commit();
		statement.close();
	}

	@Test
	public void testLogin() {
		String username = "katarina96";
		String password = "Kaca1234.";
		
		try {
			controller.login(username, password);
			user = (User) controller.getMap().get("currentUser");
			assertEquals(user.getUsername(), username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testLoginNoUser() throws Exception {
		String username = "katarina_1";
		String password = "Kaca1234.";
		
		controller.login(username, password);
	}

	@Test
	public void testRegistrate() throws Exception {
		user.setFirstName("Sava");
		user.setLastName("Savanovic");
		user.setGender("Male");
		user.setUsername("sava99");
		user.setPassword("Sava1234.");
		user.setBirthday("27-08-2020");
		
		controller.registrate(user);
		controller.login(user.getUsername(), user.getPassword());
		User currentUser = (User) controller.getMap().get("currentUser");
		assertEquals("sava99", currentUser.getUsername());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testRegistrateUserExist() throws Exception {
		user.setFirstName("Katarina");
		user.setLastName("Novakovic");
		user.setGender("Female");
		user.setUsername("katarina96");
		user.setPassword("Kaca1234.");
		user.setBirthday("22-08-1996");
		
		controller.registrate(user);
	}
}
