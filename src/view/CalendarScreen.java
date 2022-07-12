/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 12, 2022
 * Description: Creates the home screen / calendar screen where the user can navigate through the side bar and make use of the calendar
 * Main source used for creating calculating dates algorithms 
 * 		(i.e. calculating dates when user clicks next/back button, calculating dates when user changes format of calendar, etc.)
 * 		(http://www.sunshine2k.de/articles/coding/datediffindays/calcdiffofdatesindates.html)
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
public class CalendarScreen extends JFrame implements ActionListener {

	// Instance Variables
	// Panel
	private JPanel profilePanel = new JPanel();
	private JPanel sidePanel = new JPanel();
	private JPanel calendarPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel weekdaysPanel = new JPanel();
	private JPanel outputWeek;
	private JPanel outputMonth;
	private JPanel outputYear;

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
	private JButton backButton = new JButton();
	private JButton next = new JButton(new ImageIcon("images/Forward.png"));
	private JButton back = new JButton(new ImageIcon("images/Backward.png"));
	private JButton monthButton;

	// Labels
	private JLabel appNameLabel = new JLabel();
	private JLabel username = new JLabel();
	private JLabel logoImg = new JLabel(new ImageIcon("images/Taskily Logo Two.png"));
	private JLabel userProfileImg = new JLabel("");
	private JLabel calendarTitle = new JLabel();

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

	// Constants
	public final static String[] MONTH_NAME = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	public final static int[] DAYS_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final static String[] WEEK_DAYS = { "Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat" };

	// Variables
	private int day;
	private int month;
	private int year;
	private int weekday;
	private int display;
	private boolean displayWeek;
	private int savedDate[] = new int[4];

	// Constructor Method
	public CalendarScreen() {
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

		// Set the background of the frame
		this.setBackground(Color.LIGHT_GRAY);

		// Make the application close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Set title
		setTitle("Taskly - Calendar");

		// Make the window not resizable (locked to set dimensions)
		setResizable(false);
		getContentPane().setLayout(null);

		// Add profilePanel, sidePanel, calendarPanel, weekdaysPanel and topPanel to
		// frame
		getContentPane().add(profilePanel);
		getContentPane().add(sidePanel);
		getContentPane().add(calendarPanel);
		getContentPane().add(weekdaysPanel);
		getContentPane().add(topPanel);

		// Set JMenuBar
		setJMenuBar(menuBar);

		// Make frame visible
		setVisible(true);
	}

	// Initialize the contents of the frame and sets up the profilePanel, sidePanel,
	// calendarPanel, weekdaysPanel and topPanel
	private void initialize() {

		// Set bounds, layout, border and background color for profilePanel
		profilePanel.setBounds(0, 0, 400, 300);
		profilePanel.setLayout(null);
		profilePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		profilePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout, border and background color for sidePanel
		sidePanel.setBounds(0, 300, 400, 600);
		sidePanel.setLayout(null);
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sidePanel.setBackground(new Color(63, 43, 99));

		// Set bounds, layout and background color for topPanel
		topPanel.setBounds(400, 0, 1000, 200);
		topPanel.setLayout(null);
		topPanel.setBackground(Color.LIGHT_GRAY);

		// Set bounds, layout and background color for weekdaysPanel
		weekdaysPanel.setBounds(400, 200, 1000, 100);
		weekdaysPanel.setLayout(null);
		weekdaysPanel.setBackground(Color.LIGHT_GRAY);

		// Set text color, horizontal alignment, font, text and bounds for appNameLabel
		// Add appNameLabe to profilePanel
		appNameLabel.setForeground(Color.WHITE);
		appNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appNameLabel.setFont(new Font("Gadugi", Font.BOLD, 35));
		appNameLabel.setText("Taskly");
		appNameLabel.setBounds(130, 50, 175, 100);
		profilePanel.add(appNameLabel);

		// Set text color, horizontal alignment, font, text, and bounds for username
		// Add user name label to profilePanel
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Gadugi", Font.BOLD, 25));
		username.setText(
				PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername());
		username.setBounds(170, 165, 253, 100);
		profilePanel.add(username);

		// Set text color, font, text and bounds for calendarButton
		calendarButton.setForeground(Color.WHITE);
		calendarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calendarButton.setText("Calendar");
		calendarButton.setBounds(75, 20, 187, 81);

		// Make calendarButton transparent, border not painted, content area not filled,
		// not enabled
		// Add action listener to calendarButton and add it to sidePanel
		calendarButton.setOpaque(false);
		calendarButton.setBorderPainted(false);
		calendarButton.setContentAreaFilled(false);
		calendarButton.setEnabled(false);
		calendarButton.addActionListener(this);
		sidePanel.add(calendarButton);

		// Set bounds of calendarImg
		// Make calendarImg transparent, border not painted, content area not filled,
		// and button not enabled
		// Add action listener to calendarImg and add it to sidePanel
		calendarImg.setBounds(53, 23, 70, 70);
		calendarImg.setOpaque(false);
		calendarImg.setBorderPainted(false);
		calendarImg.setContentAreaFilled(false);
		calendarImg.setEnabled(false);
		calendarImg.addActionListener(this);
		sidePanel.add(calendarImg);

		// Set text color, font, text and bounds for listButton
		listButton.setForeground(Color.WHITE);
		listButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listButton.setText("To-do List");
		listButton.setBounds(82, 120, 187, 81);

		// Make listButton transparent, borders not painted, and content area not filled
		// Add action listener to listButton and add it to sidePanel
		listButton.setOpaque(false);
		listButton.setBorderPainted(false);
		listButton.setContentAreaFilled(false);
		listButton.addActionListener(this);
		sidePanel.add(listButton);

		// Set bounds of listImg
		// Make listImg transparent, border not painted, content area not filled
		// Add action listener to listImg and add it to sidePanel
		listImg.setBounds(55, 125, 70, 70);
		listImg.setOpaque(false);
		listImg.setBorderPainted(false);
		listImg.setContentAreaFilled(false);
		listImg.addActionListener(this);
		sidePanel.add(listImg);

		// Set text color, font, text, and bounds for addEventButton
		addEventButton.setForeground(Color.WHITE);
		addEventButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addEventButton.setText("Add Event/Task");
		addEventButton.setBounds(70, 220, 257, 81);

		// Make addEventButton transparent, border not painted, content area not filled
		// Add action listener to addEventButton and add it to sidePanel
		addEventButton.setOpaque(false);
		addEventButton.setBorderPainted(false);
		addEventButton.setContentAreaFilled(false);
		addEventButton.addActionListener(this);
		sidePanel.add(addEventButton);

		// Set bounds of addEventsImg
		// Make addEventsImg transparent, border not painted, content area not filled
		// Add action listener to addEventsImg and add it to sidePanel
		addEventsImg.setBounds(55, 225, 70, 70);
		addEventsImg.setOpaque(false);
		addEventsImg.setBorderPainted(false);
		addEventsImg.setContentAreaFilled(false);
		addEventsImg.addActionListener(this);
		sidePanel.add(addEventsImg);

		// Set text color, font, text, and bounds for settingsButton
		settingsButton.setForeground(Color.WHITE);
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		settingsButton.setText("Settings");
		settingsButton.setBounds(75, 320, 187, 81);

		// Make settingsButton transparent, border not painted, content area not filled
		// Add action listener to settingsButton and add it to sidePanel
		settingsButton.setOpaque(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.addActionListener(this);
		sidePanel.add(settingsButton);

		// Set bounds of settingsImg
		// Make settingsImg transparent, border not painted, content area not filled
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

		// Set text color, background color, font, text, bounds and border for
		// backButton
		// Add action listener to backButton and add it to topPanel
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(156, 138, 165));
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backButton.setText("Back");
		backButton.setBounds(22, 60, 148, 64);
		backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		backButton.addActionListener(this);
		topPanel.add(backButton);

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

		// Make next button transparent, border not painted, content area not filled,
		// and set bounds
		// Add action listener to next button and add it to topPanel
		next.setOpaque(false);
		next.setBorderPainted(false);
		next.setContentAreaFilled(false);
		next.setBounds(700, 40, 100, 100);
		next.addActionListener(this);
		topPanel.add(next);

		// Make back button transparent, border not painted, content area not filled and
		// set bounds
		// Add action listener to back button and add it to topPanel
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(225, 40, 100, 100);
		back.addActionListener(this);
		topPanel.add(back);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel sunday = new JLabel();
		sunday.setText("Sun");
		sunday.setFont(new Font("Gadugi", Font.BOLD, 25));
		sunday.setBounds(20, 0, 100, 100);
		sunday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(sunday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel monday = new JLabel();
		monday.setText("Mon");
		monday.setFont(new Font("Gadugi", Font.BOLD, 25));
		monday.setBounds(165, 0, 100, 100);
		monday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(monday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel tuesday = new JLabel();
		tuesday.setText("Tues");
		tuesday.setFont(new Font("Gadugi", Font.BOLD, 25));
		tuesday.setBounds(300, 0, 100, 100);
		tuesday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(tuesday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel wednesday = new JLabel();
		wednesday.setText("Wed");
		wednesday.setFont(new Font("Gadugi", Font.BOLD, 25));
		wednesday.setBounds(440, 0, 100, 100);
		wednesday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(wednesday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel thursday = new JLabel();
		thursday.setText("Thurs");
		thursday.setFont(new Font("Gadugi", Font.BOLD, 25));
		thursday.setBounds(580, 0, 100, 100);
		thursday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(thursday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel friday = new JLabel();
		friday.setText("Fri");
		friday.setFont(new Font("Gadugi", Font.BOLD, 25));
		friday.setBounds(720, 0, 100, 100);
		friday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(friday);

		// Create new JLabel, set text, set font, set bounds, set horizontal alignment,
		// and add it to weekdaysPanel
		JLabel saturday = new JLabel();
		saturday.setText("Sat");
		saturday.setFont(new Font("Gadugi", Font.BOLD, 25));
		saturday.setBounds(860, 0, 100, 100);
		saturday.setHorizontalAlignment(SwingConstants.CENTER);
		weekdaysPanel.add(saturday);

		// Set text, font, horizontal alignment, text color and bounds for calendarTitle
		// Add calendarTitle to topPanel
		calendarTitle.setText(MONTH_NAME[month - 1] + " " + year);
		calendarTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		calendarTitle.setForeground(Color.BLACK);
		calendarTitle.setBounds(294, 11, 423, 150);
		topPanel.add(calendarTitle);

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

		// Set default display to month view, and display week
		display = 1;
		displayWeek = true;

		// Update the display
		this.updateDisplay();
	}

	// Updates the display when the view of the calendar is switched
	public void updateDisplay() {

		// Variables
		String date;

		// save date and update weekday display
		this.updateWeekdayDisplay();
		this.saveDate();

		// Enable back button if display is not set to year format
		backButton.setEnabled(display != 0);

		// If display is set to year format, convert year int to string and store in
		// date variable
		if (display == 0) {
			date = Integer.toString(year);
		}

		// If display is set to month format, convert date variable to month / year
		else if (display == 1) {
			date = month + "/" + year;
		}

		// Otherwise, if display is set to day format
		else {

			// Finds start of weekday
			// While weekday is greater than 0
			while (weekday > 0) {

				// Decrement day
				day--;

				// If day is 0
				if (day == 0) {

					// Decrement month
					month--;

					// If month is 0
					if (month == 0) {

						// Set month to 12, then decrement year
						month = 12;
						year--;
					}

					// Set day to days in the month
					day = DAYS_MONTH[month - 1];

					// If the month is Feb and leap year, add one to day
					if (month == 2 && year % 4 == 0)
						day++;
				}

				// Decrement weekday
				weekday--;
			}

			date = day + "/" + month + "/" + year;
		}

		// If display is set to year format, set calendar panel and call prepareYear()
		// method
		if (display == 0) {
			prepareYear();

		}

		// If display is set to month format, call prepareMonth() method
		if (display == 1) {
			prepareMonth();
		}

		// If display is set to day format, call prepareWeek() method
		if (display == 2) {
			prepareWeek();
		}

		// If display is set to year format, set text of calendar title to show just
		// year
		if (display == 0) {
			calendarTitle.setText(" " + year + " ");
		}

		// If display is set to month format, set text of calendar title to show month
		// and year
		if (display == 1) {
			calendarTitle.setText(MONTH_NAME[month - 1] + ' ' + year);
		}

		// If display is set to week format, set text of calendar title to show week of
		// month and day
		if (display == 2) {
			calendarTitle.setText("Week Of " + MONTH_NAME[month - 1].substring(0, 3) + ' ' + day);
		}

		this.loadDate();
	}

	// Prepares the year screen
	private JPanel prepareYear() {

		// Create a JPanel, set bounds, background color and border
		outputYear = new JPanel(new GridLayout(3, 4, 30, 30));
		outputYear.setBounds(0, 0, 984, 541);
		outputYear.setBackground(Color.LIGHT_GRAY);
		outputYear.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

		// Set bounds of calendarPanel
		calendarPanel.setBounds(400, 200, 984, 741);

		// Go through for loop creating monthButton for each month
		for (int i = 0; i < 12; i++) {

			// Create new JButton, set alignment to center alignment, set border, set
			// background, set action command, set preferred size, and add action listener
			monthButton = new JButton("<html><font size='6' color = '#000000'>" + MONTH_NAME[i] + "</font></html>");
			monthButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			monthButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			monthButton.setBorderPainted(true);
			monthButton.setBackground(new Color(226 - i * 8, 208 - i * 8, 235));
			monthButton.setActionCommand(Integer.toString(i + 1));
			monthButton.setPreferredSize(new Dimension(215, 180));
			monthButton.addActionListener(this);

			// Add monthButton to outputYear panel
			outputYear.add(monthButton);
		}

		// Add outputYear panel to calendarPanel, and return output panel
		calendarPanel.add(outputYear);
		return outputYear;
	}

	// Prepare the month screen
	private JPanel prepareMonth() {

		// Create a new JPanel, set border and background
		outputMonth = new JPanel(new GridLayout(0, 7));
		outputMonth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		outputMonth.setBackground(Color.LIGHT_GRAY);

		// Set bounds of calendarPanel
		calendarPanel.setBounds(400, 300, 984, 741);

		// JButton array
		JButton dates[];

		// String array
		String[] labels;

		// Int array
		int numEntries[];

		// Calculate the num of days
		int numDays = DAYS_MONTH[month - 1];
		if (year % 4 == 0 && month == 2) {
			numDays++;
		}

		// Create new JButton[], new String[] and new int[]
		dates = new JButton[numDays];
		labels = new String[numDays];
		numEntries = new int[numDays];

		// For each day in the month, create a labels array
		for (int i = 0; i < numDays; i++) {
			labels[i] = "";
		}

		// Set dimension for each day
		final Dimension daySize = new Dimension(140, 90);

		// Calculate starting weekday
		int startingWeekday = (weekday - day - 6) % 7;
		if (startingWeekday < 0) {
			startingWeekday += 7;
		}

		// Create invisible component for the starting week till the first day is
		// reached
		int count = 0;
		for (int i = 0; i < startingWeekday; i++, count++) {
			outputMonth.add(Box.createRigidArea(daySize));
		}

		// For the number of days in the month
		for (int i = 0; i < numDays; i++, count++) {

			// Create new JButton in array, set border, background color, action command and
			// add action listener
			dates[i] = new JButton();
			dates[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			dates[i].setBackground(new Color(226 - i * 2, 208 - i * 2, 235));
			dates[i].setActionCommand(Integer.toString(i + 1));
			dates[i].addActionListener(new ActionListener() {

				// Action performed when one of the dates are clicked
				public void actionPerformed(ActionEvent g) {

					// Remove outputMonth panel from calendarPanel
					calendarPanel.remove(outputMonth);

					// Set newDay to ActionCommand of that date
					int newDay = Integer.parseInt(g.getActionCommand());

					// Calculate weekday
					weekday = (weekday + newDay - day) % 7;
					if (weekday < 0)
						weekday += 7;

					// Set day to newDay, set display to week display and update display
					day = newDay;
					display = 2;
					updateDisplay();
				}
			});

			// Add the button to the output panel
			outputMonth.add(dates[i]);
		}

		// Add invisible components for the final tiles
		while (count < 42) {
			outputMonth.add(Box.createRigidArea(daySize));
			count++;
		}

		// For each date created by user
		for (int i = 0; i < PersonalCalendarApplication.dates.size(); i++) {

			// If the month of the event/task is the same as the month and the year of the
			// event/task is the same as the year
			if (PersonalCalendarApplication.dates.get(i).getMonth() == month
					&& PersonalCalendarApplication.dates.get(i).getYear() == year) {

				// If task is not selected - event
				if (PersonalCalendarApplication.dates.get(i).getTaskIsSelcted() == false) {

					// Create variable that holds the day
					int index = PersonalCalendarApplication.dates.get(i).getDay() - 1;

					// Add the title to the specific index
					numEntries[index]++;
					labels[index] += "<br><font size='3'><font color=#007bff>"
							+ PersonalCalendarApplication.dates.get(i).getTitle();
				}

				// If task is selected - task
				else if (PersonalCalendarApplication.dates.get(i).getTaskIsSelcted() == true) {

					// Create variable that holds the day
					int index = PersonalCalendarApplication.dates.get(i).getDay() - 1;

					// Add the title to the specific index
					numEntries[index]++;
					labels[index] += "<br><font size='3'><font color=#b80000>"
							+ PersonalCalendarApplication.dates.get(i).getTitle();
				}
			}
		}

		// For the number of days
		for (int i = 0; i < numDays; i++) {

			// Create a new JLabel for the date of each box, set alignments, and add it to
			// the specified index of the dates[] array
			JLabel tempLabel = new JLabel("<html><b><font size ='4'>" + Integer.toString(i + 1)
					+ "</b></font?<font size='2'>" + labels[i] + "<br><br></font></html>");
			tempLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			tempLabel.setAlignmentY(JComponent.TOP_ALIGNMENT);
			dates[i].add(tempLabel);
		}

		// Add output panel to the calendarPanel, and return output panel
		calendarPanel.add(outputMonth);
		return outputMonth;
	}

	// Prepare the week screen
	private JPanel prepareWeek() {

		// Create a new panel, set background color and bounds
		outputWeek = new JPanel(new GridLayout(1, 7));
		outputWeek.setBackground(Color.LIGHT_GRAY);
		calendarPanel.setBounds(400, 300, 984, 741);

		// Create a day panel for each day in the week
		JPanel dayPanel[] = new JPanel[7];

		// Variables holding temporary day month and year
		int tempDay = day;
		int tempYear = year;
		int tempMonth = month;

		// Labels holding the events/tasks for each day
		String labels[] = new String[7];

		// For each day in the week
		for (int i = 0; i < 7; i++) {

			// Create a new JPanel, set layout and set background color
			dayPanel[i] = new JPanel();
			dayPanel[i].setLayout(new BoxLayout(dayPanel[i], BoxLayout.Y_AXIS));
			dayPanel[i].setBackground(new Color(226 - i * 10, 208 - i * 10, 235));

			// Create a new JLabel holding the month and date (e.g. Feb 22)
			JLabel dayLabel = new JLabel("<html><font size='5' color='#000000'>"
					+ MONTH_NAME[tempMonth - 1].substring(0, 3) + ' ' + tempDay + "</font></html>");

			// Create new JPanel, add topPanel to dayPanel
			JPanel topPanel = new JPanel();
			dayPanel[i].add(topPanel);

			// Set layout, set border, set panel to transparent, set x and y alignment, and
			// add to topPanel
			topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
			topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			topPanel.setOpaque(false);
			topPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			topPanel.setAlignmentY(JComponent.TOP_ALIGNMENT);
			topPanel.add(dayLabel);
			topPanel.add(Box.createRigidArea(new Dimension(5, 0)));
			dayPanel[i].add(Box.createRigidArea(new Dimension(0, 5)));

			// For each dates in the array list
			for (int j = 0; j < PersonalCalendarApplication.dates.size(); j++) {

				// If the date is the same as the tempMonth, tempDay and tempYear
				if (PersonalCalendarApplication.dates.get(j).getMonth() == tempMonth
						&& PersonalCalendarApplication.dates.get(j).getDay() == tempDay
						&& PersonalCalendarApplication.dates.get(j).getYear() == tempYear) {

					// If the date is an event
					if (PersonalCalendarApplication.dates.get(j).getTaskIsSelcted() == false) {

						// Add the title and description to the label panel
						labels[i] += "<br><u><font size='5'><font color=#007bff>"
								+ PersonalCalendarApplication.dates.get(j).getTitle()
								+ " - </u><font size = '3'><font color=#007bff>"
								+ PersonalCalendarApplication.dates.get(j).getDesc();
					}

					// Otherwise if the date is a task
					else if (PersonalCalendarApplication.dates.get(j).getTaskIsSelcted() == true) {

						// Add the title and description to the label panel
						labels[i] += "<br><u><font size='5'><font color=#b80000>"
								+ PersonalCalendarApplication.dates.get(j).getTitle()
								+ " - </u><font size = '3'><font color=#b80000>"
								+ PersonalCalendarApplication.dates.get(j).getDesc();
					}
				}
			}

			// If no event/task is added, set label to ""
			if (labels[i] == null) {
				labels[i] = "";
			}

			// If the label contains "null", replace it with ""
			if (labels[i].contains("null")) {
				labels[i] = labels[i].replace("null", "");
			}

			// Create new Label, add labels[i] to it and set alignment for it
			// Add tempLabel to dayPanel[i]
			JLabel tempLabel = new JLabel(
					"<html><b><font size='4'>" + labels[i] + "<br><br><br><br><br></b></font></html>");
			tempLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			tempLabel.setAlignmentY(JComponent.TOP_ALIGNMENT);
			dayPanel[i].add(tempLabel);
			dayPanel[i].setPreferredSize(new Dimension(137, 500));

			// Create new JScrollPane for dayPanel[i]
			// Set horizontal scroll bar policy and border for scroll
			JScrollPane scroll = new JScrollPane(dayPanel[i]);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));

			// Add the scroll to outputWeek panel
			outputWeek.add(scroll);

			// Increment tempDay, tempMonth and tempYear accordingly
			tempDay++;
			if (tempMonth == 2 && tempYear % 4 == 0 ? tempDay > 29 : tempDay > DAYS_MONTH[tempMonth - 1]) {
				tempDay = 1;
				tempMonth++;
				if (tempMonth > 12) {
					tempMonth = 1;
					tempYear++;
				}
			}

		}

		// Add outputWeek to calendarPanel, set background color of calendarPanel and
		// return outputWeek panel
		calendarPanel.add(outputWeek);
		calendarPanel.setBackground(Color.LIGHT_GRAY);
		return outputWeek;
	}

	// Updates weekday display
	private void updateWeekdayDisplay() {

		// If displayWeek is set to true, but it is set to year display, remove it and
		// set boolean to false
		if (displayWeek == true && display == 0) {
			this.remove(weekdaysPanel);
			displayWeek = false;
		}

		// If displayWeek is set to false, but it is month or week format, add it to
		// frame and set boolean to true
		else if (displayWeek == false && display != 0) {
			getContentPane().add(weekdaysPanel);
			displayWeek = true;
		}
	}

	// Gets the current day (day, weekday, month, and year)
	private void parseDate(String current_date) {
		StringTokenizer st = new StringTokenizer(current_date, "/");
		day = Integer.parseInt(st.nextToken());
		weekday = Integer.parseInt(st.nextToken());

		// If weekday is sunday, move it back to front
		if (weekday == 7) //
			weekday = 0;
		month = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
	}

	// Saves date into array
	private void saveDate() {
		savedDate[0] = day;
		savedDate[1] = weekday;
		savedDate[2] = month;
		savedDate[3] = year;
	}

	// Loads dates from array
	private void loadDate() {
		day = savedDate[0];
		weekday = savedDate[1];
		month = savedDate[2];
		year = savedDate[3];
	}

	// Action performed - button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		// If listButton or listImg is clicked
		if (e.getSource() == listButton || e.getSource() == listImg) {

			// Call ToDoListScreen constructor method, set the CalendarScreen to not visible
			// and dispose it
			new ToDoListScreen();
			setVisible(false);
			dispose();
		}

		// If addEventButton or addEventsImg is clicked
		else if (e.getSource() == addEventButton || e.getSource() == addEventsImg) {

			// Call AddEventScreen constructor method, set current screen to not visible and
			// dispose it
			new AddEventScreen();
			setVisible(false);
			dispose();
		}

		// If settingsButton or settingsImg is clicked
		else if (e.getSource() == settingsButton || e.getSource() == settingsImg) {

			// Call SettingsScreen constructor method, set CalendarScreen to not visible and
			// dispose it
			new SettingsScreen();
			setVisible(false);
			dispose();
		}

		// If signOutButton is clicked
		else if (e.getSource() == signOutButton) {

			// Display option dialog asking if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks on yes
			if (res == JOptionPane.YES_OPTION) {

				// Write the users date file, call LogInScreen constructor method and dispose
				// CalendarScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();

				// If user says no
			} else {

				// Call LogInScreen constructor method, set CalendarScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If exitMenuItem is clicked from menuBar
		else if (e.getSource() == exitMenuItem) {

			// Display option dialog asking if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks on yes
			if (res == JOptionPane.YES_OPTION) {

				// Write the users date file and exit the application
				FileInput.writeDatesFile();
				System.exit(0);

				// If user says no, exit the application
			} else {
				System.exit(0);
			}
		}

		// If helpMenuItem is clicked from menuBar
		else if (e.getSource() == helpMenuItem) {

			// Call HelpScreen constructor method
			new HelpScreen();
		}

		// If userMenuItem is clicked from menuBar
		else if (e.getSource() == userMenuItem) {

			// Display option dialog asking if they wish to save
			int res = JOptionPane.showOptionDialog(this, "Do you wish to save?", "Save", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);

			// If user clicks on yes
			if (res == JOptionPane.YES_OPTION) {

				// Write the users date file, call logInScreen constructor method and dispose
				// CalendarScreen
				FileInput.writeDatesFile();
				new LogInScreen();
				setVisible(false);
				dispose();

			} else {

				// Call LogInScreen constructor method, set CalendarScreen to not visible and
				// dispose it
				new LogInScreen();
				setVisible(false);
				dispose();
			}
		}

		// If next button is clicked, adjust the dates depending on what display is
		// currently at
		else if (e.getSource() == next) {

			// If display is set to year display
			if (display == 0) {

				// Remove outputYear panel from calendarPanel
				calendarPanel.remove(outputYear);

				// Calculate new weekday
				weekday -= day - 1;
				day = 1;

				// Used to loop through the year
				// While month is less than or equal 12
				while (month <= 12) {

					// If month is Feb and occurring on leap year
					if (month == 2 && year % 4 == 0) {

						// Add 29 to weekday and add counter to month
						weekday += 29;
						month++;
					}

					// Else add days in month to weekday and add counter to month
					else {
						weekday += DAYS_MONTH[month - 1];
						month++;
					}
				}

				// Set weekday to remainder of / 7
				weekday %= 7;

				// If weekday is < 0 add 7 to weekday
				if (weekday < 0) {
					weekday += 7;
				}

				// Set month to first month of new year
				month = 1;

				// Add counter to year
				year++;

				// Update display again
				updateDisplay();
			}

			// If display is set to month format
			else if (display == 1) {

				// Remove outputMonth from calendarPanel
				calendarPanel.remove(outputMonth);

				// Calculate new weekday
				weekday += DAYS_MONTH[month - 1] - day + 1;

				// If month is Feb and is leap year, add increment to weekday
				if (month == 2 && year % 4 == 0) {
					weekday++;
				}
				weekday %= 7;

				// If weekday is < 0, add 7 to weekday
				if (weekday < 0) {
					weekday += 7;
				}

				// Set day to 1
				day = 1;

				// Increment month and if it becomes 13, set month to 1, and increment year by 1
				month++;
				if (month == 13) {
					month = 1;
					year++;
				}

				// Update the display
				updateDisplay();
			}

			// If display is set to week format
			else if (display == 2) {

				// Remove outputWeek from calendarPanel
				calendarPanel.remove(outputWeek);

				// For 7 days
				for (int i = 0; i < 7; i++) {

					// Increment day by 1
					day++;

					// If month is Feb and leap year, day is > 29, else day is > days in month -
					// indicates month needs to be incremented and day needs to start back at 1
					if (month == 2 && year % 4 == 0 ? day > 29 : day > DAYS_MONTH[month - 1]) {

						// Set day = 1 and increment month
						day = 1;
						month++;

						// If month is greater than 12 increment year and set month back to 1
						if (month > 12) {
							month = 1;
							year++;
						}
					}
				}

				// Update the display
				updateDisplay();
			}

		}

		// If back button is clicked, adjust the dates depending on what display is
		// currently at
		else if (e.getSource() == back) {

			// If display is set to year display
			if (display == 0) {

				// Remove outputYear from calendarPanel
				calendarPanel.remove(outputYear);

				// Calculate new weekday
				weekday -= day - 1;

				// Used to loop through the year but backwards instead
				// While month is greater than 1
				while (month > 1) {

					// Decrement month counter
					month--;

					// If month is Feb and lands in leap year
					if (month == 2 && year % 4 == 0) {

						// Decrement 29 from weekday
						weekday -= 29;
					}

					// Else decrement the days in the month from the weekday
					else {
						weekday -= DAYS_MONTH[month - 1];
					}
				}

				// Decrement the year by 1
				year--;

				// Set month to 12
				month = 12;

				// Set weekday to remainder of /7
				weekday = (weekday - 1) % 7;

				// Set days to the number of days in the month
				day = DAYS_MONTH[month - 1];

				// If weekday is less than 0, add 7
				if (weekday < 0)
					weekday += 7;

				// Update the display
				updateDisplay();
			}

			// If display is set to month display
			else if (display == 1) {

				// Remove outputMonth panel from calendarPanel
				calendarPanel.remove(outputMonth);

				// Decrement month
				month--;

				// If month is 0, go back to previous year and set month to 12
				if (month == 0) {
					month = 12;
					year--;
				}

				// Calculate weekday
				weekday = weekday - day - DAYS_MONTH[month - 1] + 1;

				// If month is Feb and year is leap year, decrement weekday
				if (month == 2 && year % 4 == 0) {
					weekday--;
				}
				weekday %= 7;

				// If weekday is less than 0 add 7 day to weekday and set to day to 1
				if (weekday < 0) {
					weekday += 7;
				}
				day = 1;

				// Update display
				updateDisplay();

			}

			// If display is set to week display
			else if (display == 2) {

				// Remove outputWeek panel from calendarPanel
				calendarPanel.remove(outputWeek);

				// For 7 days
				for (int i = 0; i < 7; i++) {

					// Decrement day
					day--;

					// If day is 0, decrement month
					if (day == 0) {
						month--;

						// If month is 0, decrement year, and set month to 12
						if (month == 0) {
							month = 12;
							year--;
						}

						// Set day to days in month
						day = DAYS_MONTH[month - 1];

						// If month is Feb and year is leap year, increment day
						if (month == 2 && year % 4 == 0) {
							day++;
						}
					}
				}

				// Update the display
				updateDisplay();

			}
		}

		// If user clicks on back button
		else if (e.getSource() == backButton) {

			// If display is set to week display, change it to month view
			if (display == 2) {
				calendarPanel.removeAll();
				display = 1;
			}

			// Otherwise if display is set to month display, change it to year view
			else if (display == 1) {
				calendarPanel.removeAll();
				display = 0;
			}

			// Update the display
			updateDisplay();
		}

		// If user clicks on month in year format
		else if (e.getSource() instanceof JButton) {

			// Remove outputYear from calendarPanel
			calendarPanel.remove(outputYear);

			// Set new month to action command of that month button
			int newMonth = Integer.parseInt(e.getActionCommand());
			weekday -= day - 1;
			day = 1;

			// Find the increment of the newMonth
			int increment = newMonth;
			if (newMonth > month) {
				increment = 1;
			} else {
				increment = -1;
			}

			// While the month doesn't equal the newMonth
			while (month != newMonth) {
				// Add the increment (+1 or -1 since user could choose newMonth from before
				// current month) to the month
				month += increment;

				// If month is Feb and leap year, don't add to weekday, otherwise add days in
				// month * increment
				if (month == 2 && year % 4 == 0) {
					weekday += 2;
				} else {
					weekday += DAYS_MONTH[month - 1] * increment;
				}
			}

			weekday %= 7;
			// If weekday is less than 0 add 7 day to weekday
			if (weekday < 0) {
				weekday += 7;
			}

			// Set display to month display and update display
			display = 1;
			updateDisplay();
		}
	}
}
