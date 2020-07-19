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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
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
		prepareForm();
	}

	private void prepareForm() {
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setFocusable(true);
		bg.add(getRdbtnMale());
		bg.add(getRdbtnFemale());
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
			lblPasswordErr.setBounds(152, 376, 287, 16);
		}
		return lblPasswordErr;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
			lblPassword.setBounds(29, 394, 113, 31);
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
			txtPassword.setBounds(152, 399, 287, 25);
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
					String gender = null;
					String birthday = null;
					
					if(firstName.isEmpty() || firstName.equals("First name...")) {
						lblFirstNameErr.setText("Please enter your first name.");
						firstName = null;
					}
					
					if(lastName.isEmpty() || lastName.equals("Last name...")) {
						lblLastNameErr.setText("Please enter your last name.");
						lastName = null;
					}
					
					if(username.isEmpty() || username.equals("Username...")) {
						lblUsernameErr.setText("Please enter your username.");
						username = null;
					}
					
					if(password.isEmpty()) {
						lblPasswordErr.setText("Please enter your password.");
						password = null;
					}
					
					if(!rdbtnFemale.isSelected() && !rdbtnMale.isSelected())
						lblGenderErr.setText("Please select your gender.");
					else {
						gender = bg.getSelection().getActionCommand();
					}
					
					if(dateChooser.getDate() == null)
						lblDateErr.setText("Please choose your birthday");
					else {
						lblDateErr.setText("");
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						birthday = df.format(dateChooser.getDate());
					}
					
					try {
						User user = new User();
						user.setUsername(username);
						user.setPassword(password);
						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setGender(gender);
						user.setBirthday(birthday);
						Controller.getInstance().registrate(user);
						JOptionPane.showMessageDialog(null, "Registration successful!");
						dispose();
					} catch (Exception e2) {
						messages(e2.getMessage());
						System.out.println(e2.getMessage());
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
	
	public void messages(String message) {
		switch (message) {
		case "Username is invalid.":
			if(lblUsernameErr.getText().isEmpty())
				lblUsernameErr.setText("<html>Only letters, numbers and _ are allowed.<br/>It must starts with a letter</html>");
		case "Password is invalid.":
			if(lblPasswordErr.getText().isEmpty())
				lblPasswordErr.setText("Required: uppercase, lowercase, number, special char");
		case "First name is invalid.":
			if(lblFirstNameErr.getText().isEmpty())
				lblFirstNameErr.setText("<html>Only letters are allowed.<br/>It must starts with upper letter.</html>");
		case "Last name is invalid.":
			if(lblLastNameErr.getText().isEmpty())
				lblLastNameErr.setText("<html>Only letters, space, ' and - are allowed<br/>It must starts with upper letter.</html>");
			break;
		case "That username is already taken.":
			lblUsernameErr.setText("That username is already taken.");
		}
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
}
