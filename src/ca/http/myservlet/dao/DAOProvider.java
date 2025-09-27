package ca.http.myservlet.dao;

import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.impl.AdminHeaderNavBarDAOImpl;
import ca.http.myservlet.dao.impl.NewsDAOImpl;
import ca.http.myservlet.dao.impl.UserDAOImpl;

public final class DAOProvider {

	private final ConnectionPool pool;
	private static DAOProvider instance;

	private DAOProvider(ConnectionPool pool) {
		this.pool = pool;
	}

	public static synchronized DAOProvider getInstance(ConnectionPool pool) {
		if(instance == null) {
			return new DAOProvider(pool);
		}
		return instance;
	}

	public UserDAO getUserDAO() {
		return new UserDAOImpl(pool);
	}
	
	public NewsDAO getNewsDAO() {
		return new NewsDAOImpl(pool);
	}
	
	public AdminHeaderNavBarDAO getAdminHeaderNavBarDAO() {
		return new AdminHeaderNavBarDAOImpl(pool);
	}

}
