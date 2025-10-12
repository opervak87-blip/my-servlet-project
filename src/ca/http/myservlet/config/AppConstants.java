package ca.http.myservlet.config;

public enum AppConstants {

	CONNECTION_POOL("Pool Connection"), 
	NEWS ("news"),
	ADMIN_HEADER_NAV_BAR("header_nav_bar"),
	ADMIN_DROP_MENU_DETAILS("admin_drop_menu_details"),
	BREADCRUMBS("breadcrumbs"),
	REGISTRATION("Registration"),
	FULL_NAME("fullname"),
	EMAIL("email"),
	PASSWORD("password"),
	LOGIN("Login"),
	LOGIN_SMALL_LETTER("login"),
	ROLE_USER("USER");
	

	private final String value;

	AppConstants (String value){
		this.value = value;
	}
	public String get() {
		return value;
	}
}
