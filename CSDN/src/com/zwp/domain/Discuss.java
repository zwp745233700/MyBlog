package com.zwp.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Discuss {
	private int disId;
	private String disContent;
	private Date date;
	
	private User user;
	private article article;
	private Set<Reply> setReply=new HashSet<Reply>();
	
	public int getDisId() {
		return disId;
	}
	public void setDisId(int disId) {
		this.disId = disId;
	}
	public String getDisContent() {
		return disContent;
	}
	public void setDisContent(String disContent) {
		this.disContent = disContent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public article getArticle() {
		return article;
	}
	public void setArticle(article article) {
		this.article = article;
	}
	public Set<Reply> getSetReply() {
		return setReply;
	}
	public void setSetReply(Set<Reply> setReply) {
		this.setReply = setReply;
	}

	
	
}
