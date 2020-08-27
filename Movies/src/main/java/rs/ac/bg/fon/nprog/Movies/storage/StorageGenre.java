package rs.ac.bg.fon.nprog.Movies.storage;

import java.util.List;

import rs.ac.bg.fon.nprog.Movies.domain.Genre;

public interface StorageGenre {

	/**
	 * Vraca sve zanrove iz baze.
	 * @return Lista svih zanrova iz baze
	 * @throws Exception
	 */
	List<Genre> getAll();
	
	/**
	 * Pronalazi zanrove odredjenog filma.
	 * @param id Id filma cije zanrove zelimo
	 * @return Lista zanrova odredjenog filma
	 * @throws Exception
	 */
	List<Genre> findGenres(Long id) throws Exception;

}
