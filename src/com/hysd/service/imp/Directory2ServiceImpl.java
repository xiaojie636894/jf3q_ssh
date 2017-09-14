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
import com.hysd.domain.PageList;
import com.hysd.service.Directory2Service;
/**
 * 二级目录实现类
 * @author jf3q.com
 *
 */
@Transactional
@Service("directory2Service")
public class Directory2ServiceImpl implements Directory2Service{
	
	@Resource
	private BaseDAO<Directory2> baseDAO;

	/**
	 * 查询所有二级目录
	 * 如果有条件，则加上条件
	 */
	public PageList<Directory2> findAll(Integer pageNo, Integer pageSize,
			Directory2 directory2) {
		
		String list_hql = "from Directory2 where 1=1";
		String count_hql = "select count(*) from Directory2 where 1=1";
		
		List<Object> li = null;
		//如果二级目录名字不为空，说明是带条件查询，把条件放在li集合中。
		if(directory2 != null){
			li = new ArrayList<Object>();
			if(StringUtils.isNotEmpty(directory2.getCname())){
				li.add("%"+directory2.getCname()+"%");
				list_hql += "and cname like ?";
				count_hql += "and cname like ?";
			}
		}
		Long count = baseDAO.count(count_hql, li);
		List<Directory2> directory2s = baseDAO.find(list_hql, li, pageNo, pageSize);
		
		PageList<Directory2> pl = new PageList<Directory2>();
		pl.setList(directory2s);//所有二级目录
		pl.setCount(count);//设置总记录数
		pl.setPages(pl.getP(count, pageSize));//设置总页数
		
		return pl;
	}

	/**
	 * 按id查二级目录
	 */
	public Directory2 findById(Integer ddid) {
		return baseDAO.get(Directory2.class, ddid);
	}

	/**
	 * 删除二级目录
	 */
	public void delete(Directory2 directory2) {
		baseDAO.delete(directory2);
	}

	/**
	 * 增加or修改二级目录
	 */
	public void add(Directory2 directory2) {
		baseDAO.saveOrUpdate(directory2);
	}

	/**
	 * 查询所有二级目录
	 */
	public List<Directory2> findAll() {
		return baseDAO.find("from Directory2");
	}

	/**
	 * 通过一级目录did查询二级目录
	 */
	public List<Directory2> findDirectory2ByDid(Integer did) {
		List<Directory2> directory2s = baseDAO.find("from Directory2 where did = ?", new Object[]{did});
		return directory2s;
	}

	/**
	 * 通过ddid查询对应二级目录
	 */
	public Directory2 findDirectory2ByDdid(Integer ddid) {
		return baseDAO.get(Directory2.class, ddid);
	}

	
	


}
