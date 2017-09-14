package com.hysd.action.admin;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.Directory;
import com.hysd.domain.PageList;
import com.hysd.service.DirectoryService;
import com.hysd.util.DateUtils;
import com.hysd.util.UpFile;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class DirectoryAction extends ActionSupport implements ServletRequestAware{
	
	@Resource
	private DirectoryService directoryService; 
	private Directory directory;
	private Integer pageNo;//当前页
	private Integer pageSize;//每页记录数
	private Integer pages;//总页数
	private Long count;//总记录数
	
	private File file;//要上传的文件
	private String fileFileName;//上传文件名称
	
	

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * 按条件分页查询所有一级目录
	 * @return
	 */
	public String list(){
		pageNo = (pageNo==null?1:pageNo);
		pageSize = (pageSize==null?Sys.Common.PGGESIZE:pageSize);
		PageList<Directory> pl = directoryService.findAll(pageNo, pageSize, directory);
		if(pl != null){
			requset.setAttribute("directorys", pl.getList());
			this.count = pl.getCount();
			this.pages = pl.getPages();
		}
		return "list";
	}
	
	/**
	 * 添加一级目录前提交到添加页面
	 * @return
	 */
	public String addPre(){
		return "addPre";
	}
	 
	/**
	 * 添加or修改一级目录
	 * @return
	 */
	public String addOrUpdate(){
		//获取文件上传的路径
		String path = uploadFile();
		//修改时:
		if(directory.getDid() != null){
			Directory newDirectory = directoryService.findByDid(directory.getDid());
			newDirectory.setCname(directory.getCname());
			newDirectory.setOrderby(directory.getOrderby());
			newDirectory.setLinkUrl(directory.getLinkUrl());
			newDirectory.setImgPath(path);
			directoryService.saveOrUpdate(newDirectory);
		}else{
		//添加时:
			directory.setCts(DateUtils.DateToString(new Date()));//将创建时间set进去
			directory.setStatus(1);//设置为开启状态
			directory.setImgPath(path);
			directoryService.saveOrUpdate(directory);
		}
		return "addOrUpdate";
	}
	
	/**
	 * 上传文件
	 */
	public String uploadFile(){
		try {
			if(fileFileName!=null){
				String path = UpFile.uploadFile(file);    //  /upImgs/xxx.img
				return path;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	
	/**
	 * 修改一级目录前之前
	 * 通过did查询指定一级目录
	 * 跳转到修改页面
	 * @return
	 */
	public String updatePre(){
		if(directory.getDid() == null){
			return list();
		}
		directory = directoryService.findByDid(directory.getDid());
		return "updatePre";
	}
	
	
	public Directory getDirectory() {
		return directory;
	}
	
	public void setDirectory(Directory directory) {
		this.directory = directory;
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
	
	HttpServletRequest requset;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.requset=arg0;
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
	 
}