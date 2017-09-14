package com.hysd.service;

import java.util.List;

import com.hysd.domain.PageList;
import com.hysd.domain.Price;

public interface PriceService {

	PageList<Price> findAll(Integer pageNo, Integer pageSize, Price price);

	void saveOrUpdate(Price price);

	Price findById(Integer pid);

	void delete(Price price);

	List<Price> findAll();

}
