/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 11, 2022
 * Description: Reads a .csv file that contains all the user's user names and passwords
 * 				Such information is then used to validate when a user logs into their desired accounts
 */

package fileInput;

// Import packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import application.PersonalCalendarApplication;
import model.CalendarEvent;
import model.User;

public class FileInput {

	// Constructor method
	public FileInput() {

		// Calls readUserLogin method that reads the .csv file
		readUserLogin();
	}

	// Reads the .csv file containing all the user's information (i.e. name,
	// password, email, birthday, etc.)
	public void readUserLogin() {

		// Implement a try and catch in case file path can't be located
		try {

			// Clear the array list containing users - in case
			PersonalCalendarApplication.users.clear();

			// Takes input from the User Login Informatin.csv file
			Scanner input = new Scanner(new File("files/User Login Information.csv"));

			// Use "," as a delimiter, splits the strings
			input.useDelimiter(",");

			// Skip the first line since it is column headings
			input.nextLine();

			// While there is a next line in the .csv file
			while (input.hasNextLine()) {

				// Create a new user - call constructor method
				User user = new User();

				// Set the username, password, first name, last name, birth day, birth month,
				// and birth year for that individual user
				user.setUsername(input.next());
				user.setPassword(input.next());
				user.setFirstName(input.next());
				user.setLastName(input.next());
				user.setEmail(input.next());
				user.setBirthDay(Integer.parseInt(input.next()));
				user.setBirthMonth(Integer.parseInt(input.next()));
				user.setBirthYear(Integer.parseInt(input.next()));

				// Go to the next line containing the next user's information
				input.nextLine();

				// Add the user to the array list
				PersonalCalendarApplication.users.add(user);
			}

			// Once all the lines have been read, close the scanner
			input.close();

		} catch (FileNotFoundException error) {

			// Giver error in terminal if file can't be found
			System.out.println("Error Trying to Locate the File");
		}
	}

	// Copies the user login information file, stores it in a string, and returns it
	// in a string
	// This string is then used to recreate the new .csv file
	public static String copyUserFile() {

		// Variable
		String userFile = "";

		// Try to read through the file, adds the lines into the userFile variable and
		// stores it as a string
		try {

			// Read the User Login Information csv file using scanner
			Scanner input = new Scanner(new File("files/User Login Information.csv"));

			// Keep adding the lines into the variable
			userFile = input.nextLine();
			while (input.hasNextLine()) {
				userFile += "\n" + input.nextLine();
			}

			// Once there are no more lines, close scanner
			input.close();

			// If file is not found, output error in terminal
		} catch (FileNotFoundException error) {
			System.out.println("Error locating the file");
		}

		// Return string
		return userFile;
	}

	// Reads the user date txt file
	public static void readDatesFile() {
		
		// Try to read the user's date txt file
		try {
			// Create new scanner, set location of txt file and use delimiter
			Scanner input = new Scanner(new File("files/users/" +PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername() 
					+ ".txt"));
			input.useDelimiter("@");

			// While the txt file has a next line
			while (input.hasNextLine()) {
				
				// Get next, and add it to variables
				int year = Integer.parseInt(input.next());
				int month = Integer.parseInt(input.next());
				int day = Integer.parseInt(input.next());
				String title = input.next();
				String desc = input.next();
				boolean taskIsSelected = Boolean.parseBoolean(input.next());
				
				// Create new calendar event using the variables
				PersonalCalendarApplication.dates.add(new CalendarEvent(year, month, day, title, desc, taskIsSelected));
				
				// Go to next line
				input.nextLine();
			}

			// Once all the dates have been added, close scanner
			input.close();

			// If the file couldn't be located (because user has just made a new account), use default dates
		} catch (FileNotFoundException e) {
			PersonalCalendarApplication.dates.clear();
			for (int i = 1900; i < 2100; i++) {
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 1, 1, "New Years", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 2, 14, "Valentine's Day", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 4, 1, "April Fools", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 7, 1, "Canada's Day", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 10, 31, "Halloween", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 11, 11, "Remembrance Day", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 12, 25, "Christmas Day", "", false));
				PersonalCalendarApplication.dates.add(new CalendarEvent(i, 12, 26, "Boxing Day", "", false));
			}
			System.out.println("File Not Found");
		}
	}

	// Writes the txt file for the user
	public static void writeDatesFile() {

		// Try to write the user's txt file
		try {
			
			// Create new PrintWriter
			PrintWriter writer = new PrintWriter("files/users/"
					+ PersonalCalendarApplication.users.get(PersonalCalendarApplication.loggedInUserNum).getUsername()
					+ ".txt");
			
			// For each dates, print the year,month,day,title,desc,task is selected to the txt file incorporating the @ - delimiter 
			for (int i = 0; i < PersonalCalendarApplication.dates.size(); i++) {
				writer.println(PersonalCalendarApplication.dates.get(i).getYear() + "@"
						+ PersonalCalendarApplication.dates.get(i).getMonth() + "@"
						+ PersonalCalendarApplication.dates.get(i).getDay() + "@"
						+ PersonalCalendarApplication.dates.get(i).getTitle() + "@"
						+ PersonalCalendarApplication.dates.get(i).getDesc() + "@"
						+ PersonalCalendarApplication.dates.get(i).getTaskIsSelcted() + "@");
			}
			
			// Once all the dates have been added, close the writer
			writer.close();
			
			// Print error in terminal if error is found
		} catch (IOException e) {
			System.out.println("Error Creating File");
		}
	}

}
