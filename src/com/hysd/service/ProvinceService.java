package com.hysd.service;

import java.util.List;

import com.hysd.domain.Province;

public interface ProvinceService {

	List<Province> findProvinceByCountryId(Integer countryId);

}
