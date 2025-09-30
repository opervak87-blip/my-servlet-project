package ca.http.myservlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.controller.command.CommandName;
import ca.http.myservlet.controller.command.CommandProvider;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.service.ServiceProvider;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();
		ConnectionPool pool = (ConnectionPool) ctx.getAttribute(AppConstants.CONNECTION_POOL.get());
		ServiceProvider serviceProvider = ServiceProvider.getInstance(pool);
		
		String name;
		name = request.getParameter("command");
		System.out.println("Controller : command name : " + name);
		if (name == null) {
			name = CommandName.GOTOINDEXPAGE.toString();
		}
		
		provider.takeCommand(name).execute(request, response, serviceProvider);
	}

}
