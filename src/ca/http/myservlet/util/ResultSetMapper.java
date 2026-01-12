package ca.http.myservlet.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetMapper {
	
	public static String getString(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName);
		return value != null ? value : "";
	}
	
	public static int  getInt(ResultSet rs, String columnName) throws SQLException {
		Integer value = rs.getInt(columnName);
		return value != null ? value : 0;
	}
	
	public static boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
		Boolean value = rs.getBoolean(columnName);
		return value != null ? value : false;
	}

}
