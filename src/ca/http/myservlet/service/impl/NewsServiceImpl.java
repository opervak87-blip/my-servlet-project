package ca.http.myservlet.service.impl;

import java.util.List;

import ca.http.myservlet.bean.News;
import ca.http.myservlet.dao.DAOProvider;
import ca.http.myservlet.dao.NewsDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.service.NewsService;

public class NewsServiceImpl implements NewsService {

	private final NewsDAO newsDAO;

	public NewsServiceImpl(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public List<News> getAll() {
		return newsDAO.getAll();
	}

}
