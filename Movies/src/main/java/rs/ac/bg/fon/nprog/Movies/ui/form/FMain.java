package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.ui.component.table.model.MovieTableModel;

@SuppressWarnings("serial")
public class FMain extends JFrame {

	private JPanel contentPane;
	private JTable jtblMovies;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public FMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		
		setLocationRelativeTo(null);
		
		fillForm();
	}
	private JTable getTable_1() {
		if (jtblMovies == null) {
			jtblMovies = new JTable();
			jtblMovies.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		return jtblMovies;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 13, 667, 360);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	
	
	public void fillForm() {
		try {
			List<Movie> movies = Controller.getInstance().getAllMovies();
			
			for(Movie m : movies) {
				List<Genre> genres = Controller.getInstance().findMovieGenres(m.getId());
				m.setGenres(genres);
			}
			
			jtblMovies.setModel(new MovieTableModel(movies));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
