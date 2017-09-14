package com.hysd.service;

 
 
import java.util.List;

import com.hysd.domain.Merchant;
import com.hysd.domain.PageList;

 

public interface MerchantService{

	 

	public  Merchant findForLogin(Merchant m);
	public void saveOrUpdate(Merchant m);
	public List<Merchant> findAll();
	public Merchant findById(Integer mid);
	public PageList<Merchant> findAll(Merchant merchant, Integer pageNo,
			Integer pageSize);
	public Merchant findByMobile(String mobile);

}