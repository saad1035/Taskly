/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 11, 2022
 * Description: Creates the login screen where the user can enter their user name and password to log in or head on to create a new account
 */

package view;

// Import packages used to create log in screen
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import application.PersonalCalendarApplication;
import fileInput.FileInput;

@SuppressWarnings("serial")
public class LogInScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panel
	private JPanel logoPanel = new JPanel();
	private JPanel logInPanel = new JPanel();

	// Labels
	private JLabel logoTitle = new JLabel();
	private JLabel title = new JLabel();
	private JLabel titleTwo = new JLabel();
	private JLabel usernameLabel = new JLabel();
	private JLabel passwordLabel = new JLabel();
	private JLabel logoImg = new JLabel(new ImageIcon("images/logo.png"));
	private JLabel passwordImg = new JLabel(new ImageIcon("images/PasswordIcon.png"));
	private JLabel usernameImg = new JLabel(new ImageIcon("images/UsernameIcon.png"));

	// TextFields and PasswordFields
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();

	// Buttons
	private JButton logInButton = new JButton();
	private JButton signUpButton = new JButton();
	private JToggleButton hideShowPassword = new JToggleButton(new ImageIcon("images/HideShowIcon.png"));

	// Menu
	private JMenu fileMenu = new JMenu("File");
	private JMenu helpMenu = new JMenu("Help");

	// Menu Items
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem helpMenuItem = new JMenuItem("User Help");

	// MenuBar
	private JMenuBar menuBar = new JMenuBar();

	// Constructor Method
	public LogInScreen() {
		frameSetup();
		initialize();
	}

	// Set up the frame
	private void frameSetup() {
		
		// Set the bounds of the frame
		setBounds(0, 0, 1400, 900);

		// Makes the whole application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set the title of the frame
		setTitle("Taskly");

		// Window's not resizable (locked to the specific dimensions)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add the panels to the frame
		getContentPane().add(logoPanel);
		getContentPane().add(logInPanel);

		// Add JMenuBar to the frame
		setJMenuBar(menuBar);

		// Make it visible
		setVisible(true);
	}

	// Initializes the contents of the frame and sets up the logoPanel and
	// logInPanel (adds components to it)
	private void initialize() {

		// Set bounds, layout and background color of the logoPanel
		logoPanel.setBounds(0, 0, 600, 900);
		logoPanel.setLayout(null);
		logoPanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout and background color of the logInPanel
		logInPanel.setBounds(600, 0, 800, 900);
		logInPanel.setLayout(null);
		logInPanel.setBackground(Color.LIGHT_GRAY);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// logoTitle label
		// Add the label to the logoPanel
		logoTitle.setForeground(Color.WHITE);
		logoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		logoTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 75));
		logoTitle.setText("TASKLY");
		logoTitle.setBounds(50, 230, 500, 200);
		logoPanel.add(logoTitle);

		// Set text color, horizontal alignment, font, text, and bounds for the title
		// label
		// Add the label to the logInPanel
		title.setForeground(Color.BLACK);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		title.setText("WELCOME BACK!");
		title.setBounds(75, -10, 639, 300);
		logInPanel.add(title);

		// Set font, text color, horizontal alignment, text and bounds for the titleTwo
		// label
		// Add the label to the logInPanel
		titleTwo.setFont(new Font("Unispace", Font.BOLD, 25));
		titleTwo.setForeground(Color.BLACK);
		titleTwo.setHorizontalAlignment(SwingConstants.CENTER);
		titleTwo.setText("USER LOGIN");
		titleTwo.setBounds(92, 135, 600, 300);
		logInPanel.add(titleTwo);

		// Set font, bounds, horizontal alignment, text color, background color, and
		// border for the usernameField textfield
		// Add the textfield to the logInPanel
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameField.setBounds(225, 368, 335, 35);
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setForeground(Color.BLACK);
		usernameField.setBackground(new Color(156, 138, 165));
		usernameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		logInPanel.add(usernameField);

		// Set font, bounds, horizontal alignment, text color, background color and
		// border for the passwordField passwordfield
		// Add the passwordfield to the logInPanel
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(225, 490, 335, 35);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(new Color(156, 138, 165));
		passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		logInPanel.add(passwordField);

		// Set font, text color, text, horizontal alignment and bounds for the
		// usernameLabel label
		// Add the label to the logInPanel
		usernameLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setText("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(305, 303, 175, 100);
		logInPanel.add(usernameLabel);

		// Set font, text color, text, horizontal alignment, and bounds for the
		// passwordLabel label
		// Add the label to the logInPanel
		passwordLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setText("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(305, 425, 175, 100);
		logInPanel.add(passwordLabel);

		// Set the background color, text color, font, text, bounds, and border for the
		// sigUpButton button
		// Add an action listener to the button and add the button to the logInpanel
		signUpButton.setBackground(new Color(156, 138, 165));
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		signUpButton.setText("SIGN UP");
		signUpButton.setBounds(440, 610, 180, 65);
		signUpButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		signUpButton.addActionListener(this);
		logInPanel.add(signUpButton);

		// Set the background color, text color, font, text, bounds, and border for the
		// logInButton button
		// Add an action listener to the button and add the button to the logInpanel
		logInButton.setBackground(new Color(156, 138, 165));
		logInButton.setForeground(Color.BLACK);
		logInButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		logInButton.setText("LOG IN");
		logInButton.setBounds(160, 610, 180, 65);
		logInButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		logInButton.addActionListener(this);
		logInPanel.add(logInButton);

		// Set bounds for the toggle button
		// Make the button transparent, borders removed, and content areas not filled
		// Add action listener to the button and add the button to the logInPanel
		hideShowPassword.setBounds(540, 457, 100, 100);
		hideShowPassword.setOpaque(false);
		hideShowPassword.setBorderPainted(false);
		hideShowPassword.setContentAreaFilled(false);
		hideShowPassword.addActionListener(this);
		logInPanel.add(hideShowPassword);

		// Set bounds for the passwordImg label and add it to the panel
		passwordImg.setBounds(153, 457, 100, 100);
		logInPanel.add(passwordImg);

		// Set bounds for the usernameImg label and add it to the panel
		usernameImg.setBounds(153, 337, 100, 100);
		logInPanel.add(usernameImg);

		// Set bounds for the logoImg label and add it to the panel
		logoImg.setBounds(205, 380, 200, 170);
		logoPanel.add(logoImg);

		// Set background of menu bar
		menuBar.setBackground(new Color(156, 138, 165));
		menuBar.setBorder(null);

		// Set text color of the menu text
		fileMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);

		// Set text color of the menu item text
		exitMenuItem.setForeground(Color.BLACK);
		helpMenuItem.setForeground(Color.BLACK);

		// Set background color of the menu items
		exitMenuItem.setBackground(new Color(156, 138, 165));
		helpMenuItem.setBackground(new Color(156, 138, 165));

		// Add action listener to the menu items
		exitMenuItem.addActionListener(this);
		helpMenuItem.addActionListener(this);

		// Add the menu items to the menu
		fileMenu.add(exitMenuItem);
		helpMenu.add(helpMenuItem);

		// Add the menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// Revalidate and repaint
		revalidate();
		repaint();

	}

	@Override
	// If user input is made (ActionListener), a task is performed
	public void actionPerformed(ActionEvent e) {

		// If user clicks on logInButton
		if (e.getSource() == logInButton) {

			// Call login method
			// This method verifies that the information given in the field matches up to
			// one of the possible users in the array list
			login();
		}

		// If user clicks on signUpButton
		else if (e.getSource() == signUpButton) {

			// Call SignUp constructor method where the user is taken to the sign up screen
			new SignUpScreen();

			// Dispose this screen
			this.dispose();
		}

		// If user clicks on hideShowPassowrd toggle button
		else if (e.getSource() == hideShowPassword) {

			// Since hideShowPassowrd is a toggleButton, it has two options; selected or
			// unselected
			// If the hideShowPassword button is selected, print out the characters
			if (hideShowPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			}

			// If the hideShowPassword button is not selected, set the characters to *
			else {
				passwordField.setEchoChar('*');
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

	// Validates and verifies if user's user name and password matches and is a
	// possible login
	// This method is called when the user clicks on logInButton
	private void login() {

		// For each users in array list
		for (int currentUserNum = 0; currentUserNum < PersonalCalendarApplication.users.size(); currentUserNum++) {

			// If the fields given by user matches with the users in array list
			if (usernameField.getText().equals(PersonalCalendarApplication.users.get(currentUserNum).getUsername())
					&& passwordField.getText()
							.equals(PersonalCalendarApplication.users.get(currentUserNum).getPassword())) {

				// Since the user's input matches with a login
				// Set the loggedInUserNum to the index of the users array list
				PersonalCalendarApplication.loggedInUserNum = currentUserNum;

				// Output in terminal access has been granted
				System.out.println("Access Granted");
				
				PersonalCalendarApplication.dates.clear();
				FileInput.readDatesFile();

				// Take the user to the home screen / calendar screen
				new CalendarScreen();

				// Dispose this screen
				this.dispose();
				return;
			}
		}

		// If they don't have a login that matches with one of the users in the array
		// list show a message dialog letting the user know incorrect information
		// was provided
		JOptionPane.showMessageDialog(logInPanel, "Incorrect Username or Password", "INCORRECT",
				JOptionPane.WARNING_MESSAGE);
		System.out.println("Incorrect Username or Password");
	}

}
