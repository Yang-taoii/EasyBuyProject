package com.kgc.service.news;

import com.kgc.pojo.News;
import com.kgc.pojo.Page;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();


    Page fenYe_News(Page page, int news_id, String news_title);
}
