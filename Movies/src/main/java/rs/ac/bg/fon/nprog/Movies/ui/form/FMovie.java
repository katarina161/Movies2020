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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.domain.Movie;

@SuppressWarnings("serial")
public class FMovie extends JFrame {

	final Image blackStar = new ImageIcon(this.getClass().getResource("/icons/blackStar1.png")).getImage();
	final Image goldStar = new ImageIcon(this.getClass().getResource("/icons/goldStar1.png")).getImage();
	final Image userBlackStar = new ImageIcon(this.getClass().getResource("/icons/userBlackStar.png")).getImage();
	final Image userGoldStar = new ImageIcon(this.getClass().getResource("/icons/userGoldStar.png")).getImage();
	final Image cancel = new ImageIcon(this.getClass().getResource("/icons/cancel.png")).getImage();
	
	private Movie movie;
	private int userRating;
	
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
	private JSeparator separator;
	
	JLabel stars[] = new JLabel[10];
	private JPanel panel;
	private JLabel lblRating;
	private JLabel lblReviews;
	private JLabel label_1;
	private JLabel lblCancel;
	/**
	 * Create the frame.
	 */
	public FMovie(Movie movie) {
		this.movie = movie;
		try {
			userRating = Controller.getInstance().getUserRating(movie);
			movie.setReviews(Controller.getInstance().getReviews(movie.getId()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		setTitle(movie.getTitle() +" (" +movie.getYear() +")");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 661);
		contentPane = new JPanel();
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setSize(1, 50);
		separator.setLocation(545, 469);
		separator.setBackground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
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
		contentPane.add(getPanel());
		contentPane.add(getLblUserRatingStar());
		contentPane.add(getLblUserRating());
		contentPane.add(separator);
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
		contentPane.add(getLblRating());
		contentPane.add(getLblReviews());
		contentPane.add(getLabel_1());
		contentPane.add(getLblCancel());
		fillStars();
		
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
			lblTitle.setBounds(0, 13, 848, 64);
		}
		return lblTitle;
	}
	private JLabel getLblCoverImage() {
		if (lblCoverImage == null) {
			lblCoverImage = new JLabel("");
			lblCoverImage.setHorizontalAlignment(SwingConstants.CENTER);
			if(movie.getImage() != null) {
				Image img = new ImageIcon(this.getClass().getResource("/covers/" +movie.getImage())).getImage().getScaledInstance(310, 440, Image.SCALE_DEFAULT);
				lblCoverImage.setIcon(new ImageIcon(img));
			}
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
			lblStar1.setBounds(12, 7, 26, 26);
			lblStar1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(1);
					lblUserRating.setText("1");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 1;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar1;
	}
	private JLabel getLblStar2() {
		if (lblStar2 == null) {
			lblStar2 = new JLabel("");
			lblStar2.setBounds(38, 7, 26, 26);
			lblStar2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(2);
					lblUserRating.setText("2");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 2;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar2;
	}
	private JLabel getLblStar3() {
		if (lblStar3 == null) {
			lblStar3 = new JLabel("");
			lblStar3.setBounds(64, 7, 26, 26);
			lblStar3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(3);
					lblUserRating.setText("3");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 3;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar3;
	}
	private JLabel getLblStar4() {
		if (lblStar4 == null) {
			lblStar4 = new JLabel("");
			lblStar4.setBounds(90, 7, 26, 26);
			lblStar4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(4);
					lblUserRating.setText("4");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 4;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar4;
	}
	private JLabel getLblStar5() {
		if (lblStar5 == null) {
			lblStar5 = new JLabel("");
			lblStar5.setBounds(116, 7, 26, 26);
			lblStar5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(5);
					lblUserRating.setText("5");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 5;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar5;
	}
	private JLabel getLblStar6() {
		if (lblStar6 == null) {
			lblStar6 = new JLabel("");
			lblStar6.setBounds(142, 7, 26, 26);
			lblStar6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(6);
					lblUserRating.setText("6");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 6;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar6;
	}
	private JLabel getLblStar7() {
		if (lblStar7 == null) {
			lblStar7 = new JLabel("");
			lblStar7.setBounds(168, 7, 26, 26);
			lblStar7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(7);
					lblUserRating.setText("7");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 7;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar7;
	}
	private JLabel getLblStar8() {
		if (lblStar8 == null) {
			lblStar8 = new JLabel("");
			lblStar8.setBounds(194, 7, 26, 26);
			lblStar8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(8);
					lblUserRating.setText("8");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 8;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar8;
	}
	private JLabel getLblStar9() {
		if (lblStar9 == null) {
			lblStar9 = new JLabel("");
			lblStar9.setBounds(220, 7, 26, 26);
			lblStar9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(9);
					lblUserRating.setText("9");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 9;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar9;
	}
	private JLabel getLblStar10() {
		if (lblStar10 == null) {
			lblStar10 = new JLabel("");
			lblStar10.setBounds(246, 7, 26, 26);
			lblStar10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					colorStarsGold(10);
					lblUserRating.setText("10");
					lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					colorStarsBlack();
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					userRating = 10;
					try {
						Controller.getInstance().saveUserRating(movie, userRating);
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
		}
		return lblStar10;
	}
	
	public void colorStarsGold(int numberOfStars) {
		colorStarsBlack();
		for(int i = 1; i <= numberOfStars; i++) {
			stars[i-1].setIcon(new ImageIcon(goldStar));
		}
	}
	
	public void colorStarsBlack() {
		for(JLabel label : stars) {
			label.setIcon(new ImageIcon(blackStar));
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
			colorUserRatingStar();
			lblUserRatingStar.setBounds(455, 469, 36, 36);
		}
		return lblUserRatingStar;
	}
	private JLabel getLblUserRating() {
		if (lblUserRating == null) {
			lblUserRating = new JLabel("");
			lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
			fillUserRatingLabel();
			lblUserRating.setHorizontalAlignment(SwingConstants.LEFT);
			lblUserRating.setBounds(498, 469, 36, 32);
		}
		return lblUserRating;
	}
	private JLabel getLblRatedOrNot() {
		if (lblRatedOrNot == null) {
			lblRatedOrNot = new JLabel("");
			lblRatedOrNot.setFont(new Font("Arial", Font.PLAIN, 15));
			if(userRating > 0)
				lblRatedOrNot.setText("You");
			lblRatedOrNot.setBounds(498, 503, 36, 16);
		}
		return lblRatedOrNot;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					fillStars();
					lblUserRating.setText(String.valueOf(userRating));
					colorUserRatingStar();
					fillUserRatingLabel();
					showRating();
					showReviews();
				}
			});
			panel.setBounds(450, 420, 285, 40);
			panel.setLayout(null);
			panel.add(getLblStar1());
			panel.add(getLblStar2());
			panel.add(getLblStar3());
			panel.add(getLblStar4());
			panel.add(getLblStar5());
			panel.add(getLblStar6());
			panel.add(getLblStar7());
			panel.add(getLblStar8());
			panel.add(getLblStar9());
			panel.add(getLblStar10());
		}
		return panel;
	}
	private JLabel getLblRating() {
		if (lblRating == null) {
			lblRating = new JLabel("");
			showRating();
			lblRating.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRating.setBounds(564, 469, 46, 33);
		}
		return lblRating;
	}
	private JLabel getLblReviews() {
		if (lblReviews == null) {
			lblReviews = new JLabel("");
			lblReviews.setForeground(Color.GRAY);
			lblReviews.setFont(new Font("Arial", Font.PLAIN, 15));
			showReviews();
			lblReviews.setBounds(572, 501, 74, 16);
		}
		return lblReviews;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("/10");
			label_1.setForeground(Color.GRAY);
			label_1.setFont(new Font("Arial", Font.PLAIN, 15));
			label_1.setBounds(613, 485, 28, 16);
		}
		return label_1;
	}
	
	public void colorUserRatingStar() {
		if(userRating > 0) {
			lblUserRatingStar.setIcon(new ImageIcon(userGoldStar));
		} else {
			lblUserRatingStar.setIcon(new ImageIcon(userBlackStar));
		}
	}
	
	public void fillUserRatingLabel() {
		if(userRating > 0) {
			lblUserRating.setText(String.valueOf(userRating));
			lblUserRating.setFont(new Font("Arial", Font.PLAIN, 30));
		} else {
			lblUserRating.setText("<html>Rate<br/>This</html>");
			lblUserRating.setFont(new Font("Arial", Font.PLAIN, 15));
		}
	}
	
	public void showRating() {
		double setRating = getMovieRating();
		int intPart = (int)setRating;
		String print;
		if(setRating - intPart == 0)
			print = String.valueOf(intPart);
		else
			print = String.valueOf(setRating);
		if(setRating == 0) {
			lblRating.setText("<html>No<br/>Rating</html>");
			lblRating.setFont(new Font("Arial", Font.PLAIN, 15));
		} else {
			lblRating.setText(print);
			lblRating.setFont(new Font("Arial", Font.PLAIN, 30));
		}
	}
	
	public void showReviews() {
		int reviews = getMovieReviews();
		lblReviews.setText(String.valueOf(reviews));
	}
	
	private JLabel getLblCancel() {
		if (lblCancel == null) {
			lblCancel = new JLabel("");
			lblCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Controller.getInstance().deleteUserRating(movie);
						userRating = 0;
						fillStars();
						colorUserRatingStar();
						fillUserRatingLabel();
						showRating();
						showReviews();
						lblRatedOrNot.setText("");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
			});
			lblCancel.setHorizontalAlignment(SwingConstants.LEFT);
			lblCancel.setIcon(new ImageIcon(cancel));
			lblCancel.setBounds(737, 425, 28, 33);
		}
		return lblCancel;
	}
	
	private double getMovieRating() {
		try {
			double rating = Controller.getInstance().getRating(movie.getId());
			movie.setRating(rating);
			
			return movie.getRating();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return movie.getRating();
	}
	
	private int getMovieReviews() {
		try {
			int reviews = Controller.getInstance().getReviews(movie.getId());
			movie.setReviews(reviews);
			
			return movie.getReviews();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return movie.getReviews();
	}
}
