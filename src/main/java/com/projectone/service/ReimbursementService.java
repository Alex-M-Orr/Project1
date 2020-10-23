package com.projectone.service;

import java.util.List;

import com.projectone.model.Reimbursement;
import com.projectone.repo.ReimbursementDao;

public class ReimbursementService {
private ReimbursementDao rdao;
	
	public ReimbursementService() {
		this(new ReimbursementDao());
	}
	public ReimbursementService(ReimbursementDao rdao) {
		this.rdao = rdao;
	}
	public List<Reimbursement> findAll() {
		return rdao.findAll();
	}
	public Reimbursement findById(Integer i) {
		return rdao.findById(i);
	}
	public Reimbursement update(Reimbursement t) {
		return rdao.update(t);
	}
	public int delete(Reimbursement t) {
		return rdao.delete(t);
	}
	public Reimbursement Create(Reimbursement t) {
		return rdao.Create(t);
	}
	
}
