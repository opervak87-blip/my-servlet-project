package ca.http.myservlet.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.service.impl.UserServiceImpl;

public class AuthorityFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(AuthorityFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpRespose = (HttpServletResponse) response;
		
		 String uri = httpRequest.getRequestURI();
		 String command = httpRequest.getParameter("command");
		 
		 log.info ("URI : " + uri + "  COMMAND : " + command);
		
		if (!uri.contains("user")) {
		        chain.doFilter(request, response);
		        return;
		    }

		User user = (User) httpRequest.getSession().getAttribute(AppConstants.USER.get());

		if (user == null) {
			httpRespose.sendRedirect(httpRequest.getContextPath() + "/Controller?command=goToIndexPage");
			return;
		} 
			chain.doFilter(request, response);
		
	}

}
