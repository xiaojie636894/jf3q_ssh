package com.hysd.action.admin;

 

import java.util.Date;

import javax.annotation.Resource;
 

import org.springframework.stereotype.Controller;

import com.hysd.cons.Sys;
import com.hysd.domain.CmgLog;
import com.hysd.domain.Merchant;
import com.hysd.service.CmgLogService;
import com.hysd.service.MerchantService;
import com.hysd.util.DateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	 
	@Resource
	private MerchantService merchantService;
	
	@Resource
	private CmgLogService cmgLogService;

	private Merchant merchant;
	 
	
	public String login(){
		return "login";
	}
	
	public String loginIn(){
		Merchant mer=merchantService.findForLogin(merchant);
		if(mer==null){
			//返回值放入struts2的栈中，传给前台
			ActionContext.getContext().put("msg", "账号密码错误，请联系管理员");
			return "login"; 
		}else{
			if(mer.getStatus()==Sys.Common.IS_USE){
				if(mer.getRole()!=null){
					mer.setRname(mer.getRole().getRname());//session关闭，暂存此字段中
				}
				//登录信息放入session中
				ActionContext.getContext().getSession().put("admin", mer);
				
				//添加日志信息
				CmgLog cl=new CmgLog();
				cl.setCmts(DateUtils.DateTimeToString(new Date()));
				cl.setType(Sys.CmgLog.LOGIN);
				cl.setContent(mer.getName()+" 登录系统");
				cmgLogService.save(cl);
				return "loginin"; 
			}else{
				ActionContext.getContext().put("msg", "此账号被禁用");
				return "login"; 
			}
		}
		
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	 

	
	 
}