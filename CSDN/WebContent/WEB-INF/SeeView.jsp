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
				<c:if test="${article.user.headPic!=null }">
					<a href="${pageContext.request.contextPath }/useraction_???uid=${article.user.uid}"><img class="pic" src="/pictures/${article.user.headPic }" /></a>
				</c:if>
				<c:if test="${article.user.headPic==null }">
					<a href="${pageContext.request.contextPath }/useraction_???uid=${article.user.uid}"><img class="pic" src="images/headpic.jpg" /></a>
				</c:if>
				<div style="clear:both;"></div>
				<div class="div1">
					${article.user.username }<br/>
					<input type="button" value="+加关注" ></input>
					<input type="button" value="发私信" ></input><br/>
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
		<div class="right_top">
			<div class="title">
				<span style="font-size:30px;">(${article.type.type})&nbsp;&nbsp;&nbsp;&nbsp;${article.title }</span><br/>
				<span style="float:right">${article.date }&nbsp;&nbsp;&nbsp;68人阅读&nbsp;&nbsp;&nbsp;<a href="#">评论</a>(5)<a href="#"></a>&nbsp;&nbsp;<a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></span>
			</div>
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
				<c:if test="${article.pic!=null }"><br/><br/><br/>
					文章图片：<br/>
					<img src="/pictures/${article.pic }" style="margin-top:30px;margin-left:250px;width:250px;height:250px;"/>
				</c:if>
			</div>
		</div>
		
		<!-- 最底部：文章的评论 -->
		<div class="discuss">
			<br/>
			<span style="font-size:20px;margin-left:10px;">查看评论:</span><br/>
					<span>---------------------------------------------------------------
				----------------------------------------------------</span><br/><br/>
				<c:forEach items="${discussList }" var="discuss">
					<div style="weight:800px;border:1px solid gray;">
						<c:if test="${article.aid==discuss.article.aid }">
							${discuss.user.username }用户在${discuss.date }发表了评论:<br/>
							评论内容：${discuss.disContent }<br/>
								<c:if test="${replyList!=null }">
									<c:forEach items="${replyList }" var="reply">
										<c:if test="${reply.discuss.disId==discuss.disId }">
											&nbsp;&nbsp;&nbsp;&nbsp;用户${reply.user.username }在${reply.date }回复了：${reply.reContext }
											<br/>
										</c:if>
									</c:forEach>
								</c:if>
							<br/>	
								
							
								<div id="reply${discuss.disId }" style="float:left;width:800px;display:none;">
									<form action="${pageContext.request.contextPath }/replyAction_reply.action" method="post">
										<input id="${discuss.disId }" type="text" name="reContext" placeholder="输入回复的内容"/>
										<input type="hidden" name="article.aid" value="${article.aid }"/>
										<input type="hidden" name="user.uid" value="${user.uid }"/>
										<input type="hidden" name="discuss.disId" value="${discuss.disId }"/>
										<input type="submit" value="回复"/>
									</form>
								</div>
								<div style="text-align:right;">
									<a href="javascript:viod(0)" onclick="reply('reply'+${discuss.disId })">回复</a>
								</div>
								
						<c:if test="${article.user.uid==user.uid }">	
								<div style="text-align:right;">
										<a href="${pageContext.request.contextPath }/discussAction_delDiscuss.action?disId=${discuss.disId}&aid=${discuss.article.aid}">删除评论</a>
								</div>
							</c:if>
						</c:if>
					</div>
				</c:forEach>
			<div>
			
			</div>
			<div>
				<br/>
				<form action="${pageContext.request.contextPath }/discussAction_addDiscuss.action" method="post">
					<span style="font-size:20px;margin-left:10px;">发表评论</span><br/>
					<span>---------------------------------------------------------------
				----------------------------------------------------</span><br/>
					<span style="margin-left:100px;">用户名：${user.username }</span><br/>
					<input type="hidden" name="user.uid" value="${user.uid }"/>
					<input type="hidden" name="article.aid" value="${article.aid }"/>
					<span style="margin-left:100px;">评论内容：</span>
						
					<div style="margin-left:170px;">
						<textarea name="disContent" style="width:400px;height:200px;"></textarea>
					</div>
					<input style="margin-top:10px;margin-left:170px;width:80px;" type="submit" value="提交"/>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
