package com.projectone.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.projectone.config.EnvironmentConnectionUtil;
import com.projectone.model.Users;

public class UsersDao implements DaoContract<Users, Integer>{

	@Override
	public List<Users> findAll() {
		List<Users> users = new LinkedList<>();
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from ers_users";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				users.add();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users update(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
