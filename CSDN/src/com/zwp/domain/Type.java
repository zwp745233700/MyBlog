package com.zwp.domain;

import java.util.HashSet;
import java.util.Set;

public class Type {
	private String typeId;
	private String type;
	
	private Set<article> setarticle=new HashSet<article>();
	
	
	public Set<article> getSetarticle() {
		return setarticle;
	}
	public void setSetarticle(Set<article> setarticle) {
		this.setarticle = setarticle;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
