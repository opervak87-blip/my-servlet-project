package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.News;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.NewsDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;

public class NewsDAOImpl implements NewsDAO {
	
	private static final Logger log = Logger.getLogger(NewsDAOImpl.class.getName());
	private final ConnectionPool pool;

	public NewsDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<News> getAll() {
		List<News> newsList = new ArrayList<News>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_NEWS.get());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				News news = new News.Builder()
						.id(rs.getInt(SQLColumn.ID.get()))
						.title(rs.getString(SQLColumn.NEWS_TITLE.get()))
						.article(rs.getString(SQLColumn.NEWS_ARTICLE.get()))
						.createdAt(rs.getDate(SQLColumn.NEWS_CREATED_AT.get()))
						.build();
				newsList.add(news);
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching news : " );
			e.printStackTrace();
			 throw new DAOException("Unable to fetch news", e);
		} 
		return newsList;
	}
}
