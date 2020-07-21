package rs.ac.bg.fon.nprog.Movies.ui.component.table.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.Movies.domain.Movie;

@SuppressWarnings("serial")
public class MovieTableModel extends AbstractTableModel{
	
	private final List<Movie> movies;
	private String[] columnNames = new String[] {"Title", "Year", "Genre"};
	
	public MovieTableModel(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		if(movies == null)
			return 0;
		
		return movies.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Movie movie = movies.get(row);
		switch (column) {
		case 0:
			return movie.getTitle();
		case 1:
			return movie.getYear();
		case 2:
			return movie.getGenres();
		default:
			return "n/a";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		if(column > columnNames.length)
			return "n/a";
		
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Movie getMovie(int index) {
		return movies.get(index);
	}

}
