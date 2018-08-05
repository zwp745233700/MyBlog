package com.zwp.service;

import java.util.List;

import com.zwp.dao.BelongDao;
import com.zwp.domain.Belong;
import com.zwp.domain.mytype;

public class BelongService {
	private BelongDao belongDao;
	public void setBelongDao(BelongDao belongDao) {
		this.belongDao = belongDao;
	}
	
	
	public void addBelong(Belong belong) {
		belongDao.addBelong(belong);
	}
	public List<Belong> findBelong(int aid) {
		return belongDao.findBelong(aid);
	}
	public void deleteBelong(int aid) {
		belongDao.deleteBelong(aid);
	}
	
}
