package com.projectone.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectone.controller.ReimbursementDataController;
import com.projectone.controller.UsersController;
import com.projectone.controller.UsersDataController;

public class RequestForwarder {
	UsersController uc = new UsersController();
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/Project1/html/login.page":
			return uc.login(req);
		case "/Project1/html/register.page":
			return uc.registerUser(req);
		default: 
			System.out.println("in routes default");
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
