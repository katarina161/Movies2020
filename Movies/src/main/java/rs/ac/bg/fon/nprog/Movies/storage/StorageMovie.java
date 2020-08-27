package rs.ac.bg.fon.nprog.Movies.storage;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface StorageMovie {
	
	/**
	 * Vraca sve filmove iz baze.
	 * @return Lista filmova iz baze
	 * @throws Exception
	 */
	List<Movie> getAll();

	/**
	 * Vraca filmove odredjenog zanra.
	 * @param searchGenre Zanr na osnovu koga se vrsi filtriranje filmova.
	 * @return Lista filmova odredjenog zanra
	 * @throws Exception
	 */
	List<Movie> getSpecificGenre(Genre searchGenre) throws Exception;

	/**
	 * Cuva ocenu koju je korisnik dao odredjenom filmu.
	 * @param user Korisnik koji je ocenio film
	 * @param movie Film koji je korisnik ocenio
	 * @param userRating Ocena koju je korisnik dao filmu
	 * @throws Exception
	 */
	void saveUserRating(User user, Movie movie, int userRating) throws Exception;

	/**
	 * Brise ocenu korisnika za odredjeni film.
	 * @param user Korisnik koji zeli da obrise svoju ocenu filma
	 * @param movie Film ciju ocenu korisnik zeli da obrise
	 * @throws Exception
	 */
	void deleteUserRating(User user, Movie movie) throws Exception;

	/**
	 * Vraca ocenu korisnika koju je dao odredjenom filmu.
	 * @param user Korisnik koji je ocenio film
	 * @param movie Film ciju ocenu zelimo da vidimo
	 * @return Ocena filma
	 * @throws Exception
	 */
	int getUserRating(User user, Movie movie) throws Exception;

	/**
	 * Vraca prosecnu ocenu odredjenog filma.
	 * @param movieId Id filma ciju prosecnu ocenu zelimo
	 * @return Prosecna ocena filma
	 * @throws Exception
	 */
	double getRating(Long movieId) throws Exception;

	/**
	 * Vraca broj ocena odredjenog filma.
	 * @param movieId Id filma ciji broj ocena zelimo 
	 * @return Broj ocena
	 * @throws Exception
	 */
	int getReviews(Long movieId) throws Exception;

	/**
	 * Dodaje filmu u listu 'za gledanje'.
	 * @param movie Film koji se dodaje u listu
	 * @param user Korisnik u ciju se listu 'za gledanje' film dodaje
	 * @throws Exception
	 */
	void addToWatchlist(Movie movie, User user) throws Exception;

	/**
	 * Proverava da li se odredjeni film nalazi u listi 'za gledanje'.
	 * @param user Korisnik cija lista 'za gledanje' se proverava
	 * @param movie Film za koji se proverava da li se nalazi u listi
	 * @return <b>True</b> ukoliko film postoji u listi 'za gledanje' odredjenog korisnika, 
	 * u suprotnom vraca <b>False</b>.
	 * @throws Exception
	 */
	boolean findMovieInWatchlist(User user, Movie movie) throws Exception;

	/**
	 * Brise film iz liste 'za gledanje' odredjenog korisnika.
	 * @param user Korisnik iz cije se liste brise film
	 * @param movie Film koji se brise iz liste
	 * @throws Exception
	 */
	void removeFromWatchlist(User user, Movie movie) throws Exception;

	/**
	 * Vraca filmove iz liste 'za gledanje' odredjenog zanra.
	 * @param searchGenre Zanr koji se koristi za filtriranje filmova
	 * @param user Korisnik cija lista 'za gledanje' se posmatra
	 * @return Lista filmova iz liste korisnika odredjenog zanra
	 * @throws Exception
	 */
	List<Movie> getSpecificGenreWatchlist(Genre searchGenre, User user) throws Exception;

	/**
	 * Vraca sve filmove iz liste 'za gledanje; odredjenog korisnika.
	 * @param user Kosrinik ciju listu zelimo
	 * @return Lista filmova iz liste 'za gledanje' odredjenog korisnika
	 * @throws Exception
	 */
	List<Movie> getAllFromWatchlist(User user) throws Exception;

	Movie findMovieById(Long id) throws Exception;

}
