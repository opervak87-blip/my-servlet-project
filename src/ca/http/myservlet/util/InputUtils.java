package ca.http.myservlet.util;

import java.util.logging.Logger;

public class InputUtils {

	private static final Logger log = Logger.getLogger(InputUtils.class.getName());

	public static String trim(String input) {
		return input != null ? input.trim() : "";
	}

	public static int stringToInt(String input) {
		int output = 1;

		try {
			output = Integer.parseInt(input);
			return output;
		} catch (NumberFormatException e) {
			log.warning("throw NumberFormatException : " + input);
		}

		return output;
	}

}
