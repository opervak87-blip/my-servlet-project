package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.News;
import ca.http.myservlet.bean.Province;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.ProvinceDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;
import ca.http.myservlet.util.ResultSetMapper;

public class ProvinceDAOImpl implements ProvinceDAO{
	
	private static final Logger log = Logger.getLogger(ProvinceDAOImpl.class.getName());
	private final ConnectionPool pool;

	public ProvinceDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<Province> getAll() {
		
		List<Province> provinceList = new ArrayList<Province>();
		try (Connection con = pool.getConnection();
				PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_PROVINCE_ID.get());
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Province province = new Province.Builder()
						.id(ResultSetMapper.getInt(rs, SQLColumn.ID.get()))
						.nameOfProvince(ResultSetMapper.getString(rs, SQLColumn.PROVINCE_NAME_PROVINCE.get()))
						.shortNameOfProvince(ResultSetMapper.getString(rs,SQLColumn.PROVINCE_SHORT_NAME_PROVINCE.get()))
						.build();
				provinceList.add(province);
			}
		} catch (InterruptedException | SQLException e) {
			log.info("Error while fetching province : " + e.getMessage());
			 throw new DAOException("Unable to fetch province", e);
		} 
		return provinceList;
	}

}
