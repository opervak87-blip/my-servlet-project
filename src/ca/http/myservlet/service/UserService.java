package ca.http.myservlet.service;

import java.util.List;

import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.User;

public interface UserService {
	
	List<User> getAll();
	
	OperationResult<Void> saveUser(User user);
	
	OperationResult<Void> validateDataUser(User user);
	
	OperationResult<User> login(String password, String login);

}
