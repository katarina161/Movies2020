package rs.ac.bg.fon.nprog.Movies.storage.impl.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public class StorageDatabaseMovieTest {
	private static Connection connection;
	private static Controller controller;
	
	User user;
	Genre g;
	Movie m;
	List<Movie> allMovies;
	List<Movie> watchlistAll;
	List<Movie> specificGenre;

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
		g = new Genre();
		user = new User();
		m = new Movie();
		allMovies = new ArrayList<Movie>();
		watchlistAll = new ArrayList<Movie>();
		specificGenre = new ArrayList<Movie>();
		
		String query = "INSERT INTO user (id,username,password,firstname,lastname,gender,birthday) "
				+ "VALUES (1,'katarina96','Kaca1234.','Katarina','Novakovic','Female','22-08-1996')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		user.setId((long) 1);
		user.setFirstName("Katarina");
		user.setLastName("Novakovic");
		user.setUsername("katarina96");
		user.setPassword("Kaca1234.");
		user.setGender("Female");
		user.setBirthday("22-08-1996");
		
		for(int i = 1; i < 4; i++) {
			query = "INSERT INTO watchlist VALUES(1,"+i+")";
			statement.executeUpdate(query);
		}
		
		query = "INSERT INTO user (id,username,password,firstname,lastname,gender,birthday) "
				+ "VALUES (2,'sava96','Sava1234.','Sava','Jeremic','Male','05-10-1996')";
		statement.executeUpdate(query);
		
		query = "INSERT INTO review VALUES(1, 1, 8)";
		statement.executeUpdate(query);
		
		connection.commit();
		statement.close();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
		allMovies = null;
		watchlistAll = null;
		specificGenre = null;
		m = null;
		
		String query = "DELETE FROM watchlist";
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		
		query = "DELETE FROM review";
		statement.executeUpdate(query);
		
		query = "DELETE FROM user";
		statement.executeUpdate(query);
		
		connection.commit();
		statement.close();
	}

	@Test
	public void testGetAll() throws Exception {
		allMovies = controller.getAllMovies();
		
		assertEquals(21, allMovies.size());
	}

	@Test
	public void testGetAllFromWatchlist() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		watchlistAll = controller.getAllFromWatchlist();
		
		assertEquals(3, watchlistAll.size());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetAllFromWatchlistEmpty() throws Exception {
		controller.login("sava96", "Sava1234.");
		watchlistAll = controller.getAllFromWatchlist();
	}

	@Test
	public void testGetSpecificGenre() throws Exception {
		g.setId((long) 1);
		g.setName("Action");
		specificGenre = controller.getSpecificGenre(g);
		
		assertEquals(5, specificGenre.size());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetSpecificGenreDoesntExist() throws Exception {
		g.setId((long) 20);
		g.setName("Western");
		specificGenre = controller.getSpecificGenre(g);
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetSpecificGenreNull() throws Exception {
		specificGenre = controller.getSpecificGenre(null);
	}

	@Test
	public void testGetSpecificGenreWatchlist() throws Exception {
		g.setId((long) 6);
		g.setName("Crime");
		controller.login(user.getUsername(), user.getPassword());
		specificGenre = controller.getSpecificGenreWatchlist(g);
		
		assertEquals(2, specificGenre.size());
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetSpecificGenreWatchlistGenreDoesntExist() throws Exception {
		g.setId((long) 20);
		g.setName("Western");
		controller.login(user.getUsername(), user.getPassword());
		specificGenre = controller.getSpecificGenreWatchlist(g);
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetSpecificGenreWatchlistEmptyWatchlist() throws Exception {
		g.setId((long) 1);
		g.setName("Action");
		controller.login("sava96", "Sava1234.");
		specificGenre = controller.getSpecificGenreWatchlist(g);
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testGetSpecificGenreWatchlistNull() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		specificGenre = controller.getSpecificGenreWatchlist(null);
	}

	@Test (expected = java.lang.Exception.class)
	public void testSaveUserRatingMovieNull() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		controller.saveUserRating(null, 1);
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testSaveUserRatingUserRating0() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		controller.saveUserRating(m, 0);
	}
	
	@Test
	public void testSaveUserRatingUserChange() throws Exception {
		int userRatingDb = 0;
		int reviewsDb = 0;
		
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		controller.saveUserRating(m, 7);
		
		String query = "SELECT rating FROM review WHERE user_id=" +user.getId()+ " AND movie_id=" +m.getId();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
			userRatingDb = rs.getInt("rating");
		
		query = "SELECT reviews FROM movie WHERE id=" +m.getId();
		rs = statement.executeQuery(query);
		if(rs.next())
			reviewsDb = rs.getInt("reviews");
		
		
		assertEquals(7, userRatingDb);
		assertEquals(37, reviewsDb);
		controller.saveUserRating(m, 8);
		rs.close();
		statement.close();
	}
	
	@Test
	public void testSaveUserRatingUserNew() throws Exception {
		int userRatingDb = 0;
		int reviewsDb = 0;
		
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 3);
		m.setTitle("Pulp Fiction");
		m.setYear(1994);
		m.setDuration(154);
		m.setRating(8.9);
		m.setReviews(66);
		m.setImage("pulpFiction.jpg");
		
		controller.saveUserRating(m, 9);
		
		String query = "SELECT rating FROM review WHERE user_id=" +user.getId()+ " AND movie_id=" +m.getId();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
			userRatingDb = rs.getInt("rating");
		
		query = "SELECT reviews FROM movie WHERE id=" +m.getId();
		rs = statement.executeQuery(query);
		if(rs.next())
			reviewsDb = rs.getInt("reviews");
		
		assertEquals(9, userRatingDb);
		assertEquals(67, reviewsDb);
		controller.deleteUserRating(m);
	}

	@Test
	public void testDeleteUserRating() throws Exception {
		int userRatingDb = 0;
		int reviewsDb = 0;
		
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		controller.deleteUserRating(m);
		
		String query = "SELECT rating FROM review WHERE user_id=" +user.getId()+ " AND movie_id=" +m.getId();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
			userRatingDb = rs.getInt("rating");
		
		query = "SELECT reviews FROM movie WHERE id=" +m.getId();
		rs = statement.executeQuery(query);
		if(rs.next())
			reviewsDb = rs.getInt("reviews");
		
		assertEquals(0, userRatingDb);
		assertEquals(36, reviewsDb);
		controller.saveUserRating(m, 8);
	}

	@Test (expected = java.lang.Exception.class)
	public void testGetUserRatingNull() throws Exception {
		controller.getUserRating(null);
	}
	
	@Test 
	public void testGetUserRating() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		int userRating = controller.getUserRating(m);
		
		assertEquals(8, userRating);
	}

	@Test
	public void testGetRating() throws Exception {
		Double rating = controller.getRating((long) 1);
		
		assertEquals(Double.valueOf(9), rating);
	}

	@Test
	public void testGetReviews() throws Exception {
		int reviews = controller.getReviews((long) 1);
		
		assertEquals(37, reviews);
	}

	@Test
	public void testAddToWatchlist() throws Exception {
		boolean idDb = false;
		
		controller.login(user.getUsername(), user.getPassword());
		
		m.setId((long) 5);
		m.setTitle("Seven");
		m.setYear(1995);
		m.setDuration(127);
		m.setRating(8.6);
		m.setReviews(77);
		m.setImage("seven.jpg");
		
		controller.addToWatchList(m);
		
		String query = "SELECT * FROM watchlist WHERE user_id=" +user.getId()+ " AND movie_id=" +m.getId();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
			idDb = true;
		
		assertTrue(idDb);
		
		rs.close();
		statement.close();
	}

	@Test
	public void testFindMovieInWatchlistTrue() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		assertTrue(controller.findMovieInWatchlist(m));
	}
	
	@Test
	public void testFindMovieInWatchlistFalse() throws Exception {
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 5);
		m.setTitle("Seven");
		m.setYear(1995);
		m.setDuration(127);
		m.setRating(8.6);
		m.setReviews(77);
		m.setImage("seven.jpg");
		
		assertFalse(controller.findMovieInWatchlist(m));
	}

	@Test
	public void testRemoveFromWatchlist() throws Exception {
		boolean exist = false;
		
		controller.login(user.getUsername(), user.getPassword());
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		controller.removeFromWatchList(m);
		
		String query = "SELECT * FROM watchlist WHERE user_id=" +user.getId()+ " AND movie_id=" +m.getId();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
			exist = true;
		
		assertFalse(exist);
		
		rs.close();
		statement.close();
		
	}

	@Test
	public void testFindMovieById() throws Exception {
		m.setId((long) 1);
		m.setTitle("The Dark Knight");
		m.setYear(2008);
		m.setDuration(152);
		m.setRating(9);
		m.setReviews(37);
		m.setImage("theDarkKnight.jpg");
		
		assertTrue(m.equals(controller.findMovieById((long) 1)));
	}
	
	@Test (expected = java.lang.Exception.class)
	public void testFindMovieByIdDoesntExist() throws Exception {
		controller.findMovieById((long) 50);
	}

}
