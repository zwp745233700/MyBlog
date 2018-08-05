package com.zwp.domain;

import java.util.Date;

public class Reply {
	private int rid;
	private Date date;
	private String reContext;
	
	private User user;
	private article article;
	private Discuss discuss;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReContext() {
		return reContext;
	}
	public void setReContext(String reContext) {
		this.reContext = reContext;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setArticle(article article) {
		this.article = article;
	}
	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}
	public User getUser() {
		return user;
	}
	public article getArticle() {
		return article;
	}
	public Discuss getDiscuss() {
		return discuss;
	}
	
	
}
