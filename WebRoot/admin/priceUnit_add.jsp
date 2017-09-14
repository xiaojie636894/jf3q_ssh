<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>增加单位</title>
	</head>

	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加单位</strong></div>
			<div class="body-content">
				<form method="post" class="form-x" action="price_add.do">
					<div class="form-group">
						<div class="label">
							<label>单位名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="price.pname" data-validate="required:请输入单位名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>商品单价：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="price.priceUnit" data-validate="required:请输入商品单价" />
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
						</div>
					</div>
				</form>
			</div>
		</div>

	</body>

</html>