<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/writeboke.css" type="text/css" />
	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>

	<title>管理员界面 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	${manage.musername }欢迎登陆：<br/>
	------------------------------------------------------------------------<br/>
	选择你想要做的操作：<br/>
	<a href="${pageContext.request.contextPath }/manageAction_manageUser.action">管理用户</a><br/>
	<a href="${pageContext.request.contextPath }/manageAction_manageArticle.action">管理文章</a><br/>
</body>
</html>
