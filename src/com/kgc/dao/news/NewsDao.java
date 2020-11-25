package com.kgc.dao.news;
import com.kgc.pojo.News;

import java.util.List;

/**
 * 新闻的dao
 */
public interface NewsDao{
	/**
	 * 查询全部新闻
	 */
	List<News> findAllNews();


	/**
	 * 添加新闻
	 */
	void add(News news);
	/**
	 * 修改新闻
	 */
	void update(News news) ;
	/**
	 * 根据id删除新闻
	 */
	void deleteById(Integer id) ;
	/**
	 * 根据id查询新闻
	 */
	News getNewsById(Integer id);
	/**
	 * 查询新闻列表
	 */
	List<News> queryNewsList(News params);
	/**
	 * 查询新闻的数目
	 */
	int queryNewsCount(News params);





}
