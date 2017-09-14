<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>我的基本信息</title>
	</head>

	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>我的基本信息</strong></div>
			<div class="body-content">
				<form method="post" class="form-x" action="merchant_uploadface.do" enctype="multipart/form-data">
					<div class="form-group">
						<div class="label">
							<label>真实姓名：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${admin.name}"   readonly="readonly" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>系统角色：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${admin.rname}" name=" " readonly="readonly" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>录入时间：</label>
						</div>
						<div class="field">
							${admin.cts }
						</div>
					</div>
					<div class="form-group">
				        <div class="label">
				          <label>上传头像：</label>
				        </div>
				        <div class="field">
				           <input type="button" class="button bg-blue margin-left" id="upimg" value="+ 浏览上传"  style="float:left;">
				          <input type="file"  name="file" class="input tips" style="display: none;" accept="image/*"/>
				          <div class="tipss">图片尺寸：100*100</div>
				          <div   style="width:20%;">
				          	<img id="img" style="width: 100%;" src="${imgctx}${admin.faceimg }">
				          </div>
				        </div>
				      
				    </div>
				    
					<div class="form-group">
						
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<p style="color: red;" >${msg }</p>
							<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>

	</body>
<script type="text/javascript">
$("#upimg").click(function(){
	$(this).next().click();
});
$("#upimg").next().change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	if (objUrl) {
		$('#img').attr('src',objUrl);
	}
});


	function getObjectURL(file) {
		var url = null;
		if (window.createObjectURL != undefined) { // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
</script>
</html>