package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.Breadcrumb;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.util.BreadcrumbHelper;

public class GoToLoginPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {
		
		List<Breadcrumb> trail = BreadcrumbHelper.nextToHome(AppConstants.LOGIN.get()).getCrumbs();
		request.setAttribute(AppConstants.BREADCRUMBS.get(), trail);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		requestDispatcher.forward(request, response);
	}

}
