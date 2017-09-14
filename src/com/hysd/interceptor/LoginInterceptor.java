package com.hysd.interceptor;

import com.hysd.domain.Merchant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor  implements  Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("登陆拦截，开始-------------"); 
		
		String className=arg0.getProxy().getConfig().getClassName();
		String method=arg0.getProxy().getMethod();
		
		
		if(className.contains("admin")){
			//进入的是后台的action
			if(!method.equals("login")&&!method.equals("loginIn")){
				//不需要拦截的方法login，loginIn
				Merchant m=(Merchant) ActionContext.getContext().getSession().get("admin");
				if(m==null){
					System.out.println("登陆拦截，被拦截--admin-----------"); 
					return "login";
				}
			}
		}else if(className.contains("front")){
			//进入的是前台的action 
		}
		System.out.println("登陆拦截，结束-------------"); 
		return arg0.invoke();
	}

//	@Override
//	protected String doIntercept(ActionInvocation arg0) throws Exception {
//		System.out.println("登陆拦截，开始-------------");
//        Object loginUserName = ;  
//        System.out.println(arg0.);
////        if(null == loginUserName){  
////            return "login";  // 这里返回用户登录页面视图  
////        } 
//        System.out.println("登陆拦截，结束-------------");
//        return arg0.invoke();   
//		 
//	}

	 

	 
	 
	 

}
