package ca.http.myservlet.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ca.http.myservlet.dao.exception.AppException;
import ca.http.myservlet.util.ErrorIdGenerator;

public class ExceptionHandlerFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(ExceptionHandlerFilter.class.getName());
	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try {
			arg2.doFilter(arg0, arg1);
		}catch(AppException e) {
			String errorId = ErrorIdGenerator.generate();
			log.info("Application error: " +  e.getMessage() + " ERROR ID: " + errorId);
			e.printStackTrace();
			arg0.setAttribute("errorMessage", e.getMessage());
			arg0.setAttribute("errorID", errorId );
			arg0.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(arg0, arg1);
		}catch(Exception e) {
			String errorId = ErrorIdGenerator.generate();
			log.info("Unexpected error: " +  e.getMessage() + " ERROR ID: " + errorId);
			e.printStackTrace();
			arg0.setAttribute("errorMessage", (e.getMessage()));
			arg0.setAttribute("errorID", errorId );
			arg0.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(arg0, arg1);
		}
		
	}

}
