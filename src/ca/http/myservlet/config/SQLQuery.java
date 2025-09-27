package ca.http.myservlet.config;

public enum SQLQuery {

	GET_ALL_USERS("SELECT id, login, password FROM users"), 
	GET_ALL_NEWS("SELECT * FROM news"),
	ADMIN_HEADER_NAV_BAR_GET_ALL("SELECT * FROM admin_header_nav_bar"),
	ADMIN_HEADER_NAV_BAR_GET_ALL_INUSE_TRUE("SELECT * FROM admin_header_nav_bar WHERE is_use = true;");

	private final String value;

	SQLQuery(String value) {
		this.value = value;
	}

	public String get() {
		return value;
	}

}
