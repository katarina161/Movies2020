package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.domain.Genre;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;
import rs.ac.bg.fon.nprog.Movies.domain.User;
import rs.ac.bg.fon.nprog.Movies.ui.component.table.model.MovieTableModel;

@SuppressWarnings("serial")
public class FMain extends JFrame {
	
	private FMain thisFrame;
	
	private JPanel contentPane;
	private JPanel sidePane;
	private JTable jtblMovies;
	private JScrollPane scrollPane;
	private JButton btnDetails;
	private JComboBox<Genre> cbGenres;
	private JLabel lblGenre;
	private List<Movie> movies;
	private boolean testActionListener;
	private JButton btnAllMovies;
	private User currentUser;
	private JLabel lblLogOut;
	private JButton btnYourWatchlist;
	
	private boolean seeWatchlist;
	
	/**
	 * Create the frame.
	 */
	public FMain() {
		thisFrame = this;
		currentUser = (User) Controller.getInstance().getMap().get("currentUser");
		setTitle(currentUser.getUsername());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 433);
		contentPane = new JPanel();
		sidePane = new JPanel();
		sidePane.setPreferredSize(new Dimension(300, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(sidePane, BorderLayout.EAST);
		contentPane.add(getLblLogOut(), BorderLayout.SOUTH);
		sidePane.setLayout(null);
		sidePane.add(getLblGenre());
		sidePane.add(getCbGenres());
		sidePane.add(getBtnAllMovies());
		sidePane.add(getBtnDetails());
		sidePane.add(getBtnYourWatchlist());
//		sidePane.add(getLblLogOut());
		
		setLocationRelativeTo(null);
		movies = new ArrayList<Movie>();
		testActionListener = true;
		seeWatchlist = false;
		
		fillComboGenres();
		fillForm();
		
	}
	
	private void fillComboGenres() {
		testActionListener = false;
		cbGenres.removeAllItems();
		try {
			List<Genre> genres = Controller.getInstance().getAllGenres();
			for(Genre g : genres) {
				cbGenres.addItem(g);
			}
			
			cbGenres.setSelectedIndex(-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		testActionListener = true;
	}

	private JTable jtblMovies() {
		if (jtblMovies == null) {
			jtblMovies = new JTable();
			jtblMovies.setSelectionForeground(Color.WHITE);
			jtblMovies.setSelectionBackground(Color.RED);
			jtblMovies.setFont(new Font("Arial", Font.PLAIN, 15));
			jtblMovies.setFillsViewportHeight(true);
			jtblMovies.setRowHeight(30);
			jtblMovies.getTableHeader().setBackground(new Color(32, 136, 203));
			jtblMovies.getTableHeader().setForeground(new Color(255, 255, 255));
			jtblMovies.getTableHeader().setPreferredSize(new Dimension(100, 25));
			jtblMovies.setSelectionBackground(new Color(244, 37, 37));
			jtblMovies.setGridColor(Color.WHITE);
		}
		return jtblMovies;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(jtblMovies());
		}
		return scrollPane;
	}
	
	private Component getBtnDetails() {
		if(btnDetails == null) {
			btnDetails = new JButton();
			btnDetails.setBounds(35, 111, 253, 31);
			btnDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int selectedRow = jtblMovies.getSelectedRow();
					if(selectedRow == -1) {
						JOptionPane.showMessageDialog(null, "Please select a movie.");
					} else {
						MovieTableModel tm = (MovieTableModel) jtblMovies.getModel();
						Movie movie = tm.getMovie(selectedRow);
						new FMovie(movie, thisFrame).setVisible(true);
					}
				}
			});
			btnDetails.setBackground(new Color(244, 37, 37));
			btnDetails.setForeground(new Color(255, 255, 255));
			btnDetails.setToolTipText("Select a movie and click here to see details");
			btnDetails.setFont(new Font("Arial", Font.PLAIN, 18));
			btnDetails.setText("Details");
		}
		return btnDetails;
	}
	
	private JComboBox<Genre> getCbGenres() {
		if (cbGenres == null) {
			cbGenres = new JComboBox<Genre>();
			cbGenres.setBounds(35, 49, 116, 31);
			cbGenres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(testActionListener)
						fillForm();
				}
			});
			cbGenres.setBackground(new Color(255, 255, 255));
			cbGenres.setFont(new Font("Arial", Font.PLAIN, 17));
			
		}
		return cbGenres;
	}
	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel("Genre:");
			lblGenre.setBounds(35, 13, 79, 23);
			lblGenre.setFont(new Font("Arial", Font.PLAIN, 17));
		}
		return lblGenre;
	}
	private JButton getBtnAllMovies() {
		if (btnAllMovies == null) {
			btnAllMovies = new JButton();
			btnAllMovies.setBounds(172, 49, 116, 31);
			btnAllMovies.setBackground(new Color(32, 136, 203));
			btnAllMovies.setForeground(new Color(255, 255, 255));
			btnAllMovies.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					testActionListener = false;
					cbGenres.setSelectedIndex(-1);
					seeWatchlist = false;
					testActionListener = true;
					
					fillForm();
				}
			});
			btnAllMovies.setText("All Movies");
			btnAllMovies.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		return btnAllMovies;
	}
	
	private JLabel getLblLogOut() {
		if (lblLogOut == null) {
			lblLogOut = new JLabel("", JLabel.RIGHT);
			lblLogOut.setBounds(252, 327, 36, 36);
			lblLogOut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			lblLogOut.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
					Controller.getInstance().getMap().put("currentUser", null);
					new FLogIn().setVisible(true);
				}
			});
			lblLogOut.setToolTipText("Log Out");
			Image img = new ImageIcon(this.getClass().getResource("/icons/logout1.png")).getImage();
			lblLogOut.setIcon(new ImageIcon(img));
		}
		return lblLogOut;
	}
	
	
	
	
	/**
	 * Metoda koja popunjava tabelu svim filmovima iz baze ili filmovima odredjenog zanra, 
	 * ukoliko je selektovan odredjeni zanr.
	 */
	public void fillForm() {
		try {
			if(cbGenres.getSelectedIndex() != (-1)) {
				Genre searchGenre = (Genre) cbGenres.getSelectedItem();
				if(seeWatchlist) {
					movies = Controller.getInstance().getSpecificGenreWatchlist(searchGenre);
				} else
					movies = Controller.getInstance().getSpecificGenre(searchGenre);
			} else {
				if(seeWatchlist) {
					movies = Controller.getInstance().getAllFromWatchlist();
				} else
					movies = Controller.getInstance().getAllMovies();
			}
			
			for(Movie m : movies) {
				List<Genre> genres = Controller.getInstance().findMovieGenres(m.getId());
				m.setGenres(genres);
			}
			
			jtblMovies.setModel(new MovieTableModel(movies));
			jtblMovies.getColumnModel().getColumn(0).setPreferredWidth(150);
			jtblMovies.getColumnModel().getColumn(1).setPreferredWidth(7);
			jtblMovies.getColumnModel().getColumn(2).setPreferredWidth(300);
		} catch (Exception e) {
			if(e.getMessage().equals("Empty watchlist")) {
				seeWatchlist = false;
				JOptionPane.showMessageDialog(null, "Your watchlist is empty!");
				fillForm();
			} else
				System.out.println(e.getMessage());
		}
	}
	private JButton getBtnYourWatchlist() {
		if (btnYourWatchlist == null) {
			btnYourWatchlist = new JButton();
			btnYourWatchlist.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					seeWatchlist = true;
					fillForm();
				}
			});
			btnYourWatchlist.setToolTipText("");
			btnYourWatchlist.setText("Your Watchlist");
			btnYourWatchlist.setForeground(new Color(244, 37, 37));
			btnYourWatchlist.setFont(new Font("Arial", Font.PLAIN, 18));
			btnYourWatchlist.setBackground(Color.WHITE);
			btnYourWatchlist.setBounds(35, 166, 253, 31);
		}
		return btnYourWatchlist;
	}
}
