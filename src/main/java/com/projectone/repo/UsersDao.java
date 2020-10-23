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
				users.add(new Users(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			return users;

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users findById(Integer i) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from ers_users where ers_user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			ResultSet rs = s.executeQuery();
			rs.next();
			Users user = new Users(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			rs.close();
			s.close();
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users update(Users t) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update ers_users set user_first_name=?, user_last_name=?, user_email=?, user_role_id=? where ers_user_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setString(1, t.getUserFirstName());
			s.setString(2, t.getUserLastName());
			s.setString(3, t.getUserEmail());
			s.setInt(4, t.getUserRoleId());
			s.setInt(5, t.getUserID());
			s.executeUpdate();		
			s.close();
			return t;
		}catch(SQLException e) {
			
		}
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
