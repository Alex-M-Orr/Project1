package com.projectone.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import com.projectone.config.SessionController;
import com.projectone.model.Reimbursement;
import com.projectone.service.ReimbursementService;

public class ReimbursementController {
	private ReimbursementService rs;
	private SessionController sc;

	public ReimbursementController() {
		this(new ReimbursementService(), new SessionController());
	}

	public ReimbursementController(ReimbursementService rs, SessionController sc) {
		super();
		this.rs = rs;
		this.sc = sc;
	}
	
	public String requestReimbursement(HttpServletRequest req) {
		double amount = Double.parseDouble(req.getParameter("amount"));
		String description = req.getParameter("description");
		int type = Integer.parseInt(req.getParameter("type"));
		 if(sc.getSessionUser(req) == null) {
			 System.out.println("User new logged in");
			 return "index.html";
		 }
		 else {
			 int userId = sc.getSessionUser(req).getUserID();
			 Reimbursement reimb = new Reimbursement(amount, description, userId, type);
			 rs.Create(reimb);
			 return "user.html";
		 }		
	}

	public String updateReimbursement(HttpServletRequest req) {
		int status = Integer.parseInt(req.getParameter("resolution"));
		int reqId = Integer.parseInt(req.getParameter("requestId"));
		Reimbursement reimb = rs.findById(reqId);
		reimb.setReimbStatusId(status);
		reimb.setReimbResolved(LocalDateTime.now());
		reimb.setReimbResolver(sc.getSessionUser(req).getUserID());
		
		if(rs.update(reimb) != null){
			return "viewReimbursements.html";
		}
		return "user.html";
	}
	
}





















