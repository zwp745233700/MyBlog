package com.zwp.domain;

import java.util.HashSet;
import java.util.Set;

public class FirstType {
	private String ftid;
	private String fttag;
	
	private Set<article> setarticle=new HashSet<article>();
	
	
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	public String getFttag() {
		return fttag;
	}
	public void setFttag(String fttag) {
		this.fttag = fttag;
	}
	public Set<article> getSetarticle() {
		return setarticle;
	}
	public void setSetarticle(Set<article> setarticle) {
		this.setarticle = setarticle;
	}
}
