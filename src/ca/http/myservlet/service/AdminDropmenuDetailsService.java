package ca.http.myservlet.service;

import java.util.List;

import ca.http.myservlet.bean.AdminDropmenuDetails;

public interface AdminDropmenuDetailsService {
	
	List<AdminDropmenuDetails> getAll();

	List<AdminDropmenuDetails> getAllInUseTrue();
	
	List<AdminDropmenuDetails> getAllByAdminDropMenuID(int adminDropMenuId);

}
