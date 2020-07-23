package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import rs.ac.bg.fon.nprog.Movies.domain.Movie;

@SuppressWarnings("serial")
public class FMovie extends JFrame {

	private Movie movie;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCoverImage;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblYear;
	private JLabel lblGenres;
	private JLabel lblDuration;

	/**
	 * Create the frame.
	 */
	public FMovie(Movie movie) {
		this.movie = movie;
		setTitle(movie.getTitle() +" (" +movie.getYear() +")");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 931, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitle());
		contentPane.add(getLblCoverImage());
		contentPane.add(getLbl1());
		contentPane.add(getLbl2());
		contentPane.add(getLbl3());
		contentPane.add(getLblYear());
		contentPane.add(getLblGenres());
		contentPane.add(getLblDuration());
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("", SwingConstants.CENTER);
			lblTitle.setOpaque(true);
			lblTitle.setBackground(new Color(32, 136, 203));
			lblTitle.setForeground(new Color(255, 255, 255));
			lblTitle.setText(movie.getTitle());
			lblTitle.setFont(new Font("Castellar", Font.BOLD, 40));
			lblTitle.setBounds(12, 13, 887, 64);
		}
		return lblTitle;
	}
	private JLabel getLblCoverImage() {
		if (lblCoverImage == null) {
			lblCoverImage = new JLabel("");
			lblCoverImage.setHorizontalAlignment(SwingConstants.CENTER);
			Border pictureBorder = BorderFactory.createRaisedBevelBorder();
			Image img = new ImageIcon(this.getClass().getResource("/covers/" +movie.getImage())).getImage().getScaledInstance(330, 435, Image.SCALE_DEFAULT);
			lblCoverImage.setIcon(new ImageIcon(img));
			lblCoverImage.setBounds(39, 123, 370, 480);
			lblCoverImage.setBorder(pictureBorder);
		}
		return lblCoverImage;
	}
	private JLabel getLbl1() {
		if (lbl1 == null) {
			lbl1 = new JLabel("Year :");
			lbl1.setForeground(new Color(32, 136, 203));
			lbl1.setFont(new Font("Cambria Math", Font.PLAIN, 27));
			lbl1.setBounds(464, 154, 135, 33);
		}
		return lbl1;
	}
	private JLabel getLbl2() {
		if (lbl2 == null) {
			lbl2 = new JLabel("Genres :");
			lbl2.setForeground(new Color(32, 136, 203));
			lbl2.setFont(new Font("Cambria Math", Font.PLAIN, 27));
			lbl2.setBounds(464, 269, 135, 33);
		}
		return lbl2;
	}
	private JLabel getLbl3() {
		if (lbl3 == null) {
			lbl3 = new JLabel("Duration :");
			lbl3.setForeground(new Color(32, 136, 203));
			lbl3.setFont(new Font("Cambria Math", Font.PLAIN, 27));
			lbl3.setBounds(464, 210, 135, 33);
		}
		return lbl3;
	}
	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("");
			lblYear.setText(String.valueOf(movie.getYear()));
			lblYear.setFont(new Font("Cambria Math", Font.PLAIN, 27));
			lblYear.setBounds(611, 154, 135, 33);
		}
		return lblYear;
	}
	private JLabel getLblGenres() {
		if (lblGenres == null) {
			lblGenres = new JLabel("");
			lblGenres.setVerticalAlignment(SwingConstants.TOP);
			lblGenres.setHorizontalAlignment(SwingConstants.LEFT);
			String genres = movie.getGenres().toString().replace("[", "").replace("]", "");
			String[] splitGenres = genres.split(",");
			String print = "<html><ul>";
			for(String s : splitGenres) {
				s = "<li>" +s+ "</li>";
				print = print.concat(s);
			}
			lblGenres.setText(print+ "</ul></html>");
			lblGenres.setFont(new Font("Cambria Math", Font.PLAIN, 25));
			lblGenres.setBounds(574, 257, 172, 111);
		}
		return lblGenres;
	}
	private JLabel getLblDuration() {
		if (lblDuration == null) {
			lblDuration = new JLabel("");
			String hours = String.valueOf(movie.getDuration() / 60);
			String minutes = String.valueOf(movie.getDuration() % 60);
			lblDuration.setText(hours+ "h " +minutes+ "min");
			lblDuration.setFont(new Font("Cambria Math", Font.PLAIN, 27));
			lblDuration.setBounds(611, 210, 135, 33);
		}
		return lblDuration;
	}
}
