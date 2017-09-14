package com.hysd.service.imp;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.hysd.dao.BaseDAO;
import com.hysd.domain.PageList;
import com.hysd.domain.Role;
 
import com.hysd.service.RoleService;

@Transactional //启用事务机制
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private BaseDAO<Role> baseDAO;

	@Override
	public PageList<Role> findAll(Role r,Integer pageNo,Integer pageSize) {
		String hql_list="from Role where 1=1";
		String hql_count="select count(*) from Role where 1=1";
		
		List<Object> li=null;
		//动态拼接hql，灵活处理多条件查询
		if(r!=null){
			li=new ArrayList<Object>();
			if(StringUtils.isNotBlank(r.getRname())){
				hql_count+=" and rname like ?";
				hql_list+=" and rname like ?";
				li.add("%"+r.getRname()+"%");
			}
				
		}
		hql_list+=" order by cts desc";
		
		List<Role> rolelist=baseDAO.find(hql_list,li,pageNo,pageSize);
		Long count=baseDAO.count(hql_count,li);
		
		PageList<Role> pl=new PageList<Role>();
		pl.setList(rolelist);
		pl.setCount(count);
		pl.setPageSize(pageSize); 
		pl.setPages(pl.getP(count, pageSize));
		
		return pl;
	}
	

	@Override
	public void save(Role r) {
		baseDAO.save(r);
	}

	@Override
	public Role getById(int id) {
		return baseDAO.get(Role.class, id);
	}

	@Override
	public void update(Role r) {
		baseDAO.update(r);
	}

	@Override
	public void delete(Role r) {
		baseDAO.delete(r);
	}


	@Override
	public List<Role> getList() {
		return baseDAO.find("from Role");
	}
	
	 
	  
	 
}
