package com.hysd.service;

import com.hysd.domain.Goods;
import com.hysd.domain.PageList;

/**
 * 商品接口
 * @author jf3q.com
 *
 */
public interface GoodsService {

	void saveOrUpdate(Goods goods);

	PageList<Goods> findAll(Goods goods, Integer pageNo, Integer pageSize);

}
