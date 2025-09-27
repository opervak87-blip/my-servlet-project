package ca.http.myservlet.service;

import java.util.List;

import ca.http.myservlet.bean.AdminHeaderNavBar;

public interface AdminHeaderNavBarService {

	List<AdminHeaderNavBar> getAll();

	List<AdminHeaderNavBar> getAllInUseTrue();

}
