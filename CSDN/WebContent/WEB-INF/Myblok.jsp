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
		
		<!-- 左边：用户个人信息 -->
		<div class="left">
			<div class="bground"><span>个人资料</span></div><br/>
			
			<div style="width:200px;">
				<!-- 点击头像 跳转到个人主页 -->
				<c:if test="${user.headPic!=null }">
					<a href="${pageContext.request.contextPath }/useraction_???uid=${user.uid}"><img class="pic" src="/pictures/${user.headPic }" /></a>
				</c:if>
				<c:if test="${user.headPic==null }">
					<a href="${pageContext.request.contextPath }/useraction_???uid=${user.uid}"><img class="pic" src="images/headpic.jpg" /></a>
				</c:if>
				<div style="clear:both;"></div>
				<div class="div1">
					昵称：${user.username }<br/>
					<span>--------------------------------</span>
					<div style="clear:both;"></div>
				</div>
				<div class="div2">
						<span>访问：147次</span><br/>
						<span>积分：35</span><br/>
						<span>等级：1</span><br/>
						<span>排名：千里之外</span><br/>
						<span>-------------------------------</span>
						<span>原创：1篇&nbsp;&nbsp;&nbsp;&nbsp;转载：0篇</span><br/>
						<span>译文：3篇&nbsp;&nbsp;&nbsp;&nbsp;评论：5条</span><br/>
				</div>
				<div style="clear:both;"></div>
			</div>
			
			<div class="bground"><span>文章搜索</span></div>
			<div>
				<input style="margin-top:10px;margin-left:10px;width:160px;" type="text" name=""/>
				<div style="clear:both;"></div>
			</div><br/>
			<div class="bground"><span>文章分类</span></div>
			<div style="margin-left:15px;margin-top:15px;line-height:25px;">
				<c:forEach items="${typelist }" var="mytype">
					<a href="#">${mytype.mytag }</a>(7)<br/>
				</c:forEach>
				<span>--------------------------------</span>
			</div>
			<div style="clear:both;"></div>
			
		</div>
		
		<!-- 右上：文章的标题 -->
		<c:forEach items="${articleList }" var="article">
			<div class="right_top">
				<div class="title">
					<a href="${pageContext.request.contextPath }/articleaction_SelectOne.action?aid=${article.aid}" target="_blank"><span style="font-size:30px;">(${article.type.type})&nbsp;&nbsp;&nbsp;&nbsp;${article.title }</span></a><br/>
					<span style="float:right">${article.date }&nbsp;&nbsp;&nbsp;68人阅读&nbsp;&nbsp;&nbsp;<a href="#">评论</a>(5)<a href="#"></a>&nbsp;&nbsp;<a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></span>
				</div>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>
