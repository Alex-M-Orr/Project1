package com.projectone.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.projectone.model.Users;

public class SessionController {
	
	public void setSession(HttpServletRequest req, Users u) {
		HttpSession session = req.getSession();
		session.setAttribute("user", u);
	}
	
	public Users getSessionUser(HttpServletRequest req) {
		return (Users)req.getSession().getAttribute("user");
	}
	
	public void invalidate(HttpServletRequest req) {
		req.getSession().invalidate();
	}

}
