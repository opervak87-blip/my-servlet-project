package ca.http.myservlet.listeners;

import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;

public class AppContextListener implements ServletContextListener {
	
	private  ConnectionPool pool ;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		pool = ConnectionPool.getInstance();
		sce.getServletContext().setAttribute(AppConstants.CONNECTION_POOL.get(), pool);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			pool.shutdown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
