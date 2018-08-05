package com.zwp.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.Reply;
import com.zwp.service.ReplyService;

public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	Reply reply =new Reply();
	public Reply getModel() {
		return reply;
	}
	
	//»Ø¸´ÆÀÂÛ£º
	public String reply()
	{
		Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        reply.setDate(sqlDate);
        
		replyService.addreply(reply);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("aid",reply.getArticle().getAid());
		
		return "replyOk";
	}
	
	
}
