package ca.http.myservlet.dao;

import java.sql.SQLException;
import java.util.List;

import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.User;

public interface UserDAO {
	
	List<User> getAll();
	
	OperationResult <Void> saveUser(User user);
	
	User loginByLogin(String login) throws SQLException, InterruptedException;
	
	User loginByEmail(String login) throws SQLException, InterruptedException;

}
