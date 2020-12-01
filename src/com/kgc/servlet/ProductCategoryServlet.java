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
import java.util.ArrayList;
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

        if("classification".equals(method)){
            this.doClassification(request,response);
        }

        if ("insert".equals(method)){
            this.doInsertCategory(request,response);
        }
        if ("delete".equals(method)){
            this.doDeleteCategory(request,response);
        }
        if("modify".equals(method)){
            this.doModifyCategory(request,response);
        }
        if ("update".equals(method)){
            doUpdate(request,response);
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

    //后端展示产品分类
    protected void doClassification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategory> list_father = pcs.findAllParents();
        request.getSession().setAttribute("list_father",list_father);
        response.sendRedirect("Manage/productClass.jsp");
    }

    //后端新增分类
    protected void doInsertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int epc_parent_id = Integer.parseInt(request.getParameter("parentId"));
        ProductCategory pc = new ProductCategory();
        pc.setEpc_parent_id(epc_parent_id);
        pc.setEpc_id(Integer.parseInt(request.getParameter("classID")));
        pc.setEpc_name(request.getParameter("className"));
        int isInsert = pcs.insertCategory(pc);
        if (isInsert>0){
            response.sendRedirect("Manage/index.jsp");
        }else {
            response.sendRedirect("Manage/productClass-add.jsp");
        }
    }

    //后端删除产品分类
    protected void doDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int epc_id = Integer.parseInt(request.getParameter("epc_id"));
        System.out.println(epc_id);
        int isDelete = pcs.deleteCategory(epc_id);
        if (isDelete>0){
            response.sendRedirect("Manage/index.jsp");
        }else {
            response.sendRedirect("Manage/productClass.jsp");
        }
    }

    //后端修改产品分类
    protected void doModifyCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductCategory pc = new ProductCategory();
        int epc_id = Integer.parseInt(request.getParameter("epc_id"));
        System.out.println(epc_id);
        String epc_name = request.getParameter("className");
        int epc_parent_id = Integer.parseInt(request.getParameter("parentId"));
        pc.setEpc_id(epc_id);
        pc.setEpc_name(epc_name);
        pc.setEpc_parent_id(epc_parent_id);

        int isUpdate = pcs.updateCategory(pc);
        if (isUpdate>0){
            response.sendRedirect("Manage/index.jsp");
        }else
            response.sendRedirect("Manage/productClass-modify.jsp");
    }
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int epc_id = Integer.parseInt(request.getParameter("epc_id"));
        ProductCategory pc = pcs.findCategoryById(epc_id);
        ProductCategory pc_father = pcs.findCategoryById(pc.getEpc_parent_id());
        request.getSession().setAttribute("ProductCategory",pc);
        request.getSession().setAttribute("pc_father",pc_father);
        response.sendRedirect("Manage/productClass-modify.jsp");
    }

}
