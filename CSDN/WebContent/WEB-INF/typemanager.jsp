<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    <link rel="stylesheet" href="/CSDN/css/typemanager.css" type="text/css" />
    
	<title>类别管理 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	

    <div class="typemanager">
   	<form action="${pageContext.request.contextPath }/typeaction_conditionfind.action" method="post">
		查找文章类别：<input name="mytag" type="text" size="50" maxlength="30" />
		<input type="submit" value="查找" />
	</form>
       	<table class="table1">
  			<tr>
  				<td style="width:600px">类别</td><td style="width:200px">文章</td><td style="width:200px">操作</td>
 			</tr>
			<c:forEach items="${typelist }" var="type">
			<tr>
    			<td>
   					<form id="form1" name="form1" action="${pageContext.request.contextPath }/typeaction_editmytag.action?mtid=${type.mtid}" method="post">
    					<span id="${type.mtid }1">${type.mytag }</span>
    					<span id="${type.mtid }2" class="edit2">
    						<input type="text" name="mytag" value="${type.mytag }"/>
    						<input type="submit" value="保存" />
    						<input type="reset" value="取消"/>
    					</span>
   					</form>
   				</td>
   				<td>0</td>
   				<td>
  					<a id="${type.mtid }" href="javascript:;" onclick="edit(this)">编辑</a>|
  					<a href="${pageContext.request.contextPath }/typeaction_delmytag.action?mtid=${type.mtid}">删除</a>
   				</td>
   			</tr>
   			</c:forEach>
   		</table>
   		
       	<form action="${pageContext.request.contextPath }/typeaction_addmytag.action" method="post">
       		<div class="add">
				<input name="mytag" type="text" size="50" maxlength="30" />
				<input type="submit" value="添加分类" />
			</div>
		</form>

		
 		</div>
</body>
</html>
