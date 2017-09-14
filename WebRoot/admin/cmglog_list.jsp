<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>  
		<title>系统日志管理</title>
		 
	</head>

	<body>
		<form method="post" action="cmglog_list.do" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder"> 日志列表</strong>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<input type="date" placeholder="请输入时间" value="${cmgLog.startTs}" name="cmgLog.startTs" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<input type="date" placeholder="请输入时间" value="${cmgLog.endTs}" name="cmgLog.endTs" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<button href="javascript:void(0)" class="button border-main icon-search" type="submit"> 搜索</button>
						</li>
					</ul>
				</div>
			</div>
		</form>
		<table class="table table-hover text-center">
			<tr>
				<th width="10%">ID</th>
				<th>创建时间</th>
				<th>内容</th>
				<th>类型</th>
			</tr>
			<volist name="list" id="vo">
				<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td width="10%">${item.cmid }</td>
					<td>${item.cmts }</td>
					<td>${item.content }</td>
					<td>
						<c:if test="${item.type eq 0}"> 创建</c:if>
						<c:if test="${item.type eq 1}"> 修改</c:if>
						<c:if test="${item.type eq 2}"> 删除</c:if>
						<c:if test="${item.type eq 3}"> 登录</c:if>
						<c:if test="${item.type eq 4}"> 其它</c:if>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<form method="post" action="cmglog_list.do">
							<input type="hidden" value="${cmgLog.startTs }" name="cmgLog.startTs"/>
							<input type="hidden" value="${cmgLog.endTs }" name="cmgLog.endTs"/>
							<input type="hidden" value="${cmgLog.cmts }" name="cmgLog.cmts"/>
							<%@ include file="page.jsp"%>   
						</form>
						
					</td>
				</tr>
			</volist>
		</table>

	</body>

</html>