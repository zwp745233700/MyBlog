package com.zwp.service;

import java.util.List;

import com.zwp.dao.TypeDao;
import com.zwp.domain.FirstType;
import com.zwp.domain.Type;
import com.zwp.domain.mytype;

public class TypeService {
	private TypeDao typeDao;
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	public List<mytype> findType(int uid) {
		return typeDao.findType(uid);
	}
	public void addmytag(mytype mtype) {
		typeDao.addmytag(mtype);
	}
	public mytype findOne(int mtid) {
		return typeDao.findOne(mtid);
	}
	public void delmytag(mytype mtag) {
		typeDao.delmytag(mtag);
	}
	public void updatetag(mytype mtype) {
		typeDao.updatetag(mtype);
	}
	public List<mytype> conditionfind(mytype mtype, int uid) {
		return typeDao.conditionfind(mtype,uid);
	}
	public List<FirstType> findFtag() {
		return typeDao.findFtag();
	}
	public List<Type> findAllType() {
		return typeDao.findAllType();
	}
	public List<mytype> findTypeByName(String name, int uid) {
		return typeDao.findTypeByName(name,uid);
	}
}
