<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
	</head>

<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#dir").blur(function(){
		$("#dir2 option:gt(0)").remove();
		
		var val = $(this).val();
		if(val != null){
			var url = "directory2_findDirectory2ByDid.do";
			var args = {"directory.did":val};
			$.post(url, args, function(data){
				$(data).each(function(i ,n){
					$("#dir2").append("<option value='" + n.ddid + "'>" + n.cname + "</option>");
				})
			}, "json");
			
		}
	});		
	
});


</script>


	<body>
		<form method="post" action="goods_list1.do" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head"><strong class="icon-reorder"> 商品列表</strong>
					<a href="" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li>
							<a class="button border-main icon-plus-square-o" href="goods_addPre.do"> 添加内容</a>
						</li>
						<li>
							<input type="text" placeholder="请输入商品名称" name="goods.gname" value="${goods.gname }" class="input" style="width:250px; line-height:17px;display:inline-block" />
							<select id="dir" name="goods.directory2.directory.did" class="input" style="width:260px; line-height:17px; display:inline-block" >
					            <option value="">一级目录</option>
					           	<c:forEach items="${directories }" var="item">
					           		<option value="${item.did }" <c:if test="${item.did eq goods.directory2.directory.did}">selected</c:if> > ${item.cname }</option>
					           	</c:forEach>
					        </select>
					        <select id="dir2" name="goods.directory2.ddid" class="input"   style="width:260px; line-height:17px; display:inline-block">
					            <option value="">二级目录</option>
					            <option value="${directory2.ddid }" selected="selected">${directory2.cname }</option>
					        </select>
							<button type="submit" class="button border-main icon-search" > 搜索</butyon>
						</li>
						 
					</ul>
				</div>
		</form>
				<table class="table table-hover text-center">
					<tr>
						<th width="10%">ID</th>
						<th>名称</th>
						<th>正常价格</th>
						<th>单价单位</th>
						<th>库存(件)</th>
						<th>售卖(件)</th>
						<th>状态</th>
						<th>上/下架时间</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
						
					<c:forEach var="item" items="${goodss }">
						<tr>
							<td width="10%">${item.gid }</td>
							<td>${item.gname }</td>
							<td>${item.priceValue }</td>
							<td>${item.price.pname }</td>
							<td>${item.store }</td>
							<td>${item.soldNum }</td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<div class="button-group">
									<a class="button border-green goodsDetails"><span class="icon-desktop"></span> 查看详情</a>
									<a class="button border-main" href="role_update.html"><span class="icon-edit"></span> 修改</a>
									<a class="button border-red" href="javascript:void(0)" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
						
						<tr>
							<td colspan="10">
								<div class="pagelist">
									<%@ include file="page.jsp" %>
									<form action="goods_list.do" method="post">
										<input type="hidden" value="${goods.gname }" name="goods.gname"/>
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
			$(".goodsDetails").click(function(){
				var w=$(window).width()-200;
				var h=$(window).height();
				window.open("../jsp/proinfo.html","newwindow","top=100,left=100,width="+w+",height="+h+",menubar=yes,scrollbars=yes,toolbar=no,status=yes");
			});
			 
		</script>
	</body>

</html>