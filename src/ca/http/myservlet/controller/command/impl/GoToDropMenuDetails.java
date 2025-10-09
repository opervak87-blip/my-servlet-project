package ca.http.myservlet.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.bean.AdminDropmenuDetails;
import ca.http.myservlet.bean.AdminHeaderNavBar;
import ca.http.myservlet.bean.Breadcrumb;
import ca.http.myservlet.bean.BreadcrumbTrail;
import ca.http.myservlet.config.AppConstants;
import ca.http.myservlet.controller.command.Command;
import ca.http.myservlet.service.ServiceProvider;
import ca.http.myservlet.util.BreadcrumbHelper;

public class GoToDropMenuDetails implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Object context)
			throws ServletException, IOException {

		ServiceProvider provider = (ServiceProvider) context;
		String id = request.getParameter("id");

		if (id != null) {
			List<AdminDropmenuDetails> adminDropmenuDetailsList = provider.getAdminDropmenuDetailsService()
					.getAllByAdminDropMenuID(Integer.parseInt(id));
			
			List<Breadcrumb> trail = BreadcrumbHelper.dropMenu(adminDropmenuDetailsList.get(0)).getCrumbs();
			
			request.setAttribute(AppConstants.BREADCRUMBS.get(), trail);
			request.setAttribute(AppConstants.ADMIN_DROP_MENU_DETAILS.get(), adminDropmenuDetailsList);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index_details.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
