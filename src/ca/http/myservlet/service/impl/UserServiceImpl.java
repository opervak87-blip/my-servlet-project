package ca.http.myservlet.service.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import ca.http.myservlet.bean.RegistrationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.dao.UserDAO;
import ca.http.myservlet.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public RegistrationResult saveUser(User user) {
		RegistrationResult validation = validateDataUser(user);
		RegistrationResult saveUser;
		if (validation.isSuccessful()) {
			saveUser = userDAO.saveUser(user);
			if (saveUser.isSuccessful()) {
				saveUser.setPath("/Controller?command=goToLoginPage&message=success");
				return saveUser;
			} else {
				saveUser.setPath("/Controller?command=GoToRegistrationPage&message=error&details=" + saveUser.getMessage());
				return saveUser;
			}
		} else {
			validation.setPath(
					"/Controller?command=GoToRegistrationPage&message=error&details=" + validation.getMessage());
			return validation;
		}
	}

	@Override
	public RegistrationResult validateDataUser(User user) {

		StringBuilder message = new StringBuilder();

		if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
			message.append("Full name is required.<br>");
		}

		if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			message.append("Please enter a valid email address.<br>");
		}

		if (user.getLogin() == null || user.getLogin().trim().length() < 3) {
			message.append("Login must be at least 3 characters.<br>");
		}

		if (user.getPassword() == null || user.getPassword().length() < 6) {
			message.append("Password must be at least 6 characters long.<br>");
		}

		return new RegistrationResult.Builder().isSuccessful(message.length() == 0 ? true : false)
				.message(URLEncoder.encode(message.toString(), StandardCharsets.UTF_8)).build();
	}

}
