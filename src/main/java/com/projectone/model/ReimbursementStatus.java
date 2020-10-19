package com.projectone.model;

public class ReimbursementStatus {
	private String status;


	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ReimbursementStatus [status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
