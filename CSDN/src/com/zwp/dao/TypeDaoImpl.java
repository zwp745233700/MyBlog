package com.zwp.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.FirstType;
import com.zwp.domain.Type;
import com.zwp.domain.mytype;

@Transactional(readOnly = false)
public class TypeDaoImpl implements TypeDao {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	
	
	//查询所有的首要分类
	public List<FirstType> findFtag() {
		List<FirstType> list=(List<FirstType>) hibernateTemplate.find("from FirstType");
		return list;
	}
	//查询所有的文章分类
	public List<Type> findAllType() {
		List<Type> list=(List<Type>) hibernateTemplate.find("from Type");
		return list;
	}
	//查找用户id查找个人分类
	public List<mytype> findType(int uid) {
		List<mytype> list=(List<mytype>) hibernateTemplate.find("from mytype where umid=?",uid);
		return list;
	}
	//添加用户的个人分类，对象中需要有用户的id
	public void addmytag(mytype mtype) {
		hibernateTemplate.save(mtype);
	}
	//根据个人分类的Id进行查询
	public mytype findOne(int mtid) 
	{
		mytype mtag=hibernateTemplate.get(mytype.class,mtid);
		return mtag;
	}
	//根据个人类别对象进行删除
	public void delmytag(mytype mtag) {
		hibernateTemplate.delete(mtag);
	}
	//修改个人类别
	public void updatetag(mytype mtype) {
		hibernateTemplate.update(mtype);
	}
	
	//多条件查询：需要有用户的id
	public List<mytype> conditionfind(mytype mtype,int uid) {
		// 1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(mytype.class);
		// 2 设置对实体类哪个属性
		criteria.add(Restrictions.like("mytag", "%"+mtype.getMytag()+"%"));
		//设置外键：离线查询不能直接使用外键的名称
		criteria.add(Restrictions.eq("user.id", uid));
		// 3 调用hibernateTemplate里面的方法得到list集合
		List<mytype> list =(List<mytype>) hibernateTemplate.findByCriteria(criteria);	
	
		return list;
	}
	//根据个人类别的名称进行查询：需要用户Id
	public List<mytype> findTypeByName(String name,int uid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(mytype.class);
		criteria.add(Restrictions.eq("mytag",name));
		criteria.add(Restrictions.eq("user.id", uid));
		List<mytype> list =(List<mytype>) hibernateTemplate.findByCriteria(criteria);	
		
		return list;
	}
}
