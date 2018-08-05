<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/writeboke.css" type="text/css" />
	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>

	<title>管理文章 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	管理员：${manage.musername }欢迎：<br/>
	------------------------------------------------------------------------<br/>
	<table style="border-collapse:collapse;" border="1px">
		<tr>
			<td>文章名称</td><td>所属用户</td><td>文章审核</td><td>操作</td>
		</tr>
		<c:forEach items="${articleList }" var="article">
			<tr>
				<td><a href="${pageContext.request.contextPath }/articleaction_mSeeOne.action?uid=${article.user.uid}&aid=${article.aid}">${article.title }</a></td>
				<td>${article.user.username }</td>
				<td>
					<a href="${pageContext.request.contextPath }/manageAction_passArticle.action?aid=${article.aid}">审核通过</a>
					<a href="${pageContext.request.contextPath }/manageAction_dispassArtilce.action?aid=${article.aid}">审核不通过</a>	
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/manageAction_delartilce.action?aid=${article.aid}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
