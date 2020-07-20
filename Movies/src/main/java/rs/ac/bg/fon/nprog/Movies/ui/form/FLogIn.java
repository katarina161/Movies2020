package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;

@SuppressWarnings("serial")
public class FLogIn extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JButton btnRegister;
	private JButton btnLogIn;
	private JPasswordField txtPassword;
	private JLabel lblUsernameErr;
	private JLabel lblPasswordErr;
	private JLabel lblUserErr;
	private JLabel lblImage;
	private JRootPane rootPane;

	/**
	 * Create the frame.
	 */
	public FLogIn() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtUsername());
		contentPane.add(getBtnRegister());
		contentPane.add(getBtnLogIn());
		contentPane.add(getTxtPassword());
		contentPane.add(getLblUsernameErr());
		contentPane.add(getLblPasswordErr());
		contentPane.add(getLblUserErr());
		contentPane.add(getLblImage());
		prepareForm();
	}

	public void prepareForm() {
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setFocusable(true);
		
		rootPane = SwingUtilities.getRootPane(getBtnLogIn());
		rootPane.setDefaultButton(getBtnLogIn());
	}
	
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Arial", Font.PLAIN, 28));
			lblUsername.setBounds(303, 104, 159, 30);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 28));
			lblPassword.setBounds(303, 183, 159, 24);
		}
		return lblPassword;
	}
	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblUsernameErr.setText("");
					lblUserErr.setText("");
				}
			});
			txtUsername.setFont(new Font("Arial", Font.PLAIN, 20));
			txtUsername.setToolTipText("");
			txtUsername.setBounds(474, 105, 202, 33);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblUserErr.setText("");
					lblUsernameErr.setText("");
					lblPasswordErr.setText("");
					
					new FRegister().setVisible(true);
				}
			});
			Image img = new ImageIcon(this.getClass().getResource("/icons/activation1.png")).getImage();
			btnRegister.setIcon(new ImageIcon(img));
			btnRegister.setFont(new Font("Arial", Font.PLAIN, 25));
			btnRegister.setBounds(303, 266, 159, 46);
		}
		return btnRegister;
	}
	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			Image img = new ImageIcon(this.getClass().getResource("/icons/login1.png")).getImage();
			btnLogIn.setIcon(new ImageIcon(img));
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String username = txtUsername.getText();
					String password = String.valueOf(txtPassword.getPassword());
					
					if(username.isEmpty()) {
						lblUsernameErr.setText("Please enter your username.");
					}
					if(password.isEmpty()) {
						lblPasswordErr.setText("Please enter your password");
					}
					
					try {
						Controller.getInstance().login(username, password);
						dispose();
						new FMain().setVisible(true);
					} catch (Exception e) {
						if(!username.isEmpty() && !password.isEmpty())
							lblUserErr.setText("No such user. Please try again!");
						txtPassword.setText("");
						System.out.println(e.getMessage());
					}
				}
			});
			btnLogIn.setFont(new Font("Arial", Font.PLAIN, 25));
			btnLogIn.setBounds(517, 266, 159, 46);
		}
		return btnLogIn;
	}
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblPasswordErr.setText("");
					lblUserErr.setText("");
				}
			});
			txtPassword.setBounds(474, 180, 202, 33);
		}
		return txtPassword;
	}
	
	private JLabel getLblUsernameErr() {
		if (lblUsernameErr == null) {
			lblUsernameErr = new JLabel("");
			lblUsernameErr.setForeground(Color.RED);
			lblUsernameErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblUsernameErr.setBounds(474, 76, 202, 16);
		}
		return lblUsernameErr;
	}
	private JLabel getLblPasswordErr() {
		if (lblPasswordErr == null) {
			lblPasswordErr = new JLabel("");
			lblPasswordErr.setForeground(Color.RED);
			lblPasswordErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPasswordErr.setBounds(474, 151, 202, 16);
		}
		return lblPasswordErr;
	}
	private JLabel getLblUserErr() {
		if (lblUserErr == null) {
			lblUserErr = new JLabel("");
			lblUserErr.setForeground(Color.RED);
			lblUserErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblUserErr.setBounds(303, 226, 373, 24);
		}
		return lblUserErr;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBounds(37, 60, 256, 308);
			Image img = new ImageIcon(this.getClass().getResource("/icons/popcorn.png")).getImage();
			lblImage.setIcon(new ImageIcon(img));
		}
		return lblImage;
	}
}
