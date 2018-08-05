package com.zwp.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.Manage;

@Transactional(readOnly = false)
public class ManageDaoImpl implements ManageDao {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//¹ÜÀíÔ±µÇÂ½£º
	public Manage find(Manage manage) {
		List<Manage> list=
				(List<Manage>) hibernateTemplate.find("from Manage where musername=? and mpassword=?",manage.getMusername(),manage.getMpassword());
		Manage m = null;
		if(list.size()>0)
		{
			m=list.get(0);
		}
		return m;
	}
}
