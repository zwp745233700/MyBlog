<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/articlemanage.css" type="text/css" />
    	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    
	<title>评论管理 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	
	<div class="main">
	
	<form id="form1" action="${pageContext.request.contextPath }/articleaction_FindByTypes.action" method="post">
		<div style="float:left">
			<span>类别：</span>
			<select name="type1" onchange="conditionFind(this)">
				<option value="">全部</option>
				<c:forEach items="${mytypelist }" var="mytype">
					<option value="${mytype.mtid }"
					<c:if test="${mytype.mtid==type1 }">selected</c:if>>${mytype.mytag }</option>
				</c:forEach>
			</select>
		</div>
		
		<div style="float:left;margin-left:10px;">
			<span>类型：</span>
			<select name="type2" onchange="conditionFind(this)">
				<option value="">全部</option>
				<c:forEach items="${typelist }" var="type">
					<option value="${type.typeId }"
					<c:if test="${type.typeId==type2 }">selected</c:if>>${type.type }</option>
				</c:forEach>
			</select>
		</div>
	</form>
	
	<div>
       	<table style="width:1000px;">
  			<tr>
  				<td style="width:500px">标题</td><td style="width:100px">状态</td><td style="width:200px">发表时间</td><td style="width:200px">操作</td>
 			</tr>
			<c:forEach items="${articleList }" var="article">
				<tr>
	    			<td>
	   					<a href="${pageContext.request.contextPath }/articleaction_SelectOne.action?aid=${article.aid}" target="_blank">${article.title }</a>
	   				</td>
					<td>${article.state.state }</td>
	   				<td>${article.date }</td>
	   				<td>
	  					<a href="${pageContext.request.contextPath }/articleaction_Toupdarticle.action?aid=${article.aid}">编辑</a>|
	  					<%-- <a href="${pageContext.request.contextPath }/articleaction_delartilce.action?aid=${article.aid}">删除</a>| --%>
	  					<a href="${pageContext.request.contextPath }/articleaction_takeTorecycle.action?aid=${article.aid}">删除</a>|
	   					<a href="${pageContext.request.contextPath }/belongAction_ToupdbelongView.action?aid=${article.aid}">分类</a>
	   				</td>
	   			</tr>
   			</c:forEach>
   		</table>
	</div>
	
	</div>
</body>
</html>
