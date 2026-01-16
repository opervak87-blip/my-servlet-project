package ca.http.myservlet.config;


public enum SQLQuery {

	GET_ALL_USERS("SELECT u.id as u_id, u.login as u_login, u.password as u_password, u.is_active as u_is_active, "
			+ "r.role_name as r_role_name " + 
			"FROM users u " + 
			"LEFT JOIN user_roles ur " + 
			"ON ur.user_id = u.id  " + 
			"LEFT JOIN roles r " + 
			"ON ur.role_id = r.id " + 
			"ORDER BY u.id;"), 
	GET_ALL_NEWS("SELECT * FROM news"),
	ADMIN_HEADER_NAV_BAR_GET_ALL("SELECT * FROM admin_header_nav_bar"),
	ADMIN_HEADER_NAV_BAR_GET_ALL_INUSE_TRUE("SELECT * FROM admin_header_nav_bar WHERE is_use = true;"),
	ADMIN_HEADER_NAV_BAR_CET_ALL_INUSE_TRUE_WITH_DROPMENU("SELECT"
			+ " h.id   AS header_id,   h.title   AS header_title,"
			+ " m.id   AS menu_id,     m.title   AS menu_title  "
			+ " FROM admin_header_nav_bar h "
			+ " LEFT JOIN admin_dropmenu m "
			+ " ON h.id = m.admin_header_nav_bar_id "
			+ "WHERE h.is_use = true AND m.is_use = true ORDER BY h.id, m.id;"),
	ADMIN_DROP_MENU_DETAILS_ALL("SELECT  dmd.id as dmd_id, dmd.title as dmd_title, dmd.article as dmd_article, "
			+ "dmd.is_use as dmd_is_use, dm.id as dm_id, dm.title as dm_title, dm.is_use as dm_is_use  "
			+ "FROM admin_dropmenu_details dmd LEFT JOIN admin_dropmenu dm ON dmd.admin_dropmenu_id = dm.id ORDER BY dmd.id, dm.id;"),
	ADMIN_DROP_MENU_DETAILS_ALL_INUSE_TRUE("SELECT  dmd.id as dmd_id, dmd.title as dmd_title, dmd.article as dmd_article, "
			+ "dmd.is_use as dmd_is_use, dm.id as dm_id, dm.title as dm_title, dm.is_use as dm_is_use  "
			+ "FROM admin_dropmenu_details dmd LEFT JOIN admin_dropmenu dm ON dmd.admin_dropmenu_id = dm.id  "
			+ "WHERE dmd.is_use = true AND dm.is_use = true ORDER BY dmd.id, dm.id;"),
	ADMIN_DROP_MENU_DETAILS_BY_ID("SELECT nb.title as nb_title, dmd.id as dmd_id, dmd.title as dmd_title, dmd.article as dmd_article, "
			+ "dmd.is_use as dmd_is_use, dm.id as dm_id, dm.title as dm_title, dm.is_use as dm_is_use  "
			+ "FROM admin_dropmenu_details dmd "
			+ "LEFT JOIN admin_dropmenu dm ON dmd.admin_dropmenu_id = dm.id  "
			+ "LEFT JOIN admin_header_nav_bar nb ON dm.admin_header_nav_bar_id = nb.id "
			+ "WHERE dm.id = ? "
			+ "ORDER BY dmd.id, dm.id;"),
	SAVE_NEW_USER("INSERT INTO users (login, password, is_active, email, fullname) VALUES (?, ?, ?, ?, ?) RETURNING id;"),
	SAVE_NEW_USER_DETAIL("INSERT INTO user_detail (user_id, address_id, last_name, first_name, middle_name, phone) "
			+ "VALUES (?, ?, ?, ?, ?, ?);"),
	SAVE_NEW_ADDRESS("INSERT INTO address (city_id, street_number, street_name, postal_code, apartment_number) "
			+ "VALUES (?, ?, ?, ?, ?) RETURNING id;"),
	GET_ROLE_ID_BY_NAME("SELECT id FROM roles WHERE role_name = ?;"),
	SAVE_USER_ROLES("INSERT INTO user_roles (user_id, role_id) VALUES (?, ?);"),
	GET_USER_BY_LOGIN("SELECT u.id as u_id, " + 
			"u.login as u_login, " + 
			"u.email as u_email, " + 
			"u.password as u_password, " + 
			"u.is_active as u_is_active, " + 
			"r.role_name as r_role_name " + 
			"FROM users u " + 
			"LEFT JOIN user_roles ur " + 
			"ON ur.user_id = u.id " + 
			"LEFT JOIN roles r " + 
			"ON ur.role_id = r.id WHERE login = ?;"),
	GET_USER_BY_EMAIL("SELECT u.id as u_id,  " + 
			"u.login as u_login,  " + 
			"u.email as u_email,  " + 
			"u.password as u_password,  " + 
			"u.is_active as u_is_active,  " + 
			"r.role_name as r_role_name  " + 
			"FROM users u  " + 
			"LEFT JOIN user_roles ur  " + 
			"ON ur.user_id = u.id  " + 
			"LEFT JOIN roles r  " + 
			"ON ur.role_id = r.id WHERE email = ?;"),
	GET_CITY_BY_PROVINCE_ID("SELECT * FROM city WHERE province_id = ?;"),
	GET_CITY_ALL("SELECT * FROM city;"),
	GET_ALL_PROVINCE_ID("SELECT * FROM province;");

	private final String value;

	SQLQuery(String value) {
		this.value = value;
	}

	public String get() {
		return value;
	}

}
