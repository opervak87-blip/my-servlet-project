package ca.http.myservlet.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;

public class Logination implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context) throws ServletException, IOException {
		 System.out.println("Logination");
		 String login = "login";
		 String password = "password";
		 
		 login = request.getParameter("login");
		 password = request.getParameter("password");
		 System.out.println("LOGIN: " + login + " PASSWORD: "+password);
	}

}
