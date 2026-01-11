package ca.http.myservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.City;
import ca.http.myservlet.config.SQLColumn;
import ca.http.myservlet.config.SQLQuery;
import ca.http.myservlet.dao.CityDAO;
import ca.http.myservlet.dao.connectionpool.ConnectionPool;
import ca.http.myservlet.dao.exception.DAOException;
import ca.http.myservlet.util.ResultSetMapper;

public class CityDAOImpl  implements CityDAO{
	
	private static final Logger log = Logger.getLogger(CityDAOImpl.class.getName());
	private final ConnectionPool pool;

	public CityDAOImpl(ConnectionPool pool) {
		this.pool = pool;
	}

	@Override
	public List<City> getAllByProvinceId(int provinceId) {

		List<City> cityList = new ArrayList<>();
		
		try(Connection con = pool.getConnection(); PreparedStatement ps = con.prepareStatement(SQLQuery.GET_CITY_BY_PROVINCE_ID.get())){
			ps.setInt(1, provinceId);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					City city = new City.Builder().id(ResultSetMapper.getInt(rs, SQLColumn.ID.get()))
							.nameOfCity(ResultSetMapper.getString(rs, SQLColumn.PROVINCE_NAME_PROVINCE.get()))
							.build();
					cityList.add(city);
				}
			}
		} 
		catch (SQLException | InterruptedException e) {
			log.warning("Error while fetching city : " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Unable to fetch city", e);
		}
		return null;
	}

}
