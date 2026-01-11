package ca.http.myservlet.dao;

import java.util.List;

import ca.http.myservlet.bean.City;

public interface CityDAO {
	
	List<City> getAllByProvinceId(int provinceId);

}
