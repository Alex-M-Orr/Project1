package com.projectone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.model.Users;
import com.projectone.service.UsersService;

public class UsersDataController {
	private UsersService us;

	public UsersDataController(UsersService us) {
		super();
		this.us = us;
	}

	public UsersDataController() {
		this(new UsersService());
	}
	
	public void sendAllData(HttpServletResponse resp) {
		List<Users> users = us.findAll();
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(users));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

