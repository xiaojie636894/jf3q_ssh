package com.hysd.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.Country;
import com.hysd.service.CountryService;

@Transactional
@Service("countryService")
public class CountryServiceImpl implements CountryService{

	@Resource
	private BaseDAO<Country> baseDAO;
	
	/**
	 * 查询所有国家
	 */
	public List<Country> findAll() {
		return baseDAO.find("from Country");
	}

}
