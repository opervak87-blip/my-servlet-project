package ca.http.myservlet.dao.exception;

public class ServiceException extends AppException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
