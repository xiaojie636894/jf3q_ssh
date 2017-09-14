package com.hysd.action.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.hysd.domain.City;
import com.hysd.domain.Province;
import com.hysd.service.CityService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * City的控制器类
 * @author jf3q.com
 */
@Controller
public class CityAction extends ActionSupport implements ServletRequestAware{

	
	@Resource
	private CityService cityService;
	private Province province;

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	/**
	 * 根据指定provinceId查询city
	 * @return
	 */			 
	public String findCityByProvinceId(){
		
		List<City> cities = cityService.findCityByProvinceId(province.getProvinceId());
		String jsonString = JSON.toJSONString(cities);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	
}
