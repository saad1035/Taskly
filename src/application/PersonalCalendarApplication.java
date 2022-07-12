/*
 * Name: Saad Naeem
 * 
 * Date: January 22, 2022
 * 
 * Course Code: ICS4U1-03 Mr.Fernandes
 * 
 * Title: Taskly - Personal Calendar Application
 * 
 * Description: 
 * 		This program is a person calendar application. Users can create their own individual accounts from 
 * 		where they can access a functional calendar, a to do list and be able to add events and tasks to them. This is in hopes 
 * 		to increase organization and productivity in the user's life.
 * 
 * Features: 
 *		 - A log in screen that allows the user to log in to their account if they have an account made (Includes validation)
 * 		- A sign up screen that asks user for required fields and creates the account if the information inputed is legitimate (Includes validation)
 * 		- A functional calendar where the view of the calendar can be altered (i.e. year format, month format, week format). This can
 * 		be done by clicking on dates/months. As well, the user can scroll through the calendar, adjusting the view screens.
 * 		- A to-do list displaying the users tasks that were added. Can delete them by checking them off and pressing delete
 * 		- A upcoming events list that displays events coming up in the next 14 days. Can delete them by checking them off and pressing delete
 *		 - Add event/task screen where user can create events and tasks, given the required fields. (Includes validation and character count)
 * 		- A settings screen where the user can adjust the fields of their information as well as change their profile picture
 * 		- A help screen that provides aid and assistance to the user by providing information for each individual screen
 * 		- A save/load feature that loads a user's tasks/events if they were created
 * 		- Added couple of national holidays as default to every user's account (only dates where the number/date stays the same throughout the years);
 * 
 * Major Skills:
 * 		- Practice of GUI interface and WindowBuilder
 * 		- Practice of frame/panel components/contents (i.e. buttons, checkbox, labels, etc.)
 * 		- Practice of OOP
 * 		- Practice of reading and writing csv and txt files
 * 		- Use of Class Hierarchy and MVC Framework
 * 		- Use of data structures (Array, ArrayList)
 * 		- Use of control statements and data types
 * 		- Implementation of algorithms
 *
 * Areas of Concern:
 * 		- Txt files for each individuals user created are included and required to run
 * 		- Csv file holding user's information is included and required to run
 * 		- jcalendar-1.4.jar API is imported to display the calendar text field
 * 		- Only one event/task in the to-do list can be deleted at a time
 * 		- When creating an account, changing information, or adding an event or task, 
 * 		ensure that all the information validated and satisfies the errors being displayed 
 * 		- If calendar scrolls through far, eventually the layout of dates in the month are not accurate. 
 * 		The month and view format can be scrolled through excessively, and it is still functional and accurate
 * 		- Main source used for creating calculating dates algorithms 
 * 		(i.e. calculating dates when user clicks next/back button, calculating dates when user changes format of calendar, etc.)
 * 		(http://www.sunshine2k.de/articles/coding/datediffindays/calcdiffofdatesindates.html)
 */

package application;

import java.util.ArrayList;

import model.CalendarEvent;
import model.User;
import view.LogInScreen;
import fileInput.FileInput;

public class PersonalCalendarApplication {

	// Public instance variables
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<CalendarEvent> dates = new ArrayList<CalendarEvent>();
	public static int loggedInUserNum = 0;

	public static void main(String[] args) {

		// Calls FileInput and LogInScreen constructor method
		new FileInput();
		new LogInScreen();
	}

}
