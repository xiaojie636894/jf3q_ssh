package com.hysd.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hysd.dao.BaseDAO;
import com.hysd.domain.Directory;
import com.hysd.domain.PageList;
import com.hysd.service.DirectoryService;

@Transactional //启用事务机制
@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

	@Resource
	private BaseDAO<Directory> baseDAO;

	  
	@Override
	public List<Directory> findAllList() {
		return baseDAO.find("from Directory where status=1 order by orderby desc");
	}

	/**
	 * 按条件分页查询所有一级目录 
	 */
	public PageList<Directory> findAll(Integer pageNo, Integer pageSize,
			Directory directory) {

		String hql_count = "select count(*) from Directory where 1=1";
		String hql_list = "from Directory where 1=1";
		
		List<Object> li = null;
		if(directory != null){
			li = new ArrayList<Object>();
			if(StringUtils.isNotBlank(directory.getCname())){
				hql_count += "and cname like ?";
				hql_list += "and cname like ?";
				li.add("%"+directory.getCname()+"%");
			}
		}
		
		List<Directory> directories = baseDAO.find(hql_list, li, pageNo, pageSize);
		Long count = baseDAO.count(hql_count, li);
		
		PageList<Directory> pl = new PageList<Directory>();
		pl.setList(directories);//设置所有数据
		pl.setCount(count);//设置总记录数
		pl.setPages(pl.getP(count, pageSize));//设置总页数
//		pl.setPageSize(pageSize);//设置每页记录数
		
		return pl;
	}

	/**
	 * 增加or更新一级目录
	 */
	public void saveOrUpdate(Directory directory) {
		baseDAO.saveOrUpdate(directory);
	}

	/**
	 * 通过指定id查询一级目录
	 */
	public Directory findByDid(Integer did) {
		Directory directory = baseDAO.get(Directory.class, did);
		return directory;
	}

	/**
	 * 查询所有一级目录 
	 */
	public List<Directory> findAll() {
		return baseDAO.find("from Directory");
	}
	
	
	
	
}