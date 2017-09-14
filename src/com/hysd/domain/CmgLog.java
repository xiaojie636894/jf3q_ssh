package com.hysd.domain;

import net.sf.ehcache.pool.sizeof.annotations.IgnoreSizeOf;

public class CmgLog {// 后台客服操作日志
	private Integer cmid;
	private String cmts;// 时间
	private String content;// 内容
	private Integer type;// 类型
	@IgnoreSizeOf
	private String startTs;//开始时间
	@IgnoreSizeOf
	private String endTs;//结束时间

	

	

	public Integer getCmid() {
		return cmid;
	}

	public void setCmid(Integer cmid) {
		this.cmid = cmid;
	}

	public String getCmts() {
		return cmts;
	}

	public void setCmts(String cmts) {
		this.cmts = cmts;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStartTs() {
		return startTs;
	}

	public void setStartTs(String startTs) {
		this.startTs = startTs;
	}

	public String getEndTs() {
		return endTs;
	}

	public void setEndTs(String endTs) {
		this.endTs = endTs;
	}

}
