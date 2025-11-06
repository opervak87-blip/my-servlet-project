package ca.http.myservlet.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.controller.command.Command;

public class LogoutUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/Controller?command=goToIndexPage");
		
	}

}
