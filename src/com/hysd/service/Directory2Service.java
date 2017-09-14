package com.hysd.service;

import java.util.List;

import com.hysd.domain.Directory2;
import com.hysd.domain.PageList;

/**
 * 二级目录接口
 * @author jf3q.com
 *
 */
public interface Directory2Service {

	PageList<Directory2> findAll(Integer pageNo, Integer pageSize,
			Directory2 directory2);

	Directory2 findById(Integer ddid);

	void delete(Directory2 directory2);

	void add(Directory2 directory2);

	List<Directory2> findAll();

	List<Directory2> findDirectory2ByDid(Integer did);

	Directory2 findDirectory2ByDdid(Integer ddid);



}
