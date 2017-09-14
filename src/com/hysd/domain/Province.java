package com.hysd.domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 省份的实体类
 * @author jf3q.com
 */
public class Province {

	private Integer provinceId;
	private String provinceName;
	//设置后:不把Country进行json转换
	@JSONField(serialize=false)
	private Country country;//一对一：一个省份对应一个国家
	
	//设置后:不把set集合进行json转换,也就不会导致死循环（province查询city，city查province）
	@JSONField(serialize=false)
	Set<City> cities = new HashSet<City>();//一对多：一个省份对应多个城市 
	
	
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName="
				+ provinceName + "]";
	}
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
