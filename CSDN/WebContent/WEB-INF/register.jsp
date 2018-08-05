<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
	  <meta charset="utf-8" />
	  <title>用户注册</title>
	  
	  <link rel="stylesheet" href="css/register.css" type="text/css" />
	  <link rel="stylesheet" href="css/common.css" type="text/css" />
	</head>
  
	<body class="main">
	<h1 class="title">欢迎注册博客</h1>
		<div class="login1">
			<h3 class="font1">用户注册界面 </h3>
			
            <div class="login2">
                <form action="${pageContext.request.contextPath }/useraction_register.action" method="post">
					   	用户名：<input type="text" name="username"></input><br />
						密码：<input type="text" name="password"></input><br/>
						<input type="submit" class="submit1" value="注册" /> 
						<input type="reset" class="submit1" value="取消" /> 
						<input type="button" class="submit1" onclick="window.location.href('${pageContext.request.contextPath }/index.jsp')" value="返回" /> 
                  </form>
         	  </div>
         	  
       	  </div>
  </body>
</html>
