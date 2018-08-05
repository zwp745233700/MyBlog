package com.zwp.dao;

import java.util.List;

import com.zwp.domain.Discuss;

public interface DiscussDao {

	void addDiscuss(Discuss discuss);

	List<Discuss> findArticleDis(int aid);

	void delDiscuss(int disId);

}
