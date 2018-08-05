<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/writeboke.css" type="text/css" />
	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
	<script type="text/javascript">
		function saveBtnClick(){
			document.forms.articleForm.action="${pageContext.request.contextPath }/articleaction_drafts.action";
			document.forms.articleForm.submit();
		}
	</script>
	
	<title>发表文章 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	
    <div class="writeboke">
    
    	<form id="articleForm" action="${pageContext.request.contextPath }/articleaction_commit.action" method="post" enctype="multipart/form-data">
    	
    	<input type="hidden" name="user.uid" value="${user.uid }"/>
    	
		<p>文章标题
			<span id="message" style="color:green; margin-left: 18px;font-size:12px;display:inline-block;">尊重原创，请保证您的文章为原创作品</span>
		</p>
		<div>
			<select name="type.typeId" id="TypeSel" style="float:left;width:65px;height:27px;" onchange="change()"> 
				<c:forEach items="${tlist }" var="typelist">
					<option id="${typelist.typeId }" value="${typelist.typeId }">${typelist.type }</option>
				</c:forEach>
			</select>
			<input type="text" name="title" style="width:560px; height:20px; float:left;" maxlength="100" />
		</div><br/>

		<p>文章内容</p>
		<div>
		      <textarea name="content" rows="30" style="width:90%;"></textarea>
		</div>
		
		<fieldset style="margin-top: 10px; padding: 4px 10px 10px 10px;">
			<legend>上传图片</legend>
				<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
					<tr>
						<td valign="top">
							<input type="file" name="upload"/><br />
						</td>
						 
						<td rowspan="2" valign="top" style="width: 240px;">
							<div style="border: solid 1px #999; background-color: #f0f0f0; font-size: 11px; padding-left: 10px;">
								<p>1、图片大小不能超过<b>2M</b></p>
								<p>2、支持格式：.jpg .gif .png .bmp</p>
							</div>
						</td>
					</tr>
				</table>
		</fieldset>
		
		<div>
		<p>个人分类 [
			<a href="${pageContext.request.contextPath }/typeaction_findType.action" target="_blank">编辑分类</a>]
		</p>
		<input type="text" id="newmtype" name="newmtype" style="width:60%; height:20px;" maxlength="100" />(多个分类使用","分隔)<br />
<%-- <c:forEach items="${typelist }" var="mytype">
			<label for="${mytype.mtid }"><input type='radio' name="mtype.mtid" id="${mytype.mtid }" value="${mytype.mtid }" />${mytype.mytag }</label>
		</c:forEach>--%>
<%-- 		<c:forEach items="${typelist }" var="mytype">
			<label id="label1" for="${mytype.mtid }"><input type='checkbox' name="checkboxList" id="${mytype.mtid }" value="${mytype.mtid }" onclick="addmytype(this)" />${mytype.mytag }</label>
		</c:forEach> --%>
		<c:forEach items="${typelist }" var="mytype">
			<label for="${mytype.mtid }"><input type='checkbox' id="${mytype.mtid }" value="${mytype.mtid }" onclick="addmytype(this)" />${mytype.mytag }</label>
		</c:forEach>
		</div>
		<div>
		<p>文章分类（到分类首页）</p>
			<c:forEach items="${ftaglist }" var="ftag">
				<input type='radio' name="ftype.ftid" id="${ftag.ftid }" value="${ftag.ftid }" /><label for="${ftag.ftid }">${ftag.fttag }</label>
			</c:forEach>
			<br/>
			<span>--------------------------------------------------------------------------------------------
			-------------------------------------------------------------------------------------------</span>
		</div>
		
		<div style="width:400px;margin:0 auto;">
			<input type="submit" value="发表文章" />
			<input type="button" value="立即保存" onclick="saveBtnClick()"/>
			<input type="reset" value="重写" />   
		</div>
		
		</form>

</div>
<div style="width:1000px;margin:0 auto;color:gray;" >
	<p style="text-indent:2em;">提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
</div>
  
</body>
</html>
