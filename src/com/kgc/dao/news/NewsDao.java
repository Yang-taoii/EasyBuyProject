package com.kgc.dao.news;



import com.kgc.dao.BaseDao;
import com.kgc.pojo.News;

import java.util.List;

/**
 * 新闻的dao
 */
public interface NewsDao{
	/**
	 * 添加新闻
	 */
	void add(News news) throws Exception;
	/**
	 * 修改新闻
	 */
	void update(News news) throws Exception;
	/**
	 * 根据id删除新闻
	 */
	void deleteById(Integer id) throws Exception;
	/**
	 * 根据id查询新闻
	 */
	News getNewsById(Integer id)throws Exception;
	/**
	 * 查询新闻列表
	 */
	List<News> queryNewsList(News params)throws Exception;
	/**
	 * 查询新闻的数目
	 */
	int queryNewsCount(News params)throws Exception;
}
