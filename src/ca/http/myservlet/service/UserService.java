package ca.http.myservlet.service;

import java.util.List;

import ca.http.myservlet.bean.RegistrationResult;
import ca.http.myservlet.bean.User;

public interface UserService {
	
	List<User> getAll();
	
	boolean saveUser(User user);
	
	RegistrationResult validateDataUser(User user);

}
