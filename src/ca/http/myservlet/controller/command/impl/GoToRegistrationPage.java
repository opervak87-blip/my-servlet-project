package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.Breadcrumb;
import ca.http.myservlet.bean.City;
import ca.http.myservlet.bean.Province;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;
import ca.http.myservlet.util.BreadcrumbHelper;

public class GoToRegistrationPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context) throws ServletException, IOException {


		List<Breadcrumb> trail = BreadcrumbHelper.nextToHome(AppConstants.REGISTRATION.get()).getCrumbs();
		request.setAttribute(AppConstants.BREADCRUMBS.get(), trail);
		
		ServiceProvider provider = (ServiceProvider) context;
		
		List<Province> provinceList = provider.getProvinceService().getAll(); 
		List<City> cityList = provider.geCityService().getAll();
		
		request.setAttribute("provinces", provinceList);
		request.setAttribute("cities", cityList);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
