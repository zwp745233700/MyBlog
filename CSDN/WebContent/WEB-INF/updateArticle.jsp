<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="css/writeboke.css" type="text/css" />
	<script type="text/javascript" src="/CSDN/js/edittype.js"></script>
	<script type="text/javascript">
			function delBtnClick(){
			document.forms.articleForm.action="${pageContext.request.contextPath }/articleaction_takeTorecycle.action";
			document.forms.articleForm.submit();
		}
	</script>
	
	<title>发表文章 - CSDN博客</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<jsp:include page="head.jsp" />	
    <div class="writeboke">
    
    	<form id="articleForm" action="${pageContext.request.contextPath }/articleaction_updartilce.action" method="post" enctype="multipart/form-data">
    	
    	<input type="hidden" name="user.uid" value="${user.uid }"/>
    	<input type="hidden" name="aid" value="${article.aid }"/>
    	
		<p>文章标题
			<span id="message" style="color:green; margin-left: 18px;font-size:12px;display:inline-block;">尊重原创，请保证您的文章为原创作品</span>
		</p>
		<div>
			<select name="type.typeId" id="TypeSel" style="float:left;width:65px;height:27px;" onchange="change()"> 
				<c:forEach items="${tlist }" var="typelist">
					<option id="${typelist.typeId }" value="${typelist.typeId }"
						<c:if test="${typelist.typeId==article.type.typeId }">selected</c:if>>${typelist.type }
					</option>
				</c:forEach>
			</select>
			<input type="text" name="title" value="${article.title }" style="width:560px; height:20px; float:left;" maxlength="100" />
		</div><br/>

		<p>文章内容</p>
		<div>
		      <textarea name="content" rows="30" style="width:90%;">${article.content }</textarea>
		</div>
		
		<fieldset style="margin-top: 10px; padding: 4px 10px 10px 10px;">
			<legend>上传图片</legend>
				<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
					<tr>
						<td valign="top">
							<c:if test="${article.pic!=null }">
								<img src="/pictures/${article.pic }" width=100 height=100 /><br/>
							</c:if>
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
		<input type="text" id="newmtype" name="newmtype" value="${minetext }" style="width:60%; height:20px;" maxlength="100" />(多个分类使用","分隔)<br />
		<c:forEach items="${typelist }" var="mytype">
			<label for="${mytype.mtid }"><input type='checkbox' id="${mytype.mtid }" value="${mytype.mtid }" onclick="addmytype(this)" 
				<c:forEach items="${minetypeList }" var="mine">
					<c:if test="${mytype.mtid==mine.mytype1.mtid }">checked="checked"</c:if>
				</c:forEach>
			/>${mytype.mytag }</label>
		</c:forEach>
		</div>
		
		<div>
		<p>文章分类（到分类首页）</p>
			<c:forEach items="${ftaglist }" var="ftag">
				<label for="${ftag.ftid }"><input type='radio' name="ftype.ftid" id="${ftag.ftid }" value="${ftag.ftid }" 
				<c:if test="${ftag.ftid==article.ftype.ftid }">checked</c:if>/>${ftag.fttag }</label>
			</c:forEach>
		</div>
		<br/>
		是否允许评论：
		<input type="radio" name="allow" value="Y" />允许
		<input type="radio" name="allow" value="Y" />禁止
		<br />
		
		
		<div style="width:400px;margin:0 auto;">
			<input type="submit" value="修改文章" />
			<input type="reset" value="取消修改" />
			<input type="button" value="舍弃" onclick="delBtnClick()" />   
		</div>
		
		</form>

</div>
<div style="width:1000px;margin:0 auto;color:gray;" >
	<p style="text-indent:2em;">提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
</div>
  
</body>
</html>
