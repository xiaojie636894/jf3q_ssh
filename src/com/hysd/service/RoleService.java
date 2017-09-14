package com.hysd.service;

 

import java.util.List;

import com.hysd.domain.PageList;
import com.hysd.domain.Role;

public interface RoleService{
	public PageList<Role> findAll(Role r,Integer pageNo,Integer pageSize);
	public void save(Role r);
	public Role getById(int id); 
	public void update(Role r);
	public void delete(Role r);
	public List<Role> getList();
}