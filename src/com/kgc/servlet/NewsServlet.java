package com.kgc.servlet;

import com.kgc.pojo.News;
import com.kgc.service.news.NewsService;
import com.kgc.service.news.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("findAll".equals(method)){
            this.doFindAllNews(request,response);
        }



        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doFindAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> list_news = newsService.findAllNews();

    }
}
