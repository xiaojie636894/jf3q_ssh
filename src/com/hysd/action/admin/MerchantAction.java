package com.hysd.action.admin;

 

 
 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.Merchant;
import com.hysd.domain.PageList;
import com.hysd.domain.Role;
import com.hysd.service.MerchantService;
import com.hysd.service.RoleService;
import com.hysd.util.DateUtils;
import com.hysd.util.UpFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class MerchantAction extends ActionSupport implements ServletRequestAware{
	
	HttpServletRequest requset;
	@Resource
	MerchantService merchantService;
	@Resource
	RoleService roleService;

	//上传文件   
    private File file;   
    private Merchant merchant;   
    private Integer pageNo;//当前页码

	private Integer pageSize;//一页几条数据
	private Long count;//总的记录数
	private Integer pages;//总的页数

	public String info(){
		return "info";
	}
	
	/**
	 * 添加Merchant之前
	 * 查询所有Role
	 * 跳转到添加页面
	 * @return
	 */
	public String addPre(){
		List<Role> roles = roleService.getList();
		ActionContext.getContext().put("roles", roles);
		return "addPre";
	}
	
	/**
	 * 添加Merchant
	 * @return
	 */
	public String add(){
		merchant.setCts(DateUtils.DateTimeToString(new Date()));
		merchant.setStatus(1);
		merchantService.saveOrUpdate(merchant);
		return "add";
	}
	
	/**
	 * 分页查询所有Merchant
	 * @return
	 */
	public String list(){
		pageNo=(pageNo==null?1:pageNo);
		pageSize=(pageSize==null?Sys.Common.PGGESIZE:pageSize);
		PageList<Merchant> pl = merchantService.findAll(merchant,pageNo,pageSize);
		if(pl != null){
			ActionContext.getContext().put("merLists", pl.getList());
			this.count = pl.getCount();
			this.pages = pl.getPages();
		}
		return "list";
	}
	
	/**
	 * 修改Merchant之前
	 * 先通过mid查merchant
	 * 然后跳转到修改页面
	 * @return
	 */
	public String editPre(){
		if(merchant.getMid() == null){
			return list();
		}
		merchant = merchantService.findById(merchant.getMid());
		List<Role> lists = roleService.getList();
		ActionContext.getContext().put("lists", lists);
		return "editPre";
	}
	
	/**
	 * 修改Merchant
	 * 要在下拉列表中显示Role，要先查询Role
	 */
	public String edit(){
		if(merchant.getMid() != null){
			Merchant newMerchant = merchantService.findById(merchant.getMid());
			newMerchant.setName(merchant.getName());
			newMerchant.setMobile(merchant.getMobile());
			newMerchant.setRole(merchant.getRole());
			merchantService.saveOrUpdate(newMerchant);			
		}
		return list();
	}
	
	/**
	 * 查询当前mobile对应的merchant
	 * @return
	 * @throws IOException 
	 */
	public String findByMobile() throws IOException{
		Merchant existMerchant = merchantService.findByMobile(merchant.getMobile());
		//得到response
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		if(existMerchant != null){
			writer.write("yes");
		}else{
			writer.write("no");
		}
		return NONE;
	}
	
	public String uploadface(){
		try {
			if(file!=null){
				String path=UpFile.uploadFile(file);
				if(StringUtils.isNotBlank(path)){
					merchant=(Merchant) ActionContext.getContext().getSession().get("admin");
					UpFile.deleteFile(merchant.getFaceimg());
					merchant.setFaceimg(path);
					merchantService.saveOrUpdate(merchant);
					ActionContext.getContext().getSession().put("admin",merchant);
					
					ActionContext.getContext().put("msg", "头像上传成功！");
				}else{
					ActionContext.getContext().put("msg", "头像上传失败！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "info";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.requset=arg0;
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
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}
	
	public Integer getPages() {
		return pages;
	}
	
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

}