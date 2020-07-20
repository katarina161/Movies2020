package rs.ac.bg.fon.nprog.Movies.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predstvalja film koji sadrzi atribute:
 * <ul>
 * 	<li>identifikator filma</li>
 * 	<li>naziv filma</li>
 * 	<li>godina izlaska filma</li>
 * 	<li>trajanje filma u minutima</li>
 * 	<li>ocena filma</li>
 * 	<li>broj glasova</li>
 * 	<li>zanrovi filma</li>
 * 	<li>naziv slike</li>
 * </ul>
 * 
 * @author Katarina
 *
 */
public class Movie {
	
	/**
	 * id filma
	 */
	private Long id;
	
	/**
	 * naziv filma
	 */
	private String title;
	
	/**
	 * godina izlaska filma
	 */
	private int year;
	
	/**
	 * trajanje filma u minutima
	 */
	private int duration;
	
	/**
	 * ocena filma [1-10]
	 */
	private double rating;
	
	/**
	 * broj glasova
	 */
	private int reviews;
	
	/**
	 * zanrovi filma
	 */
	private List<Genre> genres;
	
	/**
	 * naziv slike filma
	 */
	private String image;

	
	/**
	 * Parametrizovani konstruktor
	 * @param id identifikator filma
	 * @param title naziv filma
	 * @param year godina izlaska filma
	 * @param duration trajanje filma u minutima
	 * @param rating ocena filma
	 * @param reviews broj glasova
	 * @param genres zanrovi filma
	 * @param image naziv slike filma
	 */
	public Movie(Long id, String title, int year, int duration, Double rating, int reviews, String image) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.rating = rating;
		this.reviews = reviews;
		this.genres = new ArrayList<>();
		this.image = image;
	}
	
	/**
	 * Neparametrizovani konstruktor
	 */
	public Movie() {
		this.genres = new ArrayList<>();
	}

	/**
	 * Vraca id film.
	 * 
	 * @return id filma
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
	 * Vraca naziv filma.
	 * 
	 * @return naziv filma
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Postavlja vrednost atributa naziv filma.
	 * 
	 * @param title Nova vrednost atributa naziv filma.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko je prosledjena null vrednost
	 */
	public void setTitle(String title) {
		if(title == null)
			throw new RuntimeException("Title can not be null.");
		this.title = title;
	}

	/**
	 * Vraca godinu izlazka filma.
	 * 
	 * @return godina izlaska filma.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Postavlja vrednost atributa godina izlaska filma.
	 * 
	 * @param year Nova vrednost atributa godina izlaska filma.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko je godina 0 ili negativan broj.
	 */
	public void setYear(int year) {
		if(year <= 0)
			throw new RuntimeException("Year must be a positive number.");
		
		this.year = year;
	}

	/**
	 * Vraca trajanje filma u minutima.
	 * 
	 * @return trajanje filma u minutima
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Postavlja vrednost atributa trajanje filma.
	 * 
	 * @param duration Nova vrednost atributa trajanje filma.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko je trajanje filma 0 ili negativan broj.
	 */
	public void setDuration(int duration) {
		if(duration <= 0)
			throw new RuntimeException("Duration must be a positive number.");
		this.duration = duration;
	}

	/**
	 * Vraca ocenu filma.
	 * 
	 * @return ocena filma
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Postavlja vrednost atributa ocena filma.
	 * 
	 * @param rating Nova vrednost parametra ocena filma.
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Vraca listu zanrova filma
	 * 
	 * @return lista zanrova filma
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * Postavlja vrednost liste zanrovi.
	 * 
	 * @param genres Nova lista zanrova.
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * Vraca broj glasova korisnika.
	 * 
	 * @return broj glasova korisnika
	 */
	public int getReviews() {
		return reviews;
	}

	/**
	 * Postavlja vrednost atributa broj glasova.
	 * 
	 * @param reviews Nova vrednost atributa broj glasova.
	 * 
	 * @throws java.lang.RuntimeException Ukoliko je broj glasova negativan.
	 */
	public void setReviews(int reviews) {
		if(reviews < 0)
			throw new RuntimeException("Number of reviews can not be negative.");
		this.reviews = reviews;
	}

	/**
	 * Vraca naziv slike.
	 * 
	 * @return naziv slike
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Postavlja vrednost atributa naziv slike.
	 * 
	 * @param image Nova vrednost atributa naziv slike.
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * Metoda koja racuna prosecnu ocenu na osnovu nove ocene korisnika.
	 * 
	 * @param userRating ocena korisnika
	 * 
	 * @return Nova vrednost ocene filma.
	 */
	public double calculateRating(int userRating) {
		double input = (rating * reviews + userRating) * 1.0 / (reviews + 1);
		BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
		
		double r = bd.doubleValue();
		
		return r;
	}

}
