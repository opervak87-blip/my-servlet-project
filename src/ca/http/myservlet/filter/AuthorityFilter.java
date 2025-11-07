package ca.http.myservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.User;
import ca.http.myservlet.config.AppConstants;

public class AuthorityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpRespose = (HttpServletResponse) response;
		
		User user = (User) httpRequest.getSession().getAttribute(AppConstants.USER.get());
		
		if (user == null) {
			httpRespose.sendRedirect(httpRequest.getContextPath() + "/Controller?command=goToIndexPage");
			return;
		}
		
		chain.doFilter(httpRequest, httpRespose);
		
	}

}
