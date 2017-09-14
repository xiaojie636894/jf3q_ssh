<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>单价列表</title>
	</head>

	<body>
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder">单位列表</strong>
					<a href="" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="price_addPre.do"> 添加单位</a>
						</li>
						<li>
							<input type="text" placeholder="请输入单位" name="price.pname" value="${price.pname }" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<button type="submit" class="button border-main icon-plus-square-o"> 搜索</button>
						</li>
					</ul>
				</div>
		</form>
				<table class="table table-hover text-center">
					<tr>
						<th width="10%">ID</th>
						<th>单位名称</th>
						<th>单价</th>
						<th>操作</th>
					</tr>
						
					<c:forEach items="${prices}" var="item">
						<tr>
							<td width="10%">${item.pid }</td>
							<td>${item.pname }</td>
							<td>${item.priceUnit }</td>
							<td>
								<div class="button-group">
									<a class="button border-main" href="price_updatePre.do?price.pid=${item.pid }"><span class="icon-edit"></span> 修改</a>
									<a class="button border-red" href="price_delete.do?price.pid=${item.pid }" onClick="return confirm('确认要删除？')"><span class="icon-trash-o"></span> 删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>	
					
						<tr>
							<td colspan="8">
								<div class="pagelist">
									<form action="price_list.do" method="post">
										<input type="hidden" name="price.pname" value="${price.pname }"/>
										<%@ include file="page.jsp"%>
									</form>
								</div>
							</td>
						</tr>
				</table>
			</div>
		<script type="text/javascript">
			 
			//单个删除
			function del(id, mid, iscid) {
				if(confirm("您确定要删除吗?")) {
				}
			}
			 
		</script>
	</body>

</html>