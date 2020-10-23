package com.projectone.model;

public class Users {
	
	private int userID;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleId;
	
	public Users(int userID, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.userID = userID;
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
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + 
				", userEmail=" + userEmail + ", userRoleId=" + userRoleId + "]";
	}
	
}
