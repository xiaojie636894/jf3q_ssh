<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>增加二级目录</title>
	</head>

	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加二级目录</strong></div>
			<div class="body-content">
				<form method="post" class="form-x" action="directory2_add.do">
					<div class="form-group">
						<div class="label">
							<label>目录名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="" name="directory2.cname" data-validate="required:请输入二级目录名称" placeholder="请输入目录名称"/>
							<div class="tips"></div>
						</div>
					</div>
					 
					<div class="form-group">
						<div class="label">
							<label>排序：</label>
						</div>
						<div class="field">
							<input type="number" class="input w50" value="" name="directory2.orderby" data-validate="required:请输入排序数字" placeholder="请输入排序数字"/>
							<div class="tips"></div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="label">
							<label>所属一级目录：</label>
						</div>
						<div class="field">
							<!-- 把一级目录的id提交 -->	
							<select name="directory2.directory.did" class="input"   style="width:260px; line-height:17px; display:inline-block" data-validate="required:请选择一级目录" >
					          	<option value="">--请选择--</option>
					           	<c:forEach items="${directories }" var="item">
						            <option value="${item.did }">${item.cname }</option>
					           	</c:forEach>
					        </select> 
						</div>
					</div>
					
				      
				      
					<div class="form-group">
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
							<button class="button bg-green icon-backward" type="button" onclick="javascript:history.go(-1)"> 返回</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</body>
	
	<script>
		
	</script>

</html>