package com.projectone.repo.test;

import static org.junit.Assert.assertFalse;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectone.model.Reimbursement;
import com.projectone.repo.ReimbursementDao;

public class ReimbursementDaoTest {
	ReimbursementDao rd;
	@Before
	public void setup() {
		rd = new ReimbursementDao();
	}
	@Test
	public void findAllTest() {
		List<Reimbursement> reimbursements = rd.findAll();
		System.out.println(reimbursements.toString());
		assertFalse(reimbursements.size()==0);
	}
	@Test
	public void findByIdTest() {
		Reimbursement reimbursement = rd.findById(1);
		System.out.println(reimbursement.toString());
		assertFalse(reimbursement == null);
	}
	@Test
	public void	updateTest() {
		Reimbursement reimbursement = rd.findById(2);
		System.out.println(reimbursement.toString());
		reimbursement.setReimbResolver(7);;
		reimbursement.setReimbAmount(500);
		reimbursement.setReimbResolved(LocalDateTime.now());
		rd.update(reimbursement);
		System.out.println(reimbursement.toString());
		assertFalse(reimbursement == null);
	}
	@Test
	public void deleteTest() {
		Reimbursement r = rd.findById(1);
		assertFalse(rd.delete(r) == 0);
	}
	@Test
	public void createTest() {
		Reimbursement r = new Reimbursement(4000, "Sushi Dinner", 8, 3);
		assertFalse(rd.Create(r) == null);
	}
}
