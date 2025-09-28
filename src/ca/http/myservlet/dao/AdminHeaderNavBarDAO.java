package ca.http.myservlet.dao;

import java.util.List;

import ca.http.myservlet.bean.AdminHeaderNavBar;

public interface AdminHeaderNavBarDAO {
	
	List<AdminHeaderNavBar> getAll();
	
	List<AdminHeaderNavBar> getAllInUseTrue();
	
	List<AdminHeaderNavBar> getAllInUseTrueWithDropMenu();

}
