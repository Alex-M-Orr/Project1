package com.projectone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.model.Reimbursement;
import com.projectone.service.ReimbursementService;

public class ReimbursementDataController {
	private ReimbursementService rs;

	public ReimbursementDataController(ReimbursementService rs) {
		super();
		this.rs = rs;
	}

	public ReimbursementDataController() {
		this(new ReimbursementService());
	}
	public void sendAllData(HttpServletResponse resp) {
		List<Reimbursement> reimbursements = rs.findAll();
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
