package ca.http.myservlet.config;

public enum AppConstants {

	CONNECTION_POOL("Pool Connection"), 
	NEWS ("news"),
	ADMIN_HEADER_NAV_BAR("header_nav_bar"),
	ADMIN_DROP_MENU_DETAILS("admin_drop_menu_details");

	private final String value;

	AppConstants (String value){
		this.value = value;
	}
	public String get() {
		return value;
	}
}
