package com.zwp.action;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwp.domain.Belong;
import com.zwp.domain.Discuss;
import com.zwp.domain.FirstType;
import com.zwp.domain.Reply;
import com.zwp.domain.State;
import com.zwp.domain.Type;
import com.zwp.domain.User;
import com.zwp.domain.article;
import com.zwp.domain.mytype;
import com.zwp.service.ArticleService;
import com.zwp.service.BelongService;
import com.zwp.service.DiscussService;
import com.zwp.service.ReplyService;
import com.zwp.service.TypeService;
import com.zwp.util.UploadUtil;

public class Articleaction extends ActionSupport implements ModelDriven<article>{
	
	article article1=new article();
	public article getModel() {
		return article1;
	}
	
	//接收文章的图片：
	private File upload;
	private String uploadFileName;
	
	//接收个人分类文本框的值：
	private String newmtype;
	
	//接收所选择的类型
	private String type1;
	private String type2;
	
	private ReplyService replyService;
	private ArticleService articleService;
	private TypeService typeService;
	private BelongService belongService;
	private DiscussService discussService;
	
	
	public void setDiscussService(DiscussService discussService) {
		this.discussService = discussService;
	}
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
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	public void setBelongService(BelongService belongService) {
		this.belongService = belongService;
	}
	public String getNewmtype() {
		return newmtype;
	}
	public void setNewmtype(String newmtype) {
		this.newmtype = newmtype;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	
	//添加文章：
	public String commit() throws IOException
	{	
		//上传图片；返回图片的url
		UploadUtil upLoadUtil=new UploadUtil();
		String url=upLoadUtil.uploadFile(upload,uploadFileName,"article",article1.getUser().getUid());
		//把图片的url存到数据库字段中
		article1.setPic(url);

        //文章创建的时间：
        Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        article1.setDate(sqlDate);
        
        //设置文章的状态：1为审核
        //此处可以直接在页面设置一个隐藏的的hidden提交到模型对象中：
        State state=new State();
        state.setStateId(1);
        
        article1.setState(state);
        
        articleService.commit(article1);
        
        //建立文章和类别的关联：
        String[] stringList=this.getNewmtype().split(",");
        //消除重复的类别名称：
        List list=Arrays.asList(stringList);
        Set set=new HashSet(list);
        String[] mtypeList=(String[]) set.toArray(new String[0]);
        
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
        
        for(int i=0;i<mtypeList.length;i++)
        {
        	//根据名字查询类类别
        	String name=mtypeList[i];
        	List<mytype> list1=typeService.findTypeByName(name,user.getUid());
        	if(!(list1.isEmpty()))
        	{	//存在，直接建立关联
        		mytype mytype1=list1.get(0);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		belongService.addBelong(belong);
        	}else{
        		//不存在，先创建类别，再建立关联
        		mytype mytype1=new mytype();
        		mytype1.setMytag(name);
        		mytype1.setUser(user);
        		typeService.addmytag(mytype1);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		
        		belongService.addBelong(belong);
        	}
        }
		//跳转到文章管理界面：
		return "Tomanage";
	}
	
	//drafts()和commit()代码基本一致，合并；
	//将文章保存到草稿箱：
	public String drafts() throws IOException
	{	
		UploadUtil upLoadUtil=new UploadUtil();
		String url=upLoadUtil.uploadFile(upload,uploadFileName,"article",article1.getUser().getUid());
		article1.setPic(url);

        Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        article1.setDate(sqlDate);
        
        //设置文章的状态：2是草稿箱
        State state=new State();
        state.setStateId(2);
        
        article1.setState(state);
        
        articleService.commit(article1);
        
        
        //建立草稿箱文章和类别的关联：
        String[] stringList=this.getNewmtype().split(",");
        //消除重复的类别：
        List l=Arrays.asList(stringList);
        Set set=new HashSet(l);
        String[] mtypeList=(String[]) set.toArray(new String[0]);
        
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
        
        for(int i=0;i<mtypeList.length;i++)
        {
        	//根据名字查询类类别
        	String name=mtypeList[i];
        	List<mytype> list1=typeService.findTypeByName(name,user.getUid());
        	if(!(list1.isEmpty()))
        	{	//存在
        		mytype mytype1=list1.get(0);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		belongService.addBelong(belong);
        	}else{
        		//不存在
        		mytype mytype1=new mytype();
        		mytype1.setMytag(name);
        		mytype1.setUser(user);
        		typeService.addmytag(mytype1);
        		
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		
        		belongService.addBelong(belong);
        	}
        }
 
        //回到草稿箱页面
		return "Todrafts";
	}
	
	
	//取消删除：将文章放回草稿箱
	public String cancelDel() throws IOException
	{	
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		article article1 = articleService.findOne(aid);
		
        //文章恢复的时间：
        Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        article1.setDate(sqlDate);
        //放入草稿箱：id:2
        State state=new State();
        state.setStateId(2);
        article1.setState(state);
        
        //修改：时间和状态：
        articleService.updartilce(article1);
     
        //回到回收站页面
		return "cancelsuccess";
	}
	
	
	//删除文章：放到回收站：
	public String takeTorecycle() throws IOException
	{	
		int aid=0;
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		aid=Integer.parseInt(id);
		
		article article1 = articleService.findOne(aid);
		
        //文章删除的时间：
        Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        article1.setDate(sqlDate);
        
        //放入回收站：id:4
        State state=new State();
        state.setStateId(4);
        article1.setState(state);
        	
        //修改
        articleService.updartilce(article1);
        
		return "Tomanage";
	}

	//takeTorecycle和takeTorecycleByDrafts()内容完全一样，跳转的页面不一样，合并
	//删除草稿：放到回收站：
	public String takeTorecycleByDrafts() throws IOException
	{	
		int aid=0;
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		aid=Integer.parseInt(id);
		
		article article1 = articleService.findOne(aid);
		
        //文章删除的时间：
        Date date = new Date();
        java.sql.Date sqlDate =new java.sql.Date(date.getTime());
        article1.setDate(sqlDate);
        
        //放入回收站：id:4
        State state=new State();
        state.setStateId(4);
        article1.setState(state);
        	
        //修改
        articleService.updartilce(article1);
        
        //跳转到草稿箱
		return "todraftsview";
	}
	
	
	//彻底删除文章：
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
		
		//最终删除文章，仍然回到回收站页面
		return "delsuccess";
	}
		
	
	//到文章管理界面
	public String manage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取用户的uid
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		List<Type> typelist=typeService.findAllType();
		//将用户id传进去，根据用户id查询：
		List<mytype> mytypelist=typeService.findType(uid);
		List<article> articleList= articleService.findAllArticle(uid);
		
		request.getSession().setAttribute("articleList", articleList);
		request.getSession().setAttribute("typelist", typelist);
		request.getSession().setAttribute("mytypelist", mytypelist);
		
		return "manageView";
	}
	
	
	//到草稿箱界面
	public String todraftsView(){
		HttpServletRequest request = ServletActionContext.getRequest();

		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		List<article> articleList= articleService.findDrafts(uid);
		
		request.getSession().setAttribute("articleList", articleList);
		
		return "todraftsView";
	}
	
	
	//到回收站界面
	public String torecycleView(){
		HttpServletRequest request = ServletActionContext.getRequest();

		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		List<article> articleList= articleService.findRecycle(uid);
		
		request.getSession().setAttribute("articleList", articleList);
		
		return "torecycleView";
	}
	
	
	//Toupdarticle和ToAddArticleByDrafts方法内容一样，跳转页面不一样，合并；
	//到更新页面：
	public String Toupdarticle()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		//查找所有的文章类型：
		//查找所有的首页标签类型：
		article article1 = articleService.findOne(aid);
		List<FirstType> ftaglist= typeService.findFtag();
		List<Type> tlist= typeService.findAllType();
		List<mytype> typelist= typeService.findType(uid);
		List<Belong> minetypeList=belongService.findBelong(aid);
		
		String minetext="";
		for(Belong bl:minetypeList)
		{
			String add=bl.getMytype1().getMytag();
			if("".equals(minetext))
			{
				minetext=minetext+add;
			}else{
				minetext=minetext+","+add;
			}
			
		}
	
		request.setAttribute("minetext", minetext);
		request.setAttribute("ftaglist", ftaglist);
		request.setAttribute("tlist", tlist);
		request.setAttribute("typelist", typelist);
		request.setAttribute("article", article1);
		request.setAttribute("minetypeList", minetypeList);
		
		//跳转到更新页面
		return "toUpdateView";
	}
	
	
	//到草稿箱更新页面：
	public String ToAddArticleByDrafts()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		//查找所有的文章类型：
		//查找所有的首页标签类型：
		article article1 = articleService.findOne(aid);
		List<FirstType> ftaglist= typeService.findFtag();
		List<Type> tlist= typeService.findAllType();
		List<mytype> typelist= typeService.findType(uid);
		List<Belong> minetypeList=belongService.findBelong(aid);
		
		String minetext="";
		for(Belong bl:minetypeList)
		{
			String add=bl.getMytype1().getMytag();
			if("".equals(minetext))
			{
				minetext=minetext+add;
			}else{
				minetext=minetext+","+add;
			}
			
		}
	
		request.setAttribute("minetext", minetext);
		request.setAttribute("ftaglist", ftaglist);
		request.setAttribute("tlist", tlist);
		request.setAttribute("typelist", typelist);
		request.setAttribute("article", article1);
		request.setAttribute("minetypeList", minetypeList);
		
		return "AddArticleByDraftsView";
	}
	
	
	//updartilce和updDraft方法内容基本一样，合并；
	//更新文章：
	public String updartilce()
	{	
		UploadUtil upLoadUtil=new UploadUtil();
		String url=upLoadUtil.uploadFile(upload,uploadFileName,"article",article1.getUser().getUid());
		article1.setPic(url);
		
        //重新设置为审核状态：
        State state=new State();
        state.setStateId(1);
        
        article1.setState(state);
        
        articleService.updartilce(article1);	
        
        //建立文章和类别的关联：
        String[] stringList=this.getNewmtype().split(",");
        //消除重复的类别：
        List l=Arrays.asList(stringList);
        Set set=new HashSet(l);
        String[] mtypeList=(String[]) set.toArray(new String[0]);
        
        //更新文章分类之前，先删除之前文章分类的记录
        belongService.deleteBelong(article1.getAid());
        
        HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
        
        for(int i=0;i<mtypeList.length;i++)
        {	
        	//根据名字查询类类别
        	String name=mtypeList[i];
        	List<mytype> list1=typeService.findTypeByName(name,user.getUid());
        	if(!(list1.isEmpty()))
        	{	//如果存在，则调用更新
        		mytype mytype1=list1.get(0);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		belongService.addBelong(belong);
        	}else{
        		//个人分类不存在，则创建新的个人分类，在建立文章的分类
        		mytype mytype1=new mytype();
        		mytype1.setMytag(name);
        		mytype1.setUser(user);
        		typeService.addmytag(mytype1);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		
        		belongService.addBelong(belong);
        	}
        }
        
		return "Tomanage";
	}
	
	//更新草稿箱里面的文章：
	public String updDraft()
	{	
		UploadUtil upLoadUtil=new UploadUtil();
		String url=upLoadUtil.uploadFile(upload,uploadFileName,"article",article1.getUser().getUid());
		article1.setPic(url);
   
        //重新设置为审核状态：
        State state=new State();
        state.setStateId(2);
        
        article1.setState(state);
        
        articleService.updartilce(article1);	
        
        //建立文章和类别的关联：
        String[] stringList=this.getNewmtype().split(",");
        //消除重复的类别：
        List l=Arrays.asList(stringList);
        Set set=new HashSet(l);
        String[] mtypeList=(String[]) set.toArray(new String[0]);
        
        //更新文章分类之前，先删除之前文章分类的记录
        belongService.deleteBelong(article1.getAid());
        
        HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
        
        for(int i=0;i<mtypeList.length;i++)
        {	
        	//根据名字查询类类别
        	String name=mtypeList[i];
        	List<mytype> list1=typeService.findTypeByName(name,user.getUid());
        	if(!(list1.isEmpty()))
        	{	//如果存在，则调用更新
        		mytype mytype1=list1.get(0);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		belongService.addBelong(belong);
        	}else{
        		//个人分类不存在，则创建新的个人分类，在建立文章的分类
        		mytype mytype1=new mytype();
        		mytype1.setMytag(name);
        		mytype1.setUser(user);
        		typeService.addmytag(mytype1);
        		
        		Belong belong=new Belong();
        		belong.setArticle1(article1);
        		belong.setMytype1(mytype1);
        		
        		belongService.addBelong(belong);
        	}
        }
        
        //跳转到草稿箱界面
		return "Todrafts";
	}
	
	
	//根据类型进行查询：
	public String FindByTypes(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		
		List<Type> typelist=typeService.findAllType();
		List<mytype> mytypelist=typeService.findType(user.getUid());
		
		
		if(type1==""&&type2=="")
		{//如果都为空，查询所有文章
			List<article> articleList= articleService.findAllArticle(user.getUid());
			request.getSession().setAttribute("articleList", articleList);
		}else{
			//否则，根据类别查询
			List<article> articleList=articleService.FindByTypes(type1,type2,user.getUid());
			request.getSession().setAttribute("articleList", articleList);
		}
		
		request.getSession().setAttribute("typelist", typelist);
		request.getSession().setAttribute("mytypelist", mytypelist);
		request.setAttribute("type1", type1);
		request.setAttribute("type2", type2);
		
		return "manageView";
	}
	
	
	//到文章观看页面:
	public String SelectOne()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		
		//查找所有的文章类型：
		//查找所有的首页标签类型：
		article article1 = articleService.findOne(aid);
		List<FirstType> ftaglist= typeService.findFtag();
		List<Type> tlist= typeService.findAllType();
		List<mytype> typelist= typeService.findType(uid);
		List<Belong> minetypeList=belongService.findBelong(aid);
		//查询所有的评论
		List<Discuss> discussList=discussService.findArticleDis(aid);
		//查看文章所有的回复
		List<Reply> replyList=replyService.findReply(aid);
		
		request.setAttribute("ftaglist", ftaglist);
		request.setAttribute("tlist", tlist);
		request.setAttribute("typelist", typelist);
		request.setAttribute("article", article1);
		request.setAttribute("minetypeList", minetypeList);
		request.setAttribute("discussList", discussList);
		request.setAttribute("replyList", replyList);
		
		return "ToSeeView";
	}

	//到管理员文章观看页面:
	public String mSeeOne()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("aid");
		int aid=Integer.parseInt(id);
		
		String id2=request.getParameter("uid");
		int uid=Integer.parseInt(id2);
		
		//查找所有的文章类型：
		//查找所有的首页标签类型：
		article article1 = articleService.findOne(aid);
		List<Type> tlist= typeService.findAllType();
		List<mytype> typelist= typeService.findType(uid);
		List<Belong> minetypeList=belongService.findBelong(aid);
		//查询所有的评论
		List<Discuss> discussList=discussService.findArticleDis(aid);
		
		request.setAttribute("tlist", tlist);
		request.setAttribute("typelist", typelist);
		request.setAttribute("article", article1);
		request.setAttribute("minetypeList", minetypeList);
		request.setAttribute("discussList", discussList);
		
		return "ToManageSeeView";
	}
	
	//到我的博客界面，可观看自己所有的文章：
	public String toMyblok()
	{
		//查找用户 
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("user");
		int uid=user.getUid();
		//查找该用户的文章
		List<article> articleList=articleService.findAllArticle(uid);
		List<mytype> typelist= typeService.findType(uid);
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("typelist", typelist);
		
		return "toMyblok";
	}
	
	//到博客首页：可以观看所有用户发表的文章：
	public String toFirstView()
	{
		//查找用户 
		HttpServletRequest request=ServletActionContext.getRequest();
		
		//查找所有用户的发表的文章
		List<article> articleList=articleService.AllUserArticle();
		
		request.setAttribute("articleList", articleList);
		
		return "toFirstView";
	}

}
