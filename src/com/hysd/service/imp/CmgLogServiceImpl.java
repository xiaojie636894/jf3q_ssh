package com.hysd.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hysd.dao.BaseDAO;
import com.hysd.domain.CmgLog;
import com.hysd.domain.PageList;
import com.hysd.domain.Role;
import com.hysd.service.CmgLogService;

@Transactional //启用事务机制
@Service("cmgLogService")
public class CmgLogServiceImpl implements CmgLogService {

	@Resource
	private BaseDAO<CmgLog> baseDAO;

	@Override
	public void save(CmgLog c) {
		baseDAO.save(c);
	}

	@Override
	public PageList<CmgLog> findAll(CmgLog cmgLog, Integer pageNo, Integer pageSize) {
		String hql_list="from CmgLog where 1=1";//1=1的目的是为了拼接下面的多条件查询
		String hql_count="select count(*) from CmgLog where 1=1";//配合分页，统计记录条数
		
		List<Object> li=null;
		//动态拼接hql，灵活处理多条件查询
		if(cmgLog!=null){
			li=new ArrayList<Object>();
			//条件查询一
			if(StringUtils.isNotBlank(cmgLog.getStartTs())){
				hql_count+=" and cmts >= ?";
				hql_list+=" and cmts >= ?";
				li.add(cmgLog.getStartTs());
			}
			
			if(StringUtils.isNotBlank(cmgLog.getEndTs())){
				hql_count+=" and cmts <= ?";
				hql_list+=" and cmts <= ?";
				li.add(cmgLog.getEndTs());
			}
				
		}
		hql_list+=" order by cmts desc";//默认是升序（ase）  desc的意思是降序
		
		List<CmgLog> rolelist=baseDAO.find(hql_list,li,pageNo,pageSize);
		Long count=baseDAO.count(hql_count,li);
		
		PageList<CmgLog> pl=new PageList<CmgLog>();
		pl.setList(rolelist);
		pl.setCount(count);
		pl.setPageSize(pageSize); 
		pl.setPages(pl.getP(count, pageSize));
		
		return pl;
	}
}