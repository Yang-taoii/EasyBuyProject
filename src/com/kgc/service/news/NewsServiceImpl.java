package com.kgc.service.news;

import com.kgc.dao.news.NewsDao;
import com.kgc.dao.news.NewsDaoImpl;
import com.kgc.pojo.News;
import com.kgc.pojo.Page;
import com.kgc.pojo.User;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();
    }

    @Override
    public Page fenYe_News(Page page, int news_id, String news_title) {
        int index = page.getPageIndex();
        int size = page.getPageSize();
        int realIndex = (index-1)*size;
        Page page1 = new Page(realIndex,size);

        List<News> list_news = newsDao.fenYe_News(page1,news_id,news_title);
        int totalCount = newsDao.fenYeCount(page1,news_id,news_title);
        int totalPage=0;
        if(totalCount>0){
            totalPage=totalCount%size==0?(totalCount/size):(totalCount/size+1);
        }
        Page page2 = new Page();
        page2.setList_news(list_news);
        page2.setPageIndex(index);
        page2.setPageSize(size);
        page2.setTotalPage(totalPage);
        page2.setTotalCount(totalCount);
        return page2;
    }
}
