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
	public Users login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = us.login(username, password);
		return user;
	}
	public Users registUser(HttpServletRequest req) {
		
		return null;
	}
}
