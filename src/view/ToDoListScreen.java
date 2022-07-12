/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 14, 2022
 * Description: This file creates the to do list screen. This screen includes a side bar, a to-do list, and urgent events list and a button to add events
 */

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import application.PersonalCalendarApplication;
import fileInput.FileInput;

@SuppressWarnings("serial")
public class ToDoListScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panel
	private JPanel profilePanel = new JPanel();
	private JPanel sidePanel = new JPanel();
	private JPanel listPanel = new JPanel();
	private JPanel upcomingList = new JPanel();
	private JPanel todoList = new JPanel();

	// Buttons
	private JButton calendarButton = new JButton();
	private JButton listButton = new JButton();
	private JButton addEventButton = new JButton();
	private JButton settingsButton = new JButton();
	private JButton signOutButton = new JButton();
	private JButton calendarImg = new JButton(new ImageIcon("images/Calendar.png"));
	private JButton listImg = new JButton(new ImageIcon("images/List.png"));
	private JButton addEventsImg = new JButton(new ImageIcon("images/Add.png"));
	private JButton settingsImg = new JButton(new ImageIcon("images/Settings.png"));
	private JButton addImg = new JButton();
	private JButton deleteButton = new JButton();

	// Scroll Pane
	private JScrollPane listScroll;
	private JScrollPane upcomingScroll;

	// Labels
	private JLabel appNameLabel = new JLabel();
	private JLabel username = new JLabel();
	private JLabel logoImg = new JLabel(new ImageIcon("images/Taskily Logo Two.png"));
	private JLabel userProfileImg = new JLabel("");
	private JLabel toDoListLabel = new JLabel();
	private JLabel titleLabel = new JLabel();
	private JLabel upcomingLabel = new JLabel();

	// Menu
	private JMenu fileMenu = new JMenu("File");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu userMenu = new JMenu("User");

	// Menu Items
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem helpMenuItem = new JMenuItem("User Help");
	private JMenuItem userMenuItem = new JMenuItem("Sign Out");

	// Menu Bar
	private JMenuBar menuBar = new JMenuBar();

	// Array List
	ArrayList<JCheckBox> label = new ArrayList<JCheckBox>();

	// Variables
	private int day;
	private int month;
	private int year;

	// Constants
	public final static int[] SUM_AT_MONTH = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

	// Constructor method
	public ToDoListScreen() {
		frameSetup();
		initialize();
	}

	// Set up the frame
	private void frameSetup() {

		// Get the current date - used to display the current date/month/year
		String current_date = (new SimpleDateFormat("dd/uu/MM/yyyy")).format(new Date());
		this.parseDate(current_date);

		// Set bounds
		setBounds(0, 0, 1400, 900);

		// Make the application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set title
		setTitle("Taskly - To Do List");

		// Make the screen not resizable (dimensions are locked)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add profilePanel, sidePanel and listPanel to frame
		getContentPane().add(profilePanel);
		getContentPane().add(sidePanel);
		getContentPane().add(listPanel);

		// Set JMenuBar
		setJMenuBar(menuBar);

		// Make frame visible
		setVisible(true);
	}

	// Initialize the contents of the frame and sets up profilePanel, sidePanel and
	// listPanel
	private void initialize() {

		// Set bounds, border, and background color of profilePanel
		profilePanel.setBounds(0, 0, 400, 300);
		profilePanel.setLayout(null);
		profilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		profilePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, border, and background color of sidePanel
		sidePanel.setBounds(0, 300, 400, 600);
		sidePanel.setLayout(null);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sidePanel.setBackground(new Color(63, 43, 99));

		// Set bounds and background color of listPanel
		listPanel.setBounds(400, 0, 1000, 900);
		listPanel.setLayout(null);
		listPanel.setBackground(Color.LIGHT_GRAY);

		// Set text color, horizontal alignment, font, text and bounds for appNameLabel
		// Add appNameLabel to profilePanel
		appNameLabel.setForeground(Color.WHITE);
		appNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appNameLabel.setFont(new Font("Gadugi", Font.BOLD, 35));
		appNameLabel.setText("Taskly");
		appNameLabel.setBounds(130, 50, 175, 100);
		profilePanel.add(appNameLabel);

		// Set text color, horizontal alignment, font, text, and bounds for user name
		// label
		// Add user name label to profilePanel
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Gadugi", Font.BOLD, 25));
		username.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername());
		username.setBounds(170, 165, 253, 100);
		profilePanel.add(username);

		// Set text color, horizontal alignment, font, text and bounds for titleLabel
		// Add titleLabel to listPanel
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		titleLabel.setText("To Do List");
		titleLabel.setBounds(250, 70, 500, 100);
		listPanel.add(titleLabel);

		// Set text color, horizontal alignment, font, text, and bounds for
		// toDoListLabel
		// Add toDoListLabel to listPanel
		toDoListLabel.setForeground(Color.BLACK);
		toDoListLabel.setHorizontalAlignment(SwingConstants.LEFT);
		toDoListLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		toDoListLabel.setText("To Do List:");
		toDoListLabel.setBounds(110, 180, 200, 100);
		listPanel.add(toDoListLabel);

		// Set text color, horizontal alignment, font, text, and bounds for
		// upcomingLabel
		// Add upcomingLabel to listPanel
		upcomingLabel.setForeground(Color.BLACK);
		upcomingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		upcomingLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		upcomingLabel.setText("Upcoming Events List:");
		upcomingLabel.setBounds(530, 180, 300, 100);
		listPanel.add(upcomingLabel);

		// Set text color, font, text, and bounds for calendarButton
		calendarButton.setForeground(Color.WHITE);
		calendarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calendarButton.setText("Calendar");
		calendarButton.setBounds(75, 20, 187, 81);

		// Set calendarButton to transparent, border not painted, content area not
		// filled
		// Add action listener to calendarButton and add it to sidePanel
		calendarButton.setOpaque(false);
		calendarButton.setBorderPainted(false);
		calendarButton.setContentAreaFilled(false);
		calendarButton.addActionListener(this);
		sidePanel.add(calendarButton);

		// Set bounds for calendarImg
		// Set calendarImg to transparent, border not painted, and content area not
		// filed
		// Add calendarImg to sidePanel
		calendarImg.setBounds(53, 23, 70, 70);
		calendarImg.setOpaque(false);
		calendarImg.setBorderPainted(false);
		calendarImg.setContentAreaFilled(false);
		calendarImg.addActionListener(this);
		sidePanel.add(calendarImg);

		// Set text color, font, text, and bounds for listButton
		listButton.setForeground(Color.WHITE);
		listButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listButton.setText("To-do List");
		listButton.setBounds(82, 120, 187, 81);

		// Set listButton to transparent, border not painted, content area not filled,
		// and button not enabled
		// Add action listener to listButton and add it to sidePanel
		listButton.setOpaque(false);
		listButton.setBorderPainted(false);
		listButton.setContentAreaFilled(false);
		listButton.setEnabled(false);
		listButton.addActionListener(this);
		sidePanel.add(listButton);

		// Set bounds for listImg
		// Set listImg to transparent, border not painted, content area not filled, and
		// button not enabled
		// Add action listener to listImg and add it to sidePanel
		listImg.setBounds(55, 125, 70, 70);
		listImg.setOpaque(false);
		listImg.setBorderPainted(false);
		listImg.setContentAreaFilled(false);
		listImg.setEnabled(false);
		listImg.addActionListener(this);
		sidePanel.add(listImg);

		// Set text color, font, text, and bounds for addEventButton
		addEventButton.setForeground(Color.WHITE);
		addEventButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addEventButton.setText("Add Event/Task");
		addEventButton.setBounds(70, 220, 257, 81);

		// Set addEventButton to transparent, border not painted, content area not
		// filled
		// Add action listener to addEventButton and add it to sidePanel
		addEventButton.setOpaque(false);
		addEventButton.setBorderPainted(false);
		addEventButton.setContentAreaFilled(false);
		addEventButton.addActionListener(this);
		sidePanel.add(addEventButton);

		// Set bounds for addEventsImg
		// Set addEventsImg to transparent, border not painted, content area not filled
		// Add action listener to addEventsImg and add it to sidePanel
		addEventsImg.setBounds(55, 225, 70, 70);
		addEventsImg.setOpaque(false);
		addEventsImg.setBorderPainted(false);
		addEventsImg.setContentAreaFilled(false);
		addEventsImg.addActionListener(this);
		sidePanel.add(addEventsImg);

		// Set text color, font, text, bounds for settingsButton
		settingsButton.setForeground(Color.WHITE);
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		settingsButton.setText("Settings");
		settingsButton.setBounds(75, 320, 187, 81);

		// Set settingsButton to transparent, border not painted, content area not
		// filled
		// Add action listener to settingsButton and add it to sidePanel
		settingsButton.setOpaque(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.addActionListener(this);
		sidePanel.add(settingsButton);

		// Set bounds for settingsImg
		// Set settingsImg to transparent, border not painted, content area not filled
		// Add action listener to settingsImg and add it to sidePanel
		settingsImg.setBounds(56, 325, 70, 70);
		settingsImg.setOpaque(false);
		settingsImg.setBorderPainted(false);
		settingsImg.setContentAreaFilled(false);
		settingsImg.addActionListener(this);
		sidePanel.add(settingsImg);

		// Set text color, background color, font, text, bounds, and border for
		// signOutButton
		// Add action listener to signOutButton and add it to sidePanel
		signOutButton.setForeground(Color.WHITE);
		signOutButton.setBackground(new Color(156, 138, 165));
		signOutButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signOutButton.setText("Sign Out");
		signOutButton.setBounds(105, 430, 190, 80);
		signOutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		signOutButton.addActionListener(this);
		sidePanel.add(signOutButton);

		// Set text color, background color, font, text, bounds, and border for
		// deleteButton
		// Add action listener to deleteButton and add it to listPanel
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBackground(new Color(156, 138, 165));
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteButton.setText("Delete");
		deleteButton.setBounds(695, 742, 190, 80);
		deleteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		deleteButton.addActionListener(this);
		listPanel.add(deleteButton);

		// Set bounds for addImg, scale the image, and set icon for addImg
		addImg.setBounds(595, 750, 60, 60);
		ImageIcon defaultAddImg = new ImageIcon("images/Add Event.png");
		Image newAddImg = defaultAddImg.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		addImg.setIcon(new ImageIcon(newAddImg));

		// Set addImg to transparent, border not painted, content area not filled
		// Add action listener to addImg and add it to listPanel
		addImg.setOpaque(false);
		addImg.setBorderPainted(false);
		addImg.setContentAreaFilled(false);
		addImg.addActionListener(this);
		listPanel.add(addImg);

		// Set bounds for logoImg and add it to profilePanel
		logoImg.setBounds(40, 50, 100, 100);
		profilePanel.add(logoImg);

		// Set bounds for userProfileImg, scale the image, set icon and add it to
		// profilePanel
		userProfileImg.setBounds(50, 165, 100, 100);
		ImageIcon defaultImage = new ImageIcon("images/Profile Picture " + PersonalCalendarApplication.users
				.get(PersonalCalendarApplication.loggedInUserNum).getProfilePictureNumber() + ".png");
		Image newImage = defaultImage.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		userProfileImg.setIcon(new ImageIcon(newImage));
		profilePanel.add(userProfileImg);

		// Create new JPanel, set layout, and background color
		todoList = new JPanel();
		todoList.setLayout(new BoxLayout(todoList, BoxLayout.Y_AXIS));
		todoList.setBackground(new Color(156, 138, 165));

		// Create new JScrollPane, set border, bounds and add it to listPanel
		listScroll = new JScrollPane(todoList);
		listScroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		listScroll.setBounds(110, 260, 355, 458);
		listPanel.add(listScroll);

		// Create new JPanel, set layout and background color
		upcomingList = new JPanel();
		upcomingList.setLayout(new BoxLayout(upcomingList, BoxLayout.Y_AXIS));
		upcomingList.setBackground(new Color(156, 138, 165));

		// Create new JScrollpane, set border, bounds and add it to listPanel
		upcomingScroll = new JScrollPane(upcomingList);
		upcomingScroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		upcomingScroll.setBounds(530, 260, 355, 458);
		listPanel.add(upcomingScroll);

		// Set background color of menu bar
		menuBar.setBackground(new Color(156, 138, 165));
		menuBar.setBorder(null);

		// Set text color of the menu text
		fileMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
		userMenu.setForeground(Color.BLACK);

		// Set text color of the menu item text
		exitMenuItem.setForeground(Color.BLACK);
		helpMenuItem.setForeground(Color.BLACK);
		userMenuItem.setForeground(Color.BLACK);

		// Set background of the menu item
		exitMenuItem.setBackground(new Color(156, 138, 165));
		helpMenuItem.setBackground(new Color(156, 138, 165));
		userMenuItem.setBackground(new Color(156, 138, 165));

		// Add action listener to the menu item
		exitMenuItem.addActionListener(this);
		helpMenuItem.addActionListener(this);
		userMenuItem.addActionListener(this);

		// Add the menu items to the menus
		fileMenu.add(exitMenuItem);
		helpMenu.add(helpMenuItem);
		userMenu.add(userMenuItem);

		// Add the menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		menuBar.add(userMenu);

		// Keep counter of task and events
		int taskCounter = 0;
		int eventCounter = 0;

		// For the number of dates (events/tasks)
		for (int i = 0; i < PersonalCalendarApplication.dates.size(); i++) {

			// Variable to find difference in days
			int dayDiff;

			// If the date is a task
			if (PersonalCalendarApplication.dates.get(i).getTaskIsSelcted() == true) {

				// Variables holding day, month, year, title and desc of task
				int taskDay = PersonalCalendarApplication.dates.get(i).getDay();
				int taskMonth = PersonalCalendarApplication.dates.get(i).getMonth();
				int taskYear = PersonalCalendarApplication.dates.get(i).getYear();
				String title = PersonalCalendarApplication.dates.get(i).getTitle();
				String desc = PersonalCalendarApplication.dates.get(i).getDesc();

				// Create new JCheckBox holding information of event
				JCheckBox checkbox = new JCheckBox(
						taskMonth + "/" + taskDay + "/" + taskYear + ": " + title + " - " + desc);
				checkbox.setActionCommand(Integer.toString(i));
				System.out.println(checkbox.getActionCommand());

				// Add it to label array list
				label.add(checkbox);

				// Set bounds, font, and background color of check box
				// Add check box to toDoList
				checkbox.setBounds(30, 80 * i + 20, 50, 50);
				checkbox.setFont(new Font("Gadugi", Font.BOLD, 18));
				checkbox.setBackground(new Color(156, 138, 165));
				todoList.add(checkbox);

				// Increment taskCounter
				taskCounter++;
			}

			// If the date is an event
			else if (PersonalCalendarApplication.dates.get(i).getTaskIsSelcted() == false) {

				// Variables holding day, month, year, title and desc of event
				int eventDay = PersonalCalendarApplication.dates.get(i).getDay();
				int eventMonth = PersonalCalendarApplication.dates.get(i).getMonth();
				int eventYear = PersonalCalendarApplication.dates.get(i).getYear();
				String title = PersonalCalendarApplication.dates.get(i).getTitle();
				String desc = PersonalCalendarApplication.dates.get(i).getDesc();

				// Formula used to find difference in days
				dayDiff = ((eventYear * 365) + ((eventYear - (eventMonth > 2 ? 0 : 1)) / 4)
						+ SUM_AT_MONTH[eventMonth - 1] + eventDay)
						- ((year * 365) + ((year - (month > 2 ? 0 : 1)) / 4) + SUM_AT_MONTH[month - 1] + day);

				if (dayDiff > 0 && dayDiff <= 14) {
					// Create new JCheckBox holding information of event
					JCheckBox checkbox = new JCheckBox(
							eventMonth + "/" + eventDay + "/" + eventYear + ": " + title + " - " + desc);
					checkbox.setActionCommand(Integer.toString(i));
					System.out.println(checkbox.getActionCommand());

					// Add it to label array list
					label.add(checkbox);

					// Set bounds, font, and background color of check box
					checkbox.setBounds(30, 80 * i + 20, 50, 50);
					checkbox.setFont(new Font("Gadugi", Font.BOLD, 18));
					checkbox.setBackground(new Color(156, 138, 165));

					// Add check box to upcomingList
					upcomingList.add(checkbox);

					// Increment eventCounter
					eventCounter++;
				}
			}
		}

		// If eventCounter is 0
		if (eventCounter == 0) {

			// Create new JPanel, set to transparent, and add JLabel to it saying no
			// upcoming events
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.add(new JLabel("<html><font size='4' color='#000000'> No upcoming events </font></html>"));

			// Add panel to upcomingList
			upcomingList.add(panel);
		}

		// If taskCounter is 0
		if (taskCounter == 0) {

			// Create new JPanel, set to transparent, and add JLabel to it saying no
			// upcoming tasks
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.add(new JLabel("<html><font size='4' color='#000000'> No upcoming tasks </font></html>"));

			// Add panel to todoList
			todoList.add(panel);
		}
	}

	// If action is performed - button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		// If calendarButton or calendarImg is clicked
		if (e.getSource() == calendarButton || e.getSource() == calendarImg) {

			// Call CalendarScreen constructor method, set ToDoListScreen to not visible,
			// and dispose screen
			new CalendarScreen();
			setVisible(false);
			dispose();
		}

		// If addEventButton or addEventsImg is clicked
		else if (e.getSource() == addEventButton || e.getSource() == addEventsImg) {

			// Call AddEventScreen constructor method, set ToDoListScreen to not visible,
			// and dispose screen
			new AddEventScreen();
			setVisible(false);
			dispose();
		}

		// If settingsButton or settingsImg is clicked
		else if (e.getSource() == settingsButton || e.getSource() == settingsImg) {

			// Call SettingsScreen constructor method, set ToDoListScreen to not visible,
			// and dispose screen
			new SettingsScreen();
			setVisible(false);
			dispose();
		}

		// If signOutButton is clicked
		else if (e.getSource() == signOutButton) {

			// Display option dialog asking user if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks yes
			if (res == JOptionPane.YES_OPTION) {

				// Rewrite user's date file, call LogInScreen constructor method and dispose
				// ToDoListScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();
			}

			// Otherwise if user clicks no
			else {

				// Call LogInScreen constructor method, set ToDoListScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If exitMenuItem is clicked from menu bar
		else if (e.getSource() == exitMenuItem) {

			// Display option dialog asking user if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks yes
			if (res == JOptionPane.YES_OPTION) {

				// Rewrite user's date file, and exit the application
				FileInput.writeDatesFile();
				System.exit(0);
			}

			// Otherwise if user says no, exit the application
			else {
				System.exit(0);
			}
		}

		// If helpMenuItem is clicked from menu bar
		else if (e.getSource() == helpMenuItem) {

			// Call HelpScreen constructor method
			new HelpScreen();
		}

		// If userMenuItem is clicked from menu bar
		else if (e.getSource() == userMenuItem) {

			// Display option asking user if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user says yes
			if (res == JOptionPane.YES_OPTION) {

				// Rewrite user's date file, call LogInScreen constructor method and dispose
				// ToDoListScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();
			}

			// Otherwise if user says no
			else {

				// Call LogInScreen constructor method, set ToDoListScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If user clicks on add event button, dispose ToDoListScreen and take them to
		// AddEventScreen
		else if (e.getSource() == addImg) {
			setVisible(false);
			dispose();
			new AddEventScreen();
		}

		// If deleteButton is clicked
		else if (e.getSource() == deleteButton) {

			// For the number of events/tasks in the label array list
			for (int j = 0; j < label.size(); j++) {

				// If the event/task is selected
				if (label.get(j).isSelected()) {

					// Remove it from label array list and dates array list
					PersonalCalendarApplication.dates.remove(Integer.parseInt(label.get(j).getActionCommand()));
					label.remove(j);
					j--;
				}
			}

			// Refresh ToDoListScreen
			setVisible(false);
			dispose();
			new ToDoListScreen();

		}
	}

	// Get the current date
	private void parseDate(String date) {
		StringTokenizer st = new StringTokenizer(date, "/");
		day = Integer.parseInt(st.nextToken());
		st.nextToken();
		month = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
	}

}
