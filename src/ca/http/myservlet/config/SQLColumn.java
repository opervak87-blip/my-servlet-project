package ca.http.myservlet.config;

public enum SQLColumn {
	
	ID("id"),
	
	NEWS_TITLE("title"),
	NEWS_ARTICLE("article"),
	NEWS_CREATED_AT("created_at"),
	
	USER_LOGIN("login"),
	USER_PASSWORD("password"),
	
	ADMIN_HEADER_NAV_BAR_TITLE("title"),
	ADMIN_HEADER_NAV_BAR_IS_USE("is_use"),
	
	ADMIN_HEADER_NAV_BAR_JOIN_DROP_MENU_ID("header_id"),
	ADMIN_HEADER_NAV_BAR_JOIN_DROP_MENU_TITLE("header_title"),
	DROP_MENU_JOIN_ADMIN_HEADER_NAV_BAR_ID("menu_id"),
	DROP_MENU_JOIN_ADMIN_HEADER_NAV_BAR_TITLE("menu_title"),
	
	ADMIN_DROPMENU_DETAILS_ADMIN_HEADER_NAV_BAR_TITLE("nb_title"),
	ADMIN_DROPMENU_DETAILS_ID("dmd_id"),
	ADMIN_DROPMENU_DETAILS_TITLE("dmd_title"),
	ADMIN_DROPMENU_DETAILS_ARTICLE("dmd_article"),
	ADMIN_DROPMENU_DETAILS_IS_USE("dmd_is_use"),
	ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_ID("dm_id"),
	ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_TITLE("dm_title"),
	ADMIN_DROPMENU_DETAILS_ADMIN_DROP_MENU_IS_USE("dm_is_use");
	


	
	private final String value;

	SQLColumn (String value){
		this.value = value;
	}
	public String get() {
		return value;
	}

}
