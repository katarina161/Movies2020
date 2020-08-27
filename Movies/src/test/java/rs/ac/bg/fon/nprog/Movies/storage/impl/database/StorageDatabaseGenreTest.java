package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.nprog.Movies.configuration.Configuration;
import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.database.connection.ConnectionFactory;
import rs.ac.bg.fon.nprog.Movies.domain.Genre;

public class StorageDatabaseGenreTest {
	private static Connection connection;
	private static Controller controller;
	
	List<Genre> allGenres;
	List<Genre> movieGenres;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String url = "jdbc:mysql://localhost:3306/moviestest";
		String user = "root";
		String password = "";
		connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		
		ConnectionFactory.getInstance().setUrl("jdbc:mysql://localhost:3306/moviestest");
		
		controller = Controller.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ConnectionFactory.getInstance().setUrl(Configuration.getInstance().getUrl());
		connection.close();
		controller = null;
	}

	@Before
	public void setUp() throws Exception {
		allGenres = new ArrayList<Genre>();
		movieGenres = new ArrayList<Genre>();
	}

	@After
	public void tearDown() throws Exception {
		allGenres = null;
		movieGenres = null;
	}

	@Test
	public void testGetAll() {
		allGenres = controller.getAllGenres();
		
		assertEquals(16, allGenres.size());
	}

	@Test
	public void testFindGenres() throws Exception {
		movieGenres = controller.findMovieGenres((long) 3);
		
		assertEquals("Crime", movieGenres.get(0).getName());
		assertEquals("Drama", movieGenres.get(1).getName());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testFindGenresNoSuchMovie() throws Exception {
		movieGenres = controller.findMovieGenres((long) 100);
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testFindGenresNull() throws Exception {
		movieGenres = controller.findMovieGenres(null);
	}

}
