/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 12, 2022
 * Description: The sign up screen that is displayed when the user clicks on the sign up button through the log in screen.
 * 				This screen asks the user to fill out required information, and validates it to make sure it meets the requirements and is legitimate
 */

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import application.PersonalCalendarApplication;
import fileInput.FileInput;
import model.User;

@SuppressWarnings("serial")
public class SignUpScreen extends JFrame implements ActionListener {

	// Instance variables
	// Panel
	private JPanel signUpPanel = new JPanel();
	private JPanel logoPanel = new JPanel();

	// Buttons and ToggleButtons
	private JButton backButton = new JButton();
	private JButton signUpButton = new JButton();
	private JToggleButton hideShowPassword = new JToggleButton(new ImageIcon("images/HideShowIcon.png"));
	private JToggleButton confmHideShowPassword = new JToggleButton(new ImageIcon("images/HideShowIcon.png"));

	// Labels
	private JLabel title = new JLabel();
	private JLabel firstNameLabel = new JLabel();
	private JLabel lastNameLabel = new JLabel();
	private JLabel usernameLabel = new JLabel();
	private JLabel emailLabel = new JLabel();
	private JLabel passwordLabel = new JLabel();
	private JLabel confmPasswordLabel = new JLabel();
	private JLabel birthdayLabel = new JLabel();
	private JLabel logoImg = new JLabel(new ImageIcon("images/logo.png"));
	private JLabel firstNameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel lastNameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel usernameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel passwordIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel confmPasswordIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel emailIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel birthdayIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel incorrectLabel = new JLabel();
	private JLabel usernameReq = new JLabel();
	private JLabel passwordReq = new JLabel();
	private JLabel passwordReqTwo = new JLabel();

	// Text fields and Password Fields
	private JTextField firstNameField = new JTextField();
	private JTextField lastNameField = new JTextField();
	private JTextField usernameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JPasswordField confmPasswordField = new JPasswordField();

	// Calendar
	private JDateChooser calendar = new JDateChooser();

	// Menu
	private JMenu fileMenu = new JMenu("File");
	private JMenu helpMenu = new JMenu("Help");

	// Menu Items
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem helpMenuItem = new JMenuItem("User Help");

	// Menu Bar
	private JMenuBar menuBar = new JMenuBar();

	// Constructor method
	public SignUpScreen() {
		frameSetup();
		initialize();
	}

	// Set up the frame
	private void frameSetup() {

		// Set bounds
		setBounds(0, 0, 1400, 900);

		// Make the application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set title
		setTitle("Taskly - Sign Up");

		// Make the window not resizable (locked to set dimensions)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add the panel to the frame
		getContentPane().add(signUpPanel);

		// Add JMenuBar to the frame
		setJMenuBar(menuBar);

		// Make frame visible
		setVisible(true);
	}

	// Initialize the contents of the frame and sets up the signUpPanel and
	// logoPanel
	private void initialize() {

		// Set bounds, layout and background color for the panel
		signUpPanel.setBounds(0, 0, 1400, 900);
		signUpPanel.setLayout(null);
		signUpPanel.setBackground(Color.LIGHT_GRAY);

		// Set bounds, layout, background color, border for the panel
		// Add the panel to the signUpPanel
		logoPanel.setBounds(50, 250, 550, 550);
		logoPanel.setLayout(null);
		logoPanel.setBackground(new Color(63, 43, 99));
		logoPanel.setBorder(BorderFactory.createLineBorder(new Color(156, 138, 165), 7));
		signUpPanel.add(logoPanel);

		// Set font, bounds, text color, background color and border of the
		// firstNameField text field
		// Add the text field to the signUpPanel
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstNameField.setBounds(870, 290, 350, 30);
		firstNameField.setForeground(Color.BLACK);
		firstNameField.setBackground(new Color(156, 138, 165));
		firstNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(firstNameField);

		// Set font, bounds, text color, background color, and border of the
		// lastNameField text field
		// Add the text field to the signUpPanel
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lastNameField.setBounds(870, 370, 350, 30);
		lastNameField.setForeground(Color.BLACK);
		lastNameField.setBackground(new Color(156, 138, 165));
		lastNameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(lastNameField);

		// Set font, bounds, text color, background color, and border of the
		// usernameField text field
		// Add the text field to the signUpPanel
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameField.setBounds(870, 440, 350, 30);
		usernameField.setForeground(Color.BLACK);
		usernameField.setBackground(new Color(156, 138, 165));
		usernameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(usernameField);

		// Set font, bounds, text color, background color, and border of the emailField
		// text field
		// Add the text field to the signUpPanel
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailField.setBounds(870, 510, 350, 30);
		emailField.setForeground(Color.BLACK);
		emailField.setBackground(new Color(156, 138, 165));
		emailField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(emailField);

		// Set font, bounds, text color, background color and border of the
		// passwordField text field
		// Add the text field to the signUpPanel
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(870, 650, 350, 30);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(new Color(156, 138, 165));
		passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(passwordField);

		// Set font, bounds, text color, background color, border of the
		// confmPasswordField text field
		// Add the text field to the signUpPanel
		confmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confmPasswordField.setBounds(870, 720, 350, 30);
		confmPasswordField.setForeground(Color.BLACK);
		confmPasswordField.setBackground(new Color(156, 138, 165));
		confmPasswordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpPanel.add(confmPasswordField);

		// Set text color, font, text, bounds, background color and border for the
		// backButton button
		// Add an action listener to the button and add the button to the logoPanel
		backButton.setForeground(Color.BLACK);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		backButton.setText("BACK");
		backButton.setBounds(54, 400, 187, 81);
		backButton.setBackground(new Color(156, 138, 165));
		backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		backButton.addActionListener(this);
		logoPanel.add(backButton);

		// Set text color, font, text, bounds, background color, and border for the
		// signUpButton button
		// Add an action listener to the button and add the button to the logoPanel
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		signUpButton.setText("CONTINUE");
		signUpButton.setBounds(296, 400, 187, 81);
		signUpButton.setBackground(new Color(156, 138, 165));
		signUpButton.addActionListener(this);
		signUpButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		logoPanel.add(signUpButton);

		// Set bounds for the toggle button
		// Make the button transparent, borders removed, and content areas not filled
		// Add action listener to the button and add the button to the signUpPanel
		hideShowPassword.setBounds(1200, 615, 100, 100);
		hideShowPassword.setOpaque(false);
		hideShowPassword.setBorderPainted(false);
		hideShowPassword.setContentAreaFilled(false);
		hideShowPassword.addActionListener(this);
		signUpPanel.add(hideShowPassword);

		// Set bounds for the toggle button
		// Make the button transparent, borders removed, and content areas not filled
		// Add action listener to the button and add the button to the signUpPanel
		confmHideShowPassword.setBounds(1200, 685, 100, 100);
		confmHideShowPassword.setOpaque(false);
		confmHideShowPassword.setBorderPainted(false);
		confmHideShowPassword.setContentAreaFilled(false);
		confmHideShowPassword.addActionListener(this);
		signUpPanel.add(confmHideShowPassword);

		// Set text color, horizontal alignment, font, text and bounds for the title
		// label
		// Add the title label to the signUpPanel
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		title.setText("Create An Account");
		title.setBounds(300, 75, 800, 100);
		signUpPanel.add(title);

		// Set text color, horizontal alignment, font, text and bounds for the
		// firstNameLabel
		// Add the firstNameLabel to the signUpPanel
		firstNameLabel.setForeground(Color.BLACK);
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		firstNameLabel.setText("First Name:");
		firstNameLabel.setBounds(710, 252, 175, 100);
		signUpPanel.add(firstNameLabel);

		// Set text color, horizontal alignment, font, text and bounds for the
		// lastNameLabel
		// Add the lastNameLabel to the signUpPanel
		lastNameLabel.setForeground(Color.BLACK);
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		lastNameLabel.setText("Last Name:");
		lastNameLabel.setBounds(710, 332, 175, 100);
		signUpPanel.add(lastNameLabel);

		// Set text color, horizontal alignment, font, text and bounds for the
		// usernameLabel
		// Add the usernameLabel to the signUpPanel
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		usernameLabel.setText("Username:");
		usernameLabel.setBounds(712, 402, 175, 100);
		signUpPanel.add(usernameLabel);

		// Set text color, horizontal alignment, font, text and bounds for the
		// emailLabel
		// Add the emailLabel to the signUpPanel
		emailLabel.setForeground(Color.BLACK);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		emailLabel.setText("Email:");
		emailLabel.setBounds(732, 472, 175, 100);
		signUpPanel.add(emailLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// passwordLabel
		// Add the passwordLabel to the signUpPanel
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		passwordLabel.setText("Password:");
		passwordLabel.setBounds(714, 612, 175, 100);
		signUpPanel.add(passwordLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// confmPasswordLabel
		// Add the confmPasswordLabel to the signUpPanel
		confmPasswordLabel.setForeground(Color.BLACK);
		confmPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confmPasswordLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		confmPasswordLabel.setText("Confirm Password:");
		confmPasswordLabel.setBounds(679, 682, 175, 100);
		signUpPanel.add(confmPasswordLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// birthdayLabel
		// Add the birthdayLabel to the signUpPanel
		birthdayLabel.setForeground(Color.BLACK);
		birthdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthdayLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		birthdayLabel.setText("Birthday:");
		birthdayLabel.setBounds(717, 542, 175, 100);
		signUpPanel.add(birthdayLabel);

		// Set font, horizontal alignment, text color and bounds for the incorrectLabel
		// Add the incorrectLabel to the signUpPanel
		incorrectLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		incorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectLabel.setForeground(new Color(102, 0, 0));
		incorrectLabel.setBounds(711, 211, 550, 50);
		signUpPanel.add(incorrectLabel);

		// Set bounds, border, font, and format string for the calendar
		calendar.setBounds(870, 580, 350, 30);
		calendar.setBorder(new LineBorder(Color.BLACK));
		calendar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calendar.setDateFormatString("MM-dd-yyyy");

		// Makes the background of the JDateChooser text field similar to the other
		// fields, and adds the JDateChooser to the signUpPanel
		for (Component c : calendar.getComponents()) {
			((JComponent) c).setBackground(new Color(156, 138, 165));
		}
		signUpPanel.add(calendar);

		// Set bounds and make the firstNameIncorrect Label not visible
		// Add the label to signUpPanel
		firstNameIncorrect.setBounds(1225, 272, 60, 60);
		firstNameIncorrect.setVisible(false);
		signUpPanel.add(firstNameIncorrect);

		// Set bounds and make the lastNameIncorrect label not visible
		// Add the label to signUpPanel
		lastNameIncorrect.setBounds(1225, 352, 60, 60);
		lastNameIncorrect.setVisible(false);
		signUpPanel.add(lastNameIncorrect);

		// Set bounds and make the usernameIncorrect label not visible
		// Add the label to signUpPanel
		usernameIncorrect.setBounds(1225, 422, 60, 60);
		usernameIncorrect.setVisible(false);
		signUpPanel.add(usernameIncorrect);

		// Set bounds and make the passwordIncorrect label not visible
		// Add the label to signUpPanel
		passwordIncorrect.setBounds(1275, 632, 60, 60);
		passwordIncorrect.setVisible(false);
		signUpPanel.add(passwordIncorrect);

		// Set bounds and make the confmPasswordIncorrect label not visible
		// Add the label to signUpPanel
		confmPasswordIncorrect.setBounds(1275, 702, 60, 60);
		confmPasswordIncorrect.setVisible(false);
		signUpPanel.add(confmPasswordIncorrect);

		// Set bounds and make the emailIncorrect label not visible
		// Add the label to signUpPanel
		emailIncorrect.setBounds(1225, 492, 60, 60);
		emailIncorrect.setVisible(false);
		signUpPanel.add(emailIncorrect);

		// Set bounds and make the birthdayIncorrect label not visible
		// Add the label to signUpPanel
		birthdayIncorrect.setBounds(1225, 562, 60, 60);
		birthdayIncorrect.setVisible(false);
		signUpPanel.add(birthdayIncorrect);

		// Set bounds and add logoImg to the logoPanel
		logoImg.setBounds(98, 50, 340, 300);
		logoPanel.add(logoImg);

		// Set font, text color, bounds and text for usernameReq label
		// Add the label to the signUpPanel
		usernameReq.setFont(new Font("Tahoma", Font.ITALIC, 13));
		usernameReq.setForeground(Color.BLACK);
		usernameReq.setBounds(870, 430, 435, 100);
		usernameReq.setText("*Must contain at least 5 characters and can't include commas");
		signUpPanel.add(usernameReq);

		// Set font, text color, bounds, and text for passwordReq label
		// Add the label to the signUpPanel
		passwordReq.setFont(new Font("Tahoma", Font.ITALIC, 11));
		passwordReq.setForeground(Color.BLACK);
		passwordReq.setBounds(870, 640, 520, 100);
		passwordReq.setText("*Must be at least 5 characters, including at least one uppercase, lowercase and number");
		signUpPanel.add(passwordReq);

		// Set text, text color, font and bounds for the label
		// Add the label to the signUpPanel
		passwordReqTwo.setText("*Must not include commas");
		passwordReqTwo.setForeground(Color.BLACK);
		passwordReqTwo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		passwordReqTwo.setBounds(870, 660, 688, 100);
		signUpPanel.add(passwordReqTwo);

		// Set background color of menu bar
		menuBar.setBackground(new Color(156, 138, 165));
		menuBar.setBorder(null);

		// Set text color of the menu text
		fileMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);

		// Set text color of the menu item text
		exitMenuItem.setForeground(Color.BLACK);
		helpMenuItem.setForeground(Color.BLACK);

		// Set background of the menu item
		exitMenuItem.setBackground(new Color(156, 138, 165));
		helpMenuItem.setBackground(new Color(156, 138, 165));

		// Add action listener to the menu item
		exitMenuItem.addActionListener(this);
		helpMenuItem.addActionListener(this);

		// Add the menu items to the menus
		fileMenu.add(exitMenuItem);
		helpMenu.add(helpMenuItem);

		// Add the menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
	}

	// If a button is clicked - action is performed
	@Override
	public void actionPerformed(ActionEvent e) {

		// If user clicks on backButton, it takes them to the log in screen and disposes
		// the sign up screen
		if (e.getSource() == backButton) {
			new LogInScreen();
			this.dispose();
		}

		// If the user clicks signUpbutton
		else if (e.getSource() == signUpButton) {

			// Sets all the incorrect images to false, since it updates the panel every time
			// they click on button
			firstNameIncorrect.setVisible(false);
			lastNameIncorrect.setVisible(false);
			usernameIncorrect.setVisible(false);
			emailIncorrect.setVisible(false);
			birthdayIncorrect.setVisible(false);
			passwordIncorrect.setVisible(false);
			confmPasswordIncorrect.setVisible(false);

			// Call panelUpdate method
			// this method sets the incorrect images to true depending on what is
			// missing/incorrect
			panelUpdate();

			// If the validateInfo() method returns true, this indicates that the user's
			// account information is valid and unique
			// and therefore creates the user's account, shows a message dialog and takes them back to the home screen
			if (validateInfo()) {
				rewriteUserFile();
				new FileInput();
				JOptionPane.showMessageDialog(signUpPanel, "Account Has Been Successfully Created", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				new LogInScreen();
				this.dispose();
			}

		}

		// If user clicks on hideShowPassword
		else if (e.getSource() == hideShowPassword) {

			// If the toggleButton is selected
			if (hideShowPassword.isSelected()) {

				// Prints out the char characters
				passwordField.setEchoChar((char) 0);
			}

			// Otherwise it hides the password using *
			else {
				passwordField.setEchoChar('*');
			}
		}

		// If user clicks on confmHideShowPassword
		else if (e.getSource() == confmHideShowPassword) {

			// If the toggleButton is selected
			if (confmHideShowPassword.isSelected()) {

				// Prints out the char characters
				confmPasswordField.setEchoChar((char) 0);
			}

			// Otherwise it hides the password using *
			else {
				confmPasswordField.setEchoChar('*');
			}
		}

		// If user clicks on exitMenuItem
		else if (e.getSource() == exitMenuItem) {

			// Exit the application
			System.exit(0);
		}

		// If user clicks on helpMenuItem
		else if (e.getSource() == helpMenuItem) {

			// Call HelpScreen constructor method where the user is taken to the help screen
			new HelpScreen();
		}
	}

	// Validates the info, checking if the user name is valid and the password is
	// valid
	private boolean validateInfo() {

		// If the user name or password is not valid, return boolean as false
		if (!isValidUsername() || !validateUsername() || !validatePassword() || !isValidEmail() || !isValidFirstName()
				|| !isValidLastName()) {
			return false;
		}

		// Otherwise return boolean as true
		return true;
	}

	// When this method is called, it updates the panel by assigning the
	// incorrectLabel and incorrectImages depending on what information is
	// missing/incorrect
	private void panelUpdate() {

		// If any of the required fields are empty, set their corresponding incorrect
		// images visible
		if (firstNameField.getText().isEmpty()) {
			firstNameIncorrect.setVisible(true);
		}
		if (lastNameField.getText().isEmpty()) {
			lastNameIncorrect.setVisible(true);
		}
		if (usernameField.getText().isEmpty()) {
			usernameIncorrect.setVisible(true);
		}
		if (emailField.getText().isEmpty()) {
			emailIncorrect.setVisible(true);
		}
		if (readPassword(passwordField).equals("")) {
			passwordIncorrect.setVisible(true);
		}
		if (readPassword(passwordField).equals("")) {
			confmPasswordIncorrect.setVisible(true);
		}
		if (calendar.getDate() == null) {
			birthdayIncorrect.setVisible(true);
		}

		// If any of the required fields contain ",", set their corresponding incorrect
		if (readPassword(passwordField).contains(",")) {
			incorrectLabel.setText("PASSWORDS CAN'T CONTAIN COMMAS");
			incorrectLabel.setVisible(true);
		}
		if (readPassword(confmPasswordField).contains(",")) {
			incorrectLabel.setText("PASSWORDS CAN'T CONTAIN COMMAS");
			incorrectLabel.setVisible(true);
		}

		// If the validatePassword method is not true, it indicates that the password
		// does not match or requirements aren't met
		if (!validatePassword()) {

			// Sets the text of the incorrectLabel, makes its passwordIncorrect image
			// visible and the confmPasswordIncorrect as well
			incorrectLabel.setText("PASSWORD DO NOT MATCH OR REQUIREMENTS AREN'T MET");
			passwordIncorrect.setVisible(true);
			confmPasswordIncorrect.setVisible(true);
		}

		// If the isValidUsername method returns false, indicates that the length is < 5
		// or contains ","
		if (!isValidUsername()) {

			// Sets the text of the incorrectLabel, and makes the usernameIncorrect image
			// visible
			incorrectLabel.setText("USERNAME DOESN'T MEET REQUIREMENTS");
			usernameIncorrect.setVisible(true);
		}

		// If the validateUsername method returns false, indicates that the username is
		// taken
		if (!validateUsername()) {

			// Sets text for incorrectLabel, and makes the usernameIncorrect image visible
			incorrectLabel.setText("USERNAME IS TAKEN");
			usernameIncorrect.setVisible(true);
		}

		// If the isValidEmail returns false, indicates that email doesn't include @ or
		// .
		if (!isValidEmail()) {

			// Sets text for incorrectLabel, and makes emailIncorrect image visible
			incorrectLabel.setText("EMAIL IS NOT A VALID EMAIL");
			emailIncorrect.setVisible(true);
		}

		// If the isValidFirstName returns false, indicates that first name includes
		// number
		if (!isValidFirstName()) {

			// Sets text for incorrectLabel, and makes firstNameIncorrect image visible
			incorrectLabel.setText("FIRST NAME CAN'T CONTAIN NUMBERS");
			firstNameIncorrect.setVisible(true);
		}

		// If the isValidLastName returns false, indicates that last name includes
		// number
		if (!isValidLastName()) {

			// Sets text for incorrectLabel, and makes lastNameIncorrect image visible
			incorrectLabel.setText("LAST NAME CAN'T CONTAIN NUMBERS");
			lastNameIncorrect.setVisible(true);
		}

		// If any of the fields are empty and returns true, indicates that the text is
		// empty
		if (emptyFields()) {

			// Sets text for incorrectLabel
			incorrectLabel.setText("PLEASE FILL OUT ALL REQUIRED FIELDS");
		}
	}

	// Checks each field to see if there are any empty fields. If there is, it sets
	// the boolean to true and is used to adjust the incorrectLabel text
	private boolean emptyFields() {

		// Set boolean variable to false
		boolean empty = false;

		// If any of the fields are empty, set the boolean variable to true
		if (firstNameField.getText().isEmpty()) {
			empty = true;
		}
		if (lastNameField.getText().isEmpty()) {
			empty = true;
		}
		if (usernameField.getText().isEmpty()) {
			empty = true;
		}
		if (readPassword(passwordField).equals("")) {
			empty = true;
		}
		if (readPassword(confmPasswordField).equals("")) {
			empty = true;
		}
		if (emailField.getText().isEmpty()) {
			empty = true;
		}
		if (calendar.getDate() == null) {
			empty = true;
		}

		// Return the boolean
		// If none of the fields were empty, the boolean would return false
		return empty;
	}

	// Validates the password, ensuring that the password given in the field meets
	// the requirement and both password fields are equal
	private boolean validatePassword() {

		// Variables
		String upperCaseLetters = "(.*[A-Z].*)";
		String lowerCaseLetters = "(.*[a-z].*)";
		String numbers = "(.*[0-9].*)";

		// Put password into a char array and toString it
		char[] passwordArr = passwordField.getPassword();
		String password = new String(passwordArr);

		// If the password length is < 5 or it doesn't match upper case letters or it
		// doesn't match lower case letters or it doesn't match numbers, return false
		if (password.length() < 5 || !password.matches(upperCaseLetters) || !password.matches(lowerCaseLetters)
				|| !password.matches(numbers)) {
			return false;
		}

		// If the passwordField doesn't match the confmPasswordField, return false
		if (!readPassword(passwordField).equals(readPassword(confmPasswordField))) {
			return false;
		}

		// If the passwordField contains , it returns false
		if (readPassword(passwordField).contains(",")) {
			return false;
		}

		// Otherwise return true
		return true;
	}

	// Checks the array list of users information to see if any of the users have
	// similar user names to the one that is being signed up with
	private boolean validateUsername() {

		// For each users in the array list
		for (User currentUser : PersonalCalendarApplication.users) {

			// If the usernameField is equal to the currentUser, return false
			if (usernameField.getText().equals(currentUser.getUsername())) {
				return false;
			}
		}

		// Otherwise return true, since the user name is unique
		return true;
	}

	// Checks to see if the user name meets the requirements
	private boolean isValidUsername() {

		// If the usernameField is < 5 in length, return false
		if (usernameField.getText().length() < 5) {
			return false;
		}

		// If the usernameField contains ",", return false
		if (usernameField.getText().contains(",")) {
			return false;
		}

		// Otherwise return true
		return true;
	}

	// Checks to see if the email is legitimate by checking if it contains @ and .
	private boolean isValidEmail() {

		// If the emailField contains @ and . , return true
		if (emailField.getText().contains("@") && emailField.getText().contains(".")) {
			return true;
		}

		// Otherwise indicates it is not valid email and return false
		return false;
	}

	// Checks to see if the first name field contains numbers
	private boolean isValidFirstName() {

		// Variable
		String numbers = "(.*[0-9].*)";

		// If firstNameField contains a number, return false
		if (firstNameField.getText().matches(numbers)) {
			return false;
		}

		// Otherwise no number is in the field, return true
		return true;

	}

	// Checks to see if the last name field contains numbers
	private boolean isValidLastName() {

		// Variable
		String numbers = "(.*[0-9].*)";

		// If lastNameField contains a number, return false
		if (lastNameField.getText().matches(numbers)) {
			return false;
		}

		// Otherwise no number is in the field, return true
		return true;

	}

	// Since passwordFields are difficult to make comparisons, can turn it to a
	// string
	private String readPassword(JPasswordField passwordField) {

		// Store passwordField in the char array
		char[] passwordArray = passwordField.getPassword();

		// The password that will be returned in a string
		String password;

		// If the length is >=1, convert it to a string
		if (passwordArray.length >= 1) {
			password = new String(passwordArray);
		}

		// Otherwise set password to ""
		else {
			password = "";
		}

		// Return password variable
		return password;
	}

	// Rewrites the user file with the new user logins
	private void rewriteUserFile() {

		// String containing the user login credentials file copied
		String fileCopied = FileInput.copyUserFile();
		String fileName = String.format("files/User Login Information.csv");
		File file = new File(fileName);

		// Format the date
		String date;
		SimpleDateFormat format = new SimpleDateFormat("MM,dd,yyyy");
		date = format.format(calendar.getDate());

		if (!file.isDirectory()) {

			try {

				// Write data to a file
				PrintWriter pr = new PrintWriter(fileName);

				// Print out the fileCopied variable and the new user name information to the
				// file and close it afterwards
				pr.print(fileCopied + "\n");
				pr.print(usernameField.getText() + "," + readPassword(passwordField) + "," + firstNameField.getText()
						+ "," + lastNameField.getText() + "," + emailField.getText() + "," + date + ",");
				pr.close();

				// If file not found, output error in terminal
			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}
		}
	}

}
