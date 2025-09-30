package ca.http.myservlet.util;

import ca.http.myservlet.bean.AdminDropmenuDetails;
import ca.http.myservlet.bean.BreadcrumbTrail;

public class BreadcrumbHelper {
	
	public static BreadcrumbTrail home() {
		BreadcrumbTrail trail = new BreadcrumbTrail();
		trail.add("Home", "/Controller?command=gotoIndexPage");
		return trail;
	}
	
	public static BreadcrumbTrail dropMenu(AdminDropmenuDetails adminDropmenuDetails) {
		BreadcrumbTrail trail = home();
		trail.add(adminDropmenuDetails.getAdminDropMenu().getAdminHeaderNavBar().getTitle(), "/Controller?command=gotoIndexPage");
		return trail;
	}

}
