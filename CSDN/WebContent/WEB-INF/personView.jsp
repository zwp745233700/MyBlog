<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/personView.css" type="text/css" />
    <script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    
	<title>个人主页 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div class="head">
	<c:if test="${user.headPic!=null }">
		<a href="${pageContext.request.contextPath }/useraction_toUpdHeadView?uid=${user.uid}"><img class="pic" src="/pictures/${user.headPic }" /></a>
	</c:if>
	<c:if test="${user.headPic==null }">
		<a href="${pageContext.request.contextPath }/useraction_toUpdHeadView?uid=${user.uid}"><img class="pic" src="images/headpic.jpg" /></a>
	</c:if>
	
		<div class="message">
			<span>用户名:${user.username }</span>
			<br/><br/>
			
			<c:if test="${user.profession!=null }">
				<span style="display:block;width:100px;float:left;">${user.profession }</span>
			</c:if>
			<c:if test="${user.profession==null }">
				<span style="display:block;width:100px;float:left;">未填写行业</span>
			</c:if>
			
			<c:if test="${user.work!=null }">
				<span style="display:block;width:100px;float:left;">${user.work }</span>
			</c:if>
			<c:if test="${user.work==null }">
				<span style="display:block;width:100px;float:left;">未填写职位</span>
			</c:if>
			
			<c:if test="${user.realname!=null }">
				<span style="display:block;width:100px;float:left;">${user.realname }</span>
			</c:if>
			<c:if test="${user.realname==null }">
				<span style="display:block;width:120px;float:left;">未填写真实姓名</span>
			</c:if>
			
			<c:if test="${user.country!=null }">
				<span style="display:block;width:100px;float:left;">${user.country }</span>
			</c:if>
			<c:if test="${user.country==null }">
				<span style="display:block;width:100px;float:left;">未填写国家</span>
			</c:if>
			
			<c:if test="${user.sex!=null }">
				<span style="display:block;width:100px;float:left;">${user.sex }</span>
			</c:if>
			<c:if test="${user.sex==null }">
				<span style="display:block;width:100px;float:left;">未填写性别</span>
			</c:if>
			
			<br/><br/>
		</div>
		
		<div class="resumn">
			<span style="float:left;">个人简历:</span>
			<c:if test="${user.resume!=null }">
				<span>${user.resume }</span>
			</c:if>
			<c:if test="${user.resume==null }">
				<span>未填写任何简介信息</span>
			</c:if>
		</div>
		
		<div class="div1">
			<span>&nbsp;&nbsp;&nbsp;4</span><br/>
			<span>关注</span>
		</div>
		<div class="div1">
			<span>&nbsp;&nbsp;&nbsp;15</span><br/>
			<span>粉丝</span>
		</div>
		<div class="edit">
			<span><a href="${pageContext.request.contextPath }/useraction_editUser.action?uid=${user.uid}">修改信息</a></span>
		</div>
	</div >
		
	<div class="article">
		
		<div>发表的文章:</div>
		<div><a href="${pageContext.request.contextPath }/articleaction_manage" style="float:right;margin-right:10px;">文章管理</a></div>
		<br/>
		<table style="border-collapse:collapse;" border="1px">
			<tr>
				<td style="width:600px;">文章标题</td>
				<td style="width:200px;">发表时间</td>
			</tr>
			<c:forEach items="${articlelist }" var="article">
				<tr>
					<td><a href="${pageContext.request.contextPath }/articleaction_SelectOne.action?aid=${article.aid}" target="_blank"">${article.title }</a></td>
					<td>${article.date }</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>
