package com.zwp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwp.domain.Manage;
import com.zwp.domain.State;
import com.zwp.domain.User;
import com.zwp.domain.article;
import com.zwp.service.ArticleService;
import com.zwp.service.ManageService;
import com.zwp.service.UserService;

public class ManageAction extends ActionSupport{
	
	private String musername;
	private String mpassword;
	
	private UserService userService;
	private ManageService manageService;
	private ArticleService articleService;
	
	
	public String getMusername() {
		return musername;
	}
	public void setMusername(String musername) {
		this.musername = musername;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//判断输入是否为空
		if("".equals(musername) || "".equals(mpassword))
		{
			request.getServletContext().setAttribute("error", "帐户名或登录密码不能为空");
			return "login";
		}else{
			//到数据库进行验证用户是否有该用户：
			Manage manage=new Manage();
			manage.setMusername(musername);
			manage.setMpassword(mpassword);
			
			Manage m=manageService.find(manage);
			if(m!=null)
			{	//存在：跳转到管理员界面：
				request.getSession().setAttribute("manage",m);
				return "mloginsuccess";
			}else{
				//不存在：跳转到登陆界面：
				request.getServletContext().setAttribute("error", "帐户名或登录密码错误");
				return "login";
			}
		}
	}

	
	//管理用户界面
	public String manageUser()
	{
		//查询所有的用户：
		List<User> userList=userService.findAllUser();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userList", userList);
		
		return "ManageUserView";
	}
	
	//删除用户
	public String delUser()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id= request.getParameter("uid");
		int uid=Integer.parseInt(id);
		userService.delUser(uid);
		
		//返回用户管理界面
		return "toManageUserView";
	}
	
	//管理文章界面：
	public String manageArticle()
	{
		//查询所有的文章 
		List<article> articleList=articleService.findAll();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("articleList", articleList);
		return "ManageArticleView";
		
	}

	//删除文章：
	public String delartilce()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		article article1 = articleService.findOne(aid);
		if(article1!=null)
		{	
			articleService.delartilce(article1);
		}
		
		//删除文章,回到文章管理首页
		return "delsuccess";
	}
	
	//passArticle()和dispassArtilce()内容一样，合并；
	//通过审核
	public String passArticle(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String id= request.getParameter("aid");
		int aid=Integer.parseInt(id);
		article article=articleService.findOne(aid);
		
        //设置为发表状态：
        State state=new State();
        state.setStateId(3);
        
        article.setState(state);
		
        articleService.updartilce(article);
        
		return "IfPass";
	}
	
	//审核不通过
	public String dispassArtilce(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String id= request.getParameter("aid");
		int aid=Integer.parseInt(id);
		article article=articleService.findOne(aid);
		
        //设置为发表状态：
        State state=new State();
        state.setStateId(5);
        
        article.setState(state);
		
        articleService.updartilce(article);
        
		return "IfPass";
	}
	
}
