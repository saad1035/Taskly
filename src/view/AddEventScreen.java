/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 14, 2022
 * Description: Creates the add event screen. This screen includes a side bar with functional buttons leading to other features of the application. 
 * 				On top of that, it also includes fields that the user can input to add an event (fields get validated)
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import application.PersonalCalendarApplication;
import fileInput.FileInput;
import model.CalendarEvent;

@SuppressWarnings("serial")
public class AddEventScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panel
	private JPanel profilePanel = new JPanel();
	private JPanel sidePanel = new JPanel();
	private JPanel addEventPanel = new JPanel();

	// Buttons
	private JButton calendarButton = new JButton();
	private JButton listButton = new JButton();
	private JButton addEventButton = new JButton();
	private JButton settingsButton = new JButton();
	private JButton signOutButton = new JButton();
	private JButton saveButton = new JButton();
	private JButton calendarImg = new JButton(new ImageIcon("images/Calendar.png"));
	private JButton listImg = new JButton(new ImageIcon("images/List.png"));
	private JButton addEventsImg = new JButton(new ImageIcon("images/Add.png"));
	private JButton settingsImg = new JButton(new ImageIcon("images/Settings.png"));

	// Text Fields
	private JTextField dayTextField = new JTextField();
	private JTextField monthTextField = new JTextField();
	private JTextField yearTextField = new JTextField();

	// Text Areas
	private JTextArea title = new JTextArea();
	private JTextArea description = new JTextArea();

	// Radio Button
	private JRadioButton taskRadioButton = new JRadioButton("Task");
	private JRadioButton eventRadioButton = new JRadioButton("Event");

	// Labels
	private JLabel appNameLabel = new JLabel();
	private JLabel username = new JLabel();
	private JLabel logoImg = new JLabel(new ImageIcon("images/Taskily Logo Two.png"));
	private JLabel userProfileImg = new JLabel("");
	private JLabel addEventTitle = new JLabel();
	private JLabel enterDateLabel = new JLabel();
	private JLabel monthLabel = new JLabel();
	private JLabel dayLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private JLabel enterInformationLabel = new JLabel();
	private JLabel titleLabel = new JLabel();
	private JLabel descriptionLabel = new JLabel();
	private JLabel taskEventLabel = new JLabel();
	private JLabel dayIncorrectIcon = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel monthIncorrectIcon = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel yearIncorrectIcon = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel titleIncorrectIcon = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel descIncorrectIcon = new JLabel(new ImageIcon("images/IncorrectIcon.png"));
	private JLabel titleMax = new JLabel("Characters: 0/50");
	private JLabel descMax = new JLabel("Characters: 0/200");

	// Menu
	private JMenu fileMenu = new JMenu("File");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu userMenu = new JMenu("User");

	// Menu Items
	private JMenuItem exitMenuItem = new JMenuItem("Exit");
	private JMenuItem helpMenuItem = new JMenuItem("User Help");
	private JMenuItem userMenuItem = new JMenuItem("Sign Out");

	// Constants
	public final static String[] MONTH_NAME = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	public final static int[] DAYS_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final static String[] WEEK_DAYS = { "Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat" };

	// Menu Bar
	private JMenuBar menuBar = new JMenuBar();

	// Constructor method
	public AddEventScreen() {
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
		setTitle("Taskly - Add Event/Task");

		// Make the window not resizable (locked to set dimensions)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add the panels for the frame
		getContentPane().add(profilePanel);
		getContentPane().add(sidePanel);
		getContentPane().add(addEventPanel);

		// Set JMenuBar
		setJMenuBar(menuBar);

		// Make the frame visible
		setVisible(true);
	}

	// Initialize the contents of the frame and sets up the profilePanel, sidePanel,
	// and addEventPanel
	private void initialize() {

		// Set bounds, layout, border, and background color for the panel
		profilePanel.setBounds(0, 0, 400, 300);
		profilePanel.setLayout(null);
		profilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		profilePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout, border, and background color for the panel
		sidePanel.setBounds(0, 300, 400, 600);
		sidePanel.setLayout(null);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sidePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout, and background color for the panel
		addEventPanel.setBounds(400, 0, 1000, 900);
		addEventPanel.setLayout(null);
		addEventPanel.setBackground(Color.LIGHT_GRAY);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// appnameLabel
		// Add the appNameLabel to the profilePanel
		appNameLabel.setForeground(Color.WHITE);
		appNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appNameLabel.setFont(new Font("Gadugi", Font.BOLD, 35));
		appNameLabel.setText("Taskly");
		appNameLabel.setBounds(130, 50, 175, 100);
		profilePanel.add(appNameLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the username
		// label
		// Add the username label to the profilePanel
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Gadugi", Font.BOLD, 25));
		username.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername());
		username.setBounds(170, 165, 253, 100);
		profilePanel.add(username);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// addEventTitle
		// Add the addEventTitle to the addEventPanel
		addEventTitle.setForeground(Color.BLACK);
		addEventTitle.setHorizontalAlignment(SwingConstants.CENTER);
		addEventTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 60));
		addEventTitle.setText("Add Event/Task");
		addEventTitle.setBounds(250, 70, 500, 100);
		addEventPanel.add(addEventTitle);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// enterDateLabel
		// Add the enterDateLabel to the addEventPanel
		enterDateLabel.setForeground(Color.BLACK);
		enterDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		enterDateLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		enterDateLabel.setText("Enter The Date:");
		enterDateLabel.setBounds(150, 175, 219, 100);
		addEventPanel.add(enterDateLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// monthLabel
		// Add the monthLabel to the addEventPanel
		monthLabel.setForeground(Color.BLACK);
		monthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		monthLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		monthLabel.setText("Month:");
		monthLabel.setBounds(150, 320, 100, 50);
		addEventPanel.add(monthLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the dayLabel
		// Add the dayLabel to the addEventPanel
		dayLabel.setForeground(Color.BLACK);
		dayLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dayLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		dayLabel.setText("Day:");
		dayLabel.setBounds(150, 250, 100, 50);
		addEventPanel.add(dayLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// yearLabel
		// Add the yearLabel to the addEventPanel
		yearLabel.setForeground(Color.BLACK);
		yearLabel.setHorizontalAlignment(SwingConstants.LEFT);
		yearLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		yearLabel.setText("Year:");
		yearLabel.setBounds(150, 390, 100, 50);
		addEventPanel.add(yearLabel);

		// Set text color, horizontal alignment, font, text, and bounds for the
		// enterInformationLabel
		// Add the enterInformationLabel to the addEventPanel
		enterInformationLabel.setForeground(Color.BLACK);
		enterInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		enterInformationLabel.setFont(new Font("Gadugi", Font.BOLD, 25));
		enterInformationLabel.setText("Enter Information:");
		enterInformationLabel.setBounds(150, 480, 250, 50);
		addEventPanel.add(enterInformationLabel);

		// Set the text color, horizontal alignment, font, text, and bounds for the
		// titleLabel
		// Add the titleLabel to the addEventPanel
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		titleLabel.setText("Title:");
		titleLabel.setBounds(150, 520, 150, 50);
		addEventPanel.add(titleLabel);

		// Set the text color, horizontal alignment, font, text, and bounds for the
		// descriptionLabel
		// Add the descriptionLabel to the addEventPanel
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		descriptionLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		descriptionLabel.setText("Description:");
		descriptionLabel.setBounds(150, 620, 150, 50);
		addEventPanel.add(descriptionLabel);

		// set the text color, horizontal alignment, font, text and bounds for the
		// taskEventLabel
		// Add the taskEventLabel to the addEventPanel
		taskEventLabel.setForeground(Color.BLACK);
		taskEventLabel.setHorizontalAlignment(SwingConstants.LEFT);
		taskEventLabel.setFont(new Font("Gadugi", Font.PLAIN, 18));
		taskEventLabel.setText("Task or Event:");
		taskEventLabel.setBounds(740, 525, 150, 50);
		addEventPanel.add(taskEventLabel);

		// Set font, bounds, text color, back ground color and border of the
		// dayTextField
		// Add the dayTextField to the addEventPanel
		dayTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dayTextField.setBounds(235, 261, 350, 30);
		dayTextField.setForeground(Color.BLACK);
		dayTextField.setBackground(new Color(156, 138, 165));
		dayTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addEventPanel.add(dayTextField);

		// Set font, bounds, text color, back ground color and border of the
		// yearTextField
		// Add the yearTextField to the addEventPanel
		yearTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yearTextField.setBounds(235, 401, 350, 30);
		yearTextField.setForeground(Color.BLACK);
		yearTextField.setBackground(new Color(156, 138, 165));
		yearTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addEventPanel.add(yearTextField);

		// Set font, bounds, text color, back ground color, and border of the
		// monthTextField
		// Add the monthTextField to the addEventPanel
		monthTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		monthTextField.setBounds(235, 331, 350, 30);
		monthTextField.setForeground(Color.BLACK);
		monthTextField.setBackground(new Color(156, 138, 165));
		monthTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addEventPanel.add(monthTextField);

		// Set text color, font, text and bounds for the calendarButton
		calendarButton.setForeground(Color.WHITE);
		calendarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calendarButton.setText("Calendar");
		calendarButton.setBounds(75, 20, 187, 81);

		// Make the calendarButton transparent, border not painted, content area not
		// filled, and add action listener
		// Add the calendarButton to the sidePanel
		calendarButton.setOpaque(false);
		calendarButton.setBorderPainted(false);
		calendarButton.setContentAreaFilled(false);
		calendarButton.addActionListener(this);
		sidePanel.add(calendarButton);

		// Set bounds, make the calendarImg transparent, border not painted, content
		// area not filled, and add action listener
		// Add the calendarImg to the sidePanel
		calendarImg.setBounds(53, 23, 70, 70);
		calendarImg.setOpaque(false);
		calendarImg.setBorderPainted(false);
		calendarImg.setContentAreaFilled(false);
		calendarImg.addActionListener(this);
		sidePanel.add(calendarImg);

		// Set text color, font, text, and bounds for the listButton
		listButton.setForeground(Color.WHITE);
		listButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listButton.setText("To-do List");
		listButton.setBounds(82, 120, 187, 81);

		// Make the listButton transparent, border not painted, content area not filled,
		// and add action listener
		// Add the listButton to the sidePanel
		listButton.setOpaque(false);
		listButton.setBorderPainted(false);
		listButton.setContentAreaFilled(false);
		listButton.addActionListener(this);
		sidePanel.add(listButton);

		// Set bounds, make the listImg transparent, border not painted, content area
		// not filled, and add action listener
		// Add the listImg to the sidePanel
		listImg.setBounds(55, 125, 70, 70);
		listImg.setOpaque(false);
		listImg.setBorderPainted(false);
		listImg.setContentAreaFilled(false);
		listImg.addActionListener(this);
		sidePanel.add(listImg);

		// Set text color, font, text, and bounds for the addEventButton
		addEventButton.setForeground(Color.WHITE);
		addEventButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addEventButton.setText("Add Event/Task");
		addEventButton.setBounds(70, 220, 257, 81);

		// Make the addEventButton transparent, border not painted, content area not
		// filled, and add action listener
		// Add the addEventButton to the sidePanel
		addEventButton.setOpaque(false);
		addEventButton.setBorderPainted(false);
		addEventButton.setContentAreaFilled(false);
		addEventButton.setEnabled(false);
		addEventButton.addActionListener(this);
		sidePanel.add(addEventButton);

		// Set bounds, make the addEventsImg transparent, border not painted, content
		// area not filled, and add action listener
		// Add the addEventsImg to the sidePanel
		addEventsImg.setBounds(55, 225, 70, 70);
		addEventsImg.setOpaque(false);
		addEventsImg.setBorderPainted(false);
		addEventsImg.setContentAreaFilled(false);
		addEventsImg.setEnabled(false);
		addEventsImg.addActionListener(this);
		sidePanel.add(addEventsImg);

		// Set text color, font, text, and bounds for the settingsButton
		settingsButton.setForeground(Color.WHITE);
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		settingsButton.setText("Settings");
		settingsButton.setBounds(75, 320, 187, 81);

		// Make the settingsButton transparent, border not painted, content area not
		// filled, and add action listener
		// Add the settingsButton to the sidePanel
		settingsButton.setOpaque(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.addActionListener(this);
		sidePanel.add(settingsButton);

		// Set bounds, make the settingsImg transparent, border not painted, content
		// area not filled, and add action listener
		// Add the settingsImg to the sidePanel
		settingsImg.setBounds(56, 325, 70, 70);
		settingsImg.setOpaque(false);
		settingsImg.setBorderPainted(false);
		settingsImg.setContentAreaFilled(false);
		settingsImg.addActionListener(this);
		sidePanel.add(settingsImg);

		// Set the text color, back ground color, font, text, bounds, and border for the
		// signOutButton
		// Add action listener to the button and add it to the sidePanel
		signOutButton.setForeground(Color.WHITE);
		signOutButton.setBackground(new Color(156, 138, 165));
		signOutButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signOutButton.setText("Sign Out");
		signOutButton.setBounds(105, 430, 190, 80);
		signOutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		signOutButton.addActionListener(this);
		sidePanel.add(signOutButton);

		// Set text color, background color, font, text, bounds, and border for the
		// saveButton
		// Add action listener to the saveButton and add it to the addEventPanel
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(new Color(156, 138, 165));
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveButton.setText("Save");
		saveButton.setBounds(740, 731, 190, 80);
		saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		saveButton.addActionListener(this);
		addEventPanel.add(saveButton);

		// Set action command for the taskRadioButtom, make it set to selected, make it
		// transparent, and add action listener
		// Set bounds and add the taskRadioButton to the addEventPanel
		taskRadioButton.setActionCommand("task");
		taskRadioButton.setSelected(true);
		taskRadioButton.setOpaque(false);
		taskRadioButton.addActionListener(this);
		taskRadioButton.setBounds(740, 543, 100, 100);
		addEventPanel.add(taskRadioButton);

		// Set action command for the eventRadioButton, make it transparent, and add
		// action listener
		// Set bounds and add the eventRadioButton to the addEventPanel
		eventRadioButton.setActionCommand("event");
		eventRadioButton.setOpaque(false);
		eventRadioButton.addActionListener(this);
		eventRadioButton.setBounds(852, 543, 100, 100);
		addEventPanel.add(eventRadioButton);

		// Create a ButtonGroup, and add the taskRadioButton and eventRadioButton to the
		// group
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(taskRadioButton);
		radioButtonGroup.add(eventRadioButton);

		// Set bounds for the titleMax, and add it to the addEventPanel
		titleMax.setLocation(150, 590);
		titleMax.setSize(200, 50);
		addEventPanel.add(titleMax);

		// Set line wrap to true, set font, background color, text color, preferred
		// size, bounds, and border for the title JTextArea
		title.setLineWrap(true);
		title.setWrapStyleWord(true);
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title.setBackground(new Color(156, 138, 165));
		title.setForeground(Color.BLACK);
		title.setPreferredSize(new Dimension(335, 30));
		title.setBounds(150, 560, 500, 45);
		title.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Add document listener that keeps track of the length of the JTextArea - used
		// to warn user if they are exceeding character limit
		title.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				titleMax.setText("Characters: " + title.getText().length() + "/50");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				titleMax.setText("Characters: " + title.getText().length() + "/50");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				titleMax.setText("Characters: " + title.getText().length() + "/50");
			}
		});

		// Add the title to the addEventPanel
		addEventPanel.add(title);

		// Set bounds for the descMax and add it to the addEventPanel
		descMax.setLocation(150, 795);
		descMax.setSize(150, 50);
		addEventPanel.add(descMax);

		// Set line wrap to true, set font, background color, text color, preferred
		// size, and border for the description JTextArea
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setFont(new Font("Tahoma", Font.PLAIN, 16));
		description.setBackground(new Color(156, 138, 165));
		description.setForeground(Color.BLACK);
		description.setPreferredSize(new Dimension(400, 400));
		description.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Add document listener that keeps track of the length of the JTextArea - used
		// to warn user if they are exceeding character limit
		description.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				descMax.setText("Characters: " + description.getText().length() + "/200");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				descMax.setText("Characters: " + description.getText().length() + "/200");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				descMax.setText("Characters: " + description.getText().length() + "/200");
			}
		});

		// Create JScrollPane, set bounds, add it to addEventPanel, and set column
		// header view for description JTextArea
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 661, 500, 150);
		addEventPanel.add(scrollPane);
		scrollPane.setColumnHeaderView(description);

		// Set bounds for logoImg and add it to profilePanel
		logoImg.setBounds(40, 50, 100, 100);
		profilePanel.add(logoImg);

		// Set bounds for userProfileImg, scale image, set icon and add it to
		// profilePanel
		userProfileImg.setBounds(50, 165, 100, 100);
		ImageIcon defaultImage = new ImageIcon("images/Profile Picture " + PersonalCalendarApplication.users
				.get(PersonalCalendarApplication.loggedInUserNum).getProfilePictureNumber() + ".png");
		Image newImage = defaultImage.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		userProfileImg.setIcon(new ImageIcon(newImage));
		profilePanel.add(userProfileImg);

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

		// Set bounds for dayIncorrectIcon, make it not visible and add it to
		// addEventPanel
		dayIncorrectIcon.setBounds(590, 245, 60, 60);
		dayIncorrectIcon.setVisible(false);
		addEventPanel.add(dayIncorrectIcon);

		// Set bounds for monthIncorrectIcon, make it not visible and add it to the
		// addEventPanel
		monthIncorrectIcon.setBounds(590, 315, 60, 60);
		monthIncorrectIcon.setVisible(false);
		addEventPanel.add(monthIncorrectIcon);

		// Set bounds for yearIncorrectIcon, make it not visible and add it to the
		// addEventPanel
		yearIncorrectIcon.setBounds(590, 385, 60, 60);
		yearIncorrectIcon.setVisible(false);
		addEventPanel.add(yearIncorrectIcon);

		// Set bounds for titleIncorrectIcon, make it not visible and add it to the
		// addEvnetPanel
		titleIncorrectIcon.setBounds(655, 550, 60, 60);
		titleIncorrectIcon.setVisible(false);
		addEventPanel.add(titleIncorrectIcon);

		// Set bounds for descIncorrectIcon, make it not visible and add it to the
		// addEventPanel
		descIncorrectIcon.setBounds(655, 661, 60, 60);
		descIncorrectIcon.setVisible(false);
		addEventPanel.add(descIncorrectIcon);

	}

	// If a button is clicked - action is performed
	@Override
	public void actionPerformed(ActionEvent e) {

		// If calendarButton or calendarImg is clicked
		if (e.getSource() == calendarButton || e.getSource() == calendarImg) {

			// Call CalendarScreen constructor method
			new CalendarScreen();

			// Make the AddEventScreen not visible and dispose it
			setVisible(false);
			dispose();
		}

		// If listButton or listImg is clicked
		else if (e.getSource() == listButton || e.getSource() == listImg) {

			// Call ToDoListScreen constructor method
			new ToDoListScreen();

			// Make the AddEventScreen not visible and dispose it
			setVisible(false);
			dispose();
		}

		// If settingsButton or settingsImg is clicked
		else if (e.getSource() == settingsButton || e.getSource() == settingsImg) {

			// Call ToDoListScreen constructor method
			new SettingsScreen();

			// Make the AddEventScreen not visible and dispose it
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
				// AddEventScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();
			}

			// Otherwise if user says no
			else {

				// Call LogInScreen constructor method, set AddEventScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If exitMenuItem is clicked
		else if (e.getSource() == exitMenuItem) {

			// Display option dialog asking user if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks yes
			if (res == JOptionPane.YES_OPTION) {

				// Rewrite user's date file and exit the application
				FileInput.writeDatesFile();
				System.exit(0);
			}

			// Otherwise if user says no, exit the application
			else {
				System.exit(0);
			}
		}

		// If helpMenuItem is clicked
		else if (e.getSource() == helpMenuItem) {

			// Call HelpScreen constructor method
			new HelpScreen();
		}

		// IF userMenuItem is clicked
		else if (e.getSource() == userMenuItem) {

			// Display option dialog asking user if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks yes
			if (res == JOptionPane.YES_OPTION) {

				// Rewrite user's date file, call LogInScreen constructor method and dispose
				// AddEventScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();
			}

			// Otherwise, if user clicks no
			else {

				// Call LogInScreen constructor method, set AddEventScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If saveButton is clicked
		else if (e.getSource() == saveButton) {

			// Set all icons to false
			dayIncorrectIcon.setVisible(false);
			monthIncorrectIcon.setVisible(false);
			yearIncorrectIcon.setVisible(false);
			titleIncorrectIcon.setVisible(false);
			descIncorrectIcon.setVisible(false);

			// Boolean variables
			boolean validDate = validateDate();
			boolean validTitle = validateTitle();
			boolean validDesc = validDesc();

			// If validateDate() and validateTitle() and validDesc() all return true
			if (validDate && validTitle && validDesc) {

				// Store dayTextField, monthTextField, yearTextField in int variables
				int day = Integer.parseInt(dayTextField.getText());
				int month = Integer.parseInt(monthTextField.getText());
				int year = Integer.parseInt(yearTextField.getText());

				// Create boolean to see if taskRadioButton is selected
				boolean isTask = taskRadioButton.isSelected();

				// If taskRadioButton is selected
				if (taskRadioButton.isSelected()) {

					// Add CalendarEvent to array list
					PersonalCalendarApplication.dates
							.add(new CalendarEvent(year, month, day, title.getText(), description.getText(), isTask));
				}

				// If eventRadioButton is selected
				else if (eventRadioButton.isSelected()) {

					// Add CalendarEvent to array list
					PersonalCalendarApplication.dates
							.add(new CalendarEvent(year, month, day, title.getText(), description.getText(), isTask));
				}

				// Create JOptionPane letting user know event/task was added
				JOptionPane.showMessageDialog(null, "SuccessFully Added Event", "Successfully Added Event",
						JOptionPane.INFORMATION_MESSAGE);

				// Make screen not visible, dispose it and take them back to CalendarScreen
				setVisible(false);
				dispose();
				new CalendarScreen();
			}
		}

	}

	// Validates the date that the user inputs
	private boolean validateDate() {

		// Variables
		int day, month, year;

		// Try to convert to integer and store it in year variable
		try {
			year = Integer.parseInt(yearTextField.getText());

			// If year is invalid throw new NumberFormatException
			if (year < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {

			// Set incorrect icon to visible and set year variable to 0
			yearIncorrectIcon.setVisible(true);
			year = 0;
		}

		// Try to convert to integer and store it in month variable
		try {
			month = Integer.parseInt(monthTextField.getText());

			// If month is invalid (>12 or <1) throw new NumberFormatException
			if (month > 12 || month < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {

			// Set incorrect icon to visible and set month variable to 0
			monthIncorrectIcon.setVisible(true);
			month = 0;
		}

		// Try to convert to integer and store it in day variable
		try {
			day = Integer.parseInt(dayTextField.getText());

			// If month is invalid, throw new NumberFormatException
			if ((month != 0 && day > DAYS_MONTH[month - 1] + (year % 4 == 0 && month == 2 ? 1 : 0)) || day < 1)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {

			// Set incorrect icon to visible and set day variable to 0
			dayIncorrectIcon.setVisible(true);
			day = 0;
		}

		// If day is not > 0 and month is not > 0 and year is not > 0
		if (!(day > 0 && month > 0 && year > 0)) {

			// Create JOptionPane letting user know date is valid and return false
			JOptionPane.showMessageDialog(null, "Date Is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// Otherwise everything is valid and return true
		return true;
	}

	// Validates the title to ensure it meets all requirements
	private boolean validateTitle() {

		// Variables
		boolean valid = true;
		String titleText = title.getText();

		// If text contains ',', set incorrect icon to visible, show message dialog, and
		// set boolean to false
		if (titleText.contains(",")) {
			titleIncorrectIcon.setVisible(true);
			JOptionPane.showMessageDialog(null, "Title Contains ','", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}

		// If text exceeds 50 characters, set incorrect icon to visible, show message
		// dialog, and set boolean to false
		if (titleText.length() > 50) {
			titleIncorrectIcon.setVisible(true);
			JOptionPane.showMessageDialog(null, "Title Exceeds 50 Character Maximum", "Error",
					JOptionPane.ERROR_MESSAGE);
			valid = false;
		}

		// If text is empty, set incorrect icon to visible, show message dialog, and set
		// boolean to false
		else if (titleText.length() == 0) {
			titleIncorrectIcon.setVisible(true);
			JOptionPane.showMessageDialog(null, "Title Is Empty", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}

		// Return boolean variable
		return valid;

	}

	// Validates the description field to ensure it meets all requirements
	private boolean validDesc() {

		// Variables
		boolean valid = true;
		String descText = description.getText();

		// IF text contains ',', set incorrect icon to visible , show message dialog and
		// set boolean to false
		if (descText.contains(",")) {
			descIncorrectIcon.setVisible(true);
			JOptionPane.showMessageDialog(null, "Description Contains ','", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}

		// If text exceed 200 characters, set incorrect icon to visible, show message
		// dialog and set boolean to false
		if (descText.length() > 200) {
			descIncorrectIcon.setVisible(true);
			JOptionPane.showMessageDialog(null, "Description Exceeds 200 Character Maximum", "Error",
					JOptionPane.ERROR_MESSAGE);
			valid = false;
		}

		// Return boolean variable
		return valid;
	}

}
