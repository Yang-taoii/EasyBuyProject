package com.kgc.servlet;

import com.kgc.pojo.Order;
import com.kgc.pojo.ShoppingCar;
import com.kgc.service.order.OrderService;
import com.kgc.service.order.OrderServiceImpl;
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

@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    OrderService os = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");

        if ("submit".equals(method)){
            this.doSettlement(request,response);
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    protected void doSettlement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        ShoppingCarService scs = new ShoppingCarServiceImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String order_number = sdf.format(date)+sdf.format(System.currentTimeMillis());
        System.out.println(order_number);
        String name =(String)request.getSession().getAttribute("loginUser");

        //String sum = (String) request.getSession().getAttribute("sum_price");
        Object sum = request.getSession().getAttribute("sum_price");

        double sum_price = (double)sum;


        System.out.println("获取购物车总金额："+sum+"----"+sum_price);

        Order order = new Order();
        order.setEo_user_name(name);
        order.setEo_cost(sum_price);
        order.setEo_id(order_number);

        int isInsertOrder= os.insertOrder(order);
        if (isInsertOrder>0){
            System.out.println("创建订单成功");
        }else {
            System.out.println("创建订单失败");
        }

        List<Order> list_order = os.selectAll(name);

        for (Order od:list_order) {
            System.out.println(od.getEo_id()+"--"+od.getEo_user_name());
        }

        List<ShoppingCar> list_car_settlement = scs.selectProductByName(name);
        request.getSession().setAttribute("list_order",list_order);
        request.getSession().setAttribute("list_car_settlement",list_car_settlement);
        response.sendRedirect("EasyBuy/shopping-query.jsp");

    }
}
