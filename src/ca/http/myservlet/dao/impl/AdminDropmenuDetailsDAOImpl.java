package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


import ca.http.myservlet.bean.AdminDropMenu;
import ca.http.myservlet.bean.AdminDropmenuDetails;
import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.AdminDropmenuDetailsDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;
import ca.http.myservlet.util.ResultSetMapper;

public class AdminDropmenuDetailsDAOImpl implements AdminDropmenuDetailsDAO {

	private static final Logger log = Logger.getLogger(AdminDropmenuDetailsDAOImpl.class.getName());
	private final ConnectionPool pool;

	public AdminDropmenuDetailsDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<AdminDropmenuDetails> getAll() {
		return getListDropMenuDetails(SQLQuery.ADMIN_DROP_MENU_DETAILS_ALL.get());
	}

	@Override
	public List<AdminDropmenuDetails> getAllInUseTrue() {
		return getListDropMenuDetails(SQLQuery.ADMIN_DROP_MENU_DETAILS_ALL_INUSE_TRUE.get());
	}

	@Override
	public List<AdminDropmenuDetails> getAllByAdminDropMenuID(int adminDropMenuId) {
		List<AdminDropmenuDetails> listAdminDropmenuDetails = new ArrayList<AdminDropmenuDetails>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.ADMIN_DROP_MENU_DETAILS_BY_ID.get())) {
			ps.setInt(1, adminDropMenuId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					AdminDropmenuDetails adminDropMenuDetails = buildAdminDropmenuDetails(rs);
					listAdminDropmenuDetails.add(adminDropMenuDetails);
				}
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching AdminDropmenuDetails : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminDropmenuDetails", e);
		}

		return listAdminDropmenuDetails;
	}

	private List<AdminDropmenuDetails> getListDropMenuDetails(String query) {
		List<AdminDropmenuDetails> listAdminDropmenuDetails = new ArrayList<AdminDropmenuDetails>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				AdminDropmenuDetails adminDropMenuDetails = buildAdminDropmenuDetails(rs);
				listAdminDropmenuDetails.add(adminDropMenuDetails);
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching AdminDropmenuDetails : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminDropmenuDetails", e);
		}
		return listAdminDropmenuDetails;
	}

	private AdminDropmenuDetails buildAdminDropmenuDetails(ResultSet rs) throws SQLException {
		AdminHeaderNavBar adminHeaderNavBar = new AdminHeaderNavBar.Builder()
				.title(ResultSetMapper.getString(rs, SQLColumn.ADMIN_DROPMENU_DETAILS_ADMIN_HEADER_NAV_BAR_TITLE.get()))
				.build();
		AdminDropMenu adminDropMenu = new AdminDropMenu.Builder()
				.adminHeaderNavBar(adminHeaderNavBar)
				.id(ResultSetMapper.getInt(rs,SQLColumn.ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_ID.get()))
				.title(ResultSetMapper.getString(rs, SQLColumn.ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_TITLE.get()))
				.inUse(ResultSetMapper.getBoolean(rs,SQLColumn.ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_IS_USE.get()))
				.build();
		AdminDropmenuDetails adminDropMenuDetails = new AdminDropmenuDetails.Builder()
				.id(ResultSetMapper.getInt(rs,SQLColumn.ADMIN_DROPMENU_DETAILS_ID.get()))
				.adminDropMenu(adminDropMenu)
				.title(ResultSetMapper.getString(rs, SQLColumn.ADMIN_DROPMENU_DETAILS_TITLE.get()))
				.article(ResultSetMapper.getString(rs, SQLColumn.ADMIN_DROPMENU_DETAILS_ARTICLE.get()))
				.inUse(ResultSetMapper.getBoolean(rs, SQLColumn.ADMIN_DROPMENU_DETAILS_IS_USE.get()))
				.build();
		return adminDropMenuDetails;
	}

}
