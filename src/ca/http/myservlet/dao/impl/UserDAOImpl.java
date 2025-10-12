package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import ca.http.myservlet.bean.AdminDropMenu;
import ca.http.myservlet.bean.AdminDropmenuDetails;
import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.bean.RegistrationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.UserDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;
import ca.http.myservlet.util.ResultSetMapper;

public class UserDAOImpl implements UserDAO {

	private static final Logger log = Logger.getLogger(UserDAOImpl.class.getName());
	private final ConnectionPool pool;

	public UserDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<User> getAll() {
		Map<Integer, User> users = new HashMap<>();
		int id;

		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_USERS.get());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				id = (ResultSetMapper.getInt(rs, SQLColumn.USER_ID.get()));
				User user = users.get(id);
				if (user == null) {
					user = new User.Builder().id(id).login(ResultSetMapper.getString(rs, SQLColumn.USER_LOGIN.get()))
							.password(ResultSetMapper.getString(rs, SQLColumn.USER_PASSWORD.get()))
							.isActive(ResultSetMapper.getBoolean(rs, SQLColumn.USER_IS_ACTIVE.get()))
							.roles(new ArrayList<String>()).build();
					users.put(id, user);
				}
				users.get(id).getRoles().add(ResultSetMapper.getString(rs, SQLColumn.USER_ROLES.get()));
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching AdminHeaderNavBar : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminHeaderNavBar", e);
		}
		return new ArrayList<>(users.values());

	}

	@Override
	public RegistrationResult saveUser(User user) {
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.SAVE_NEW_USER.get())) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getIsActive());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getFullName());

			int rows = ps.executeUpdate();
			return new RegistrationResult.Builder().isSuccessful(rows > 0 ? true : false).build();

		} catch (InterruptedException | SQLException e) {
			if (e.getMessage().contains("user_login_key")) {
				log.info("User with this login already exists : " + e.getMessage());
				e.printStackTrace();
				return new RegistrationResult.Builder()
						.isSuccessful(false)
						.message("User with this login already exists.")
						.build();
			}
			log.info("Error while saving new user : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to save new user", e);
		}

	}

}
