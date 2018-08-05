package com.zwp.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int uid;
	private String username;
	private String password;
	
	private String headPic;//用户头像;
	private String realname;//真实姓名
	private String profession;//行业
	private String work;//职业
	
	private String resume;//个人简历：大文本类型
	private String sex;//性别
	private String country;//国家
	
	
	private Set<article> setarticle=new HashSet<article>();
	private Set<mytype> setmytype=new HashSet<mytype>();
	private Set<Discuss> setDiscuss=new HashSet<Discuss>();
	private Set<Reply> setReply=new HashSet<Reply>();
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<article> getSetarticle() {
		return setarticle;
	}
	public void setSetarticle(Set<article> setarticle) {
		this.setarticle = setarticle;
	}
	public Set<mytype> getSetmytype() {
		return setmytype;
	}
	public void setSetmytype(Set<mytype> setmytype) {
		this.setmytype = setmytype;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<Discuss> getSetDiscuss() {
		return setDiscuss;
	}
	public void setSetDiscuss(Set<Discuss> setDiscuss) {
		this.setDiscuss = setDiscuss;
	}
	public Set<Reply> getSetReply() {
		return setReply;
	}
	public void setSetReply(Set<Reply> setReply) {
		this.setReply = setReply;
	}
	
}
