<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>客服列表</title>
	</head>

	<body>
		<form method="post" action="merchant_list.do" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder">客服列表</strong>
					<a href="merchant_add.html" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="merchant_addPre.do">添加内容</a>
						</li>
						<li>
							<input type="text" placeholder="请输入客服姓名" name="merchant.name" value="${merchant.name}" class="input" style="width:250px; line-height:17px;display:inline-block" />

							<button  class="button border-main icon-search" type="submit"> 搜索</button>
						</li>
					</ul>
				</div>
			</div>	
		</form>
		
		<table class="table table-hover text-center">
			<tr>
				<th width="10%">ID</th>
				<th>姓名</th>
				<th>手机号</th>
				<th>状态</th>
				<th>角色</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${merLists}" var="item">
				<tr>
						<td width="10%">${item.mid}</td>
						<td>${item.name}</td>
						<td>${item.mobile}</td>
						<td>${item.status}</td>
						<td>${item.role.rname}</td>
						<td>${item.cts}</td>
					
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
								<a class="button border-blue" href="#"><span class="icon-adn"></span>初始化密码</a>
								<a class="button border-main" href="${imgctx}/merchant_editPre.do?merchant.mid=${item.mid}"><span class="icon-edit"></span> 修改</a>
								<a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a>  
							</div>
						</td>
				</tr>
			</c:forEach>	
				
			<tr>
				<td colspan="8">
					<form method="post" action="merchant_list.do">
						<input type="hidden" value="${merchant.name}" name="merchant.name"/>
						<%@ include file="page.jsp"%>   
					</form>
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
