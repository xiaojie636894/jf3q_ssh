package com.hysd.domain;

import org.junit.Ignore;

import net.sf.ehcache.pool.sizeof.annotations.IgnoreSizeOf;

public class Merchant {//后台客服
	private Integer mid	;
	private String mobile	;//登陆账号，手机号
	private String pwd	;//密码
	private String name;	//真实名字
	private Integer status;	//1启用，0禁用
	private String faceimg;//	头像
	private String cts;//创建时间
	private Role role;
	
	@IgnoreSizeOf
	private String rname;//角色名称，数据库将忽略此字段
	 
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getFaceimg() {
		return faceimg;
	}
	public void setFaceimg(String faceimg) {
		this.faceimg = faceimg;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
	 
	 
	@Override
	public String toString() {
		return "Merchant [mid=" + mid + ", mobile=" + mobile + ", pwd=" + pwd
				+ ", name=" + name + ", status=" + status + ", faceimg="
				+ faceimg + ", cts=" + cts + ", role=" + role + ", rname="
				+ rname + "]";
	}
	
	

}
