/*
 * Name: Saad
 * Teacher: Mr.Fernades
 * Date: January 16, 2022
 * Description: Model class for the calendar events that contains information regarding the event
 * 
 */

package model;

public class CalendarEvent {

	// Instance Variables
	private int year;
	private int month;
	private int day;
	private String title;
	private String desc;
	private boolean taskIsSelcted;

	// Constructor method
	public CalendarEvent(int year, int month, int day, String title, String desc, boolean taskIsSelected) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.title = title;
		this.desc = desc;
		this.taskIsSelcted = taskIsSelected;

	}

	// Getters and setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean getTaskIsSelcted() {
		return taskIsSelcted;
	}

	public void setTaskIsSelcted(boolean taskIsSelcted) {
		this.taskIsSelcted = taskIsSelcted;
	}

	@Override
	public String toString() {
		return "CalendarEvent [year=" + year + ", month=" + month + ", day=" + day + ", title=" + title + ", desc="
				+ desc + "]";
	}
}
