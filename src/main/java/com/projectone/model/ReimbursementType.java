package com.projectone.model;

public class ReimbursementType {
	private String type;

	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [type=" + type + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
