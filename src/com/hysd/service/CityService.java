/**
 * 
 */
package com.hysd.service;

import java.util.List;

import com.hysd.domain.City;

/**
 * @author jf3q.com
 *
 */
public interface CityService {

	List<City> findCityByProvinceId(Integer provinceId);


}
