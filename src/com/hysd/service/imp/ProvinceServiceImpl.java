package com.hysd.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.Province;
import com.hysd.service.ProvinceService;

/**
 * 省份的业务层
 * @author jf3q.com
 */
@Transactional
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService{

	@Resource
	private BaseDAO<Province> baseDAO;
	
	/**
	 * 通过指定countryId查询省份
	 */
	public List<Province> findProvinceByCountryId(Integer countryId) {
//		List<Province> provinces = baseDAO.find("select p.provinceId, p.provinceName from Province p where countryId = ?", new Object[]{countryId});
		
//		有关联关系，会把city查询出来。在Province添加注解使之不将city进行解析
		List<Province> provinces = baseDAO.find("from Province where countryId = ?", new Object[]{countryId});
		return provinces;
	}

}
