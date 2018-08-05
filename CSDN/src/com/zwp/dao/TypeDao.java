package com.zwp.dao;

import java.util.List;

import com.zwp.domain.FirstType;
import com.zwp.domain.Type;
import com.zwp.domain.mytype;

public interface TypeDao {

	public List<mytype> findType(int uid);

	public void addmytag(mytype mtype);

	public mytype findOne(int mtid);

	public void delmytag(mytype mtag);

	public void updatetag(mytype mtype);

	public List<mytype> conditionfind(mytype mtype,int uid);

	public List<FirstType> findFtag();

	public List<Type> findAllType();

	public List<mytype> findTypeByName(String name, int uid);

}
