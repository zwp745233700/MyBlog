<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/writeboke.css" type="text/css" />
	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
	
	<title>发表文章 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	
    <div class="writeboke">
    
    	<form action="${pageContext.request.contextPath }/belongAction_updbelong.action" method="post"3>
    	
		<div>
		<p>请选择文章的分类：</p>
		当前文章：
		<a href="#">${article.title }</a><br/>
		<input type="hidden" name="aid" value="${article.aid }"/>
		
		选择文章分类：
		<c:forEach items="${typelist }" var="mytype">
			<label for="${mytype.mtid }"><input type='checkbox' name="chkValue" id="${mytype.mtid }" value="${mytype.mtid }"
				<c:forEach items="${minetypeList }" var="mine">
					<c:if test="${mytype.mtid==mine.mytype1.mtid }">checked="checked"</c:if>
				</c:forEach>
			/>${mytype.mytag }</label>
		</c:forEach>
		</div>
		
		<div style="width:400px;margin:0 auto;">
			<input type="submit" value="保存" />
			<input type="reset" value="取消" />   
		</div>
		
		</form>

</div>
<div style="width:1000px;margin:0 auto;color:gray;" >
	<p style="text-indent:2em;">提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
</div>
  
</body>
</html>
