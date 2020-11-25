package com.kgc.servlet;

import com.kgc.pojo.Product;
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

@WebServlet(name = "ProductServlet",urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    ProductService ps = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("showAllProduct".equals(method)){
            this.doShowAll(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    //展示所有产品
    protected void doShowAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String child_Name = request.getParameter("child_name");
        String father_Name = request.getParameter("father_name");
        List<Product> list = ps.findALlProduct();
        request.getSession().setAttribute("AllProduct",list);
        request.getSession().setAttribute("child_Name",child_Name);
        request.getSession().setAttribute("father_Name",father_Name);
        response.sendRedirect("EasyBuy/product-list.jsp");
    }

    //最近浏览
    protected void doRecentlyViewed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取点击商品id
        int pid = Integer.parseInt(request.getParameter("epid"));
        Product pc = (Product) ps.findALlProductById(pid);
        //放入作用域:
        request. setAttribute("pp", pc);
        //最近浏览处理:
        Cookie[] cks=request. getCookies();
        if (cks!=null && cks.length>0){
            Cookie cookie = null;
            for (Cookie ck : cks){
                String key = ck.getName();
                if ("pids".equals(key)){

                }
            }
        }
    }
}
