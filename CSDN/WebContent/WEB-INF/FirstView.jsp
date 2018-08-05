<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/SeeView.css" type="text/css" />
    <script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    
	<title>${article.title }-CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div class="main">
		<jsp:include page="head.jsp" />
		<!-- 右上：文章的标题 -->
		<c:forEach items="${articleList }" var="article">
			<div class="right_top">
				<div class="title">
					<a href="${pageContext.request.contextPath }/articleaction_SelectOne.action?aid=${article.aid}" target="_blank"><span style="font-size:30px;">(${article.type.type})&nbsp;&nbsp;&nbsp;&nbsp;${article.title }</span></a><br/>
					<span>作者：${article.user.username }</span><span style="float:right">${article.date }&nbsp;&nbsp;&nbsp;68人阅读&nbsp;&nbsp;&nbsp;<a href="#">评论</a>(5)<a href="#"></a></span>
				</div>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>
