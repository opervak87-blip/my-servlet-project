package ca.http.myservlet.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadcrumbTrail {
	
	private final List<Breadcrumb> crumbs = new ArrayList<Breadcrumb>();
	 
	public void add(String label, String url) {
		crumbs.add(new Breadcrumb.Builder().label(label).url(url).build());
	}

	 public List<Breadcrumb> getCrumbs() {
	        return Collections.unmodifiableList(crumbs);
	    }
}
