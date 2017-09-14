package com.hysd.action.admin;

import java.util.Date;
 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.CmgLog;
import com.hysd.domain.Merchant;
import com.hysd.domain.PageList;
import com.hysd.domain.Role;
import com.hysd.service.CmgLogService;
import com.hysd.service.RoleService;
import com.hysd.util.DateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class CmgLogAction extends ActionSupport implements ServletRequestAware{
	
	@Resource
	private CmgLogService cmgLogService; 
	
	HttpServletRequest requset;
	private CmgLog cmgLog;//已在栈中（有getter,setter才会放到栈里,不用put,页面就可以取到值）
	private Integer pageNo;//当前页码
	private Integer pageSize;//一页几条数据
	private Integer pages;//共多少页
	private Long count;//共多少条数据
	 
	 
	public String list(){
		 
		pageNo=(pageNo==null?1:pageNo);//默认获取第一页
		pageSize=(pageSize==null?Sys.Common.PGGESIZE:pageSize);
		
		PageList<CmgLog> pl=cmgLogService.findAll(cmgLog,pageNo,pageSize);
		if(pl!=null){
			ActionContext.getContext().put("list",pl.getList() );
			this.pages=pl.getPages();
			this.count=pl.getCount();
		}
		return "list";
	}
	
	public CmgLog getCmgLog() {
		return cmgLog;
	}

	public void setCmgLog(CmgLog cmgLog) {
		this.cmgLog = cmgLog;
	}

	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.requset=arg0;
	}
	 

	
	 
}