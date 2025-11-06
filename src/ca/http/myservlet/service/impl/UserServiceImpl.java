package ca.http.myservlet.service.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.dao.UserDAO;
import ca.http.myservlet.service.UserService;
import ca.http.myservlet.util.PasswordUtils;

public class UserServiceImpl implements UserService {

	private static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	private final UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public OperationResult<Void> saveUser(User user) {
		OperationResult <Void> validation = validateDataUser(user);
		if (validation.isSuccessful()) {
			return userDAO.saveUser(user);
		} else {
			return validation;
		}
	}

	@Override
	public OperationResult<Void> validateDataUser(User user) {

		StringBuilder message = new StringBuilder();

		if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
			message.append("Full name is required.<br>");
		}

		if (user.getEmail() == null || !user.getEmail().matches(AppConstants.REGEX_EMAIL.get())) {
			message.append("Please enter a valid email address.<br>");
		}

		if (user.getLogin() == null || user.getLogin().trim().length() < 3) {
			message.append("Login must be at least 3 characters.<br>");
		}

		if (user.getPassword() == null || user.getPassword().length() < 6) {
			message.append("Password must be at least 6 characters long.<br>");
		}

		return new OperationResult.Builder<Void>().isSuccessful(message.length() == 0 ? true : false)
				.message(URLEncoder.encode(message.toString(), StandardCharsets.UTF_8)).build();
	}

	@Override
	public OperationResult<User> login(String password, String login) {
		User user = null;

		if (login.matches(AppConstants.REGEX_EMAIL.get())) {
			try {
				user = userDAO.loginByEmail(login);
			} catch (SQLException | InterruptedException e) {
				log.warning(AppConstants.ERROR_USER_DOESNT_EXIST.get() + e.getMessage());
				e.printStackTrace();
				return new OperationResult.Builder<User>().isSuccessful(false).data(user)
						.message(AppConstants.ERROR_USER_DOESNT_EXIST.get()).build();
			}
		} else {
			try {
				user = userDAO.loginByLogin(login);
			} catch (SQLException | InterruptedException e) {
				log.warning(AppConstants.ERROR_USER_DOESNT_EXIST.get() + e.getMessage());
				e.printStackTrace();
				return new OperationResult.Builder<User>().isSuccessful(false)
						.message(AppConstants.ERROR_USER_DOESNT_EXIST.get()).build();
			}
		}

		
		if (user == null) {
			log.info("USER IS NULL");
			log.warning(AppConstants.ERROR_USER_DOESNT_EXIST.get());
			return new OperationResult.Builder<User>().isSuccessful(false).message(AppConstants.ERROR_USER_DOESNT_EXIST.get())
					.build();
		}
		
		log.info("USER : " + user.toString());
		if (PasswordUtils.checkPassword(password, user.getPassword())) {
			log.info("Password is the same");
			return new OperationResult.Builder<User>().data(user).isSuccessful(true).build();
		} else {
			return new OperationResult.Builder<User>().isSuccessful(false).message(AppConstants.ERROR_USER_DOESNT_EXIST.get())
					.build();
		}
	}

}
