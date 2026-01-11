package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.City;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;

public class CitiesByProvince implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {

		ServiceProvider provider = (ServiceProvider) context;
		String provinceId = request.getParameter("provinceId");

		List<City> cities = provider.geCityService().getAllByProvinceId(provinceId);

		request.setAttribute("cities", cities);
		
		System.out.println("CitiesByProvince : provinceId : " + provinceId);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		requestDispatcher.forward(request, response);

	}

}
