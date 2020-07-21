package rs.ac.bg.fon.nprog.Movies.domain;

/**
 * Klasa predstavlj zanr film.
 * 
 * @author Katarina
 *
 */
public class Genre {
	
	/**
	 * id zanra
	 */
	private Long id;
	
	/**
	 * naziv zanra
	 */
	private String name;

	/**
	 * Vraca id zanra.
	 * 
	 * @return id zanra
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
	 * Vraca naziv zanra.
	 * 
	 * @return naziv zanra.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Postavlja vrednost atributa naziv zanra.
	 * 
	 * @param name Nova vrednost atributa naziv zanra.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
