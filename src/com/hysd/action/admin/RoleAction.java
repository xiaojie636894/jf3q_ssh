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
public class RoleAction extends ActionSupport implements ServletRequestAware{
	@Resource
	private RoleService roleService; 
	
	@Resource
	private CmgLogService cmgLogService; 
	
	HttpServletRequest requset;
	private Role role;//已在栈中（有getter,setter才会放到栈里,不用put,页面就可以取到值）
	private Integer pageNo;//当前页码
	private Integer pageSize;//一页几条数据
	private Integer pages;//共多少页
	private Long count;//共多少条数据
	 
	 
	public String list(){
		 
		pageNo=(pageNo==null?1:pageNo);//默认获取第一页
		pageSize=(pageSize==null?Sys.Common.PGGESIZE:pageSize);
		
		PageList<Role> pl=roleService.findAll(role,pageNo,pageSize);
		if(pl!=null){
			ActionContext.getContext().put("list",pl.getList() );
			this.pages=pl.getPages();
			this.count=pl.getCount();
		}
		return "list";
	}
	public String add(){
		return "add";
	}
	public String added(){
		role.setCts(DateUtils.DateTimeToString(new Date()));
		roleService.save(role);
		
		Merchant m=(Merchant) ActionContext.getContext().getSession().get("admin");
		
		CmgLog cl=new CmgLog();
		cl.setCmts(DateUtils.DateTimeToString(new Date()));
		cl.setType(Sys.CmgLog.CREATE);
		cl.setContent(m.getName()+" 添加角色："+role.getRname());
		cmgLogService.save(cl);
		
		return list();
	}
	public String update(){
		if(role.getRid()==null){
			return list();
		}
		role=roleService.getById(role.getRid());
		return "update";
	}
	public String updated(){
		if(role.getRid()!=null){
			Role oldr=roleService.getById(role.getRid());
			oldr.setRname(role.getRname());
			roleService.update(oldr);
			
			Merchant m=(Merchant) ActionContext.getContext().getSession().get("admin");
			
			CmgLog cl=new CmgLog();
			cl.setCmts(DateUtils.DateTimeToString(new Date()));
			cl.setType(Sys.CmgLog.UPDATE);
			cl.setContent(m.getName()+" 修改角色："+role.getRname()+" rid:"+role.getRid());
			cmgLogService.save(cl);
		}
		return list();
	}
	public String delete(){//这个方法还需要完善，如果此角色已经分配了用户，是不可以删除的
		if(role.getRid()!=null){
			Merchant m=(Merchant) ActionContext.getContext().getSession().get("admin");
			
			CmgLog cl=new CmgLog();
			cl.setCmts(DateUtils.DateTimeToString(new Date()));
			cl.setType(Sys.CmgLog.DEL);
			Role oldr=roleService.getById(role.getRid());
			cl.setContent(m.getName()+" 删除角色："+oldr.getRname()+" rid:"+role.getRid());
			cmgLogService.save(cl);
			
			roleService.delete(oldr);
		}
		return list();
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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