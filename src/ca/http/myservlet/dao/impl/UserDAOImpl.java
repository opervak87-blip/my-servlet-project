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

import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;
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
			log.warning("Error while fetching AdminHeaderNavBar : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to fetch AdminHeaderNavBar", e);
		}
		return new ArrayList<>(users.values());

	}

	@Override
	public OperationResult<Void> saveUser(User user) {

		System.out.println(" ===== User : " + user.toString());

		int newUserId = 0, roleId = 0, addressId = 0;

		try (Connection con = pool.getConnection()) {

			try {
				con.setAutoCommit(false);

				try (PreparedStatement ps = con.prepareStatement(SQLQuery.SAVE_NEW_USER.get())) {
					ps.setString(1, user.getLogin());
					ps.setString(2, user.getPassword());
					ps.setBoolean(3, user.getIsActive());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getFullName());
					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							newUserId = rs.getInt(SQLColumn.ID.get());
							System.out.println(" ===== save User  ");
						}
					}
				}

				try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ROLE_ID_BY_NAME.get())) {
					String role = user.getRoles().get(0);
					ps.setString(1, role);

					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							roleId = rs.getInt(SQLColumn.ID.get());
						}
					}
				}

				try (PreparedStatement psUserRoles = con.prepareStatement(SQLQuery.SAVE_USER_ROLES.get())) {
					psUserRoles.setInt(1, newUserId);
					psUserRoles.setInt(2, roleId);
					psUserRoles.executeUpdate();
					System.out.println(" ===== save User role  ");
				}

				try (PreparedStatement ps = con.prepareStatement(SQLQuery.SAVE_NEW_ADDRESS.get())) {
					ps.setInt(1, user.getUserDetail().getAddress().getCity().getId());
					ps.setString(2, user.getUserDetail().getAddress().getStreetNumber());
					ps.setString(3, user.getUserDetail().getAddress().getStreetName());
					ps.setString(4, user.getUserDetail().getAddress().getPostalCode());
					ps.setString(5, user.getUserDetail().getAddress().getApartmentNumber());

					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next()) {
							addressId = rs.getInt(SQLColumn.ID.get());
							System.out.println(" ===== SAVE_NEW_ADDRESS  ");
						}
					}
				}

				try (PreparedStatement ps = con.prepareStatement(SQLQuery.SAVE_NEW_USER_DETAIL.get())) {
					ps.setInt(1, newUserId);
					ps.setInt(2, addressId);
					ps.setString(3, user.getUserDetail().getLastName());
					ps.setString(4, user.getUserDetail().getFirstName());
					ps.setString(5, user.getUserDetail().getMiddleName());
					ps.setString(6, user.getUserDetail().getPhone());
					ps.executeUpdate();
					System.out.println(" ===== SAVE_NEW_USER_DETAIL  ");
				}
				con.commit();
				con.close();
				return new OperationResult.Builder<Void>().isSuccessful(newUserId != 0 ? true : false).build();
			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					log.warning(AppConstants.ERROR_ROLLBACK_SAVING_NEW_USER.get() + e1.getMessage());
					e1.printStackTrace();
					throw new DAOException(AppConstants.ERROR_UNABLE_SAVE_USER.get(), e1);
				}
				if (e.getMessage().contains(AppConstants.USER_LOGIN_KEY.get())) {
					log.warning(AppConstants.ERROR_USER_EXIST.get() + e.getMessage());
					e.printStackTrace();

					return new OperationResult.Builder<Void>().isSuccessful(false)
							.message(AppConstants.ERROR_USER_EXIST.get()).build();
				}
				throw new DAOException(AppConstants.ERROR_UNABLE_SAVE_USER.get(), e);
			}

		} catch (InterruptedException | SQLException e) {
			throw new DAOException(AppConstants.ERROR_UNABLE_SAVE_USER.get(), e);
		}

	}

	@Override
	public User loginByLogin(String login) throws SQLException, InterruptedException {
		return loginByLoginOrEmail(login, SQLQuery.GET_USER_BY_LOGIN.get());
	}

	@Override
	public User loginByEmail(String login) throws SQLException, InterruptedException {
		return loginByLoginOrEmail(login, SQLQuery.GET_USER_BY_LOGIN.get());
	}

	private User loginByLoginOrEmail(String login, String query) throws SQLException, InterruptedException {

		Map<Integer, User> users = new HashMap<>();
		int id;

		try (Connection con = pool.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, login);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					id = (ResultSetMapper.getInt(rs, SQLColumn.USER_ID.get()));
					User userBD = users.get(id);
					if (userBD == null) {
						userBD = new User.Builder().id(id)
								.login(ResultSetMapper.getString(rs, SQLColumn.USER_LOGIN.get()))
								.email(ResultSetMapper.getString(rs, SQLColumn.USER_EMAIL.get()))
								.password(ResultSetMapper.getString(rs, SQLColumn.USER_PASSWORD.get()))
								.isActive(ResultSetMapper.getBoolean(rs, SQLColumn.USER_IS_ACTIVE.get()))
								.roles(new ArrayList<String>()).build();
						users.put(id, userBD);
					}
					users.get(id).getRoles().add(ResultSetMapper.getString(rs, SQLColumn.USER_ROLES.get()));
				}
			}

			if (users.size() == 1) {
				return new ArrayList<>(users.values()).get(0);
			}

			else {
				throw new SQLException();
			}
		}
	}

}
