package com.zwp.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.Belong;
import com.zwp.domain.mytype;

@Transactional
public class BelongDaoImpl implements BelongDao {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void addBelong(Belong belong) {
		hibernateTemplate.saveOrUpdate(belong);
	}

	public List<Belong> findBelong(int abid) {
		List<Belong> list=(List<Belong>) hibernateTemplate.find("from Belong where abid=?", abid);
		return list;
	}

	//…æ≥˝£∫œ»≤È‘Ÿ…æ
	public void deleteBelong(int aid) {
		List<Belong> list=(List<Belong>) hibernateTemplate.find("from Belong where abid=?", aid);
		for(Belong bl:list)
		{
			hibernateTemplate.delete(bl);
		}
	}
}
