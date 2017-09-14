package com.hysd.service;

import java.util.List;

import com.hysd.domain.Directory;
import com.hysd.domain.PageList;

public interface DirectoryService{

	 

	public List<Directory> findAllList();

	public PageList<Directory> findAll(Integer pageNo, Integer pageSize,
			Directory directory);

	public Directory findByDid(Integer did);

	public void saveOrUpdate(Directory newDirectory);

	public List<Directory> findAll();

	
	

}