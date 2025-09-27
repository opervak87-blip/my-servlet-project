package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.bean.News;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.service.NewsService;
import ca.http.myservlet.service.ServiceProvider;

public class GoToIndexPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {
		
		ServiceProvider provider = (ServiceProvider) context;

		List<News> newsList = provider.getNewsService().getAll();
		List<AdminHeaderNavBar> adminHeaderNavBarServiceList = provider.getAdminHeaderNavBarService().getAllInUseTrue();
	
		request.setAttribute(AppConstants.NEWS.get(), newsList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
		requestDispatcher.forward(request, response);
	}
}
