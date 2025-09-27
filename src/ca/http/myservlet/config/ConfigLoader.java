package ca.http.myservlet.config;

import java.util.ResourceBundle;

public class ConfigLoader {

	private  static ConfigLoader instance ;

	private ResourceBundle bundle = ResourceBundle.getBundle("ca.http.myservlet.config.config");

	public static ConfigLoader getInstance() {
		return instance = new ConfigLoader();
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}

}
