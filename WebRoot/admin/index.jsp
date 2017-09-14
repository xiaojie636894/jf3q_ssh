<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="common.jsp"%>  
    <title>后台管理中心</title>  
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="<c:if test="${not empty admin.faceimg }">${imgctx}${admin.faceimg }</c:if>
    		<c:if test="${empty admin.faceimg }">${ctx}/images/y.jpg</c:if>" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="index_index.do" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-th-large"></span>系统管理</h2>
	  <ul style="display:block">
	    <li><a href="role_list.do" target="right"><span class="icon-caret-right"></span>角色管理</a></li>
	    <li><a href="${ctx }/menu_list.html" target="right"><span class="icon-caret-right"></span>权限管理</a></li>
	    <li><a href="${ctx }/role_menu.html" target="right"><span class="icon-caret-right"></span>权限分配</a></li>  
	    <li><a href="${imgctx}/merchant_list.do" target="right"><span class="icon-caret-right"></span>客服管理</a></li>
	     <li><a href="cmglog_list.do" target="right"><span class="icon-caret-right"></span>系统日志</a></li>      
	   </ul>
	  
	  
  <!--1<ul style="display:block">
    <li><a href="info.html" target="right"><span class="icon-caret-right"></span>网站设置</a></li>
    <li><a href="pass.html" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="page.html" target="right"><span class="icon-caret-right"></span>单页管理</a></li>  
    <li><a href="adv.html" target="right"><span class="icon-caret-right"></span>首页轮播</a></li>   
    <li><a href="book.html" target="right"><span class="icon-caret-right"></span>留言管理</a></li>     
    <li><a href="column.html" target="right"><span class="icon-caret-right"></span>栏目管理</a></li>
  </ul>   -->
  <h2><span class="icon-gift"></span>商品管理</h2>
  <ul>
 	<li><a href="${imgctx }/directory_list.do" target="right"><span class="icon-caret-right"></span>一级目录</a></li>	
 	<li><a href="${imgctx }/directory2_list.do" target="right"><span class="icon-caret-right"></span>二级目录</a></li>
    <li><a href="${imgctx }/price_list.do" target="right"><span class="icon-caret-right"></span>单价单位</a></li>   
    <li><a href="${imgctx }/goods_list.do" target="right"><span class="icon-caret-right"></span>商品管理</a></li>        
  </ul>
  
  <h2><span class="icon-list-alt"></span>订单管理</h2>
  <ul>
    <li><a href="" target="right"><span class="icon-caret-right"></span>待支付</a></li>
    <li><a href="" target="right"><span class="icon-caret-right"></span>待发货</a></li>   
    <li><a href="" target="right"><span class="icon-caret-right"></span>已发货</a></li>  
    <li><a href="" target="right"><span class="icon-caret-right"></span>待退款</a></li>
    <li><a href="" target="right"><span class="icon-caret-right"></span>已退款</a></li>       
  </ul>   
  
  <h2><span class="icon-user"></span>个人中心</h2>
  <ul>
    <li><a href="${ctx }/merchant_info.do" target="right"><span class="icon-caret-right"></span>基本信息</a></li>
    <li><a href="" target="right"><span class="icon-caret-right"></span>修改密码</a></li>        
  </ul> 
</div>

<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="${ctx }/home.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="${ctx}/home.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p></p>
</div>
</body>
</html>