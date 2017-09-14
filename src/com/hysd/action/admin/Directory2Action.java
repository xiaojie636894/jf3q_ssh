package com.hysd.action.admin;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.Directory;
import com.hysd.domain.Directory2;
import com.hysd.domain.PageList;
import com.hysd.service.Directory2Service;
import com.hysd.service.DirectoryService;
import com.hysd.util.DateUtils;
import com.hysd.util.FastJsonUtil;
import com.hysd.util.UpFile;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class Directory2Action extends ActionSupport implements ServletRequestAware{
	
	@Resource
	private Directory2Service directory2Service; 
	@Resource
	private DirectoryService directoryService;

	private Directory2 directory2;
	private Directory directory;
	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
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
	 * 按条件分页查询所有二级目录
	 * @return
	 */
	public String list(){
		pageNo = (pageNo==null?1:pageNo);//初始化当前页
		pageSize = (pageSize==null?Sys.Common.PGGESIZE:pageSize);//初始化每页记录数
		PageList<Directory2> pl = directory2Service.findAll(pageNo, pageSize, directory2);//directory2：带条件
		System.out.println(directory2);
		if(pl != null){
			requset.setAttribute("directory2s", pl.getList());
			this.count = pl.getCount();
			this.pages = pl.getPages();
		}
		return "list";
	}
	
	/**
	 * 删除二级目录
	 */
	public String delete(){
		directory2Service.delete(directory2Service.findById(directory2.getDdid()));
		System.out.println(directory2);
		return list();
	}
	
	/**
	 * 添加前跳转到添加页面
	 * 并查询所有一级目录（为了在新增二级目录页面中以下拉框形式显示）
	 * @return
	 */
	public String addPre(){
		List<Directory> directories = findAll();
		requset.setAttribute("directories", directories);
		return "addPre";
	}
	
	/**
	 * 查询所有一级目录
	 * @return
	 */
	public List<Directory> findAll(){
		return directoryService.findAll();
	}
	
	/**
	 * 增加二级目录
	 * @return
	 */
	public String add(){
		directory2Service.add(directory2);
		return "add";
	}
	
	/**
	 * 修改之前跳转到修改页面
	 * 按照ddid查询二级目录
	 * @return
	 */
	public String updatePre(){
		directory2 = directory2Service.findById(directory2.getDdid());
		List<Directory> directories = findAll();
		requset.setAttribute("directories", directories);
		return "updatePre";
	}
	
	/**
	 * 修改二级目录
	 * @return
	 */
	public String update(){
		if(directory2.getDdid() != null){
			Directory2 newDirectory2 = directory2Service.findById(directory2.getDdid());
			newDirectory2.setCname(directory2.getCname());
			newDirectory2.setOrderby(directory2.getOrderby());
			newDirectory2.setDirectory(directory2.getDirectory());
			directory2Service.add(newDirectory2);
		}
		return "update";
	}
	
	/**
	 * 通过一级目录did查询二级目录
	 * @return
	 */
	public String findDirectory2ByDid(){
		
		List<Directory2> directory2s = directory2Service.findDirectory2ByDid(directory.getDid());
		String jsonString = FastJsonUtil.toJSONString(directory2s);
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);

		return NONE;
	}
	
	
	public Directory2 getDirectory2() {
		return directory2;
	}
	public void setDirectory2(Directory2 directory2) {
		this.directory2 = directory2;
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