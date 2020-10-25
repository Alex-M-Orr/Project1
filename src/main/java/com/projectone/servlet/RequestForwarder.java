package com.projectone.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectone.controller.UsersController;
import com.projectone.controller.UsersDataController;

public class RequestForwarder {
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/Project1/login.page":
			return new UsersController().login(req);
		default: 
			return "html/index.html";
		}
	}
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/Project1/all.json":
			new UsersDataController().sendAllData(res);
			break;
		}
	}
}
