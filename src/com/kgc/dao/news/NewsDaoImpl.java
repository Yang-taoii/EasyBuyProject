package com.kgc.dao.news;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import com.kgc.dao.BaseDao;
import com.kgc.pojo.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	public News tableToClass(ResultSet rs) throws Exception {
		News news = new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setContent(rs.getString("content"));
		news.setCreateTime(rs.getDate("createTime"));
		return news;
	}

	public void add(News news) throws Exception {// 保存新闻
		String sql = " INSERT into easybuy_news(title,content,createTime) values( ?, ?, ?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), new Date() };
		this.update(sql, params);
	}

	public void update(News news) throws Exception {// 更新新闻
		String sql = " update easybuy_news set title=?,content=? where id=? ";
		Object[] params = new Object[] {news.getTitle(), news.getContent(),news.getId() };
		this.update(sql, params);
	}

	public void deleteById(Integer id) throws Exception {
		String sql = " delete from easybuy_news where id = ? ";
		Object params[] = new Object[] { id };
		this.update(sql.toString(), params);
	}

	public News getNewsById(Integer id) {
		String sql = " select * from easybuy_news where id = ? ";
		ResultSet resultSet = null;
		News news = null;
		try {
			Object params[] = new Object[] { id };
			resultSet = this.query(sql, params);
			while (resultSet.next()) {
				news = tableToClass(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con,ps,rs);
			return news;
		}
	}

	@Override
	public List<News> queryNewsList(News params) throws Exception {
		return null;
	}

	@Override
	public int queryNewsCount(News params) throws Exception {
		return 0;
	}


}
