package com.projectone.model;

public class Users {
	
	private int userID;
	private String username;
	private String password;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleId;
	
	public Users(int userID, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.userID = userID;
		this.username = "";
		this.password = "";
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}
	public Users(int userID, String username, String password, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
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
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + 
				", userEmail=" + userEmail + ", userRoleId=" + userRoleId + "]";
	}
	
}
