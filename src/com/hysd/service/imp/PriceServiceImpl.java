package com.hysd.service.imp;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.PageList;
import com.hysd.domain.Price;
import com.hysd.service.PriceService;

@Transactional
@Service("priceService")
public class PriceServiceImpl implements PriceService{

	@Resource
	private BaseDAO<Price> baseDAO;
	
	/**
	 * 分页查询所有商品单价
	 */
	public PageList<Price> findAll(Integer pageNo, Integer pageSize, Price price) {
		
		String hql_count = "select count(*) from Price where 1=1";
		String hql_list = "from Price where 1=1";
		
		List<Object> li = null;
		if(price != null){
			if(StringUtils.isNotEmpty(price.getPname())){
				li = new ArrayList<Object>();
				li.add("%"+price.getPname()+"%");
				hql_count += "and pname like ?";
				hql_list += "and pname like ?";
			}
		}
		
		Long count = baseDAO.count(hql_count, li);
		List<Price> prices = baseDAO.find(hql_list, li, pageNo, pageSize);
		
		PageList<Price> pl = new PageList<Price>();
		pl.setCount(count);
		pl.setList(prices);
		pl.setPages(pl.getP(count, pageSize));
		
		return pl;
	}

	/**
	 * 添加商品单价
	 */
	public void saveOrUpdate(Price price) {
		baseDAO.saveOrUpdate(price);
	}

	/**
	 * 通过id查询price
	 */
	public Price findById(Integer pid) {
		return baseDAO.get(Price.class, pid);
		
	}

	/**
	 * 删除商品单价
	 */
	public void delete(Price price) {
		baseDAO.delete(price);
	}

	/**
	 * 查询所有单价单位
	 */
	public List<Price> findAll() {
		return baseDAO.find("from Price");
	}

}
