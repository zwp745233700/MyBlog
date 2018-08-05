package com.zwp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.Belong;
import com.zwp.domain.User;
import com.zwp.domain.article;
import com.zwp.domain.mytype;
import com.zwp.service.ArticleService;
import com.zwp.service.BelongService;
import com.zwp.service.TypeService;

public class BelongAction extends ActionSupport{
	
	private BelongService belongService;
	private TypeService typeService;
	private ArticleService articleService;
	private String aid;
	private String[] chkValue;
	
	
	public void setBelongService(BelongService belongService) {
		this.belongService = belongService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String[] getChkValue() {
		return chkValue;
	}
	public void setChkValue(String[] chkValue) {
		this.chkValue = chkValue;
	}
	
	//ToupdbelongView()和ToupdbelongView2()内容一致，合并；
	//更新文章分类：
	public String ToupdbelongView(){
		//接收页面传过来的文章id
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		//根据id查询文章
		article article1 = articleService.findOne(aid);
		//查询所有的个人分类
		List<mytype> typelist= typeService.findType(uid);
		//查询该文章的分类：
		List<Belong> minetypeList=belongService.findBelong(aid);
		
				
		request.setAttribute("article", article1);
		request.setAttribute("typelist", typelist);
		request.setAttribute("minetypeList", minetypeList);
		
		return "ToupdbelongView";
	}
	
	//通过草稿箱到更新文章分类界面：
	public String ToupdbelongView2(){
		//接收页面传过来的文章id
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		article article1 = articleService.findOne(aid);
		List<mytype> typelist= typeService.findType(uid);
		List<Belong> minetypeList=belongService.findBelong(aid);
		
				
		request.setAttribute("article", article1);
		request.setAttribute("typelist", typelist);
		request.setAttribute("minetypeList", minetypeList);
		
		return "ToupdbelongView2";
	}
	
	
	//updbelong()和updbelongByDrafts()内容一致，合并；
	//更新文章分类
	public String updbelong(){
		
		//先删除该文章再belong表中所有的记录
		int id=Integer.parseInt(aid);
		belongService.deleteBelong(id);
		
		//重新创建文章的分类
		for(int i=0;i<this.getChkValue().length;i++)
		{
			String value=this.getChkValue()[i];
			int mtid=Integer.parseInt(value);
			mytype mytype1=new mytype();
			mytype1.setMtid(mtid);
			
			article article1=new article();
			article1.setAid(id);
	
			Belong belong=new Belong();
			belong.setArticle1(article1);
			belong.setMytype1(mytype1);
			
			belongService.addBelong(belong);
		}
		
		return "Tomanage";
	}
	
	//通过草稿箱更新文章分类
	public String updbelongByDrafts(){
		
		//先删除该文章再belong表中所有的记录
		int id=Integer.parseInt(aid);
		belongService.deleteBelong(id);
		
		//重新创建文章的分类
		for(int i=0;i<this.getChkValue().length;i++)
		{
			String value=this.getChkValue()[i];
			int mtid=Integer.parseInt(value);
			mytype mytype1=new mytype();
			mytype1.setMtid(mtid);
			
			article article1=new article();
			article1.setAid(id);
	
			Belong belong=new Belong();
			belong.setArticle1(article1);
			belong.setMytype1(mytype1);
			
			belongService.addBelong(belong);
		}
		
		//跳转到草稿箱界面：
		return "ToDraftsView";
	}
	
}
