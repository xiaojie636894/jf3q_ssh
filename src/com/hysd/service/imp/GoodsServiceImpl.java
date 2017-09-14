package com.hysd.service.imp;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.Directory2;
import com.hysd.domain.Goods;
import com.hysd.domain.PageList;
import com.hysd.service.GoodsService;

@Transactional
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private BaseDAO<Goods> baseDAO;
	@Resource
	private BaseDAO<Directory2> baseDAO2;
 	
	/**
	 * 添加商品
	 */
	public void saveOrUpdate(Goods goods) {
		baseDAO.saveOrUpdate(goods);
	}

	/**
	 * 按条件分页查询所有goods
	 */
	public PageList<Goods> findAll(Goods goods, Integer pageNo,
			Integer pageSize) {
		
		String count_hql = "select count(*) from Goods where 1 = 1";
		String list_hql = "from Goods where 1 = 1";
		
		List<Object> li = null;
		if(goods != null){
			li = new ArrayList<Object>();
			if(StringUtils.isNotBlank(goods.getGname())){
				li.add("%"+goods.getGname()+"%");
				count_hql += "and gname like ?";
				list_hql += "and gname like ?";
			}
			//一级目录did不为空
			if(goods.getDirectory2().getDirectory().getDid() != null){
				//二级目录ddid不为空		
				if(goods.getDirectory2().getDdid() != null){
					li.add(goods.getDirectory2().getDdid());
					count_hql += "and ddid = ?";
					list_hql += "and ddid = ?";
				}else{
					//二级目录ddid为空时	
					/**
					 * 先查询当前一级目录id对应的所有二级目录
					 * 然后遍历查询出来的二级目录，遍历之添加进li中
					 */
					li.add(goods.getDirectory2().getDirectory().getDid());
					count_hql += "and ddid in (select d.ddid from Directory2 d where did = ?)";
					list_hql += "and ddid in (select d.ddid from Directory2 d where did = ?)";
				}
			}
		}
		
		Long count = baseDAO.count(count_hql, li);
		List<Goods> goodss = baseDAO.find(list_hql, li, pageNo, pageSize);
		
		PageList<Goods> pl = new PageList<Goods>();
		pl.setList(goodss);//设置数据
		pl.setCount(count);//设置总记录数
		pl.setPages(pl.getP(count, pageSize));//设置总页数
		
		return pl;
	}

	
	
}
