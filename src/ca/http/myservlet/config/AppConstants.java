package ca.http.myservlet.config;

public enum AppConstants {

	CONNECTION_POOL("Pool Connection"), 
	NEWS ("news"),
	ADMIN_HEADER_NAV_BAR("header_nav_bar"),
	ADMIN_DROP_MENU_DETAILS("admin_drop_menu_details"),
	BREADCRUMBS("breadcrumbs"),
	REGISTRATION("Registration"),
	EMAIL("email"),
	PASSWORD("password"),
	LOGIN("Login"),
	LOGIN_SMALL_LETTER("login"),
	ROLE_USER("USER"),
	REGEX_EMAIL("^[A-Za-z0-9+_.-]+@(.+)$"),
	USER ("user"),
	STREET_NUMBER("streetNumber"),
	STREET_NAME("streetName"),
	APARTMENT_NUMBER("apartmentNumber"),
	PROVINCE_ID("provinceId"),
	CITY_ID("cityId"),
	POSTAL_CODE("postalCode"),
	LAST_NAME("lastName"),
	FIRST_NAME("firstName"),
	MIDDLE_NAME("middleName"),
	PHONE("phone"),
	
	// ERRORS
	ERROR_SAVING_NEW_USER("Error while saving new user : "),
	ERROR_ROLLBACK_SAVING_NEW_USER("Rollback failed while saving new user : "),
	ERROR_UNABLE_SAVE_USER("Unable to save new user"),
	USER_LOGIN_KEY("user_login_key"),
	ERROR_USER_EXIST("User with this login already exists"),
	ERROR_USER_DOESNT_EXIST("User with this login doesn't exists"),
	;
	

	private final String value;

	AppConstants (String value){
		this.value = value;
	}
	public String get() {
		return value;
	}
}
