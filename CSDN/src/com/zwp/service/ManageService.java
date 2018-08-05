package com.zwp.service;

import com.zwp.dao.ManageDao;
import com.zwp.domain.Manage;

public class ManageService {

	private ManageDao manageDao;
	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
	public Manage find(Manage manage) {
		return manageDao.find(manage);
	}
	
}
