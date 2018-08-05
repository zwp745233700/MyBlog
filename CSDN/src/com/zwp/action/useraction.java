package com.zwp.action;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.FirstType;
import com.zwp.domain.Type;
import com.zwp.domain.User;
import com.zwp.domain.article;
import com.zwp.domain.mytype;
import com.zwp.service.ArticleService;
import com.zwp.service.TypeService;
import com.zwp.service.UserService;
import com.zwp.util.UploadUtil;


public class useraction extends ActionSupport implements ModelDriven<User> {
	
	User user=new User();
	public User getModel() {
		return user;
	}
	
	//接收文章的图片：
	private File upload;
	private String uploadFileName;
	private UserService userService;
	private TypeService typeService;
	private ArticleService articleService;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	//用户登陆：
	public String login()
	{		
		HttpServletRequest request = ServletActionContext.getRequest();
		if("".equals(user.getUsername()) || "".equals(user.getPassword()))
		{
			request.getServletContext().setAttribute("error", "账户名或者密码不能为空");
			return "login";
		}else{
			//是否存在用户
			User userExist = userService.login(user);
			//判断
			if(userExist != null) {//成功
				//使用session保持登录状态
				request.getSession().setAttribute("user", userExist);
				return "loginsuccess";
			} else {//失败
				request.getServletContext().setAttribute("error", "帐户名或登录密码不正确，请重新输入");
				return "login";
			}
		}
		
	}
	
	//跳转到注册页面
	public String toregister()
	{		
		return "toregister";
	}
	
	//注册
	public String register()
	{	
		User userExist = userService.add(user);
		return "login";
	}
	
	//跳转到个人主页,显示发表的文章
	public String topersonView()
	{		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		User user1=(User) request.getSession().getAttribute("user");
		int uid=user1.getUid();
		
		List<User> userlist=userService.findOne(uid);
		User user=userlist.get(0);
		
		List<article> list = articleService.findAllArticle(uid);
		
		request.getSession().setAttribute("user", user);
		request.setAttribute("articlelist", list);
		
		return "topersonView";
	}
	
	//跳转到修改用户界面
	public String editUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("uid");
		int uid=Integer.parseInt(id);
		
		List<User> userlist=userService.findOne(uid);
		User user=userlist.get(0);
		
		request.getSession().setAttribute("user", user);
		return "toeditUserView";
	}
	
	public String updUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user1=(User) request.getSession().getAttribute("user");
		
		//接收图片
        if(upload!=null && upload.length()>0 && uploadFileName!=null && uploadFileName.length()>0)
		{	
            UploadUtil upLoadUtil=new UploadUtil();
    		String url=upLoadUtil.uploadFile(upload,uploadFileName,"HeadImg",user1.getUid());
    		//把图片的url存到数据库字段中
            user1.setHeadPic(url);
            userService.updateUser(user1);
            
		}else if(user.getUid()==0 && upload==null && uploadFileName==null){
			
		}else if(user.getUid()!=0 && upload==null && uploadFileName==null){
			userService.updateUser(user);
		}
		
		return "updsuccess";
	}
	
	//跳转到修改头像界面：
	public String toUpdHeadView(){
		return "toUpdHeadView";
	}
	
	//显示编写文章页面的数据
	public String writeboke()
	{		
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取用户的uid
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		List<FirstType> ftaglist= typeService.findFtag();
		List<Type> tlist= typeService.findAllType();
		List<mytype> typelist= typeService.findType(uid);
		
		
		request.getSession().setAttribute("ftaglist", ftaglist);
		request.getSession().setAttribute("tlist", tlist);
		request.getSession().setAttribute("typelist", typelist);
		
		return "towritePage";
	}

}
