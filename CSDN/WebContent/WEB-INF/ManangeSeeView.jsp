<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/ManageSeeView.css" type="text/css" />
    <script type="text/javascript" src="/CSDN/js/edittype.js"></script>
    
	<title>${article.title }-CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div class="main">
		<!-- 右上：文章的标题 -->
		<div class="right_top">
			<div class="title">
				<span style="font-size:30px;">(${article.type.type})&nbsp;&nbsp;&nbsp;&nbsp;${article.title }</span><br/>
				<span style="float:right">发表时间：${article.date }&nbsp;&nbsp;&nbsp;</span>
			</div>
		</div>
		<div class="author">
			<div style="margin-left:15px;margin-top:15px;"><span style="font-size:20px;">文章作者：${article.user.username }</span></div>
		</div>
		<!-- 右中：文章的分类 -->		
		<div class="right_center">
			<div style="margin-left:15px;margin-top:15px;"><span style="font-size:20px;">文章分类:</span>
			<c:forEach items="${minetypeList }" var="articletype">
				<a href="#">${articletype.mytype1.mytag }</a>&nbsp;&nbsp;
			</c:forEach>
			</div>
		</div>
		
		<!-- 右下：文章的内容 -->
		<div class="right_low">
			<div class="content">
			${article.content }
			
			</div>
			<br/><br/>	
			<c:if test="${article.pic!=null&&article.pic!='' }">
				<div class="picture">
					<div style="margin-left:15px;margin-top:15px;"><span style="font-size:20px;">文章图片：</span><br/>
						<img class="pic" src="/pictures/${article.pic }" />
					</div>
				</div>
			</c:if>
				</div>
			<br/><br/>
		<div style="text-align:center">
			<a href="${pageContext.request.contextPath }/manageAction_passArticle.action?aid=${article.aid}">审核通过</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/manageAction_dispassArtilce.action?aid=${article.aid}">审核不通过</a>
		</div>
	</div>	
			
</body>
</html>
