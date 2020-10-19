package com.projectone.model;

public class Users {
	
	private int userID;
	private String userUsername;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleId;
	
	public Users(int userID, String userUsername, String userPassword, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.userID = userID;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
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
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}
	
}
