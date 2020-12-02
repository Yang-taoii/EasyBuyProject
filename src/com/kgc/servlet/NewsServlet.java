package com.kgc.servlet;

import com.kgc.pojo.Page;
import com.kgc.service.news.NewsService;
import com.kgc.service.news.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewsServlet",urlPatterns = "/NewsServlet")
public class NewsServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();
    int news_id;
    String news_title;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("showNewsByfenYe".equals(method)){
            this.doShowNews(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doShowNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Page page = new Page();
        String pageIndex=request.getParameter("pageIndex");
        if (pageIndex == null || Integer.parseInt(pageIndex) < 1){
            page.setPageIndex(1);
        }else {
            page.setPageIndex(Integer.parseInt(pageIndex));
        }
        page.setPageSize(3);
        String news_ids = request.getParameter("news_id");
        if (news_ids!=null && !"".equals(news_ids)){
            news_id = Integer.parseInt(news_ids);
        }
        if ("".equals(news_ids)){
            news_id =0;
        }
        news_title = request.getParameter("news_title");
        System.out.println(news_ids+"---"+news_title);
        Page page1 = newsService.fenYe_News(page,news_id,news_title);
//        for (News news:page1.getList_news()) {
//            System.out.println(news.getId()+"--"+news.getTitle());
//        }
        request.getSession().setAttribute("pageNews",page1);
        response.sendRedirect("Manage/news.jsp");
    }

}
