package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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
import ca.http.myservlet.util.PasswordUtils;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {

		ServiceProvider provider = (ServiceProvider) context;

		String fullName = request.getParameter(AppConstants.FULL_NAME.get());
		String email = request.getParameter(AppConstants.EMAIL.get());
		String password = request.getParameter(AppConstants.PASSWORD.get());
		String login = request.getParameter(AppConstants.LOGIN_SMALL_LETTER.get());
		List <String> roles = new ArrayList<String>();
		roles.add(AppConstants.ROLE_USER.get());

		User user = new User.Builder().email(InputUtils.trim(email)).fullName(InputUtils.trim(fullName)).isActive(true)
				.login(InputUtils.trim(login)).password(InputUtils.trim(PasswordUtils.hashPassword(password))).roles(roles).build();
		
		RegistrationResult saveUser = provider.getUserService().saveUser(user);
		
		System.out.println("SAVE USER : " + saveUser.toString());

		if (saveUser.isSuccessful()) {
			response.sendRedirect(request.getContextPath() + saveUser.getPath());
		} else {
			response.sendRedirect(
					request.getContextPath() + saveUser.getPath());
		}
	}
}
