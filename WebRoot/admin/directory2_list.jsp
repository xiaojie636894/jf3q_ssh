<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>二级目录 </title>
	</head>

	<body>
		<form method="post" action="directory2_list.do" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder">纸杯系列&harr;二级目录列表</strong>
					<a href="directory2_add.html" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="directory2_addPre.do"> 添加内容</a>
						</li>
						<li>
							<input type="text" placeholder="请输入二级目录名称" name="directory2.cname" value="${directory2.cname }" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<button type="submit" class="button border-main icon-search"> 搜索</button>
						</li>
						<li>
							<button class="button bg-green icon-backward" type="button" onclick="javascript:history.go(-1)"> 返回</button>
						</li>
					</ul>
				</div>
		</form>
				<table class="table table-hover text-center">
					<tr>
						<th width="10%">ID</th>
						<th>目录名称</th>
						<th>状态</th>
						<th>排序字段</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${directory2s}" var="item">
						<tr>
							<td width="10%">${item.ddid }</td>
							<td>${item.cname }</td>
							<td>${item.status }</td>
							<td>${item.orderby }</td>
							<td>${item.cts }</td>
							<td>
								<div class="button-group">
									<a class="button border-green" href="#">
										<span class="icon-user"></span>
										<c:if test="${item.status eq 1}">启用</c:if>  
									</a>
									<a class="button border-red" href="#">
										<span class="icon-fighter-jet"></span>
										<c:if test="${item.status eq 0}">禁用</c:if>  
									</a>
									<a class="button border-main" href="directory2_updatePre.do?directory2.ddid=${item.ddid }"><span class="icon-edit"></span>修改</a>
									<a class="button border-red" href="directory2_delete.do?directory2.ddid=${item.ddid }" onClick="return confirm('确认要删除？')"><span class="icon-trash-o"></span> 删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
						
						<tr>
							<td colspan="8">
 								<div class="pagelist">
 									<!-- form表单：一般post请求 -->
 									<form action="directory2_list.do" method="post">
 										<input type="hidden" name="directory2.cname" value="${directory2.cname }"/>
										<%@ include file="page.jsp"%>
 									</form>
								</div> 
							</td>
						</tr>
						
				</table>
		<script type="text/javascript">
			 

			//单个删除
			function del(id, mid, iscid) {
				if(confirm("您确定要删除吗?")) {

				}
			}

			 
		</script>
	</body>

</html>