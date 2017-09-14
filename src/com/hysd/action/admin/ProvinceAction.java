package com.hysd.action.admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;








import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.hysd.domain.Country;
import com.hysd.domain.Province;
import com.hysd.service.ProvinceService;
import com.hysd.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 国家，省份，市区的控制器类
 * @author jf3q.com
 */
@Controller
public class ProvinceAction extends ActionSupport implements ServletRequestAware{

	@Resource
	private ProvinceService provinceService;
	private Country country;
	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	/**
	 * 通过CountryId查询省份
	 * @return
	 * @throws IOException 
	 */
	public String findProvinceByCountryId() throws IOException{
		
		List<Province> provinces = provinceService.findProvinceByCountryId(country.getCountryId());

		//禁止province对于city和country得关联查询转json串后，这里是json串，而不是二维数组
		String jsonString = FastJsonUtil.toJSONString(provinces);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		
		return NONE;
	}
	
	
	
	
}
