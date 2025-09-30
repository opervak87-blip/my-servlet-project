package ca.http.myservlet.service.impl;

import java.util.List;

import ca.http.myservlet.bean.AdminDropmenuDetails;
import ca.http.myservlet.dao.AdminDropmenuDetailsDAO;
import ca.http.myservlet.service.AdminDropmenuDetailsService;

public class AdminDropmenuDetailsServiceImpl implements AdminDropmenuDetailsService{
	
	private final AdminDropmenuDetailsDAO adminDropmenuDetailsDAO;
	
	public AdminDropmenuDetailsServiceImpl(AdminDropmenuDetailsDAO adminDropmenuDetailsDAO) {
		this.adminDropmenuDetailsDAO = adminDropmenuDetailsDAO;
	}

	@Override
	public List<AdminDropmenuDetails> getAll() {
		return adminDropmenuDetailsDAO.getAll();
	}

	@Override
	public List<AdminDropmenuDetails> getAllInUseTrue() {
		return adminDropmenuDetailsDAO.getAllInUseTrue();
	}

	@Override
	public List<AdminDropmenuDetails> getAllByAdminDropMenuID(int adminDropMenuId) {
		return adminDropmenuDetailsDAO.getAllByAdminDropMenuID(adminDropMenuId);
	}

}
