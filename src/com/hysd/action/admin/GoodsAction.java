package com.hysd.action.admin;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.Country;
import com.hysd.domain.Directory;
import com.hysd.domain.Directory2;
import com.hysd.domain.Goods;
import com.hysd.domain.PageList;
import com.hysd.domain.Price;
import com.hysd.service.CountryService;
import com.hysd.service.Directory2Service;
import com.hysd.service.DirectoryService;
import com.hysd.service.GoodsService;
import com.hysd.service.PriceService;
import com.hysd.util.UpFile;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品的控制器类
 * @author jf3q.com
 *
 */
@Controller
public class GoodsAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	@Resource
	private GoodsService goodsService;
	@Resource
	private PriceService priceService;
	@Resource
	private Directory2Service directory2Service;
	@Resource
	private DirectoryService directoryService;
	public Directory2 getDirectory2() {
		return directory2;
	}

	public void setDirectory2(Directory2 directory2) {
		this.directory2 = directory2;
	}
	@Resource
	private CountryService countryService;
	
	private Goods goods;
	private Directory2 directory2;
	//封装上传文件的属性
	private File[] uploads;
	//封装上传文件的类型
	private String[] uploadContentType;
	//封装上传文件的名称
	private String[] uploadFilename;
	
	private Integer pageNo;//当前页
	private Integer pageSize;//每页记录数
	private Long count;//总记录数
	private Integer pages;//总页数
	
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

	public File[] getUploads() {
		return uploads;
	}

	public void setUploads(File[] uploads) {
		this.uploads = uploads;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFilename() {
		return uploadFilename;
	}

	public void setUploadFilename(String[] uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * 按条件分页查询查询所有商品
	 * 并查询一级目录
	 * @return
	 */
	public String list(){
		
		pageNo = (pageNo==null?1:pageNo);
		pageSize = (pageSize==null?Sys.Common.PGGESIZE:pageSize);
		PageList<Goods> pl = goodsService.findAll(goods, pageNo, pageSize);
		if(pl != null){
			this.count = pl.getCount();
			this.pages = pl.getPages();
			request.setAttribute("goodss", pl.getList());
		}
		List<Directory> directories = directoryService.findAll();
		request.setAttribute("directories", directories);
		if(goods != null){  //goods商品为null就return
			if(goods.getDirectory2() != null){
				if(goods.getDirectory2().getDdid() != null){
				directory2 = directory2Service.findDirectory2ByDdid(goods.getDirectory2().getDdid());
				}
			}
		}
		return "list";
	}
	
public String list1(){
		
		pageNo = (pageNo==null?1:pageNo);
		pageSize = (pageSize==null?Sys.Common.PGGESIZE:pageSize);
		PageList<Goods> pl = goodsService.findAll(goods, pageNo, pageSize);
		if(pl != null){
			this.count = pl.getCount();
			this.pages = pl.getPages();
			request.setAttribute("goodss", pl.getList());
		}
		List<Directory> directories = directoryService.findAll();
		request.setAttribute("directories", directories);
		if(goods != null){  //goods商品为null就return
			if(goods.getDirectory2() != null){
				if(goods.getDirectory2().getDdid() != null){
				directory2 = directory2Service.findDirectory2ByDdid(goods.getDirectory2().getDdid());
				}
			}
		}
		return "list";
	}
	
	/**
	 * 添加前跳转到添加页面
	 * 查询一级目录，单价单位，所有国家
	 * @return
	 */
	public String addPre(){
		
		List<Price> prices = priceService.findAll();
		request.setAttribute("prices", prices);
		
		List<Directory> directorys = directoryService.findAll();
		request.setAttribute("directorys", directorys);
		
		List<Country> countries = countryService.findAll();
		request.setAttribute("countries", countries);
		
		return "addPre";
	}

	/**
	 * 添加商品
	 * @return
	 */
	public String add(){
		String path = "";
		if(uploads != null){
			for (int i = 0; i < uploads.length; i++) {
				try {
					if(uploads[i] != null){
						path += UpFile.uploadFile(uploads[i]);
						if(i != uploads.length-1){
							path += "/";
						}else{
							goods.setImg(path);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}
		goodsService.saveOrUpdate(goods);
		return "add";
	}

}
