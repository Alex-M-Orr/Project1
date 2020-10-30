package com.projectone.repo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		Users user = ud.findById(11);
		assertFalse(user == null);
	}
	@Test
	public void updateTest() {
		Users u = new Users(11, "Alex", "aorr123", "Alex", "Orr", "aorr917@gmail.com", 2);
		u = ud.update(u);
		assertFalse(u == null);
	}
	@Test
	public void createTest() {
		String uname = Math.random()*1000+"";
		String email = Math.random()*1000+"@gmail.com";
		Users user = new Users(0, uname, "test", "test", "test", email,1);
		assertFalse(ud.Create(user) == null);
	}
	@Test
	public void loginTest() {
		Users user = ud.login("Alex", "aorr123");
		System.out.println(user.toString());
		assertFalse(user == null);
	}
	
	@Test
	public void findByUsernameTest() {
		String uname = Math.random()*1000+"";
		String email = Math.random()*1000+"@gmail.com";
		Users user = new Users(0, uname, "test", "test", "test", email,1);
		ud.Create(user);
		assertFalse(ud.findByUsername(user.getUsername()) == null);
	}
	@Test
	public void usersDeleteTest() {
		String uname = Math.random()*1000+"";
		String email = Math.random()*1000+"@gmail.com";
		Users user = new Users(0, uname, "test", "test", "test", email, 1);
		ud.Create(user);
		assertFalse(ud.delete(ud.findByUsername(uname))==0);
	}
	@Test
	public void usersDeleteNullTest() {
		assertTrue(ud.delete(null) == 0);
	}
	@Test
	public void usersFindByInvalidIdTest() {
		assertTrue(ud.findById(-1) == null);
	}
	@Test
	public void invalidUpdateTest() {
		Users u = new Users(-1, "kjsfdngknfkjn", "aorr123", "Alex", "Orr", "aorr917@gmail.com", 2);
		assertTrue(ud.update(u)==null);		
	}
	@Test
	public void invalidCreateTest() {
		Users u = null;
		assertTrue(ud.Create(u) == null);
	}
	@Test
	public void invalidLoginTest() {
		String Username = "iudfngslij";
		String password = "ikljsdnfglksnfkgns";
		assertTrue(ud.login(Username, password) == null);
	}
	@Test
	public void invalidFindByUsernameTest() {
		assertTrue(ud.findByUsername("ihjjfgisdigsirnindfkjsdknjakjn3eybvd") == null);
	}

}
