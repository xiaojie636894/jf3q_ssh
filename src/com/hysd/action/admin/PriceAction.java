package com.hysd.action.admin;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.PageList;
import com.hysd.domain.Price;
import com.hysd.service.PriceService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 单价的控制层
 * @author jf3q.com
 *
 */
@Controller
public class PriceAction extends ActionSupport implements ServletRequestAware{

	@Resource
	private PriceService priceService;
	private Integer pageNo;
	private Integer pageSize;
	private Price price;
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

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	HttpServletRequest requset;
	public void setServletRequest(HttpServletRequest arg0) {
		this.requset = arg0;
	}
	
	/**
	 * 分页查询所有商品单价
	 * @return
	 */
	public String list(){
		pageNo = (pageNo==null?1:pageNo);
		pageSize = (pageSize==null?Sys.Common.PGGESIZE:pageSize);
		//分页查询单价
		PageList<Price> pl = priceService.findAll(pageNo, pageSize, price);
		if(pl != null){
			requset.setAttribute("prices", pl.getList());
			this.count = pl.getCount();
			this.pages = pl.getPages();
		}
		return "list";
	}
	
	/**
	 * 添加前跳转到添加页面
	 */
	public String addPre(){
		return "addPre";
	}
	
	/**
	 * 添加商品单价
	 */
	public String add(){
		priceService.saveOrUpdate(price);
		return "add";
	}
	
	/**
	 * 跳转到更新页面
	 * 通过pid查询price，显示到更新页面
	 */
	public String updatePre(){
		price = priceService.findById(price.getPid());
		return "updatePre";
	}
	
	/**
	 * 更新商品单价
	 */
	public String update(){
		if(price.getPid() != null){
			Price newPrice = priceService.findById(price.getPid());	
			newPrice.setPname(price.getPname());
			newPrice.setPriceUnit(price.getPriceUnit());
			priceService.saveOrUpdate(newPrice);
		}
		return "update";
	}
	
	/**
	 * 删除商品
	 */
	public String delete(){
		if(price.getPid() != null){
			priceService.delete(priceService.findById(price.getPid()));
		}
		return "delete";
	}
	
}






