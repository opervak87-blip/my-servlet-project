package ca.http.myservlet.util;

import java.util.UUID;

public class ErrorIdGenerator {
	
	 public static String generate() {
	        return UUID.randomUUID().toString().substring(0, 8); // short ID
	    }

}
