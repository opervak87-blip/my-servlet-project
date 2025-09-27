package ca.http.myservlet.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;

public class Registartion implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context) throws ServletException, IOException {
		
		 String login = "login";
		 String password = "password";
		 
		 login = request.getParameter("login");
		 password = request.getParameter("password");
		 System.out.println("REG LOGIN: " + login + " REG PASSWORD: "+password);
		
	}
	
	

}
