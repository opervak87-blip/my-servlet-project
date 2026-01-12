package ca.http.myservlet.service;

import java.util.List;

import ca.http.myservlet.bean.City;

public interface CityService {
	
	List<City> getAllByProvinceId(String provinceId);
	List<City> getAll();

}
