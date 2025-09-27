package ca.http.myservlet.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;

public class GoToRegistrationPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context) throws ServletException, IOException {
		System.out.println("GoToRegistrationPage");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
