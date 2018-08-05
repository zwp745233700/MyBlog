package com.zwp.service;

import java.util.List;

import com.zwp.dao.ReplyDao;
import com.zwp.domain.Reply;

public class ReplyService {
	
	private ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	public void addreply(Reply reply) {
		replyDao.addreply(reply);
	}
	public List<Reply> findReply(int aid) {
		return replyDao.findReply(aid);
	}
	
	

}
