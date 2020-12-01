package com.kgc.servlet;

import com.kgc.pojo.Product;
import com.kgc.pojo.ShoppingCar;
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
import java.util.ArrayList;
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
        if ("productDetail".equals(method)){
            this.doShowProductDetail(request,response);
        }

        if ("select_product".equals(method)){
            this.doSelectProduct(request,response);
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
        //根据父类id查询子类所有商品
        //System.out.println(request.getParameter("epc_id"));
        int epc_id = Integer.parseInt(request.getParameter("epc_id"));
        List<Product> list_category = ps.findALlProductById(epc_id);
        request.getSession().setAttribute("list_category",list_category);
        request.getSession().setAttribute("child_Name",child_Name);
        request.getSession().setAttribute("father_Name",father_Name);
        response.sendRedirect("EasyBuy/product-list.jsp");
    }


    //展示商品详情
    protected void doShowProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ep_id = Integer.parseInt(request.getParameter("ep_id"));
        System.out.println(ep_id);
        Product product = ps.findProductById(ep_id);
        request.getSession().setAttribute("productDetail",product);
        response.sendRedirect("EasyBuy/product-view.jsp");
    }


    //后端查询商品
    protected void doSelectProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ep_ids = request.getParameter("ep_id");
        String ep_father_ids = request.getParameter("ep_father_id");
        int ep_id = 0;
        if (null!=ep_ids && !"".equals(ep_ids)){
            ep_id = Integer.parseInt(ep_ids);
        }
        int ep_father_id = 0;
        if (null!= ep_father_ids && !"".equals(ep_father_ids)){
            ep_father_id = Integer.parseInt(ep_father_ids);
        }
        System.out.println(ep_id+"---"+ep_father_id);
        List<Product> products_list_by_condition = ps.findProduct(ep_id,ep_father_id);
        request.getSession().setAttribute("products",products_list_by_condition);
        response.sendRedirect("Manage/product.jsp");
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
