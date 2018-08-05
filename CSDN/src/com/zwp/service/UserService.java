package com.zwp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zwp.dao.UserDao;
import com.zwp.domain.User;

@Transactional
public class UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User login(User user) {
		return userDao.login(user);
	}

	public User add(User user) {
		return userDao.add(user);
	}

	public List<User> findOne(int uid) {
		return userDao.findOne(uid);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	public void delUser(int uid) {
		userDao.delUser(uid);
	}


}
