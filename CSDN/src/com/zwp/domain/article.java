package com.zwp.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class article{
	
	private int aid;//文章的id
	private String title;//文章标题
	private String content;//文章内容
	private Date date;//文章发表的时间
	private String pic;//上传的图片
	private int allow;//是否允许评论：1为允许，2为禁止；默认为允许
	
	private State state;//文章的状态：待审核、发表、草稿箱、回收站
	private Type type;//原创或者转载
	private User user;//文章所属的用户
	private FirstType ftype;//首页文章类型
	
	private Set<Belong> setBelong=new HashSet<Belong>();
	private Set<Discuss> setDiscuss=new HashSet<Discuss>();
	private Set<Reply> setReply=new HashSet<Reply>();
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type=type;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public FirstType getFtype() {
		return ftype;
	}
	public void setFtype(FirstType ftype) {
		this.ftype = ftype;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Belong> getSetBelong() {
		return setBelong;
	}
	public void setSetBelong(Set<Belong> setBelong) {
		this.setBelong = setBelong;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Set<Discuss> getSetDiscuss() {
		return setDiscuss;
	}
	public void setSetDiscuss(Set<Discuss> setDiscuss) {
		this.setDiscuss = setDiscuss;
	}
	public int getAllow() {
		return allow;
	}
	public void setAllow(int allow) {
		this.allow = allow;
	}
	public Set<Reply> getSetReply() {
		return setReply;
	}
	public void setSetReply(Set<Reply> setReply) {
		this.setReply = setReply;
	}
}
