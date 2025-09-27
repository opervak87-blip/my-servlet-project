package ca.http.myservlet.service;

import java.util.List;
import ca.http.myservlet.bean.News;

public interface NewsService {
	
	public List<News> getAll();

}
