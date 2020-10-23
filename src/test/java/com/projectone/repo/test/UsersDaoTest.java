package com.projectone.repo.test;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectone.model.Users;
import com.projectone.repo.UsersDao;

public class UsersDaoTest {
	UsersDao ud;
	@Before
	public void setup() {
		ud = new UsersDao();
	}
	@Test
	public void findAllTest() {
		List<Users> users = ud.findAll();
		assertFalse(users.size()==0);
	}
	@Test
	public void findByIdTest() {
		Users user = ud.findById(7);
		assertFalse(user == null);
	}
	@Test
	public void updateTest() {
		Users user = ud.findById(7);
		user.setUserEmail("aorr917@gmail.com");
		user = ud.update(user);
		assertFalse(user == null);
	}
	@Test
	public void createTest() {
		Users user = new Users(0, "Mason1", "poggers", "Mason", "Wallis", "mason@gmail.com",1);
		assertFalse(ud.Create(user) == null);
	}
	@Test
	public void loginTest() {
		Users user = ud.login("Alex", "aorr123");
		System.out.println(user.toString());
		assertFalse(user == null);

	}
}
