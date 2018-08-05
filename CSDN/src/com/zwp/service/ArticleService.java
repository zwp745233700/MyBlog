package com.zwp.service;

import java.util.List;

import com.zwp.dao.ArticleDao;
import com.zwp.domain.article;

public class ArticleService {
	
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public void commit(article article1) {
		articleDao.commit(article1);
	}
	public List<article> findAllArticle(int uid) {
		return articleDao.findAllArticle(uid);
	}
	public article findOne(int aid) {
		return articleDao.findOne(aid);
	}
	public void delartilce(article article1) {
		articleDao.delartilce(article1);
	}
	public void updartilce(article article1) {
		articleDao.updartilce(article1); 
	}
	public List<article> FindByTypes(String type1, String type2, int uid) {
		return articleDao.FindByTypes(type1,type2,uid);
	}
	public List<article> findDrafts(int uid) {
		return articleDao.findDrafts(uid);
	}
	public List<article> findRecycle(int uid) {
		return articleDao.findRecycle(uid);
	}
	public List<article> findAll() {
		return articleDao.findAll();
	}
	public List<article> AllUserArticle() {
		return articleDao.AllUserArticle();
	}
}
