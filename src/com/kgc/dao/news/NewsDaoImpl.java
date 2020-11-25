package com.kgc.dao.news;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kgc.dao.BaseDao;
import com.kgc.pojo.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List<News> findAllNews() {
		List<News> newsList = new ArrayList<>();
		String sql = "select * from easybuy_news";
		rs = this.query(sql,null);
		try{
			while (rs.next()){
				News news = new News();
				news.setId(rs.getInt("EN_ID"));
				news.setContent(rs.getString("EN_CONTENT"));
				news.setTitle(rs.getString("EN_TITLE"));
				news.setCreateTime(rs.getDate("EN_CREATE_TIME"));
				newsList.add(news);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			this.closeAll(con,ps,rs);
		}
		return newsList;
	}

	public void add(News news){// 保存新闻
		String sql = " INSERT into easybuy_news(title,content,createTime) values( ?, ?, ?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), new Date() };
		this.update(sql, params);
	}

	public void update(News news){// 更新新闻
		String sql = " update easybuy_news set title=?,content=? where id=? ";
		Object[] params = new Object[] {news.getTitle(), news.getContent(),news.getId() };
		this.update(sql, params);
	}

	public void deleteById(Integer id)  {
		String sql = " delete from easybuy_news where id = ? ";
		Object params[] = new Object[] { id };
		this.update(sql.toString(), params);
	}

	public News getNewsById(Integer id) {
		return null;
	}





	@Override
	public List<News> queryNewsList(News params) {
		return null;
	}

	@Override
	public int queryNewsCount(News params)  {
		return 0;
	}



}
