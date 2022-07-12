/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 15, 2022
 * Description: Creates the help screen. Multiple buttons are visible on this screen where user can navigate through them and new screens appear providing them with a brief description of how each screen can be used
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class HelpScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panels
	private JPanel helpPanel = new JPanel();

	// Labels
	private JLabel titleLabel = new JLabel();
	private JLabel logInHelpLabel = new JLabel();
	private JLabel signUpHelpLabel = new JLabel();
	private JLabel calendarHelpLabel = new JLabel();
	private JLabel toDoListHelpLabel = new JLabel();
	private JLabel addEventHelpLabel = new JLabel();

	// Buttons
	private JButton logInHelpButton = new JButton();
	private JButton signUpHelpButton = new JButton();
	private JButton calendarHelpButton = new JButton();
	private JButton toDoListHelpButton = new JButton();
	private JButton addEventHelpButton = new JButton();
	private JButton backButton = new JButton();

	// UIManager
	private UIManager UIManager = new UIManager();

	// Constructor method
	public HelpScreen() {
		frameSetup();
		initialize();
	}

	// Set up the frame
	private void frameSetup() {

		// Set bounds for the frame
		setBounds(0, 0, 1400, 900);

		// Make the application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set the title
		setTitle("Taskly - Help");

		// Make the window not resizable (locked to set dimension)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add helpPanel to the frame
		getContentPane().add(helpPanel);

		// Make the frame visible
		setVisible(true);

	}

	// Initialize the contents of the frame, and sets up the helpPanel
	private void initialize() {

		// Set bounds, layout, border, and background color of helpPanel
		helpPanel.setBounds(0, 0, 1400, 900);
		helpPanel.setLayout(null);
		helpPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		helpPanel.setBackground(new Color(63, 43, 99));

		// Set text color, horizontal alignment, font, text and bounds for title label
		// Add the label to the helpPanel
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		titleLabel.setText("Taskly's Help");
		titleLabel.setBounds(422, 26, 500, 100);
		helpPanel.add(titleLabel);

		// Set text color, horizontal alignment, font, text and bounds for the log in
		// help label
		// Add the label to the helpPanel
		logInHelpLabel.setForeground(Color.WHITE);
		logInHelpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logInHelpLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		logInHelpLabel.setText("Log In");
		logInHelpLabel.setBounds(133, 150, 260, 40);
		helpPanel.add(logInHelpLabel);

		// Set text color, horizontal alignment, font, text and bounds for the sign up
		// help label
		// Add the label to the helpPanel
		signUpHelpLabel.setForeground(Color.WHITE);
		signUpHelpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signUpHelpLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		signUpHelpLabel.setText("Sign Up");
		signUpHelpLabel.setBounds(539, 150, 260, 40);
		helpPanel.add(signUpHelpLabel);

		// Set the text color, horizontal alignment, font, text and bounds for the
		// calendar help label
		// Add the label to the helpPanel
		calendarHelpLabel.setForeground(Color.WHITE);
		calendarHelpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		calendarHelpLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		calendarHelpLabel.setText("Calendar");
		calendarHelpLabel.setBounds(1004, 150, 260, 40);
		helpPanel.add(calendarHelpLabel);

		// Set the text color, horizontal alignment, font, text and bounds for the to do
		// list help label
		// Add the label to the helpPanel
		toDoListHelpLabel.setForeground(Color.WHITE);
		toDoListHelpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		toDoListHelpLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		toDoListHelpLabel.setText("To Do List");
		toDoListHelpLabel.setBounds(133, 500, 260, 40);
		helpPanel.add(toDoListHelpLabel);

		// Set the text color, horizontal alignment, font, text, and bounds for the add
		// event help label
		// Add the label to the helpPanel
		addEventHelpLabel.setForeground(Color.WHITE);
		addEventHelpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addEventHelpLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		addEventHelpLabel.setText("Add Event");
		addEventHelpLabel.setBounds(1004, 500, 260, 40);
		helpPanel.add(addEventHelpLabel);

		// Set the bounds, border and icon for the log in help button
		// Add action listener to the button and add it to the helpPanel
		logInHelpButton.setBounds(130, 200, 260, 260);
		ImageIcon logInImage = new ImageIcon("images/LogIn Screen.png");
		Image newLogInImage = logInImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
		logInHelpButton.setIcon(new ImageIcon(newLogInImage));
		logInHelpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		logInHelpButton.addActionListener(this);
		helpPanel.add(logInHelpButton);

		// Set the bounds, border and icon for the sign up help button
		// Add action listener and add the button to the helpPanel
		signUpHelpButton.setBounds(539, 200, 260, 260);
		ImageIcon signUpImage = new ImageIcon("images/SignUp Screen.png");
		Image newSignUpImage = signUpImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
		signUpHelpButton.setIcon(new ImageIcon(newSignUpImage));
		signUpHelpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		signUpHelpButton.addActionListener(this);
		helpPanel.add(signUpHelpButton);

		// Set the bounds, border and icon for the calendar help button
		// Add action listener and add the button to the helpPanel
		calendarHelpButton.setBounds(1004, 200, 260, 260);
		ImageIcon calendarImage = new ImageIcon("images/Calendar Screen.png");
		Image newCalendarImage = calendarImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
		calendarHelpButton.setIcon(new ImageIcon(newCalendarImage));
		calendarHelpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		calendarHelpButton.addActionListener(this);
		helpPanel.add(calendarHelpButton);

		// Set the bounds, border and icon for the to do list help button
		// Add action listener and add the button to the helpPanel
		toDoListHelpButton.setBounds(130, 550, 260, 260);
		ImageIcon toDoListImage = new ImageIcon("images/ToDoList Screen.png");
		Image newToDoListImage = toDoListImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
		toDoListHelpButton.setIcon(new ImageIcon(newToDoListImage));
		toDoListHelpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		toDoListHelpButton.addActionListener(this);
		helpPanel.add(toDoListHelpButton);

		// Set the bounds, border and iconfor the add event help button
		// Add action listener and add button to the helpPanel
		addEventHelpButton.setBounds(1004, 550, 260, 260);
		ImageIcon addEventImage = new ImageIcon("images/Add Event Screen.png");
		Image newAddEventImage = addEventImage.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
		addEventHelpButton.setIcon(new ImageIcon(newAddEventImage));
		addEventHelpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		addEventHelpButton.addActionListener(this);
		helpPanel.add(addEventHelpButton);

		// Set bounds, text, font, border and background color for the back button
		// Add action listener and add button to the helpPanel
		backButton.setLocation(563, 625);
		backButton.setSize(217, 80);
		backButton.setText("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		backButton.setBackground(new Color(156, 138, 165));
		backButton.addActionListener(this);
		helpPanel.add(backButton);
	}

	// Action is performed
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {

		// If user clicks on backButton
		if (e.getSource() == backButton) {
			setVisible(false);
			dispose();
		}

		// If user clicks on logInHelpButton
		else if (e.getSource() == logInHelpButton) {

			// UI managers for JOptionPanes
			UIManager.put("OptionPane.background", new Color(156, 138, 165));
			UIManager.put("Panel.background", new Color(156, 138, 165));

			// Create new JPanel, set preferred size, and layout to null
			JPanel helpPanel = new JPanel();
			helpPanel.setPreferredSize(new Dimension(450, 300));
			helpPanel.setLayout(null);

			// Create new JLabel, set text, horizontal alignment, vertical alignment, font,
			// text color and bounds
			// Add the title to the helpPanel
			JLabel title = new JLabel();
			title.setText("Log In Help");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setVerticalAlignment(SwingConstants.TOP);
			title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
			title.setForeground(Color.BLACK);
			title.setBounds(0, 20, 450, 40);
			helpPanel.add(title);

			// Create new JLabel, set text, text color, bounds, and horizontal alignment
			// Add the desc to the helpPanel
			JLabel desc = new JLabel();
			desc.setFont(new Font("Arial", Font.PLAIN, 16));
			desc.setForeground(Color.BLACK);
			desc.setBounds(10, 50, 425, 260);
			desc.setHorizontalAlignment(SwingConstants.CENTER);
			helpPanel.add(desc);

			// Set text for the desc JLabel
			desc.setText(
					"<html> If you have already made an account, type in the required information in the fields and press log in to "
							+ "continue to the calendar screen. <br><br><br> If you haven't made an account, you can do so by pressing the sign up button."
							+ " This will take you to another screen where you can create your account. Once you have made one you will be taken back to this screen "
							+ "where you can log into your account as shown above. <html>");

			// Create a JOptionPane to display the panels/labels
			JOptionPane.showMessageDialog(this, helpPanel, "Log In Help", JOptionPane.PLAIN_MESSAGE);
		}

		// If user clicks on signUpHelpButton
		else if (e.getSource() == signUpHelpButton) {

			// UI managers for JOptionPane
			UIManager.put("OptionPane.background", new Color(156, 138, 165));
			UIManager.put("Panel.background", new Color(156, 138, 165));

			// Create new JPanel, set preferred size, and layout to null
			JPanel helpPanel = new JPanel();
			helpPanel.setPreferredSize(new Dimension(450, 400));
			helpPanel.setLayout(null);

			// Create new JLabel, set text, horizontal alignment, vertical alignment, font,
			// text color and bounds
			// Add the title to the helpPanel
			JLabel title = new JLabel();
			title.setText("Sign Up Help");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setVerticalAlignment(SwingConstants.TOP);
			title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
			title.setForeground(Color.BLACK);
			title.setBounds(0, 20, 450, 40);
			helpPanel.add(title);

			// Create new JLabel, set font, text color, bounds, and horizontal alignment
			// Add the desc to the helpPanel
			JLabel desc = new JLabel();
			desc.setFont(new Font("Arial", Font.PLAIN, 16));
			desc.setForeground(Color.BLACK);
			desc.setBounds(10, 50, 425, 360);
			desc.setHorizontalAlignment(SwingConstants.CENTER);
			helpPanel.add(desc);

			// Set text for the desc label
			desc.setText(
					"<html> Making a new account can be done by clicking the sign up button at the log in screen. This will take you to a new screen "
							+ "with fields that will need to be filled out in order to create an accout. When filling out the page, please keep in mind a few important points:<br><br> "
							+ " -  The username must contain at least 5 characters and can't include commas <br>"
							+ " -  The username must be unique and not similar to an account already made <br>"
							+ " -  The password must contain at least 5 characters, including one uppercase, lowercase and number <br>"
							+ " -  The password must not include commas <br>"
							+ " -  All fields are required to be filled out and will be validated before creating the account <html>");

			// Create a JOptionPane to display the panels/labels
			JOptionPane.showMessageDialog(this, helpPanel, "Sign Up Help", JOptionPane.PLAIN_MESSAGE);

		}

		// If user clicks on calendarHelpButton
		else if (e.getSource() == calendarHelpButton) {

			// UI managers for JOptionPane
			UIManager.put("OptionPane.background", new Color(156, 138, 165));
			UIManager.put("Panel.background", new Color(156, 138, 165));

			// Create new JPanel, set preferred size, and set layout to null
			JPanel helpPanel = new JPanel();
			helpPanel.setPreferredSize(new Dimension(550, 600));
			helpPanel.setLayout(null);

			// Create new JLabel, set text, horizontal alignment, vertical alignment, font,
			// text color and bounds
			// Add the title to the helpPanel
			JLabel title = new JLabel();
			title.setText("Calendar Help");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setVerticalAlignment(SwingConstants.TOP);
			title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
			title.setForeground(Color.BLACK);
			title.setBounds(0, 20, 550, 40);
			helpPanel.add(title);

			// Create new JLabel, set font, text color, bounds and horizontal alignment
			// Add the desc to the helpPanel
			JLabel desc = new JLabel();
			desc.setFont(new Font("Arial", Font.PLAIN, 16));
			desc.setForeground(Color.BLACK);
			desc.setBounds(10, 50, 525, 560);
			desc.setHorizontalAlignment(SwingConstants.CENTER);
			helpPanel.add(desc);

			// Set text for the desc label
			desc.setText("<html> When logged in to your desired accounts, you will arrive at the calendar screen. "
					+ "You'll find a calendar to the right side of the screen that is fully functional. <br> When you click on a specific date in the month,"
					+ " it will take you to the week format. <br> Same goes for the year format. When you click on a specific month in the year, it will take you "
					+ "to the month format of that specific month. <br> If you reach to the week format, and wish to go back to the month or year format, you can do "
					+ "so by clicking on the back button once or twice. <br> Two arrows are located at the top of the calendar that allow you to scroll through the months, "
					+ "weeks, or even years. <br> <br> This screen also includes a side bar. On the side bar includes a wide variety of buttons to click through. <br> If you "
					+ "wish to go to the to-do list, you can do so by clicking the to do list button. <br> If you wish to add an event you can do so by clicking on the add event"
					+ " button. <br> If you wish to change your settings/personal information, you can do so by cliking on the settings button. <br> Finally, if at any point in time, "
					+ "you wish to sign out of the application, you can do so by clicking on the sign out button or going to the menu bar where it will give you an option to sign out. <html>");

			// Create a JOptionPane to display the panel/labels
			JOptionPane.showMessageDialog(this, helpPanel, "Calendar Help", JOptionPane.PLAIN_MESSAGE);

		}

		// If user clicks on toDoListHelpButton
		else if (e.getSource() == toDoListHelpButton) {

			// UI manager for JOptionPane
			UIManager.put("OptionPane.background", new Color(156, 138, 165));
			UIManager.put("Panel.background", new Color(156, 138, 165));

			// Create new JPanel, set preferred size, and set layout to null
			JPanel helpPanel = new JPanel();
			helpPanel.setPreferredSize(new Dimension(450, 350));
			helpPanel.setLayout(null);

			// Create new JLabel, set text, horizontal alignment, vertical alignment, font,
			// text color and bounds
			// Add the title to the helpPanel
			JLabel title = new JLabel();
			title.setText("To Do List Help");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setVerticalAlignment(SwingConstants.TOP);
			title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
			title.setForeground(Color.BLACK);
			title.setBounds(0, 20, 450, 40);
			helpPanel.add(title);

			// Create new JLabel, set font, text color, bounds and horizontal alignment
			// Add the desc to the helpPanel
			JLabel desc = new JLabel();
			desc.setFont(new Font("Arial", Font.PLAIN, 16));
			desc.setForeground(Color.BLACK);
			desc.setBounds(10, 50, 425, 310);
			desc.setHorizontalAlignment(SwingConstants.CENTER);
			helpPanel.add(desc);

			// Set text for the desc label
			desc.setText(
					"<html> In the to do list screen, you can see two lists; a to do list and upcoming events list. <br> The to do list "
							+ "will show a list of all the tasks you have planned. On the other hand the upcoming events list shows events that are coming "
							+ "up very soon. <br><br> If you wish to add on to the lists, you can do so by navigating to the add event screen <br><br> If you wish"
							+ " to delete/remove a task or event, you can click on the checkbox next to the task/event, and click delete on the bottom right. Keep in mind"
							+ " only one event/task can be deleted at a time. This will "
							+ "remove it from both the to-do list and the calendar. <html>");

			// Create a JOptionPane to display the panel/labels
			JOptionPane.showMessageDialog(this, helpPanel, "To Do List Help", JOptionPane.PLAIN_MESSAGE);

		}

		// If user clicks on addEventHelpButton
		else if (e.getSource() == addEventHelpButton) {

			// UI manager for JOptionPane
			UIManager.put("OptionPane.background", new Color(156, 138, 165));
			UIManager.put("Panel.background", new Color(156, 138, 165));

			// Create new JPanel, set preferred size, and set layout to null
			JPanel helpPanel = new JPanel();
			helpPanel.setPreferredSize(new Dimension(450, 400));
			helpPanel.setLayout(null);

			// Create new JLabel, set text, horizontal alignment, vertical alignment, font,
			// text color and bounds
			// Add the title to the helpPanel
			JLabel title = new JLabel();
			title.setText("Add Event Help");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setVerticalAlignment(SwingConstants.TOP);
			title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
			title.setForeground(Color.BLACK);
			title.setBounds(0, 20, 450, 40);
			helpPanel.add(title);

			// Create new JLabel, set font, text color, bounds and horizontal alignment
			// Add the desc to the helpPanel
			JLabel desc = new JLabel();
			desc.setFont(new Font("Arial", Font.PLAIN, 16));
			desc.setForeground(Color.BLACK);
			desc.setBounds(10, 50, 425, 360);
			desc.setHorizontalAlignment(SwingConstants.CENTER);
			helpPanel.add(desc);

			// Set text for the desc label
			desc.setText(
					"<html> In the add event screen, you can add events or tasks to  your calendars and to do lists. All the fields, but the description field are required to be filled "
							+ "out in order to add the event/tasks to the calendars and to-do lists. <br><br> Start by entering the date, month and year the event or task is going "
							+ "to occur in. Ensure that these dates are valid in the dd/MM/yyyy format. <br><br> Then start giving the event/task a title, followed by a description if you wish. Ensure that the fields don't exceed the maximum character "
							+ "count. Finally select whether what you are adding is a task or event. <br><br> Once you are done, click save, and if everything is valid, "
							+ "it will add the event to the calendar/to do list. <html>");

			// Create a JOptionPane to display the panel/labels
			JOptionPane.showMessageDialog(this, helpPanel, "Add Event Help", JOptionPane.PLAIN_MESSAGE);
		}

	}

}
