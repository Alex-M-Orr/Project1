package com.projectone.model;

public class UserRole {
	private String role;

	public UserRole(String role) {
		super();
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
