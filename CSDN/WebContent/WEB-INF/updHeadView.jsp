<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
	  <meta charset="utf-8" />
	  <title>修改用户头像</title>
	  
	  <link rel="stylesheet" href="css/updHeadView.css" type="text/css" />
	  <link rel="stylesheet" href="css/common.css" type="text/css" />
	  <script type="text/javascript" src="/CSDN/js/uploadPreview.js"></script>
	  <script>
	  	window.onload=function(){
	  		new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
	  	}
	  </script>
	</head>
  
	<body class="main">
	<h1 class="title">修改头像</h1>
		<div class="oldHead">
			<span class="ziti">当前头像：</span>
			<!-- 没有设置头像，则显示默认头像 -->
         	  <c:if test="${user.headPic==null }">
			  		<img src="images/headpic.jpg" style="border:1px solid gray;" width=248 height=224 /><br/>
		      </c:if>
		      <!-- 如果设置了头像呢，则显示用户头像 -->
		      <c:if test="${user.headPic!=null }">
				  	<img src="/pictures/${user.headPic }" style="border:1px solid gray;" width=248 height=224 /><br/>
		      </c:if>
       	 </div>
       	 <div class="newHead">
			<span class="ziti">新头像：</span>
			<!-- 头像预览 -->
			<div id="imgdiv">
				<img id="imgShow" style="border:1px solid gray;" width=248 height=224 />
			</div>
       	 </div><br/>
       	 <div class="chooseImg">
       		 <form action="${pageContext.request.contextPath }/useraction_updUser.action" method="post" enctype="multipart/form-data">
      	 		 <input type="file" id="up_img" name="upload"/><br /><br/>
      	 		 <input type="submit" class="submit1" value="更改" />
      	 		 <input type="reset" class="submit1" value="取消"/>
      	 		 <input type="button" class="submit1" onclick="window.location.href('${pageContext.request.contextPath }/useraction_topersonView.action')" value="返回"/>
      	 	 </form>
       	 </div>
  </body>
</html>
