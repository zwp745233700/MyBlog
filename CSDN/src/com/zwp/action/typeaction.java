package com.zwp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.User;
import com.zwp.domain.mytype;
import com.zwp.service.TypeService;

public class typeaction extends ActionSupport implements ModelDriven<mytype>{
	
	//模型驱动封装
	private mytype mtype = new mytype();
	public mytype getModel() {
		return mtype;
	}
	
	private TypeService typeService;
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	//查找所有mytype自定义标签
	public String findType()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		List<mytype> typelist= typeService.findType(uid);
		request.getSession().setAttribute("typelist", typelist);
		return "totypePage";
	}
	
	//添加自定义标签
	public String addmytag()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		mtype.setUser(user);
		
		typeService.addmytag(mtype);
		return "totypePage1";
	}
	
	//删除自定义标签
	public String delmytag()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("mtid");
		int mtid=Integer.parseInt(id);
		mytype mtag=typeService.findOne(mtid);
		if(mtag!=null)
		{	
			typeService.delmytag(mtag);
		}
		return "totypePage1";
	}
	
	//修改自定义标签：
	public String editmytag()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		mtype.setUser(user);
		
		typeService.updatetag(mtype);
		
		return "totypePage1";
	}
	
	
	//根据名字，条件查询自定义标签
	public String conditionfind() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		if(mtype.getMytag()!=null && !"".equals(mtype.getMytag())) {
			//输入类别名称，根据名称查询
			List<mytype> typelist = typeService.conditionfind(mtype,uid);
			ServletActionContext.getRequest().setAttribute("typelist", typelist);
		} else {
			//不输入任何内容，查询所有
			List<mytype> typelist = typeService.findType(uid);
			ServletActionContext.getRequest().setAttribute("typelist", typelist);
		}
		return "totypePage";
	}
}
