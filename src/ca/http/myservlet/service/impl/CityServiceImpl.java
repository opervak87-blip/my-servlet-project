package ca.http.myservlet.service.impl;

import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.City;
import ca.http.myservlet.dao.CityDAO;
import ca.http.myservlet.service.CityService;
import ca.http.myservlet.util.InputUtils;

public class CityServiceImpl implements CityService {
	
	private static final Logger log = Logger.getLogger(CityServiceImpl.class.getName());
	private final CityDAO cityDAO;

	public CityServiceImpl(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	@Override
	public List<City> getAllByProvinceId(String provinceId) {
		int id = InputUtils.stringToInt(provinceId);
		return cityDAO.getAllByProvinceId(id);
	}

}
