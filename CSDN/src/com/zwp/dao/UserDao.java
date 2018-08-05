package com.zwp.dao;

import java.util.List;

import com.zwp.domain.User;

public interface UserDao {
	
	public User login(User user);

	public User add(User user);

	public List<User> findOne(int uid);

	public void updateUser(User user);

	public List<User> findAllUser();

	public void delUser(int uid);
}
