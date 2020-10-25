package com.projectone.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectone.controller.UsersController;
import com.projectone.controller.UsersDataController;

public class RequestForwarder {
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/Project1/html/login.page":
			System.out.println("in login.page forwarder");
			return new UsersController().login(req);
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
		}
	}
}
