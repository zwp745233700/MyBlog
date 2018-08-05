package com.zwp.domain;

import java.util.HashSet;
import java.util.Set;

public class mytype {
	private int mtid;
	private String mytag;
	
	private User user;
	private Set<Belong> setBelong=new HashSet<Belong>();
	
	
	public int getMtid() {
		return mtid;
	}
	public void setMtid(int mtid) {
		this.mtid = mtid;
	}
	public String getMytag() {
		return mytag;
	}
	public void setMytag(String mytag) {
		this.mytag = mytag;
	}
	public Set<Belong> getSetBelong() {
		return setBelong;
	}
	public void setSetBelong(Set<Belong> setBelong) {
		this.setBelong = setBelong;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
