package ca.http.myservlet.dao.exception;

public class DAOException extends AppException {

	private static final long serialVersionUID = 1L;
	
	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
