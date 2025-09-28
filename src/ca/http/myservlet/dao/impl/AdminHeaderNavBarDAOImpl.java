package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import ca.http.myservlet.bean.AdminDropMenu;
import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.bean.News;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.AdminHeaderNavBarDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;

public class AdminHeaderNavBarDAOImpl implements AdminHeaderNavBarDAO {

	private static final Logger log = Logger.getLogger(NewsDAOImpl.class.getName());
	private final ConnectionPool pool;

	public AdminHeaderNavBarDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<AdminHeaderNavBar> getAll() {
		return getListNavBar(SQLQuery.ADMIN_HEADER_NAV_BAR_GET_ALL.get());
	}

	@Override
	public List<AdminHeaderNavBar> getAllInUseTrue() {
		return getListNavBar(SQLQuery.ADMIN_HEADER_NAV_BAR_GET_ALL_INUSE_TRUE.get());
	}

	@Override
	public List<AdminHeaderNavBar> getAllInUseTrueWithDropMenu() {
		Map<Integer, AdminHeaderNavBar> mapNavBar = new HashMap<>();
		int id;

		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.ADMIN_HEADER_NAV_BAR_CET_ALL_INUSE_TRUE_WITH_DROPMENU.get());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				id = rs.getInt(SQLColumn.ADMIN_HEADER_NAV_BAR_JOIN_DROP_MENU_ID.get());
				AdminHeaderNavBar navBar = mapNavBar.get(id);
				if (navBar == null) {
					navBar = new AdminHeaderNavBar.Builder().id(id)
							.title(rs.getString(SQLColumn.ADMIN_HEADER_NAV_BAR_JOIN_DROP_MENU_TITLE.get()))
							.listAdminDropMenu(new ArrayList<AdminDropMenu>()).build();
					mapNavBar.put(id, navBar);	
				}
				AdminDropMenu dropMenu = new AdminDropMenu.Builder()
						.id(rs.getInt(SQLColumn.DROP_MENU_JOIN_ADMIN_HEADER_NAV_BAR_ID.get()))
							.title(rs.getString(SQLColumn.DROP_MENU_JOIN_ADMIN_HEADER_NAV_BAR_TITLE.get())).build();
				mapNavBar.get(id).getListAdminDropMenu().add(dropMenu);

			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching AdminHeaderNavBar : ");
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminHeaderNavBar", e);
		}
		return new ArrayList<>(mapNavBar.values());
	}

	private List<AdminHeaderNavBar> getListNavBar(String query) {
		List<AdminHeaderNavBar> navBarList = new ArrayList<AdminHeaderNavBar>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				AdminHeaderNavBar navBar = new AdminHeaderNavBar.Builder().id(rs.getInt(SQLColumn.ID.get()))
						.title(rs.getString(SQLColumn.ADMIN_HEADER_NAV_BAR_TITLE.get()))
						.inUse(rs.getBoolean(SQLColumn.ADMIN_HEADER_NAV_BAR_IS_USE.get())).build();
				navBarList.add(navBar);
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching AdminHeaderNavBar : ");
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminHeaderNavBar", e);
		}
		return navBarList;
	}

}
