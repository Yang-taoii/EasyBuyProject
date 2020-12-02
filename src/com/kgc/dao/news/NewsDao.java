package com.kgc.dao.news;
import com.kgc.pojo.News;
import com.kgc.pojo.Page;
import com.kgc.pojo.User;

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
	int addNews(News news);
	/**
	 * 修改新闻
	 */
	int updateNews(News news) ;
	/**
	 * 根据id删除新闻
	 */
	int deleteNewsById(int id) ;
	/**
	 * 根据id查询新闻
	 */
	News getNewsById(int id);



	List<News> fenYe_News(Page page, int news_id, String news_title);
	int fenYeCount(Page page,int news_id, String news_title);






}
