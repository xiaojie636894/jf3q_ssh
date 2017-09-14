package com.hysd.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.City;
import com.hysd.service.CityService;

@Transactional
@Service("cityService")
public class CityServiceImpl implements CityService {

	@Resource
	private BaseDAO<City> baseDAO;

	/**
	 * 根据指定provinceId查询city
	 */
	public List<City> findCityByProvinceId(Integer provinceId) {
		
		List<City> cities = baseDAO.find("from City where provinceId = ?", new Object[]{provinceId});
		return cities;
	}
	
	
}
