<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<%@ include file="common.jsp"%>
		<title>修改一级目录</title>
	</head>

	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改一级目录</strong></div>
			<div class="body-content">
				<form method="post" class="form-x" action="directory_addOrUpdate.do" enctype="multipart/form-data">
					<!-- 隐藏输入框 -->
					<input type="hidden" name="directory.did" value="${directory.did}"/>
				
					<div class="form-group">
						<div class="label">
							<label>目录名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${directory.cname}" name="directory.cname" data-validate="required:请输入目录名称" placeholder="请输入目录名称"/>
							<div class="tips"></div>
						</div>
					</div>
					 
					<div class="form-group">
						<div class="label">
							<label>排序：</label>
						</div>
						<div class="field">
							<input type="number" class="input w50" value="${directory.orderby}" name="directory.orderby" data-validate="required:请输入排序数字" placeholder="请输入排序数字"/>
							<div class="tips"></div>
						</div>
					</div>
					
					<div class="form-group">
				        <div class="label">
				          <label>长图片：</label>
				        </div>
				        <div class="field">
				           <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
				          <input type="file"  name="file" class="input tips" style="display: none;"/>
				          <div class="tipss">图片尺寸：1000*100</div>
				          <div id="imgdiv1" style="width:70%;">
				          	<img id="img1" style="width: 100%;" src="${imgctx}${directory.imgPath}">
				          </div>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <div class="label">
				          <label>长图片的超链接：</label>
				        </div>
				        <div class="field">
				          <input type="text" value="${directory.linkUrl}" name="directory.linkUrl" class="input tips" style="width:25%; float:left;"     data-validate="required:请输入图片跳转的超链接" placeholder="请输入图片跳转的超链接"/>
				          <div class="tips"></div>
				        </div>
				    </div>
				    
				    <!-- <div class="form-group">
				        <div class="label">
				          <label>小图片：</label>
				        </div>
				        <div class="field">
				           <input type="button" class="button bg-blue margin-left" id="image2" value="+ 浏览上传"  style="float:left;">
				          <input type="file"  name="" class="input tips" style="display: none;"/>
				          <div class="tipss">图片尺寸：200*300</div>
				          <div id="imgdiv2" style="width:20%;">
				          	<img id="img2" style="width: 100%;" src="images/y.jpg">
				          </div>
				        </div>
				    </div>
				    
				    <div class="form-group">
				        <div class="label">
				          <label>小图片的超链接：</label>
				        </div>
				        <div class="field">
				          <input type="text" value="htpp://xxx" name="" class="input tips" style="width:25%; float:left;"     data-validate="required:请输入图片跳转的超链接" placeholder="请输入图片跳转的超链接"/>
				          <div class="tips"></div>
				        </div>
				    </div> -->
				      
				      
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
	
	<script>
		$("#image1").click(function(){
			$(this).next().click();
		});
		$("#image1").next().change(function(){
			var objUrl = getObjectURL(this.files[0]) ;
			if (objUrl) {
				$('#img1').attr('src',objUrl);
			}
		});
		
		$("#image2").click(function(){
			$(this).next().click();
		});
		$("#image2").next().change(function(){
			var objUrl = getObjectURL(this.files[0]) ;
			if (objUrl) {
				$('#img2').attr('src',objUrl);
			}
		});
		
function getObjectURL(file) {
	var url = null ; 
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}
	</script>

</html>