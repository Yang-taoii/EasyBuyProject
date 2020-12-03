package com.kgc.servlet;


import com.kgc.pojo.Product;
import com.kgc.pojo.ShoppingCar;
import com.kgc.service.product.ProductService;
import com.kgc.service.product.ProductServiceImpl;
import com.kgc.service.shoppingcar.ShoppingCarService;
import com.kgc.service.shoppingcar.ShoppingCarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ShoppingCarServlet", urlPatterns = "/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {

    ShoppingCarService scs = new ShoppingCarServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("AddProduct".equals(method)) {
            this.doAddProduct(request, response);
        }

        if ("select".equals(method)) {
            this.doSelectProduct(request, response);
        }

        if ("delete".equals(method)){
            this.doDeleteProduct(request,response);
        }

        if ("updateAmount".equals(method)){
            this.doUpdateProduct(request,response);
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    //查询购物车商品
    protected void doSelectProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name =(String)request.getSession().getAttribute("loginUser");
        List<ShoppingCar> list_car = scs.selectProductByName(name);
        double sum_price = 0;
        for (ShoppingCar s : list_car) {
            sum_price += s.getProduct().getEp_price() * s.getAmount();
        }
        request.getSession().setAttribute("sum_price", sum_price);
        request.getSession().setAttribute("list_car", list_car);
        response.sendRedirect("EasyBuy/shopping.jsp");
    }


    protected void doAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name =(String)request.getSession().getAttribute("loginUser");
        System.out.println(name);
        ShoppingCar shoppingCar = new ShoppingCar();

        int ep_id = Integer.parseInt(request.getParameter("ep_id"));
        ProductService ps = new ProductServiceImpl();
        Product product = ps.findProductById(ep_id);
        shoppingCar.setProduct(product);
        shoppingCar.setSubtotal(product.getEp_price());
        shoppingCar.setUser_name(name);
        shoppingCar.setAmount(1);

        System.out.println("商品库存  "+product.getEP_STOCK());
        request.getSession().setAttribute("product_reserve",product.getEP_STOCK());

        int isAdd = scs.insertProduct(shoppingCar);
        if (isAdd > 0) {
            this.doSelectProduct(request, response);
        } else {
            out.print("<script>");
            out.print("alert('产品添加失败');");
            out.print("location.href='EasyBuy/index.jsp';");
            out.print("</script>");
        }
    }


    protected void doUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ShoppingCar sc = new ShoppingCar();
        int reserve = Integer.parseInt(request.getParameter("reserve"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        System.out.println("库存"+request.getParameter("reserve")+"--"+"购买数量"+request.getParameter("amount"));

        if (amount>reserve){
            amount = reserve;
        }else if (amount<1){
            amount = 1;
        }
        sc.setAmount(amount);
        sc.setGoods_id(Integer.parseInt(request.getParameter("goods_id")));
        int isUpdate = scs.updateProduct(sc);
        String result = "{\"result\":\"false\"}";
        if (isUpdate>0){
            result = "{\"result\":\"true\"}";
            System.out.println("成功");
        }else
        System.out.println("失败");
        out.print(result);
    }

    protected void doDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println(request.getParameter("goods_id"));
        PrintWriter out = response.getWriter();
        int isDelete = scs.deleteProduct(Integer.parseInt(request.getParameter("goods_id")));
        if (isDelete>0){
            this.doSelectProduct(request, response);
        }else {
            out.print("<script>");
            out.print("alert('删除失败');");
            out.print("location.href='EasyBuy/index.jsp';");
            out.print("</script>");
        }
    }


}
