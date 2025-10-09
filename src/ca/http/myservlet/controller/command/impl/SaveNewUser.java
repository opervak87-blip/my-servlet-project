package ca.http.myservlet.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.User;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {
		
		ServiceProvider provider = (ServiceProvider) context;

		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		
		provider.getUserService().saveUser(new User.Builder()
				.email(email)
				.fullName(fullName)
				.isActive(true)
				.login(login)
				.password(password)
				.build());

		
		System.out.println("class SaveNewUser implements Command fullname : " + fullName + " email : " + email);

		// request.setAttribute("message", "Registration OK");

		// response.sendRedirect("Controller?command=gotoindexpage&message=Registration
		// ok");
		// RequestDispatcher requestDispatcher =
		// request.getRequestDispatcher("index.jsp");
		// requestDispatcher.forward(request, response);

	}

}
