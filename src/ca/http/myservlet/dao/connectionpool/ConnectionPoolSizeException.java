package ca.http.myservlet.dao.connectionpool;

public class ConnectionPoolSizeException extends Exception {
	private static final long serialVersionUID = 1L;

	public ConnectionPoolSizeException(String message, Exception e) {
		super(message, e);
	}

}
