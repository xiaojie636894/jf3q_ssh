<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>  
		<title>角色管理</title>
		 
	</head>

	<body>
		<form method="post" action="role_list.do" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder"> 角色列表</strong>
					<a href="role_add.do" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="role_add.do"> 添加内容</a>
						</li>
						<li>
							<input type="text" placeholder="请输入角色名称" value="${role.rname }" name="role.rname" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<button href="javascript:void(0)" class="button border-main icon-search" type="submit"> 搜索</button>
						</li>
					</ul>
				</div>
			</div>
		</form>
		<table class="table table-hover text-center">
			<tr>
				<th width="10%">ID</th>
				<th>名称</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<volist name="list" id="vo">
				<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td width="10%">${item.rid }</td>
					<td>${item.rname }</td>
					<td>${item.cts }</td>
					<td>
						<div class="button-group">
							<a class="button border-main" href="role_update.do?role.rid=${item.rid}"><span class="icon-edit"></span> 修改</a>
							<a class="button border-red del" href="role_delete.do?role.rid=${item.rid}&pageNo=${pageNo}"><span class="icon-trash-o"></span> 删除</a>
						</div>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<form method="post" action="role_list.do">
							<input type="hidden" value="${role.rname}" name="role.rname"/>
							<%@ include file="page.jsp"%>   
						</form>
						
					</td>
				</tr>
			</volist>
		</table>
			
		
		<script type="text/javascript">
			 
			$("a.del").click(function(){
				if(confirm("您确定要删除吗?")) {
					window.location=$(this).attr("href");	
				}
				return false;
			});
			 

			 
		</script>
	</body>

</html>