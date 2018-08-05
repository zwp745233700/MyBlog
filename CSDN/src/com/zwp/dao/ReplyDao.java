package com.zwp.dao;

import java.util.List;

import com.zwp.domain.Reply;

public interface ReplyDao {

	void addreply(Reply reply);

	List<Reply> findReply(int aid);

}
