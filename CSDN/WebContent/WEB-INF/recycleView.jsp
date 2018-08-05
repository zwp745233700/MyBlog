<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/articlemanage.css" type="text/css" />
    	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    
	<title>回收站 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	
	<div class="main">
	
	<div>
       	<table style="width:1000px;">
  			<tr>
  				<td style="width:500px">标题</td><td style="width:100px">状态</td><td style="width:200px">删除时间</td><td style="width:200px">操作</td>
 			</tr>
			<c:forEach items="${articleList }" var="article">
				<tr>
	    			<td>
	   					<a href="#">${article.title }</a>
	   				</td>
					<td>${article.state.state }</td>
	   				<td>${article.date }</td>
	   				<td>
	   					<!-- 取消删除，即将文章放入草稿箱中 -->
	   					<a href="${pageContext.request.contextPath }/articleaction_cancelDel.action?aid=${article.aid}">取消删除</a>|
	  					<a href="${pageContext.request.contextPath }/articleaction_delartilce.action?aid=${article.aid}">删除</a>|
	   				</td>
	   			</tr>
   			</c:forEach>
   		</table>
	</div>
	
	</div>
</body>
</html>
