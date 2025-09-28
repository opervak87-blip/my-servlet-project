package ca.http.myservlet.service.impl;

import java.util.List;

import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.dao.AdminHeaderNavBarDAO;
import ca.http.myservlet.service.AdminHeaderNavBarService;

public class AdminHeaderNavBarServiceImpl implements AdminHeaderNavBarService{
	
	private final AdminHeaderNavBarDAO adminHeaderNavBarDAO;
	
	public AdminHeaderNavBarServiceImpl(AdminHeaderNavBarDAO adminHeaderNavBarDAO){
		this.adminHeaderNavBarDAO = adminHeaderNavBarDAO;
	}

	@Override
	public List<AdminHeaderNavBar> getAll() {
		return adminHeaderNavBarDAO.getAll();
	}

	@Override
	public List<AdminHeaderNavBar> getAllInUseTrue() {
		return adminHeaderNavBarDAO.getAllInUseTrue();
	}

	@Override
	public List<AdminHeaderNavBar> getAllInUseTrueWithDropMenu() {
		return adminHeaderNavBarDAO.getAllInUseTrueWithDropMenu();
	}

}
