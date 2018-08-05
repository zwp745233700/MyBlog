<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/head.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
    <div id="head" class="head">
    
		<c:if test="${user.headPic!=null }">
			<a href="${pageContext.request.contextPath }/useraction_toUpdHeadView?uid=${user.uid}"><img class="pic" src="/pictures/${user.headPic }" /></a>
		</c:if>
		<c:if test="${user.headPic==null }">
			<a href="${pageContext.request.contextPath }/useraction_toUpdHeadView?uid=${user.uid}"><img class="pic" src="images/headpic.jpg" /></a>
		</c:if>

        <span class="font1">${user.username }的博客</span><br/>
        <a href="${pageContext.request.contextPath }/useraction_topersonView.action?uid=${user.uid}" class="font1">个人主页</a><br/>
        <br/><br/>
        
        <ul class="tabs">
            <li><a href="${pageContext.request.contextPath }/useraction_writeboke.action"><span>发表文章</span></a></li>
            <li><a href="${pageContext.request.contextPath }/articleaction_manage"><span>文章管理</span></a></li>
            <li><a href="${pageContext.request.contextPath }/typeaction_findType.action"><span>类别管理</span></a></li>
            <li><a href="${pageContext.request.contextPath }/discussAction_toDisManagerView.action"><span>评论管理</span></a></li>
            <li><a href="${pageContext.request.contextPath }/articleaction_todraftsView.action"><span>草稿箱</span></a></li>
            <li><a href="${pageContext.request.contextPath }/articleaction_torecycleView.action"><span>回收站</span></a></li>
            <li><a href="${pageContext.request.contextPath }/articleaction_toMyblok.action" target="_blank"><span>我的博客</span></a></li>
            <li><a href="${pageContext.request.contextPath }/articleaction_toFirstView.action"><span>博客首页</span></a></li>
        </ul>
 </div>
</body>
</html>
