package com.zwp.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.zwp.domain.User;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	
	
	
	//登陆
	public User login(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		
		if(list != null && list.size()!=0) {
			User u = list.get(0);
			return u;
		}
		return null;
	}

	//注册
	public User add(User user) {
		hibernateTemplate.save(user);	
		return null;
	}

	//查询用户
	public List<User> findOne(int uid) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where uid=?",uid);
		return list;
	}

	//修改用户信息()
	public void updateUser(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where uid=?",user.getUid());
		User user1=list.get(0);
		
		//赋值
		if(user.getUsername()!=null)
		{
			user1.setUsername(user.getUsername());
		}if(user.getPassword()!=null)
		{
			user1.setPassword(user.getPassword());
		}if(user.getHeadPic()!=null)
		{
			user1.setHeadPic(user.getHeadPic());
		}if(user.getRealname()!=null)
		{
			user1.setRealname(user.getRealname());
		}if(user.getProfession()!=null)
		{
			user1.setProfession(user.getProfession());
		}if(user.getWork()!=null)
		{
			user1.setWork(user.getWork());
		}if(user.getResume()!=null)
		{
			user1.setResume(user.getResume());
		}if(user.getSex()!=null)
		{
			user1.setSex(user.getSex());
		}if(user.getCountry()!=null)
		{
			user1.setCountry(user.getCountry());
		}
		
		hibernateTemplate.update(user1);
	}

	//查询所有的用户
	public List<User> findAllUser() {
		return (List<User>) hibernateTemplate.find("from User");
	}

	//删除用户
	public void delUser(int uid) {
		List<User> list=(List<User>) hibernateTemplate.find("from User where uid=?", uid);
		User user=list.get(0);
		hibernateTemplate.delete(user);
	}
	
}
