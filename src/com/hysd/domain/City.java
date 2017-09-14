package com.hysd.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 城市的实体类
 * @author jf3q.com
 */
public class City {

	private Integer cityId;
	private String cityName;
	
	//不把province进行json转换
	@JSONField(serialize=false)
	private Province province;//一对一：一个城市对应一个省份 
	
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
