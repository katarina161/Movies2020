package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	final Image blackStar = new ImageIcon(this.getClass().getResource("/icons/blackStar1.png")).getImage();
	final Image goldStar = new ImageIcon(this.getClass().getResource("/icons/goldStar1.png")).getImage();
	final Image userBlackStar = new ImageIcon(this.getClass().getResource("/icons/userBlackStar.png")).getImage();
	final Image userGoldStar = new ImageIcon(this.getClass().getResource("/icons/userGoldStar.png")).getImage();
	
	private Movie movie;
	private int userRating = 8;
	
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCoverImage;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblYear;
	private JLabel lblGenres;
	private JLabel lblDuration;
	private JLabel lblStar1;
	private JLabel lblStar2;
	private JLabel lblStar3;
	private JLabel lblStar4;
	private JLabel lblStar5;
	private JLabel lblStar6;
	private JLabel lblStar7;
	private JLabel lblStar8;
	private JLabel lblStar9;
	private JLabel lblStar10;
	private JLabel lblUserRatingStar;
	private JLabel lblUserRating;
	private JLabel lblRatedOrNot;
	
	JLabel stars[] = new JLabel[10];
	/**
	 * Create the frame.
	 */
	public FMovie(Movie movie) {
		this.movie = movie;
		setTitle(movie.getTitle() +" (" +movie.getYear() +")");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 661);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		contentPane.add(getLblStar1());
		contentPane.add(getLblStar2());
		contentPane.add(getLblStar3());
		contentPane.add(getLblStar4());
		contentPane.add(getLblStar5());
		contentPane.add(getLblStar6());
		contentPane.add(getLblStar7());
		contentPane.add(getLblStar8());
		contentPane.add(getLblStar9());
		contentPane.add(getLblStar10());
		contentPane.add(getLblUserRatingStar());
		contentPane.add(getLblUserRating());
		contentPane.add(getLblRatedOrNot());
		
		stars[0] = getLblStar1();
		stars[1] = getLblStar2();
		stars[2] = getLblStar3();
		stars[3] = getLblStar4();
		stars[4] = getLblStar5();
		stars[5] = getLblStar6();
		stars[6] = getLblStar7();
		stars[7] = getLblStar8();
		stars[8] = getLblStar9();
		stars[9] = getLblStar10();
		fillStars();
		
//		for (JLabel jLabel : stars) {
//			jLabel.setIcon(new ImageIcon(blackStar));
//		}
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("", SwingConstants.CENTER);
			lblTitle.setOpaque(true);
			lblTitle.setBackground(new Color(244, 37, 37));
			lblTitle.setForeground(new Color(255, 255, 255));
			lblTitle.setText(movie.getTitle());
			lblTitle.setFont(new Font("Castellar", Font.BOLD, 40));
			lblTitle.setBounds(0, 13, 835, 64);
		}
		return lblTitle;
	}
	private JLabel getLblCoverImage() {
		if (lblCoverImage == null) {
			lblCoverImage = new JLabel("");
			lblCoverImage.setHorizontalAlignment(SwingConstants.CENTER);
			Image img = new ImageIcon(this.getClass().getResource("/covers/" +movie.getImage())).getImage().getScaledInstance(310, 440, Image.SCALE_DEFAULT);
			lblCoverImage.setIcon(new ImageIcon(img));
			lblCoverImage.setBounds(39, 100, 360, 480);
//			Border pictureBorder = BorderFactory.createRaisedBevelBorder();
//			lblCoverImage.setBorder(pictureBorder);
			Border redline = BorderFactory.createLineBorder(new Color(244, 37, 37), 5);
			Border blueline = BorderFactory.createLineBorder(new Color(32, 136, 203), 5);
			Border compound = BorderFactory.createCompoundBorder(blueline, redline);
			lblCoverImage.setBorder(compound);
			
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
	
	private JLabel getLblStar1() {
		if (lblStar1 == null) {
			lblStar1 = new JLabel("");
			lblStar1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(1);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(1);
				}
			});
			lblStar1.setBounds(455, 419, 26, 26);
		}
		return lblStar1;
	}
	private JLabel getLblStar2() {
		if (lblStar2 == null) {
			lblStar2 = new JLabel("");
			lblStar2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(2);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(2);
				}
			});
			lblStar2.setBounds(488, 419, 26, 26);
		}
		return lblStar2;
	}
	private JLabel getLblStar3() {
		if (lblStar3 == null) {
			lblStar3 = new JLabel("");
			lblStar3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(3);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(3);
				}
			});
			lblStar3.setBounds(521, 419, 26, 26);
		}
		return lblStar3;
	}
	private JLabel getLblStar4() {
		if (lblStar4 == null) {
			lblStar4 = new JLabel("");
			lblStar4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(4);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(4);
				}
			});
			lblStar4.setBounds(554, 419, 26, 26);
		}
		return lblStar4;
	}
	private JLabel getLblStar5() {
		if (lblStar5 == null) {
			lblStar5 = new JLabel("");
			lblStar5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(5);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(5);
				}
			});
			lblStar5.setBounds(587, 419, 26, 26);
		}
		return lblStar5;
	}
	private JLabel getLblStar6() {
		if (lblStar6 == null) {
			lblStar6 = new JLabel("");
			lblStar6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(6);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(6);
				}
			});
			lblStar6.setBounds(623, 419, 26, 26);
		}
		return lblStar6;
	}
	private JLabel getLblStar7() {
		if (lblStar7 == null) {
			lblStar7 = new JLabel("");
			lblStar7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(7);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(7);
				}
			});
			lblStar7.setBounds(656, 419, 26, 26);
		}
		return lblStar7;
	}
	private JLabel getLblStar8() {
		if (lblStar8 == null) {
			lblStar8 = new JLabel("");
			lblStar8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(8);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(8);
				}
			});
			lblStar8.setBounds(689, 419, 26, 26);
		}
		return lblStar8;
	}
	private JLabel getLblStar9() {
		if (lblStar9 == null) {
			lblStar9 = new JLabel("");
			lblStar9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(9);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(9);
				}
			});
			lblStar9.setBounds(722, 419, 26, 26);
		}
		return lblStar9;
	}
	private JLabel getLblStar10() {
		if (lblStar10 == null) {
			lblStar10 = new JLabel("");
			lblStar10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(10);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack(10);
				}
			});
			lblStar10.setBounds(755, 419, 26, 26);
		}
		return lblStar10;
	}
	
	public void colorStarsGold(int numberOfStars) {
		for(int i = 1; i <= numberOfStars; i++) {
			stars[i-1].setIcon(new ImageIcon(goldStar));
		}
	}
	
	public void colorStarsBlack(int numberOfStars) {
		for(int i = numberOfStars; i > 0; i--) {
			stars[i-1].setIcon(new ImageIcon(blackStar));
		}
	}
	
	public void fillStars() {
		for(int i = 1; i <= userRating; i++) {
			stars[i-1].setIcon(new ImageIcon(goldStar));
		}
		for(int i = userRating+1; i <= stars.length; i++) {
			stars[i-1].setIcon(new ImageIcon(blackStar));
		}
	}
	
	private JLabel getLblUserRatingStar() {
		if (lblUserRatingStar == null) {
			lblUserRatingStar = new JLabel("");
			if(userRating > 0) {
				lblUserRatingStar.setIcon(new ImageIcon(userGoldStar));
			} else {
				lblUserRatingStar.setIcon(new ImageIcon(userBlackStar));
			}
			lblUserRatingStar.setBounds(455, 469, 36, 36);
		}
		return lblUserRatingStar;
	}
	private JLabel getLblUserRating() {
		if (lblUserRating == null) {
			lblUserRating = new JLabel("");
			if(userRating > 0) {
				lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				lblUserRating.setText(String.valueOf(userRating));
			} else {
				lblUserRating.setFont(new Font("Arial", Font.PLAIN, 15));
				lblUserRating.setText("<html>Rate<br/>This</html>");
			}
			lblUserRating.setHorizontalAlignment(SwingConstants.LEFT);
			lblUserRating.setBounds(498, 469, 50, 33);
		}
		return lblUserRating;
	}
	private JLabel getLblRatedOrNot() {
		if (lblRatedOrNot == null) {
			lblRatedOrNot = new JLabel("");
			lblRatedOrNot.setFont(new Font("Arial", Font.PLAIN, 15));
			if(userRating > 0)
				lblRatedOrNot.setText("You");
			lblRatedOrNot.setBounds(498, 503, 50, 16);
		}
		return lblRatedOrNot;
	}
}
