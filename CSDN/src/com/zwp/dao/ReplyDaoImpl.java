package com.zwp.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.Reply;
import com.zwp.domain.article;

@Transactional(readOnly = false)
public class ReplyDaoImpl implements ReplyDao {
	
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//回复用户评论：
	public void addreply(Reply reply) {
		hibernateTemplate.save(reply);
	}

	//根据文章id查找所以的评论
	public List<Reply> findReply(int aid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reply.class);
		criteria.add(Restrictions.eq("article.id", aid));
		List<Reply> list =(List<Reply>) hibernateTemplate.findByCriteria(criteria);	
		return list;
	}

	
}
