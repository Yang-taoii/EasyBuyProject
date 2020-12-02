package com.kgc.pojo;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {
    private int pageIndex;
    private int pageSize;
    private int totalPage;
    private int totalCount;
    private List<User> list;

    public List<News> getList_news() {
        return list_news;
    }

    public void setList_news(List<News> list_news) {
        this.list_news = list_news;
    }

    private List<News> list_news;

    public Page(int pageIndex , int pageSize)  {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Page() {}

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
