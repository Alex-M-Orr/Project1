package com.projectone.controller;

import javax.servlet.http.HttpServletRequest;

import com.projectone.model.Users;
import com.projectone.service.UsersService;

public class UsersController {
	private UsersService us;

	public UsersController(UsersService us) {
		super();
		this.us = us;
	}
	public UsersController() {
		this(new UsersService());
	}
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = us.login(username, password);
		if(user != null) {
			//valid login
			//make session
			return "user.html";
		}
		else {
			//invalid login
			return "index.html";
		}
	}
	public Users registUser(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		int roleId = 1;
		Users newUser = new Users(0, username, password, firstName, lastName, email, roleId);
		return us.registUser(newUser);
	}
}
