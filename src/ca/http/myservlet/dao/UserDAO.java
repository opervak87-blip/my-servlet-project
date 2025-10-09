package ca.http.myservlet.dao;

import java.util.List;

import ca.http.myservlet.bean.User;

public interface UserDAO {
	
	List<User> getAll();
	
	boolean saveUser(User user);

}
