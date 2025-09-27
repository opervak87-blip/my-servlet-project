package ca.http.myservlet.config;

public enum AppConstants {

	CONNECTION_POOL("Pool Connection"), 
	NEWS ("news");

	private final String value;

	AppConstants (String value){
		this.value = value;
	}
	public String get() {
		return value;
	}
}
