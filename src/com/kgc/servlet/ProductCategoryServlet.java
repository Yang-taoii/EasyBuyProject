package com.kgc.servlet;

import com.kgc.pojo.Product;
import com.kgc.pojo.ProductCategory;
import com.kgc.service.product.ProductCategoryService;
import com.kgc.service.product.ProductCategoryServiceImpl;
import com.kgc.service.product.ProductService;
import com.kgc.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductCategoryServlet",urlPatterns = "/ProductCategoryServlet")
public class ProductCategoryServlet extends HttpServlet {

    ProductCategoryService pcs = new ProductCategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("show".equals(method)){
            this.doShowCategory(request,response);
        }
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    //展示产品分类
    protected void doShowCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategory> list1 = pcs.findAllParents();
        request.getSession().setAttribute("list",list1);
        response.sendRedirect("EasyBuy/index.jsp");
    }

}
