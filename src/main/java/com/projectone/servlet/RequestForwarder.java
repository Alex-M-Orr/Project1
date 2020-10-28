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
			System.out.println("ROUTER TESTING ALEXORR");
			return uc.login(req);
		case "/Project1-0.0.1-SNAPSHOT/login.page":
			System.out.println("ROUTER TESTING ALEXORR 0.0.1-SNAPSHOT");
			return uc.login(req);
		case "/Project1/html/register.page":
			return uc.registerUser(req);
		case "/Project1/html/reimbursementRequest.page":
			if(sc.getSessionUser(req) == null) {
				sc.setSession(req, testuser);
			}
			return rc.requestReimbursement(req);
		case "/Project1/html/requestresolution.page":
			if(sc.getSessionUser(req) == null) {
				sc.setSession(req, testManager);
			}
			return rc.updateReimbursement(req);
		default: 
			return "index.html"; 
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
		}
	}
}
