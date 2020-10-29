package com.projectone.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectone.config.SessionController;
import com.projectone.controller.ReimbursementController;
import com.projectone.controller.ReimbursementDataController;
import com.projectone.controller.UsersController;
import com.projectone.controller.UsersDataController;
import com.projectone.model.Users;

public class RequestForwarder {
	UsersController uc = new UsersController();
	ReimbursementController rc = new ReimbursementController();

	//setting session for testing purposes
	SessionController sc = new SessionController();
	Users testuser = new Users(14, "Mason", "Wallis", "mason@gmail.com", 1);
	Users testManager = new Users(11, "Alex", "Orr", "Alex@gmail.com", 2);

	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/Project1/login.page":
			return uc.login(req);
		case "/Project1-alpha/login.page":
			return uc.login(req);
		case "/Project1/register.page":
			return uc.registerUser(req);
		case "/Project1/reimbursementRequest.page":
			return rc.requestReimbursement(req);
		case "/Project1/requestresolution.page":
			return rc.updateReimbursement(req);
		case "/Project1/viewReimbursements.page":
			return "/html/viewReimbursements.html";
		case "/Project1/requestReimbursement.page":
			return "html/RequestReimbursement.html";
		case "/Project1/logout.page":
			System.out.println("logging out");
			sc.invalidate(req);
			return "/";
		default: 
			return "/"; 
		}
	}

	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/Project1/userslist.json":
			new UsersDataController().sendAllData(res);
			break;
		case "/Project1/reimbursementlist.json":
			new ReimbursementDataController().sendAllData(res);
			break;
		case "/Project1/userinfo.json":
			new UsersDataController().getSessionData(res, req);
		case "/Project1-alpha/userslist.json":
			new UsersDataController().sendAllData(res);
			break;
		case "/Project1-alpha/reimbursementlist.json":
			new ReimbursementDataController().sendAllData(res);
			break;
		case "/Project1-alpha/userinfo.json":
			new UsersDataController().getSessionData(res, req);
		}
	}
}
