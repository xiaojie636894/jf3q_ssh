<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
 <div class="pagelist" id="pagelist">
 	<input type="hidden" value="${pageNo }" name="pageNo" id="pageNo"/>
 	<button type="submit" style="display: none" id="sub"></button>
	<c:if test="${pages gt 1}">
		<a href="#" data-p=1>首页</a>
		<c:if test="${pageNo-1 gt 0 }">
			<a href="#" data-p=${pageNo-1 }>上一页</a>
		</c:if>
		
	</c:if>
	
	<c:if test="${pages<=10}">
		<c:forEach begin="1" end="${pages }" var="i">
			<c:choose>
				<c:when test="${i eq pageNo }">
					 <span class="current">${i }</span>
				</c:when>
				<c:otherwise>
					<a href="#" data-p=${i }>${i }</a>
		 	 	</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	<c:if test="${pages>10}">
		<c:if test="${pageNo-5>0}">
			<c:if test="${pageNo+5>=pages}">
				<c:forEach begin="${pages-9 }" end="${pages}" var="i">
					<c:choose>
						<c:when test="${i eq pageNo }">
							 <span class="current">${i }</span>
						</c:when>
						<c:otherwise>
							<a href="#" data-p=${i }>${i }</a>
				 	 	</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
		 	<c:if test="${pageNo+5<pages}">
				<c:forEach begin="${pageNo-5 }" end="${pageNo+4}" var="i">
					<c:choose>
						<c:when test="${i eq pageNo }">
							 <span class="current">${i }</span>
						</c:when>
						<c:otherwise>
							<a href="#" data-p=${i }>${i }</a>
				 	 	</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
		</c:if>
		<c:if test="${pageNo-5<=0}">
		 	<c:forEach begin="1" end="10" var="i">
				<c:choose>
					<c:when test="${i eq pageNo }">
						 <span class="current">${i }</span>
					</c:when>
					<c:otherwise>
						<a href="#" data-p=${i }>${i }</a>
			 	 	</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if> 
	</c:if>
	 
	
	<c:if test="${pages gt 1}">
		<c:if test="${pageNo+1 lt pages or pageNo+1 eq pages }">
			<a href="#" data-p=${pageNo+1 }>下一页</a>
		</c:if>
		<a href="#" data-p=${pages }>尾页</a>
	</c:if>
	
</div>
<p>共${count}条数据,共${pages}页</p>
 
 <script type="text/javascript">
 $("#pagelist a").click(function(){
	 $("#pageNo").val( $(this).attr("data-p"));
	 $("#sub").click();
	 return false;
 })
 </script>
</body>
</html>