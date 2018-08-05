package com.zwp.service;

import java.util.List;

import com.zwp.dao.DiscussDao;
import com.zwp.domain.Discuss;

public class DiscussService {
	private DiscussDao discussDao;
	public DiscussDao getDiscussDao() {
		return discussDao;
	}
	public void setDiscussDao(DiscussDao discussDao) {
		this.discussDao = discussDao;
	}
	
	public void addDiscuss(Discuss discuss) {
		discussDao.addDiscuss(discuss);
	}
	public List<Discuss> findArticleDis(int aid) {
		return discussDao.findArticleDis(aid);
	}
	public void delDiscuss(int disId) {
		discussDao.delDiscuss(disId);
	}
	
}
