package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.Address;
import ca.http.myservlet.bean.City;
import ca.http.myservlet.bean.OperationResult;
import ca.http.myservlet.bean.Province;
import ca.http.myservlet.bean.User;
import ca.http.myservlet.bean.UserDetail;
import ca.http.myservlet.bean.dto.factory.FactoryBean;
import ca.http.myservlet.bean.dto.factory.FactoryDTO;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;
import ca.http.myservlet.service.impl.UserServiceImpl;
import ca.http.myservlet.util.InputUtils;
import ca.http.myservlet.util.PasswordUtils;

public class SaveNewUser implements Command {
	
	private static final Logger log = Logger.getLogger(SaveNewUser.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {

		ServiceProvider provider = (ServiceProvider) context;
		
		User user = FactoryBean.toUser(FactoryDTO.toRegistrationRequestDTO(request));
		
		OperationResult<Void>  saveUser = provider.getUserService().saveUser(user);

		if (saveUser.isSuccessful()) {
			response.sendRedirect(request.getContextPath() + "/Controller?command=goToLoginPage&message=success");
		} else {
			response.sendRedirect(request.getContextPath() + "/Controller?command=GoToRegistrationPage&message=error&details=" + saveUser.getMessage());
		}
	}
}
