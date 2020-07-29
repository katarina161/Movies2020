package rs.ac.bg.fon.nprog.Movies.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {
	
	Movie movie;

	@Before
	public void setUp() throws Exception {
		movie = new Movie();
	}

	@After
	public void tearDown() throws Exception {
		movie = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetTitleNull() {
		movie.setTitle(null);
	}
	
	@Test
	public void testSetTitle() {
		movie.setTitle("The Shining");
		
		assertEquals("The Shining", movie.getTitle());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetYearNegative() {
		movie.setYear(-2020);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetYearZero() {
		movie.setYear(0);
	}
	
	@Test
	public void testSetYear() {
		movie.setYear(2020);
		
		assertEquals(2020, movie.getYear());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetDurationNegative() {
		movie.setDuration(-52);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetDurationZero() {
		movie.setDuration(0);
	}
	
	@Test
	public void testSetDuration() {
		movie.setDuration(120);
		
		assertEquals(120, movie.getDuration());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetReviewsNegative() {
		movie.setReviews(-5);
	}
	
	@Test
	public void testSetReviews() {
		movie.setReviews(0);
		
		assertEquals(0, movie.getReviews());
	}

	@Test
	public void testCalculateRating1() {
		movie.setRating(0);
		movie.setReviews(0);
		
		int userRating = 5;
		
		assertEquals(5.0, movie.calculateRatingPlus(userRating), 0);
	}
	
	@Test
	public void testCalculateRating2() {
		movie.setRating(9.2);
		movie.setReviews(150);
		
		int userRating = 8;
		
		assertEquals(9.2, movie.calculateRatingPlus(userRating), 0);
	}
	
	@Test
	public void testCalculateRatingMinus1() {
		movie.setRating(9.2);
		movie.setReviews(150);
		
		int userRating = 8;
		
		assertEquals(9.2, movie.calculateRatingMinus(userRating), 0);
	}
	
	@Test
	public void testCalculateRatingMinus2() {
		movie.setRating(8);
		movie.setReviews(1);
		
		int userRating = 8;
		
		assertEquals(0, movie.calculateRatingMinus(userRating), 0);
	}
	
	@Test
	public void testCalculateRatingChange1() {
		movie.setRating(9.2);
		movie.setReviews(150);
		
		int oldUserRating = 8;
		int newUserRating = 1;
		
		assertEquals(9.2, movie.calculateRatingChange(oldUserRating, newUserRating), 0);
	}
}
