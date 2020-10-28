package com.projectone.controller;

import javax.servlet.http.HttpServletRequest;

import com.projectone.config.SessionController;
import com.projectone.model.Users;
import com.projectone.service.UsersService;

public class UsersController {
	private UsersService us;
	private SessionController sc;

	public UsersController(UsersService us, SessionController sc) {
		super();
		this.us = us;
		this.sc = sc;
	}
	public UsersController() {
		this(new UsersService(),  new SessionController());
	}
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = us.login(username, password);
		if(user != null) {
			//valid login
			System.out.println("sending to user.html");
			sc.setSession(req, user);
			return "http://18.191.119.230:8081/Project1-0.0.1-SNAPSHOT/html/user.html";
		}
		else {
			//invalid login
			System.out.println("defaulting to index");
			return "http://18.191.119.230:8081/Project1-0.0.1-SNAPSHOT/";
		}
	}
	public String registerUser(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		int roleId = 1;
		Users newUser = new Users(0, username, password, firstName, lastName, email, roleId);
		if(us.registerUser(newUser) != null) {
			return "/html/index.html";
		}
		else {
			return "/html/index.html";
		}		
	}
}
