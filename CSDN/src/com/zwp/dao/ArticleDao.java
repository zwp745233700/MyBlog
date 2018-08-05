package com.zwp.dao;

import java.util.List;

import com.zwp.domain.article;

public interface ArticleDao {

	void commit(article article1);

	List<article> findAllArticle(int uid);

	article findOne(int aid);

	void delartilce(article article1);

	void updartilce(article article1);

	List<article> FindByTypes(String type1, String type2, int uid);

	List<article> findDrafts(int uid);

	List<article> findRecycle(int uid);

	List<article> findAll();

	List<article> AllUserArticle();
}
