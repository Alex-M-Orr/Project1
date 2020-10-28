package com.projectone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.config.SessionController;
import com.projectone.model.Users;
import com.projectone.service.UsersService;

public class UsersDataController {
	private UsersService us;
	private SessionController sc;

	public UsersDataController(UsersService us, SessionController sc) {
		super();
		this.us = us;
		this.sc = sc;
	}

	public UsersDataController() {
		this(new UsersService(),  new SessionController());
	}
	
	public void sendAllData(HttpServletResponse resp) {
		List<Users> users = us.findAll();
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(users));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getSessionData(HttpServletResponse resp, HttpServletRequest req) {
		if(sc.getSessionUser(req) != null) {
			Users u = new Users(sc.getSessionUser(req).getUserID(), sc.getSessionUser(req).getUserFirstName(),
					sc.getSessionUser(req).getUserLastName(), sc.getSessionUser(req).getUserEmail(), sc.getSessionUser(req).getUserRoleId());
			try {
				resp.getWriter().println(new ObjectMapper().writeValueAsString(u));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			String nosesh= "no session";
			try {
				resp.getWriter().println(new ObjectMapper().writeValueAsString(nosesh));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

