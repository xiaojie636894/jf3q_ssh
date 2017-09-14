package com.hysd.action.front;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hysd.domain.Directory;
import com.hysd.service.DirectoryService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction  extends ActionSupport {
	@Resource
	private DirectoryService directoryService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	
	public String index() {
		List<Directory> dli=directoryService.findAllList();
		request.setAttribute("dli", dli);
		return "index";
	}
}
