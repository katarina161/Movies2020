package rs.ac.bg.fon.nprog.Movies.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa predstavlja korisnika i sadrzi ime, prezime, korisnicko ime i sifru korisnika.
 * @author Katarina
 * @version 1.0.0
 *
 */
public class User {
	
	/**
	 * id korisnika
	 */
	private Long id;
	
	/**
	 * korisnicko ime korisnika
	 */
	private String username;
	
	/**
	 * sifra korisnika
	 */
	private String password;
	
	/**
	 * ime korisnika
	 */
	private String firstName;
	
	/**
	 * prezime korisnika
	 */
	private String lastName;
	
	public User() {
		
	}
	
	/**
	 * Parametrizovani konstruktor klase Korisnik
	 */
	public User(Long id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Vraca id korisnika.
	 * 
	 * @return id korisnika
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Postavlja vrednost atributa id.
	 * 
	 * @param id Nova vrednost atributa id.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Vraca korisnicko ime korisnika.
	 * 
	 * @return korisnicko ime
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Postavlja vrednost atributa korisnicko ime.
	 * 
	 * @param username Nova vrednost atributa korisnicko ime korisnika.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko korisnicko ime:
	 * <ul>
	 * 	<li> ne pocinje slovom (malim ili velikim)
	 * 	<li> sadrzi karakter koji nije slovo, _ ili broj
	 * 	<li> ima manje od 6 karaktera
	 * 	<li> ima vise od 20 karaktera
	 * </ul>
	 *
	 */
	public void setUsername(String username) {
		if(username == null || !isValidUsername(username))
			throw new RuntimeException("Username is invalid.");
		this.username = username;
	}
	
	/**
	 * Vraca sifru korisnika.
	 * 
	 * @return sifra korisnika
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Postavlja vrednost atributa sifra korisnika.
	 * 
	 * @param password Nova vrednost atributa sifra korisnika.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko sifra:
	 * <ul>
	 * 	<li> ne sadrzi bar jedan broj
	 * 	<li> ne sadrzi bar jedno malo slovo
	 * 	<li> ne sadrzi bar jedno veliko slovo
	 * 	<li> ne sadrzi bar jedan specijalni karakter
	 * 	<li> kraca je od 8 karaktera
	 * 	<li> duza je od 20 karaktera
	 * </ul>
	 */
	public void setPassword(String password) {
		if(password == null || !isValidPassword(password))
			throw new RuntimeException("Password is invalid.");
		this.password = password;
	}
	
	/**
	 * Vraca ime korisnika.
	 * 
	 * @return ime korisnika
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Postavlja vrednost atributa ime korisnika.
	 * 
	 * @param firstName Nova vrednost atributa ime korisnika.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko ime ne pocinje velikim slovom
	 * i/ili sadrzi neki drugi karakter osim malih i velikih slova.
	 */
	public void setFirstName(String firstName) {
		if(firstName == null || !firstName.matches( "[A-Z][a-z]*" ))
			throw new RuntimeException("First name is inavlid.");
		this.firstName = firstName;
	}
	
	/**
	 * Vraca prezime korisnika.
	 * 
	 * @return prezime korisnika.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Postavlja vrednost atributa prezime korisnika.
	 * 
	 * @param lastName Nova vrednost atributa prezime korisnika.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko prezime ne pocinje velikim slovom
	 * i/ili sadrzi neki drugi karakter osim malih, velikih slova, razmaka, -, ili '.
	 */
	public void setLastName(String lastName) {
		if(lastName == null || !lastName.matches( "[A-Z][a-zA-Z]*([ '-][a-zA-Z]+)*" ))
			throw new RuntimeException("Last name is inavlid.");
		this.lastName = lastName;
	}
	
	/**
	 * Staticka metoda koja proverava da li je korisnicko ime validno.
	 * 
	 * @param username korisnicko ime
	 * 
	 * @return Vraca <b>true</b> ako korisnicko ime pocinje slovom, sastoji se samo od slova, brojeva i _
	 * i ako nema manje od 6 niti vise od 20 karaktera, u soprotnom vraca <b>false</b>
	 */
	public static boolean isValidUsername(String username) {
		
		String regex = "^[a-zA-Z]\\w{5,19}$";
		Pattern p = Pattern.compile(regex);
					
		Matcher m = p.matcher(username);
		
		return m.matches();
		
	}
	
	/**
	 * Staticka metoda koja poverava da li je sifra validna.
	 * 
	 * @param password sifra korisnika
	 * 
	 * @return Vraca <b>true</b> ukoliko sifra:
	 * <ul>
	 * 	<li> sadrzi najamnje jedan broj
	 * 	<li> sadrzi najamnje jedno malo slovo
	 * 	<li> sadrzi najamnje jedno veliko slovo
	 * 	<li> sadrzi najamnje jedan specijalni karakter
	 * 	<li> nije kraca od 8 karaktera
	 * 	<li> nije duza od 20 karaktera
	 * </ul>, u suprotnom vraca <b>false</b>
	 */
	public static boolean isValidPassword(String password) {
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=.!?_])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(password);
		
		return m.matches();
		
	}
	
	/**
	 * Proverava da li su korisnici jednaki na osnovu atributa korisnicko ime.
	 * 
	 * @return Vraca <b>true</b> ako su objekti instance klase Korisnik i ako imaju isto korsinicko ime, 
	 * u suprotnom vraca <b>false</b>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
