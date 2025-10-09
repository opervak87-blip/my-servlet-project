package ca.http.myservlet.service.impl;

import java.util.List;

import ca.http.myservlet.bean.User;
import ca.http.myservlet.dao.DAOProvider;
import ca.http.myservlet.dao.UserDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
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
	public boolean saveUser(User user) {
		return userDAO.saveUser(user);
	}

}
