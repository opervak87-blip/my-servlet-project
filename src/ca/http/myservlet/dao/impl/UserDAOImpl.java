package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.UserDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;

public class UserDAOImpl implements UserDAO {

	private static final Logger log = Logger.getLogger(UserDAOImpl.class.getName());
	private final ConnectionPool pool;

	public UserDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_USERS.get());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				User user = new User.Builder()
						.id(rs.getInt(SQLColumn.ID.get()))
						.login(rs.getString(SQLColumn.USER_LOGIN.get()))
						.password(rs.getString(SQLColumn.USER_PASSWORD.get()))
						.build();
				userList.add(user);
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching users : " );
			e.printStackTrace();
			 throw new DAOException("Unable to fetch users", e);
		} 
		return userList;
	}

}
