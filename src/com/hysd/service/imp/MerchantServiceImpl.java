package com.hysd.service.imp;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.Merchant;
import com.hysd.domain.PageList;
import com.hysd.domain.Role;
import com.hysd.service.MerchantService;

@Transactional //启用事务机制
@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

	@Resource
	private BaseDAO<Merchant> baseDAO;

	@Override
	public Merchant findForLogin(Merchant m) {
		Merchant mer=baseDAO.get("from Merchant where mobile=? and pwd=?", 
				new Object[]{m.getMobile(),m.getPwd()}); 
		return mer;
	}

	public void saveOrUpdate(Merchant m) {
		baseDAO.saveOrUpdate(m);
	}

	public List<Merchant> findAll() {
		return baseDAO.find("from Merchant");
	}

	/**
	 * 通过mid查询merchant
	 */
	public Merchant findById(Integer mid) {
		Merchant merchant = baseDAO.get(Merchant.class, mid);
		return merchant;
	}

	/**
	 * 分页查询所有Merchant
	 */
	public PageList<Merchant> findAll(Merchant merchant, Integer pageNo,
			Integer pageSize) {
		
		String hql_list="from Merchant where 1=1";
		String hql_count="select count(*) from Merchant where 1=1";
		
		List<Object> li=null;
		//动态拼接hql，灵活处理多条件查询
		if(merchant != null){
			li=new ArrayList<Object>();
			if(StringUtils.isNotBlank(merchant.getName())){
				hql_count+=" and name like ?";
				hql_list+=" and name like ?";
				li.add("%"+merchant.getName()+"%");
			}
		}
		hql_list+=" order by cts desc";
		
		List<Merchant> merchantList = baseDAO.find(hql_list,li,pageNo,pageSize);
		Long count=baseDAO.count(hql_count,li);
		
		PageList<Merchant> pl=new PageList<Merchant>();
		pl.setList(merchantList);//merchant数据
		pl.setCount(count);//总记录数
		pl.setPageSize(pageSize); //设置每页记录数
		pl.setPages(pl.getP(count, pageSize));//设置总页数
		
		return pl;
		
	}

	/**
	 * 查询当前mobile对应merchant
	 */
	public Merchant findByMobile(String mobile) {
		List<Merchant> merchants = baseDAO.find("from Merchant where mobile = ?", new Object[]{mobile});
		if(merchants.size() > 0 && merchants.get(0) != null){
			return merchants.get(0);
		}
		return null;
	}

	  
	 
}