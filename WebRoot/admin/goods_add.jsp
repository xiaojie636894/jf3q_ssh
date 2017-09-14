<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
		<%@ include file="common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript" src="js/jquery-blockUI-2.70.js"></script>

<script type="text/javascript">

	$(function(){
		
		$("#dir").change(function(){
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

	$(function(){
		
		$("#country").change(function(){
			$("#province option:not(:first)").remove();
			
			var val = $(this).val();
			if(val != ""){
				var url = "provinceAction_findProvinceByCountryId.do";
				var args = {"country.countryId":val};
				$.post(url, args, function(data){
					$(data).each(function(i, n){
						$("#province").append("<option value='" + n.provinceId + "'>" + n.provinceName + "</option>");
					});
				}, "json");
			}
		});
		
		
		$("#province").change(function(){
			$("#city option:not(:first)").remove();
			
			var val = $(this).val();
			if(val != ""){
				var url = "cityAction_findCityByProvinceId.do";
				var args = {"province.provinceId":val};
				$.post(url, args, function(data){
					$(data).each(function(i, n){
						$("#city").append("<option value='" + n.cityId + "'>" + n.cityName + "</option>");
					});
				}, "json");
				
			}			
		});
		
	});
	
	

	
</script>


<!--富文本剪辑器st-->		
<link rel="stylesheet" type="text/css" href="simditor-1.0.5/styles/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="simditor-1.0.5/styles/simditor.css" />
<!--富文本剪辑器end-->

<style type="text/css">
.associated0{
	padding: 0px 5%;
}
.associated0 input{
	border-radius:5px;
	border:1px solid #999999;
	line-height: 20px;
	padding-left: 10px;
}
.associated0 img{
 	width: 200px;
}
 .td{
	text-align: center;padding-top: 20px;
} .td img{
	width: 150px;
}
.associated1{
	padding: 0px 5%;
	display: none;
}
.associated1 input{
	border-radius:5px;
	border:1px solid #999999;
	line-height: 20px;
	padding-left: 10px;
}
.special{
	display: none;
}
</style>
</head>

<body>
	<form method="post" class="form-x" action="goods_add.do" enctype="multipart/form-data">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>添加商品-基本信息</strong>
			</div>
			<div class="body-content">

				<div class="form-group">
					<div class="label">
						<label>商品名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="goods.gname"
							data-validate="required:请输入商品名称" placeholder="请输入商品名称" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>单价单位：</label>
					</div>
					<div class="field">
						<select name="goods.price.pid" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择单价单位">
							<option value="">选择</option>
							<c:forEach items="${prices }" var="item">
								<option value="${item.pid }">${item.pname }</option>
							</c:forEach>							

						</select>
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>一级目录：</label>
					</div>
					<div class="field">
						<select id="dir" name="goods.directory2.directory.did" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择一级目录">
							<option value="">--请选择一级目录--</option>
							<c:forEach items="${directorys }" var="item">
								<option value="${item.did }">${item.cname }</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>二级目录：</label>
					</div>
					<div class="field">
						<select id="dir2" name="goods.directory2.ddid" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择二级目录">
							<option value="">--请选择二级目录--</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>排序：</label>
					</div>
					<div class="field">
						<input type="number" class="input w50" value="1" name="goods.orderby"
							data-validate="required:请输入排序" placeholder="请输入排序" />
						<div class="tips"></div>
					</div>
				</div>
				
			</div>
		</div>
		
		
		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>商品属性</strong>
			</div>
			<div class="body-content">

				<div class="form-group">
					<div class="label">
						<label>商品图片：</label>
					</div>
					<div class="field">
						<input type="radio"  value="0"  checked="checked" name="goods.associated"/>不关联
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio"  value="1" name="goods.associated"/>关联
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>是否促销：</label>
					</div>
					<div class="field">
						<input type="radio"  value="0"  checked="checked" name="goods.special"/>不促销
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio"  value="1" name="goods.special" />促销
					</div>
				</div>
				
				<div class="associated0">
					 <table>
					 	<tr>
					 		<td>
					 			 规格：<input name="goods.norms" type="text" placeholder="请输入规格">&nbsp;&nbsp;
					 		</td>
					 		<td>
					 			 库存：<input name="goods.store" type="number" placeholder="请输入库存">&nbsp;&nbsp;
					 		</td>
					 		<td>
					 			 原价：<input type="goods.priceValue" placeholder="请输入原价">&nbsp;&nbsp;
					 		</td>
					 		<td>
					 			 会员价：<input name="goods.vipPrice" type="number" placeholder="请输入 会员价">&nbsp;&nbsp;
					 		</td>
					 		<td>
					 			<p class="special"> 促销价：<input name="goods.specialPrice" type="number" placeholder="请输入  促销价" ></p>
					 		</td>
					 	</tr>
					 	<tr><td colspan="4" style="line-height: 40px;">至少上传一张图片<td></tr>
					 	
					 	<tr>
					 		<td class="td">
					 			<input type="file" name="uploads"/>
					 		</td>
					 		<td class="td">
					 			<input type="file" name="uploads"/>
					 		</td>
					 		<td class="td">
					 			<input type="file" name="uploads"/>
					 		</td>
					 		<td class="td">
					 			<input type="file" name="uploads"/>
					 		</td>
					 	</tr>
					 	
					 	<tr>
					 		<td class="td">
					 			<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 		</td>
					 		<td class="td">
					 			<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 		</td>					 		
					 		<td class="td">
					 			<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 		</td>					 		
					 		<td class="td">
					 			<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 		</td>
					 	 </tr>
					 </table>
				</div>
				
				<div class="associated1" >
					<table>
						<tr>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			 <p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
						</tr>
						<tr>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
							<td class="td">
								<img src="images/upf.jpg" class="clickimg">
					 			<input type="file" style="display: none"> 
					 			<p>500*500</p>
					 			 规格：<input type="text" placeholder="请输入规格"><br>
					 			 库存：<input type="number" placeholder="请输入库存"><br>
					 			 原价：<input type="number" placeholder="请输入原价"><br>
					 			 会员价：<input type="number" placeholder="请输入 会员价"><br>
					 			<p class="special"> 促销价：<input type="number" placeholder="请输入  促销价" ></p>
							</td>
						</tr>
					</table>
				</div>
				

			</div>
		</div>
		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>添加商品-邮费设置</strong>
			</div>
			<div class="body-content">

				<div class="form-group">
					<div class="label">
						<label>包邮：</label>
					</div>
					<div class="field">
						<input type="radio"  value="0"  checked="checked" name="goods.isPost"/>不包邮邮费
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio"  value="1" name="goods.isPost"/>包邮
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio"  value="2" name="goods.isPost"/>全场<input type="number" style="width: 50px">元起，包邮
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>邮费：</label>
					</div>
					<div class="field">
						<input type="number" class="input w50" value="10" name="goods.postMoney"
							data-validate="required:请输入邮费" placeholder="请输入邮费" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>邮费说明：</label>
					</div>
					<div class="field">
						<textarea class="input w50" value="10" name="goods.postDesc"
							data-validate="required:请输入邮费说明" placeholder="请输入邮费说明" >天天快递，一般三天到，，，</textarea>
						<div class="tips"></div>
					</div>
				</div>
				
			</div>
		</div>
		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>添加商品-发货地址</strong>
			</div>
			<div class="body-content">
				<div class="form-group">
					<div class="label">
						<label>省份：</label>
					</div>
					<div class="field">
						<select id="country" name="" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择国家">
							<option value="">--请选择--</option>
							<c:forEach items="${countries }" var="item">
								<option value="${item.countryId }">${item.countryName }</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>
					
				<div class="form-group">
					<div class="label">
						<label>城市：</label>
					</div>
					<div class="field">
						<select id="province" name="" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择省份">
							<option value="">--请选择--</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
					
				<div class="form-group">
					<div class="label">
						<label>县区：</label>
					</div>
					<div class="field">
						<select id="city" name="" class="input"
							style="width: 260px; line-height: 17px; display: inline-block"
							data-validate="required:请选择城市">
							<option value="">--请选择--</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				 
 				<div class="form-group">
					<div class="label">
						<label>详细地址：</label>
					</div>
					<div class="field">
						<textarea   class="input w50"   name="goods.address"
							data-validate="required:请输入详细地址" placeholder="请输入详细地址" ></textarea>
						<div class="tips"></div> 
					</div>
				</div>
			</div>
		</div>
		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>添加商品-商品详情（描述）</strong>
			</div>
			<div class="body-content">
				<div class="form-group">
					<div class="label">
						<label>商品详情（描述）:</label>
					</div>
					<div class="field">
						<textarea id="gdesc"></textarea>
						<div class="tips"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong><span class="icon-pencil-square-o"></span>添加商品-商品参数</strong>
			</div>
			<div class="body-content">
				<div class="form-group">
					<div class="label">
						<label>商品参数:</label>
					</div>
					<div class="field">
						<textarea id="gparam" name="goods.gparam"></textarea>
						<div class="tips"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<div style="height: 20px;"></div>
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<button class="button bg-main icon-check-square-o" type="submit">
					提交</button>
			</div>
		</div>
	</form>
</body>
<!--富文本剪辑器st-->
<script type="text/javascript" src="simditor-1.0.5/scripts/js/module.js"></script>
<script type="text/javascript" src="simditor-1.0.5/scripts/js/uploader.js"></script>
<script type="text/javascript" src="simditor-1.0.5/scripts/js/simditor.js"></script>
<!--富文本剪辑器end-->
<script type="text/javascript">
$("input[name=associated]").click(function(){
	 if($(this).val()==0){
		 $('.associated0').show();
		 $('.associated1').hide();
	 }else{
		 $('.associated1').show();
		 $('.associated0').hide(); 
	 }
});
$("input[name=special]").click(function(){
	 if($(this).val()==0){
		 $('.special').hide();
	 }else{
		 $('.special').show(); 
	 }
});

toolbar = [ 'title', 'bold', 'italic', 'underline', 'strikethrough',  
        	'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|',  
        	'link', 'image', 'hr', '|', 'indent', 'outdent' ];  
var editor = new Simditor({  
   	textarea : $('#gdesc'),  
	placeholder : '这里输入内容...', 
	pasteImage: true,
	toolbarFloat:true,
	toolbar : toolbar,  //工具栏  
	defaultImage : 'simditor-1.0.5/images/image.png', //编辑器插入图片时使用的默认图片  
	upload : {  
   		url : 'ImgUpload.action', //文件上传的接口地址  
   		params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交  
   		fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名  
   		connectionCount: 3,  
   		leaveConfirm: '正在上传文件'  
   	}   
}); 

var editor = new Simditor({  
   	textarea : $('#gparam'),  
	placeholder : '这里输入内容...', 
	pasteImage: true,
	toolbarFloat:true,
	toolbar : toolbar,  //工具栏  
	defaultImage : 'simditor-1.0.5/images/image.png', //编辑器插入图片时使用的默认图片  
	upload : {  
   		url : 'ImgUpload.action', //文件上传的接口地址  
   		params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交  
   		fileKey: 'fileDataFileName', //服务器端获取文件数据的参数名  
   		connectionCount: 3,  
   		leaveConfirm: '正在上传文件'  
   	}   
}); 

$(".clickimg").click(function(){
	$(this).next().click();
})
 
$(".clickimg").next().change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	if (objUrl) {
		$(this).prev().attr('src',objUrl);
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