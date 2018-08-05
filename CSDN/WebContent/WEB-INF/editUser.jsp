<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
	  <meta charset="utf-8" />
	  <title>修改用户信息</title>
	  
	  <link rel="stylesheet" href="css/editUser.css" type="text/css" />
	  <link rel="stylesheet" href="css/common.css" type="text/css" />
	</head>
  
	<body class="main">
		<div class="login1">
			<h3 class="font1">修改个人信息 </h3>
			
            <div class="login2">
                <form id="login_form" action="${pageContext.request.contextPath }/useraction_updUser.action" method="post">
                		<input type="hidden" name="uid" value="${user.uid }"/>
	                                        用户名：<input type="text" name="username" value="${user.username }" readonly="readonly"  /><br/>
						实名：<input type="text" name="realname" value="${user.realname }" /><br/>
						行业：<input type="text" name="profession" value="${user.profession }" /><br/>
						职位：<input type="text" name="work" value="${user.work }" /><br/>
						国家：<input type="text" name="country" value="${user.country }" /><br/>
						性别：<input type="radio" name="sex" value="男"/>男<input type="radio" name="sex" value="女"/>女
						<br/>
						个人简介：
	                    <textarea name="resume" rows="10" style="width:230px;">${user.resume }</textarea>
	                    
						<input type="submit" class="submit1" value="保存" /> 
						<input type="reset" class="submit1" value="取消" /> 
						<input type="button" class="submit1" onclick="window.location.href('${pageContext.request.contextPath }/useraction_topersonView.action?uid=${user.uid}')" value="返回" /> 
                  </form>
         	  </div>
         	  
       	  </div>
  </body>
</html>
