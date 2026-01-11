package ca.http.myservlet.service.impl;

import java.util.List;
import java.util.logging.Logger;

import ca.http.myservlet.bean.Province;
import ca.http.myservlet.dao.ProvinceDAO;
import ca.http.myservlet.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
	
	private static final Logger log = Logger.getLogger(ProvinceServiceImpl.class.getName());
	private final ProvinceDAO provinceDAO;

	public ProvinceServiceImpl(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	@Override
	public List<Province> getAll() {
		return provinceDAO.getAll();
	}

}
