package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.RegistrationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;
import ca.http.myservlet.util.InputUtils;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {

		ServiceProvider provider = (ServiceProvider) context;

		String fullName = request.getParameter(AppConstants.FULL_NAME.get());
		String email = request.getParameter(AppConstants.EMAIL.get());
		String password = request.getParameter(AppConstants.PASSWORD.get());
		String login = request.getParameter(AppConstants.LOGIN_SMALL_LETTER.get());

		User user = new User.Builder().email(InputUtils.trim(email)).fullName(InputUtils.trim(fullName)).isActive(true)
				.login(InputUtils.trim(login)).password(InputUtils.trim(password)).build();
		
		System.out.println(user.toString());

		RegistrationResult userRegistrationResult = provider.getUserService().validateDataUser(user);

		if (userRegistrationResult.isSuccessful()) {
			provider.getUserService().saveUser(user);
			response.sendRedirect(request.getContextPath() + "/Controller?command=goToLoginPage&message=success");
		} else {
			response.sendRedirect(
					request.getContextPath() + "/Controller?command=GoToRegistrationPage&message=error&details="
							+ userRegistrationResult.getMessage());
		}
	}
}
