package com.zwp.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.Discuss;
import com.zwp.domain.mytype;

@Transactional(readOnly = false)
public class DiscussDaoImpl implements DiscussDao{
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//评论文章
	public void addDiscuss(Discuss discuss) {
		hibernateTemplate.save(discuss);
	}

	//根据文章id查找所有的评论：
	public List<Discuss> findArticleDis(int aid) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Discuss.class);
		criteria.add(Restrictions.eq("article.id", aid));
		List<Discuss> list =(List<Discuss>) hibernateTemplate.findByCriteria(criteria);	
		
		return list;
	}

	public void delDiscuss(int disId) {
		List<Discuss> discussList=(List<Discuss>) hibernateTemplate.find("from Discuss where disId=?", disId);
		if(discussList.size()!=0){
			Discuss discuss=discussList.get(0);
			hibernateTemplate.delete(discuss);
		}
	}
}
