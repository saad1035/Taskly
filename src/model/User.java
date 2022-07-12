/*
 * Name: Saad
 * Teacher: Mr.Fernandes
 * Date: January 10, 2022
 * Description: Model class for the user that contains all the necessary information
 */

package model;

public class User {

	// Instance variables
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private int profilePictureNumber;

	// OverLoaded Constructor Methods
	public User(String firstName, String lastName, String username, String password, String email, int birthDay,
			int birthMonth, int birthYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.profilePictureNumber = 1;
	}

	public User() {
		this.profilePictureNumber = 1;
	}

	// Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getProfilePictureNumber() {
		return profilePictureNumber;
	}

	public void setProfilePictureNumber(int profilePictureNumber) {
		this.profilePictureNumber = profilePictureNumber;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", email=" + email + ", birthDay=" + birthDay + ", birthMonth=" + birthMonth
				+ ", birthYear=" + birthYear + ", profilePictureNumber=" + profilePictureNumber + "]";
	}

}
