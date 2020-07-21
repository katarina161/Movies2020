package rs.ac.bg.fon.nprog.Movies.ui.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import rs.ac.bg.fon.nprog.Movies.controller.Controller;
import rs.ac.bg.fon.nprog.Movies.domain.User;

@SuppressWarnings("serial")
public class FRegister extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblRegistration;
	private JSeparator separator;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JLabel lblFirstNameErr;
	private JLabel lbllastName;
	private JTextField txtLastName;
	private JLabel lblLastNameErr;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblUsernameErr;
	private JLabel lblPasswordErr;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JLabel lblBirthday;
	private JDateChooser dateChooser;
	private JButton btnReset;
	private JButton btnSubmit;
	private ButtonGroup bg;
	private JLabel lblGenderErr;
	private JLabel lblDateErr;
	private JLabel lblError;
	private JRootPane rootPane;
	private DateFormat df;

	/**
	 * Create the dialog.
	 */
	public FRegister() {
		setTitle("Registration form");
		setModal(true);
		setBounds(100, 100, 483, 746);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblRegistration());
		contentPanel.add(getSeparator_1());
		contentPanel.add(getLblFirstName());
		contentPanel.add(getTxtFirstName());
		contentPanel.add(getLblFirstNameErr());
		contentPanel.add(getLbllastName());
		contentPanel.add(getTxtLastName());
		contentPanel.add(getLblLastNameErr());
		contentPanel.add(getLblUsername());
		contentPanel.add(getTxtUsername());
		contentPanel.add(getLblUsernameErr());
		contentPanel.add(getLblPasswordErr());
		contentPanel.add(getLblPassword());
		contentPanel.add(getTxtPassword());
		contentPanel.add(getLblGender());
		contentPanel.add(getRdbtnMale());
		contentPanel.add(getRdbtnFemale());
		contentPanel.add(getLblBirthday());
		contentPanel.add(getDateChooser());
		contentPanel.add(getBtnReset());
		contentPanel.add(getBtnSubmit());
		contentPanel.add(getLblGenderErr());
		contentPanel.add(getLblDateErr());
		contentPanel.add(getLblError());
		bg = new ButtonGroup();
		df = new SimpleDateFormat("dd-MM-yyyy");
		prepareForm();
	}

	private void prepareForm() {
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setFocusable(true);
		bg.add(getRdbtnMale());
		bg.add(getRdbtnFemale());
		
		rootPane = SwingUtilities.getRootPane(getBtnSubmit());
		rootPane.setDefaultButton(getBtnSubmit());
	}
	private JLabel getLblRegistration() {
		if (lblRegistration == null) {
			lblRegistration = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/icons/registration.png")).getImage();
			lblRegistration.setIcon(new ImageIcon(img));
			lblRegistration.setBounds(49, 13, 374, 84);
		}
		return lblRegistration;
	}
	private JSeparator getSeparator_1() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 110, 442, 2);
		}
		return separator;
	}
	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First name:");
			lblFirstName.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFirstName.setBounds(29, 161, 113, 31);
		}
		return lblFirstName;
	}
	private JTextField getTxtFirstName() {
		if (txtFirstName == null) {
			txtFirstName = new JTextField();
			txtFirstName.setForeground(Color.GRAY);
			txtFirstName.setText("First name...");
			txtFirstName.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblFirstNameErr.setText("");
					if(txtFirstName.getText().equals("First name...")) {
						txtFirstName.setText("");
						txtFirstName.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtFirstName.getText().isEmpty())
						lblFirstNameErr.setText("Please enter your first name.");
				}
			});
			txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
			txtFirstName.setBounds(152, 166, 287, 25);
			txtFirstName.setColumns(10);
		}
		return txtFirstName;
	}
	private JLabel getLblFirstNameErr() {
		if (lblFirstNameErr == null) {
			lblFirstNameErr = new JLabel("");
			lblFirstNameErr.setForeground(Color.RED);
			lblFirstNameErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblFirstNameErr.setBounds(152, 125, 287, 34);
		}
		return lblFirstNameErr;
	}
	private JLabel getLbllastName() {
		if (lbllastName == null) {
			lbllastName = new JLabel("Last name:");
			lbllastName.setFont(new Font("Arial", Font.PLAIN, 20));
			lbllastName.setBounds(29, 240, 113, 31);
		}
		return lbllastName;
	}
	private JTextField getTxtLastName() {
		if (txtLastName == null) {
			txtLastName = new JTextField();
			txtLastName.setForeground(Color.GRAY);
			txtLastName.setText("Last name...");
			txtLastName.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					lblLastNameErr.setText("");
					if(txtLastName.getText().equals("Last name...")) {
						txtLastName.setText("");
						txtLastName.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtLastName.getText().isEmpty())
						lblLastNameErr.setText("Please enter your last name.");
				}
			});
			txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
			txtLastName.setBounds(152, 245, 287, 25);
			txtLastName.setColumns(10);
		}
		return txtLastName;
	}
	private JLabel getLblLastNameErr() {
		if (lblLastNameErr == null) {
			lblLastNameErr = new JLabel("");
			lblLastNameErr.setForeground(Color.RED);
			lblLastNameErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblLastNameErr.setBounds(152, 204, 287, 34);
		}
		return lblLastNameErr;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
			lblUsername.setBounds(29, 321, 113, 31);
		}
		return lblUsername;
	}
	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setForeground(Color.GRAY);
			txtUsername.setText("Username...");
			txtUsername.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					lblUsernameErr.setText("");
					if(txtUsername.getText().equals("Username...")) {
						txtUsername.setText("");
						txtUsername.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUsername.getText().isEmpty())
						lblUsernameErr.setText("Please enter your username.");
				}
			});
			txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
			txtUsername.setColumns(10);
			txtUsername.setBounds(152, 326, 287, 25);
		}
		return txtUsername;
	}
	private JLabel getLblUsernameErr() {
		if (lblUsernameErr == null) {
			lblUsernameErr = new JLabel("");
			lblUsernameErr.setForeground(Color.RED);
			lblUsernameErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblUsernameErr.setBounds(152, 285, 287, 34);
		}
		return lblUsernameErr;
	}
	private JLabel getLblPasswordErr() {
		if (lblPasswordErr == null) {
			lblPasswordErr = new JLabel("");
			lblPasswordErr.setForeground(Color.RED);
			lblPasswordErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPasswordErr.setBounds(152, 364, 287, 34);
		}
		return lblPasswordErr;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
			lblPassword.setBounds(29, 398, 113, 31);
		}
		return lblPassword;
	}
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setToolTipText("Enter your password");
			txtPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					lblPasswordErr.setText("");
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(String.valueOf(txtPassword.getPassword()).isEmpty())
						lblPasswordErr.setText("Please enter your password.");
				}
			});
			txtPassword.setBounds(152, 403, 287, 25);
		}
		return txtPassword;
	}
	private JLabel getLblGender() {
		if (lblGender == null) {
			lblGender = new JLabel("Gender:");
			lblGender.setFont(new Font("Arial", Font.PLAIN, 20));
			lblGender.setBounds(29, 461, 113, 31);
		}
		return lblGender;
	}
	private JRadioButton getRdbtnMale() {
		if (rdbtnMale == null) {
			rdbtnMale = new JRadioButton("Male");
			rdbtnMale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblGenderErr.setText("");
				}
			});
			rdbtnMale.setFont(new Font("Arial", Font.PLAIN, 15));
			rdbtnMale.setBounds(152, 466, 79, 25);
			rdbtnMale.setActionCommand("Male");
		}
		return rdbtnMale;
	}
	private JRadioButton getRdbtnFemale() {
		if (rdbtnFemale == null) {
			rdbtnFemale = new JRadioButton("Female");
			rdbtnFemale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblGenderErr.setText("");
				}
			});
			rdbtnFemale.setFont(new Font("Arial", Font.PLAIN, 15));
			rdbtnFemale.setBounds(235, 466, 79, 25);
			rdbtnFemale.setActionCommand("Female");
		}
		return rdbtnFemale;
	}
	private JLabel getLblBirthday() {
		if (lblBirthday == null) {
			lblBirthday = new JLabel("Birthday:");
			lblBirthday.setFont(new Font("Arial", Font.PLAIN, 20));
			lblBirthday.setBounds(29, 525, 113, 31);
		}
		return lblBirthday;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setFont(new Font("Arial", Font.PLAIN, 15));
			dateChooser.setDateFormatString("dd-MM-yyyy");
			dateChooser.setBounds(152, 531, 160, 25);
		}
		return dateChooser;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Reset");
			Image img = new ImageIcon(this.getClass().getResource("/icons/reset1.png")).getImage();
			btnReset.setIcon(new ImageIcon(img));
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblFirstNameErr.setText("");
					lblLastNameErr.setText("");
					lblUsernameErr.setText("");
					lblPasswordErr.setText("");
					lblGenderErr.setText("");
					lblDateErr.setText("");
					
					txtFirstName.setText("");
					txtLastName.setText("");
					txtUsername.setText("");
					txtPassword.setText("");
					bg.clearSelection();
					dateChooser.setCalendar(null);
				}
			});
			btnReset.setFont(new Font("Arial", Font.PLAIN, 20));
			btnReset.setBounds(29, 637, 130, 35);
		}
		return btnReset;
	}
	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("Submit");
			Image img = new ImageIcon(this.getClass().getResource("/icons/login1.png")).getImage();
			btnSubmit.setIcon(new ImageIcon(img));
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String firstName = txtFirstName.getText();
					String lastName = txtLastName.getText();
					String username = txtUsername.getText();
					String password = String.valueOf(txtPassword.getPassword());
					String gender = (!rdbtnFemale.isSelected() && !rdbtnMale.isSelected()) ? null : bg.getSelection().getActionCommand();
					String birthday = (dateChooser.getDate() != null) ? df.format(dateChooser.getDate()) : null;
					
					User user = new User();
					Map<String, String> messages = setUser(user, username, password, firstName, lastName, gender, birthday);
					lblFirstNameErr.setText(messages.get("firstNameErr"));
					lblLastNameErr.setText(messages.get("lastNameErr"));
					lblUsernameErr.setText(messages.get("usernameErr"));
					lblPasswordErr.setText(messages.get("passwordErr"));
					lblGenderErr.setText(messages.get("genderErr"));
					lblDateErr.setText(messages.get("birthdayErr"));
					
					if(messages.get("errors").equals("0")) {
						try {
							Controller.getInstance().registrate(user);
							JOptionPane.showMessageDialog(null, "Registration successful!");
							dispose();
						} catch (Exception e2) {
							if(e2.getMessage().equals("That username is already taken."))
								lblUsernameErr.setText("That username is already taken.");
							System.out.println(e2.getMessage());
						}
					}
				}
			});
			btnSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
			btnSubmit.setBounds(309, 637, 130, 35);
		}
		return btnSubmit;
	}
	private JLabel getLblGenderErr() {
		if (lblGenderErr == null) {
			lblGenderErr = new JLabel("");
			lblGenderErr.setForeground(Color.RED);
			lblGenderErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblGenderErr.setBounds(152, 441, 287, 16);
		}
		return lblGenderErr;
	}
	private JLabel getLblDateErr() {
		if (lblDateErr == null) {
			lblDateErr = new JLabel("");
			lblDateErr.setForeground(Color.RED);
			lblDateErr.setFont(new Font("Arial", Font.PLAIN, 15));
			lblDateErr.setBounds(152, 502, 287, 16);
		}
		return lblDateErr;
	}
	
	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("");
			lblError.setForeground(Color.RED);
			lblError.setFont(new Font("Arial", Font.PLAIN, 18));
			lblError.setBounds(29, 586, 410, 25);
		}
		return lblError;
	}
	
	
	/**
	 * Metoda postavlja vrednosti atributa objekta klase Korisnik na osnovu unetih vrednosti i
	 * vraca mapu poruka koje se ispisuju u slucaju neodgovarajucih vrednosti.
	 * @param user objekat klase Korisnik
	 * @param username korisnicko ime koje je uneo korisnik
	 * @param password sifra koju je uneo korisnik
	 * @param firstName ime koje je uneo korisnik
	 * @param lastName prezime koje je uneo korisnik
	 * @param gender pol koji je selektovao korisnik
	 * @param birthday datum rodjenja koji je izabrao korisnik
	 * 
	 * @return mapu poruka o eventualnim greskama
	 */
	public static Map<String, String> setUser(User user, String username, String password, 
			String firstName, String lastName, String gender, String birthday) {
		Map<String, String> messages = new HashMap<String, String>();
		int errors = 0;
		
		messages.put("firstNameErr", "");
		messages.put("lastNameErr", "");
		messages.put("usernameErr", "");
		messages.put("passwordErr", "");
		messages.put("genderErr", "");
		messages.put("birthdayErr", "");
		messages.put("firstNameErr", "");
		
		if(firstName.isEmpty() || firstName.equals("First name...")) {
			messages.put("firstNameErr", "Please enter your first name.");
			errors++;
		}
		else {
			try {
				user.setFirstName(firstName);
			} catch (Exception e) {
				messages.put("firstNameErr", "<html>Only letters are allowed.<br/>It must starts with upper letter.</html>");
				errors++;
			}
		}
		
		
		if(lastName.isEmpty() || lastName.equals("Last name...")) {
			messages.put("lastNameErr", "Please enter your last name.");
			errors++;
		} else {
			try {
				user.setLastName(lastName);
			} catch (Exception e) {
				messages.put("lastNameErr",
						"<html>Only letters, space, ' and - are allowed<br/>It must starts with upper letter.</html>");
				errors++;
			}
		}
		
		if(username.isEmpty() || username.equals("Username...")) {
			messages.put("usernameErr", "Please enter your username.");
			errors++;
		} else if(username.length() < 6) {
			messages.put("usernameErr", "Too short! Minimum 6 characters.");
		} else if(username.length() > 20) {
			messages.put("usernameErr", "Too long! Maximum 20 characters.");
		} else {
			try {
				user.setUsername(username);
			} catch (Exception e) {
				messages.put("usernameErr",
						"<html>Only letters, numbers and _ are allowed.<br/>It must starts with a letter</html>");
				errors++;
			}
		}
		
		if(password.isEmpty()) {
			messages.put("passwordErr", "Please enter your password.");
			errors++;
		} else if(password.length() < 8) {
			messages.put("passwordErr", "Too short! Minimum 8 characters.");
		} else if(password.length() > 20) {
			messages.put("passwordErr", "Too long! Maximum 20 characters.");
		} else {
			try {
				user.setPassword(password);
			} catch (Exception e) {
				messages.put("passwordErr",
						"<html>Required: uppercase, lowercase,<br/> number, special char</html>");
				errors++;
			}
		}
		
		if(gender == null) {
			messages.put("genderErr", "Please select your gender.");
			errors++;
		} else
			user.setGender(gender);
		
		if(birthday == null) {
			messages.put("birthdayErr", "Please choose your birthday");
			errors++;
		} else
			user.setBirthday(birthday);
		
		messages.put("errors", String.valueOf(errors));
		return messages;
		
	}
}
