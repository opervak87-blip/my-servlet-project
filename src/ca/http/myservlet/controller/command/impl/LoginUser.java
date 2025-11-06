package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;

public class LoginUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {
		
		final Logger log = Logger.getLogger(LoginUser.class.getName());
		
		ServiceProvider provider = (ServiceProvider) context;
		
		String password = request.getParameter(AppConstants.PASSWORD.get());
		String login = request.getParameter(AppConstants.LOGIN_SMALL_LETTER.get());
		
		OperationResult<User>  loginUser = provider.getUserService().login(password, login);
		
		log.info(loginUser.toString());
		
		if (loginUser.isSuccessful()) {
			request.getSession().setAttribute("user", loginUser.getData());
			response.sendRedirect(request.getContextPath() + "/Controller?command=goToIndexPage");
		} else {
			response.sendRedirect(
					request.getContextPath() + "/Controller?command=goToLoginPage&message=error&details=" + loginUser.getMessage());
		}
		
		
	}

}
