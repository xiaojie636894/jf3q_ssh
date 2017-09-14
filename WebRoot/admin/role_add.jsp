<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>添加角色</title>
	</head>

	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加角色</strong></div>
			<div class="body-content">
				<form method="post" class="form-x" action="role_added.do">
					<div class="form-group">
						<div class="label">
							<label>角色名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="" name="role.rname" data-validate="required:请输入角色名称" placeholder="请输入角色名称"/>
							<div class="tips"></div>
						</div>
					</div>
					<div class="clear"></div>
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

</html>