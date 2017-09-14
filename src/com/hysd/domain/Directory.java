package com.hysd.domain;

import java.util.HashSet;
import java.util.Set;

public class Directory {//一级目录
	private Integer did;
	private String cname;//	目录名称
	private String cts;//	创建时间
	private Integer status;//	1启用，0禁用
	private Integer orderby;//	排序，倒序
	private String imgPath;//横幅图片路径
	private String linkUrl;//图片跳转路径
	private Set<Directory2> directory2 = new HashSet<Directory2>();
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String getCts() {
		return cts;
	}
	public void setCts(String cts) {
		this.cts = cts;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public Set<Directory2> getDirectory2() {
		return directory2;
	}
	public void setDirectory2(Set<Directory2> directory2) {
		this.directory2 = directory2;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
}
