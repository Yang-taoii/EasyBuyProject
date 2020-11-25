package com.kgc.service.news;

import com.kgc.dao.news.NewsDao;
import com.kgc.dao.news.NewsDaoImpl;
import com.kgc.pojo.News;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();
    }
}
