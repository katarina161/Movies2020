package rs.ac.bg.fon.nprog.Movies.storage;

import rs.ac.bg.fon.nprog.Movies.domain.User;

public interface StorageUser {
	
	/**
	 * Prijavljuje korisnika na sistem.
	 * @param username Korisnicko ime korisnika
	 * @param password Sifra korisnika
	 * @return Korisnik koji je izvrsio prijavljivanje
	 * @throws Exception Ukoliko takav korisnik ne postoji u sistemu.
	 */
	User login(String username, String password) throws Exception;

	/**
	 * Pravi nalog za novog korisnika.
	 * @param user Korisnik koji zeli da napravi nalog
	 * @throws Exception 
	 */
	void registrate(User user) throws Exception;

}
