package com.zwp.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.Discuss;
import com.zwp.service.DiscussService;

public class DiscussAction extends ActionSupport implements ModelDriven<Discuss>{

	Discuss discuss=new Discuss();
	public Discuss getModel() {
		return discuss;
	}
	
	private DiscussService discussService;
	public DiscussService getDiscussService() {
		return discussService;
	}
	public void setDiscussService(DiscussService discussService) {
		this.discussService = discussService;
	}
	
	
	//到评论管理界面：
	public String toDisManagerView()
	{
		//从数据库中查询出在评论管理界面显示的数据：
		//默认显示我文章的评论：
		return "toDisManagerView";
	}
	
	
	//添加评论
	public String addDiscuss()
	{		
		//评论的时间：
		Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        discuss.setDate(sqlDate);
		discussService.addDiscuss(discuss);
		
		//取出文章的id
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("aid",discuss.getArticle().getAid());
		
		//回到原本的文章界面
		return "OK";
	}
	
	//删除评论：
	public String delDiscuss()
	{		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("disId");
		int disId=Integer.parseInt(id);
		
		discussService.delDiscuss(disId);
		
		String aid=request.getParameter("aid");
		request.setAttribute("aid",aid);
		//回到原本的文章界面
		return "delOk";
	}
	
	
}
