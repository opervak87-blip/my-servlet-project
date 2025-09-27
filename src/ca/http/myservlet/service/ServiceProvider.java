package ca.http.myservlet.service;

import ca.http.myservlet.dao.DAOProvider;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.service.impl.AdminHeaderNavBarServiceImpl;
import ca.http.myservlet.service.impl.NewsServiceImpl;
import ca.http.myservlet.service.impl.UserServiceImpl;

public final class ServiceProvider {

	private static DAOProvider daoProvider;
	private static  ServiceProvider instance;

	private ServiceProvider(ConnectionPool pool) {
		this.daoProvider = DAOProvider.getInstance(pool);
	}

	public static synchronized ServiceProvider getInstance(ConnectionPool pool) {
		if (instance == null) {
			return new ServiceProvider(pool);
		}
		return instance;
	}

	public UserService getUserService() {
		return new UserServiceImpl(daoProvider.getUserDAO());
	}

	public NewsService getNewsService() {
		return new NewsServiceImpl(daoProvider.getNewsDAO());
	}
	
	public AdminHeaderNavBarService getAdminHeaderNavBarService() {
		return new AdminHeaderNavBarServiceImpl(daoProvider.getAdminHeaderNavBarDAO());
	}

}
