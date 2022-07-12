/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 14, 2022
 * Description: Creates the settings screen. On this screen, users can change information such as name, password, profile picture, etc.
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import application.PersonalCalendarApplication;
import model.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

@SuppressWarnings("serial")
public class SettingsScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panels
	private JPanel profilePanel = new JPanel();
	private JPanel savePanel = new JPanel();

	// Buttons
	private JButton profilePictureOne = new JButton();
	private JButton profilePictureTwo = new JButton();
	private JButton profilePictureThree = new JButton();
	private JButton profilePictureFour = new JButton();
	private JButton saveButton = new JButton();
	private JButton closeButton = new JButton();

	// Text Field
	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField usernameTextField = new JTextField();
	private JTextField emailTextField = new JTextField();

	// Labels
	private JLabel titleLabel = new JLabel();
	private JLabel firstNameLabel = new JLabel();
	private JLabel lastNameLabel = new JLabel();
	private JLabel usernameLabel = new JLabel();
	private JLabel emailLabel = new JLabel();
	private JLabel selectImgLabel = new JLabel();
	private JLabel birthdayLabel = new JLabel();
	private JLabel firstNameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel lastNameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel usernameIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel emailIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel birthdayIncorrect = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel incorrectLabel = new JLabel();

	// Date Chooser
	private JDateChooser calendar = new JDateChooser();

	// Profile Picture Chosen
	private int newProfilePictureNum;

	// Constructor method
	public SettingsScreen() {
		frameSetup();
		initialize();
	}

	// Set up the frame
	private void frameSetup() {

		// Since at the beginning the user hasn't selected any new profile picture, the
		// new profile picture will still be the user's current profile picture
		newProfilePictureNum = PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
				.getProfilePictureNumber();

		// Set bounds
		setBounds(0, 0, 900, 900);

		// Make the application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set title
		setTitle("Taskly - Settings");

		// Make the window not resizable (locked to set dimension)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add the panels to the frame
		getContentPane().add(profilePanel);
		getContentPane().add(savePanel);

		// Make the frame visible
		setVisible(true);
	}

	// Initialize the contents of the frame and sets up the profilePanel and
	// savePanel
	private void initialize() {

		// Set bounds, layout, border, and background color of the profilePanel
		profilePanel.setBounds(0, 0, 884, 740);
		profilePanel.setLayout(null);
		profilePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		profilePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout, border, and background color of the savePanel
		savePanel.setBounds(0, 740, 884, 121);
		savePanel.setLayout(null);
		savePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		savePanel.setBackground(new Color(63, 43, 99));

		// Set text color, horizontal alignment, font, text and bounds for the title
		// label
		// Add the title label to the profilePanel
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		titleLabel.setText("Edit Your Profile");
		titleLabel.setBounds(197, 23, 500, 100);
		profilePanel.add(titleLabel);

		// Set text color, horizontal alignment, font, text and bounds for the first
		// name label
		// Add the first name label to the profilePanel
		firstNameLabel.setForeground(Color.WHITE);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		firstNameLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		firstNameLabel.setText("First Name:");
		firstNameLabel.setBounds(100, 406, 260, 40);
		profilePanel.add(firstNameLabel);

		// Set text color, horizontal alignment, font, text and bounds for the last name
		// label
		// Add the last name label to the profilePanel
		lastNameLabel.setForeground(Color.WHITE);
		lastNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lastNameLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		lastNameLabel.setText("Last Name:");
		lastNameLabel.setBounds(103, 457, 260, 40);
		profilePanel.add(lastNameLabel);

		// Set text color, horizontal alignment, font, text and bounds for the username
		// label
		// Add the username label to the profilePanel
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		usernameLabel.setText("Username:");
		usernameLabel.setBounds(108, 509, 260, 40);
		profilePanel.add(usernameLabel);

		// Set the text color, horizontal alignment, font, text and bounds for the email
		// label
		// Add the email label to the profilePanel
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		emailLabel.setText("Email:");
		emailLabel.setBounds(162, 565, 260, 40);
		profilePanel.add(emailLabel);

		// Set the text color, horizontal alignment, font ,text and bounds for the
		// select img label
		// Add the select img label to the profilePanel
		selectImgLabel.setForeground(Color.WHITE);
		selectImgLabel.setHorizontalAlignment(SwingConstants.LEFT);
		selectImgLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		selectImgLabel.setText("Select New Profile Picture:");
		selectImgLabel.setBounds(32, 112, 395, 40);
		profilePanel.add(selectImgLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the birthday
		// label
		// Add the birthday label to the profilePanel
		birthdayLabel.setForeground(Color.WHITE);
		birthdayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		birthdayLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		birthdayLabel.setText("Birthday:");
		birthdayLabel.setBounds(127, 617, 395, 40);
		profilePanel.add(birthdayLabel);

		// Set font, bounds, text color, background color, text and border of the first
		// name text field
		// Add the text field to the profilePanel
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		firstNameTextField.setBounds(250, 414, 350, 30);
		firstNameTextField.setForeground(Color.BLACK);
		firstNameTextField.setBackground(new Color(156, 138, 165));
		firstNameTextField.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getFirstName());
		firstNameTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		profilePanel.add(firstNameTextField);

		// Set font, bounds, text color, background color, text and border of the last
		// name text field
		// Add the text field to the profilePanel
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lastNameTextField.setBounds(250, 465, 350, 30);
		lastNameTextField.setForeground(Color.BLACK);
		lastNameTextField.setBackground(new Color(156, 138, 165));
		lastNameTextField.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getLastName());
		lastNameTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		profilePanel.add(lastNameTextField);

		// Set font, bounds, text color, background color, text and border of the user
		// name text field
		// Add the text field to the profilePanel
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameTextField.setBounds(250, 517, 350, 30);
		usernameTextField.setForeground(Color.BLACK);
		usernameTextField.setBackground(new Color(156, 138, 165));
		usernameTextField.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername());
		usernameTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		profilePanel.add(usernameTextField);

		// Set font, bounds, text color, background color, text, and border of the email
		// text field
		// Add the text field to the profilePanel
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailTextField.setBounds(250, 571, 350, 30);
		emailTextField.setForeground(Color.BLACK);
		emailTextField.setBackground(new Color(156, 138, 165));
		emailTextField
				.setText(PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getEmail());
		emailTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		profilePanel.add(emailTextField);

		// Set text color, font, text, bounds, background color, border for the close
		// button
		// Add action listener to the button and add it to the savePanel
		closeButton.setForeground(Color.WHITE);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		closeButton.setText("Close");
		closeButton.setBounds(500, 20, 187, 81);
		closeButton.setBackground(new Color(156, 138, 165));
		closeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		closeButton.addActionListener(this);
		savePanel.add(closeButton);

		// Set text color, font, text, bounds, background color, border for the save
		// button
		// Add action listener to the button and add it to the savePanel
		saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveButton.setText("Save");
		saveButton.setBounds(200, 20, 187, 81);
		saveButton.setBackground(new Color(156, 138, 165));
		saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		saveButton.addActionListener(this);
		savePanel.add(saveButton);

		// Set bounds, scale image, and set icon for the first profile picture
		// Add the profile picture to the profilePanel
		profilePictureOne.setBounds(32, 163, 190, 190);
		ImageIcon defaultImage1 = new ImageIcon("images/Profile Picture 1.png");
		Image newImage1 = defaultImage1.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		profilePictureOne.setIcon(new ImageIcon(newImage1));
		profilePictureOne.addActionListener(this);
		profilePanel.add(profilePictureOne);

		// Set bounds, scale image, and set icon for the second profile picture
		// Add the profile picture to the profilePanel
		profilePictureTwo.setBounds(246, 163, 190, 190);
		ImageIcon defaultImage2 = new ImageIcon("images/Profile Picture 2.png");
		Image newImage2 = defaultImage2.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		profilePictureTwo.setIcon(new ImageIcon(newImage2));
		profilePictureTwo.addActionListener(this);
		profilePanel.add(profilePictureTwo);

		// Set bounds, scale image, and set icon for the third profile picture
		// Add the profile picture to the profilePanel
		profilePictureThree.setBounds(457, 163, 190, 190);
		ImageIcon defaultImage3 = new ImageIcon("images/Profile Picture 3.png");
		Image newImage3 = defaultImage3.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		profilePictureThree.setIcon(new ImageIcon(newImage3));
		profilePictureThree.addActionListener(this);
		profilePanel.add(profilePictureThree);

		// Set bounds, scale image, and set icon for the fourth profile picture
		// Add the profile picture to the profilePanel
		profilePictureFour.setBounds(668, 163, 190, 190);
		ImageIcon defaultImage4 = new ImageIcon("images/Profile Picture 4.png");
		Image newImage4 = defaultImage4.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		profilePictureFour.setIcon(new ImageIcon(newImage4));
		profilePictureFour.addActionListener(this);
		profilePanel.add(profilePictureFour);

		// Set bounds, border, text color, font for the calendar field
		calendar.setBounds(250, 622, 350, 35);
		calendar.setBorder(new LineBorder(Color.BLACK));
		calendar.setForeground(Color.WHITE);
		calendar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// Get all the user's information regarding their birthday and put it into a
		// string
		String dd = PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getBirthMonth()
				+ "-" + PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getBirthDay()
				+ "-"
				+ PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getBirthYear();

		// Try to create a Date object and set the calendar to that date
		try {
			Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dd);
			calendar.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sets the background color of the calendar field
		for (Component c : calendar.getComponents()) {
			((JComponent) c).setBackground(new Color(156, 138, 165));
		}

		// Set bounds, not visible, and add firstNameIncorrect label to profilePanel
		firstNameIncorrect.setBounds(601, 400, 60, 60);
		firstNameIncorrect.setVisible(false);
		profilePanel.add(firstNameIncorrect);

		// Set bounds, not visible, and add lastNameIncorrect label to profilePanel
		lastNameIncorrect.setBounds(601, 450, 60, 60);
		lastNameIncorrect.setVisible(false);
		profilePanel.add(lastNameIncorrect);

		// Set bounds, not visible, and add userNameIncorrect label to profilePanel
		usernameIncorrect.setBounds(601, 500, 60, 60);
		usernameIncorrect.setVisible(false);
		profilePanel.add(usernameIncorrect);

		// Set bounds, not visible, and add emailIncorrect label to profilePanel
		emailIncorrect.setBounds(601, 555, 60, 60);
		emailIncorrect.setVisible(false);
		profilePanel.add(emailIncorrect);

		// Set bounds, not visible, and add birthdayIncorrect label to profilePanel
		birthdayIncorrect.setBounds(601, 610, 60, 60);
		birthdayIncorrect.setVisible(false);
		profilePanel.add(birthdayIncorrect);

		// Set font, horizontal alignment, text color, bounds for incorrectLabel and add
		// it to profilePanel
		incorrectLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		incorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectLabel.setForeground(new Color(102, 0, 0));
		incorrectLabel.setBounds(80, 360, 550, 50);
		profilePanel.add(incorrectLabel);

		// Adds the calendar to the profilePanel
		profilePanel.add(calendar);
	}

	// Action is performed
	@Override
	public void actionPerformed(ActionEvent e) {

		// If user clicks on close button
		if (e.getSource() == closeButton) {

			// Set the profile picture to 1
			PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
					.setProfilePictureNumber(1);

			// Call CalendarScreen constructor method
			new CalendarScreen();

			// Set the settings screen to not visible and dipose the screen
			setVisible(false);
			dispose();
		}

		// If user clicks on save button
		else if (e.getSource() == saveButton) {

			// Set all incorrect labels to false
			firstNameIncorrect.setVisible(false);
			lastNameIncorrect.setVisible(false);
			usernameIncorrect.setVisible(false);
			emailIncorrect.setVisible(false);
			birthdayIncorrect.setVisible(false);

			// Update the panel
			panelUpdate();

			// If all the information is valid
			if (validateInfo()) {

				// Set the users first name, last name, user name, email, and new profile
				// picture num to the fields/buttons
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setFirstName(firstNameTextField.getText());
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setLastName(lastNameTextField.getText());
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setUsername(usernameTextField.getText());
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setEmail(emailTextField.getText());
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setProfilePictureNumber(newProfilePictureNum);

				// Get the calendar date
				String date;
				SimpleDateFormat format = new SimpleDateFormat("MM,dd,yyyy");
				date = format.format(calendar.getDate());

				// Split the date into day, month, year
				String[] dates = date.split(",");

				// Convert it to integer stored in array
				int[] birthdates = new int[dates.length];
				for (int i = 0; i < dates.length; i++) {
					birthdates[i] = Integer.parseInt(dates[i]);
				}

				// Set the users birthday, birth month, and birth year
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setBirthMonth(birthdates[0]);
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setBirthDay(birthdates[1]);
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum)
						.setBirthYear(birthdates[2]);

				// Call the rewriteuserFile - rewrites the csv file with updated information
				rewriteUserFile();

				// Let user know information is saved using a JOptionPane
				JOptionPane.showMessageDialog(profilePanel, "Successfully Saved. Returning Back To Calendar Screen",
						"Information", JOptionPane.INFORMATION_MESSAGE);

				// Hide the screen and dispose it
				setVisible(false);
				dispose();

				// Call CalendarScreen constructor method
				new CalendarScreen();
			}

		}

		// If user clicks on first profile picture
		else if (e.getSource() == profilePictureOne) {

			// Assign the numProfilePictureNum to 1
			newProfilePictureNum = 1;
		}

		// If user clicks on second profile picture
		else if (e.getSource() == profilePictureTwo) {

			// Assign the numProfilePictureNum to 2
			newProfilePictureNum = 2;
		}

		// If user clicks on third profile picture
		else if (e.getSource() == profilePictureThree) {

			// Assign the numProfilePictureNum to 3
			newProfilePictureNum = 3;
		}

		// If user clicks on fourth profile picture
		else if (e.getSource() == profilePictureFour) {

			// Assign the numProfilePictureNum to 4
			newProfilePictureNum = 4;
		}

	}

	// When this method is called, it updates the panel by assigning the
	// incorrectLabel and incorrectImages depending on what information is
	// missing/incorrect
	private void panelUpdate() {

		// If any of the required fields are empty, set their corresponding incorrect
		// images visible
		if (firstNameTextField.getText().isEmpty()) {
			firstNameIncorrect.setVisible(true);
		}
		if (lastNameTextField.getText().isEmpty()) {
			lastNameIncorrect.setVisible(true);
		}
		if (usernameTextField.getText().isEmpty()) {
			usernameIncorrect.setVisible(true);
		}
		if (emailTextField.getText().isEmpty()) {
			emailIncorrect.setVisible(true);
		}
		if (calendar.getDate() == null) {
			birthdayIncorrect.setVisible(true);
		}

		// If the isValidUsername method returns false, indicates that the length is < 5
		// or contains ","
		if (!isValidUsername()) {
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
			incorrectLabel.setText("PLEASE FILL OUT ALL REQUIRED FIELDS");
		}
	}

	// Checks each field to see if there are any empty fields. If there is, it sets
	// the boolean to true and is used to adjust the incorrectLabel text
	private boolean emptyFields() {

		// Set boolean variable to false
		boolean empty = false;

		// If any of the fields are empty, set the boolean variable to true
		if (firstNameTextField.getText().isEmpty()) {
			empty = true;
		}
		if (lastNameTextField.getText().isEmpty()) {
			empty = true;
		}
		if (usernameTextField.getText().isEmpty()) {
			empty = true;
		}
		if (emailTextField.getText().isEmpty()) {
			empty = true;
		}
		if (calendar.getDate() == null) {
			empty = true;
		}

		// Return the boolean
		// If none of the fields were empty, the boolean would return false
		return empty;
	}

	// Checks to see if the user name meets the requirements
	private boolean isValidUsername() {

		// If the usernameField is < 5 in length, return false
		if (usernameTextField.getText().length() < 5) {
			return false;
		}

		// If the usernameField contains ",", return false
		if (usernameTextField.getText().contains(",")) {
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

			// If the usernameField is equal to the currentUser and the currentUser is not
			// equal to the user name of the user currently logged in, return false
			if (usernameTextField.getText().equals(currentUser.getUsername())
					&& currentUser.getUsername() != PersonalCalendarApplication.users
							.get(PersonalCalendarApplication.loggedInUserNum).getUsername()) {
				return false;
			}
		}

		// Otherwise return true, since the user name is unique
		return true;
	}

	// Checks to see if the email is legitimate by checking if it contains @ and .
	private boolean isValidEmail() {

		// If the emailField contains @ and . , return true
		if (emailTextField.getText().contains("@") && emailTextField.getText().contains(".")) {
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
		if (firstNameTextField.getText().matches(numbers)) {
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
		if (lastNameTextField.getText().matches(numbers)) {
			return false;
		}

		// Otherwise no number is in the field, return true
		return true;

	}

	// Validates the info, checking if the user name is valid and the password is
	// valid
	private boolean validateInfo() {

		// If the user name or password is not valid, return boolean as false
		if (!isValidUsername() || !validateUsername() || emptyFields() || !isValidEmail() || !isValidFirstName() || !isValidLastName()) {
			return false;
		}

		// Otherwise return boolean as true
		return true;
	}

	// Rewrites the user file with the new user logins
	private void rewriteUserFile() {

		// String containing the user login credentials file copied
		String fileName = String.format("files/User Login Information.csv");
		File file = new File(fileName);

		if (!file.isDirectory()) {

			try {

				// Write data to a file
				PrintWriter pr = new PrintWriter(fileName);

				// Print out the fileCopied variable and the new user name information to the
				// file and close it afterwards
				pr.print("Username,Password,First Name,Last Name,Email,Birthday,Birth Month, Birth Year, \n");

				for (User currentUser : PersonalCalendarApplication.users) {
					String birthDay = String.valueOf(currentUser.getBirthDay());
					String birthMonth = String.valueOf(currentUser.getBirthMonth());
					String birthYear = String.valueOf(currentUser.getBirthYear());
					pr.print(currentUser.getUsername() + "," + currentUser.getPassword() + ","
							+ currentUser.getFirstName() + "," + currentUser.getLastName() + ","
							+ currentUser.getEmail() + "," + birthDay + "," + birthMonth + "," + birthYear + ", \n");
				}

				pr.close();

			} catch (FileNotFoundException e) {
				System.out.println("Save Failed");
			}
		}
	}

}
