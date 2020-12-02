package com.kgc.dao.news;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kgc.dao.BaseDao;
import com.kgc.pojo.News;
import com.kgc.pojo.Page;


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

	public int addNews(News news){// 保存新闻
		String sql = " INSERT into easybuy_news(title,content,createTime) values( ?, ?, ?) ";
		Object[] params = new Object[] { news.getTitle(), news.getContent(), new Date().getDate() };
		return this.update(sql, params);
	}

	public int updateNews(News news){// 更新新闻
		String sql = " update easybuy_news set title=?,content=? where id=? ";
		Object[] params = new Object[] {news.getTitle(), news.getContent(),news.getId() };
		return this.update(sql, params);
	}

	public int deleteNewsById(int id)  {
		String sql = " delete from easybuy_news where id = ? ";
		Object params[] = new Object[] { id };
		return this.update(sql, params);
	}

	@Override
	public News getNewsById(int id) {
		return null;
	}









	//分页+条件 查询新闻
	@Override
	public List<News> fenYe_News(Page page, int news_id, String news_title) {
		List<News> list_news = new ArrayList<>();
		String sql = "select * from easybuy_news where 1=1 ";
		if (news_id!=0){
			sql +="and EN_ID='"+news_id+"'";
		}
		if (news_title!=null && !news_title.equals("")){
			sql +=" and EN_TITLE='"+news_title+"'";
		}
		sql +=" limit ?,?";
		System.out.println(sql);
		Object[] objects = {page.getPageIndex(),page.getPageSize()};
		rs = this.query(sql,objects);
		try{
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt("EN_ID"));
				news.setTitle(rs.getString("EN_TITLE"));
				news.setContent(rs.getString("EN_CONTENT"));
				news.setCreateTime(rs.getDate("EN_CREATE_TIME"));
				list_news.add(news);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			this.closeAll(con,ps,rs);
		}
		return list_news;
	}

	@Override
	public int fenYeCount(Page page, int news_id, String news_title) {
		String sql="select count(1) from easybuy_news where 1=1 ";
		if (news_id!=0){
			sql +="and EN_ID='"+news_id+"'";
		}
		if (news_title!=null && !news_title.equals("")){
			sql +=" and EN_TITLE='"+news_title+"'";
		}
		int count1=0;
		rs=query(sql, null);
		try{
			while(rs.next()){
				count1=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return count1;
	}


}
