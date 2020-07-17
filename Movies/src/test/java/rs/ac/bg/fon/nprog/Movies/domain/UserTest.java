package rs.ac.bg.fon.nprog.Movies.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	//Username
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameNull() {
		user.setUsername(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameFirst_() {
		user.setUsername("_katarina");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameFirstNum() {
		user.setUsername("161katarina");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameSpecialCharacter() {
		user.setUsername("k_atarina123!");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameLessThen6() {
		user.setUsername("kaca");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameMoreThen20() {
		user.setUsername("kaca123456789123456789");
	}
	
	@Test
	public void testSetUsernameFirstSmall() {
		user.setUsername("katarina_16116");
		
		assertEquals("katarina_16116", user.getUsername());
	}
	
	@Test
	public void testSetUsernameFirstBig() {
		user.setUsername("Katarina_16116");
		
		assertEquals("Katarina_16116", user.getUsername());
	}


	//Password
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNull() {
		user.setPassword(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNoNumber() {
		user.setPassword("KatarinaNovakovic.");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNoSmall() {
		user.setPassword("KATARINA1234.");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNoBig() {
		user.setPassword("katarina1234.");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNoSpecialChar() {
		user.setPassword("Katarina1234");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordLessThan8() {
		user.setPassword("kaca123");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordMoreThan20() {
		user.setPassword("kaca123456789123456789");
	}
	
	@Test 
	public void testSetPassword() {
		user.setPassword("Katarina161_16");
		
		assertEquals("Katarina161_16", user.getPassword());
	}
	
	//First name
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetFirstNameNull() {
		user.setFirstName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetFirstNameFirstSmall() {
		user.setFirstName("katarina");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetFirstNameNumbers() {
		user.setFirstName("Katarina123");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetFirstNameSpecialChar() {
		user.setFirstName("Katarina!");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetFirstNameSpace() {
		user.setFirstName("Katarina ");
	}
	
	@Test
	public void testSetFirstName() {
		user.setFirstName("Katarina");
		
		assertEquals("Katarina", user.getFirstName());
	}


	//Last name
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLastNameNull() {
		user.setLastName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLastNameFirstSmall() {
		user.setLastName("novakovic");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLastNameNumbers() {
		user.setLastName("Novakovic123");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLastNameSpecialChar() {
		user.setLastName("Novakovic!");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLastNameOnlySpace() {
		user.setLastName("Novakovic ");
	}
	
	@Test
	public void testSetLastName1() {
		user.setLastName("Novakovic");
		
		assertEquals("Novakovic", user.getLastName());
	}
	
	@Test
	public void testSetLastName2() {
		user.setLastName("De Niro");
		
		assertEquals("De Niro", user.getLastName());
	}
	
	@Test
	public void testSetLastName3() {
		user.setLastName("McAvoy");
		
		assertEquals("McAvoy", user.getLastName());
	}
	
	@Test
	public void testSetLastName4() {
		user.setLastName("O");
		
		assertEquals("O", user.getLastName());
	}
	
	@Test
	public void testSetLastName5() {
		user.setLastName("Ji-Ho");
		
		assertEquals("Ji-Ho", user.getLastName());
	}
	
	//Sex
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSexNull() {
		user.setSex(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSex1() {
		user.setSex("Televizor");
	}
	
	@Test
	public void testSetSex2() {
		user.setSex("Muski");
		
		assertEquals("Muski", user.getSex());
	}
	
	@Test
	public void testSetSex3() {
		user.setSex("Zenski");
		
		assertEquals("Zenski", user.getSex());
	}
	
	//Birthady
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetBirthadyNull() {
		user.setBirthday(null);
	}
	
	//Equals
	@Test
	public void testEqualsObjectNull() {
		assertFalse(user.equals(null));
	}
	
	@Test
	public void testEqualsObjectDifferentClass() {
		assertFalse(user.equals(new Object()));
	}
	
	@Test
	public void testEqualsObjectDifferentObjects() {
		user.setUsername("katarina_161");
		
		User user2 = new User();
		user2.setUsername("katarina_232");
		
		assertFalse(user.equals(user2));
	}
	
	@Test
	public void testEqualsObjectDifferentNames() {
		user.setUsername("unique13");
		user.setFirstName("Katarina");
		
		User user2 = new User();
		user2.setUsername("unique13");
		user2.setFirstName("Ruzica");
		
		assertTrue(user.equals(user2));
	}
	
	@Test
	public void testEqualsObjectDifferentUsernamesSameRest() {
		user.setUsername("katarina_161");
		user.setFirstName("Katarina");
		user.setLastName("Novakovic");
		user.setPassword("Kaca1234!");
		
		User user2 = new User();
		user2.setUsername("katarina_232");
		user2.setFirstName("Katarina");
		user2.setLastName("Novakovic");
		user2.setPassword("Kaca1234!");
		
		assertFalse(user.equals(user2));
	}

}
