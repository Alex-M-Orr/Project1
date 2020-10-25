package com.projectone.service;

import java.util.List;

import com.projectone.model.Users;
import com.projectone.repo.UsersDao;

public class UsersService {
	private UsersDao udao;
	
	public UsersService() {
		this(new UsersDao());
	}
	public UsersService(UsersDao udao) {
		this.udao = udao;
	}
	public List<Users> findAll() {
		return udao.findAll();
	}
	public Users findById(Integer i) {
		return udao.findById(i);
	}
	public Users update(Users t) {
		return udao.update(t);
	}
	public Users login(String username, String password) {
		return udao.login(username, password);
	}
	public Users registUser(Users u) {
		return udao.Create(u);
	}
}
