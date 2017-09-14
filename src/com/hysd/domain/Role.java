package com.hysd.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {//角色
	private Integer rid;	
	private String rname;//	角色名称
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", cts=" + cts
				+ ", merchant=" + merchant + "]";
	}
	private String cts;//	创建时间戳
	private Set<Merchant> merchant = new HashSet<Merchant>();
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts = cts;
	}
	
	public Set<Merchant> getMerchant() {
		return merchant;
	}
	public void setMerchant(Set<Merchant> merchant) {
		this.merchant = merchant;
	}

	

	 
	 
}
