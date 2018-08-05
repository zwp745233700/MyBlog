package com.zwp.dao;

import java.util.List;

import com.zwp.domain.Belong;
import com.zwp.domain.mytype;

public interface BelongDao {

	void addBelong(Belong belong);

	List<Belong> findBelong(int abid);

	void deleteBelong(int aid);
}
