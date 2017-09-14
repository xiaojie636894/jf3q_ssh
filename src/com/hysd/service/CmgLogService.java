package com.hysd.service;

import com.hysd.domain.CmgLog;
import com.hysd.domain.PageList;

/**
 * @author hanma
 *
 */
public interface CmgLogService{

	 /**
	  * 保存日志
	 * @param c
	 */
	public void save(CmgLog c);

	/**
	 * 分页查询日志（可带条件）
	 * @param cmgLog
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageList<CmgLog> findAll(CmgLog cmgLog, Integer pageNo, Integer pageSize);
}