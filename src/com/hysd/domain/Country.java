package com.hysd.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 国家的实体类
 * @author jf3q.com
 */
public class Country {

	private Integer countryId;
	private String countryName;
	private Set<Province> provinces = new HashSet<Province>();//一对多，一个国家对应多个城市
	
	public Set<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
