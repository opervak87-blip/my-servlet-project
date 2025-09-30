package ca.http.myservlet.dao;

import java.util.List;

import ca.http.myservlet.bean.AdminDropmenuDetails;

public interface AdminDropmenuDetailsDAO {

	List<AdminDropmenuDetails> getAll();

	List<AdminDropmenuDetails> getAllInUseTrue();
	
	List<AdminDropmenuDetails> getAllByAdminDropMenuID(int adminDropMenuId);

}
