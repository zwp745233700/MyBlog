package com.zwp.domain;

import java.util.HashSet;
import java.util.Set;

public class State {

	private int stateId;
	private String state;
	
	private Set<article> setarticle=new HashSet<article>();
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<article> getSetarticle() {
		return setarticle;
	}
	public void setSetarticle(Set<article> setarticle) {
		this.setarticle = setarticle;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

}
