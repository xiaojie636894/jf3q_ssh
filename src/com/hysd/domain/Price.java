package com.hysd.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 商品单价的实体类
 * @author jf3q.com
 *
 */
public class Price {

	private Double priceUnit;//单价单位
	private Integer pid;//id
	private String pname;//单位名称
	private Set<Goods> goods = new HashSet<Goods>();//单价为一方，关联商品
	
	public Set<Goods> getGoods() {
		return goods;
	}
	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	public Double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(Double priceUnit) {
		this.priceUnit = priceUnit;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
}
