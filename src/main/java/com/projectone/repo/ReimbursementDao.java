package com.projectone.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.projectone.config.EnvironmentConnectionUtil;
import com.projectone.model.Reimbursement;

public class ReimbursementDao implements DaoContract<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbursements = new LinkedList<>();
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from ers_reimbursement";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				LocalDateTime submitted = rs.getObject(3, LocalDateTime.class);
				LocalDateTime resolved = rs.getObject(4, LocalDateTime.class);
				reimbursements.add(new Reimbursement(rs.getInt(1),rs.getDouble(2), submitted, resolved,
						rs.getString(5), rs.getBytes(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			rs.close();
			s.close();
			return reimbursements;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement findById(Integer i) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, i);
			ResultSet rs = s.executeQuery();
			rs.next();
			LocalDateTime submitted = rs.getObject(3, LocalDateTime.class);
			LocalDateTime resolved = rs.getObject(4, LocalDateTime.class);
			Reimbursement reimbursement = new Reimbursement(rs.getInt(1),rs.getDouble(2), submitted, resolved,
					rs.getString(5), rs.getBytes(6),rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			s.close();
			rs.close();
			return reimbursement;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement update(Reimbursement t) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update ers_reimbursement set reimb_amount = ?, reimb_resolved = ?, reimb_description=?,"
					+ "	reimb_receipt = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ? where reimb_id = ?;";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setDouble(1, t.getReimbAmount());
			s.setObject(2, t.getReimbResolved());
			s.setString(3, t.getReimbDescription());
			s.setBytes(4, t.getReimbReceipt());
			if(t.getReimbResolver() == 0) {
				s.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				s.setInt(5, t.getReimbResolver());
			}
			s.setInt(6, t.getReimbStatusId());
			s.setInt(7, t.getReimbTypeId());
			s.setInt(8, t.getReimbId());
			s.executeUpdate();
			s.close();
			return t;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Reimbursement t) {
		return 0;
//		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
//			String sql = "delete from ers_reimbursement where reimb_id = ?";
//			PreparedStatement s = conn.prepareStatement(sql);
//			s.setInt(1, t.getReimbId());
//			s.executeUpdate();
//			s.close();
//			return 1;
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
	}

	@Override
	public Reimbursement Create(Reimbursement t) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_description,"
					+ " reimb_author, reimb_type_id) values(?, ?, ?, ?)";
			PreparedStatement s = conn.prepareStatement(sql);
			s.setDouble(1, t.getReimbAmount());
			s.setString(2, t.getReimbDescription());
			s.setInt(3, t.getReimbAuthor());
			s.setInt(4, t.getReimbTypeId());
			s.executeUpdate();
			s.close();
			return t;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
