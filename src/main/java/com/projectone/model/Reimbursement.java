package com.projectone.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Reimbursement {
	
	private int reimbId;
	private double reimbAmount;
	private LocalDateTime reimbSubmitted;
	private LocalDateTime reimbResolved;
	private String reimbDescription;
	private byte[] reimbReceipt;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatusId;
	private int reimbTypeId;
	
	public Reimbursement(int reimbId, double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
			String reimbDescription, byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId,
			int reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}
	public Reimbursement(double reimbAmount, String reimbDescription, int reimbAuthor, int reimbTypeId) {
		super();
		this.reimbId = 0;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = LocalDateTime.now();
		this.reimbResolved = null;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = null;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = 0;
		this.reimbStatusId = 1;
		this.reimbTypeId = reimbTypeId;
		
	}
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public LocalDateTime getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(LocalDateTime reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public LocalDateTime getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(LocalDateTime reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId="
				+ reimbTypeId + "]";
	}
	
}
