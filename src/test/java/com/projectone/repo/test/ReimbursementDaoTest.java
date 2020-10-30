package com.projectone.repo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectone.model.Reimbursement;
import com.projectone.repo.ReimbursementDao;

public class ReimbursementDaoTest {
	ReimbursementDao rd;
	public int deleteID;
	@Before
	public void setup() {
		rd = new ReimbursementDao();
	}
	@Test
	public void findAllTest() {
		List<Reimbursement> reimbursements = rd.findAll();
		assertFalse(reimbursements.size()==0);
	}
	@Test
	public void findByIdTest() {
		Reimbursement reimbursement = rd.findById(5);
		System.out.println(reimbursement.toString());
		assertFalse(reimbursement == null);
	}
	@Test
	public void	updateTest() {
		Reimbursement reimbursement = rd.findById(5);
		System.out.println(reimbursement.toString());
		reimbursement.setReimbAmount(500);
		reimbursement.setReimbResolved(LocalDateTime.now());
		rd.update(reimbursement);
		assertFalse(reimbursement == null);
	}
	@Test
	public void createTest() {
		Reimbursement r = new Reimbursement(4000, "testing", 14, 3);
		assertFalse(rd.Create(r) == null);
	}
	@Test
	public void deleteTest() {
		assertTrue(rd.delete(null) == 0);
	}
	@Test
	public void invalidFindByIdTest() {
		assertTrue(rd.findById(-1) == null);
	}
	@Test
	public void invalidUpdateTest() {
		Reimbursement t = new Reimbursement(-1, -1, null, null, null, null, -1, -1, -1, -1);
		assertTrue(rd.update(t) == null);
	}
	
	
}
