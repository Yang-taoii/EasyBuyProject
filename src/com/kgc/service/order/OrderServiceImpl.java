package com.kgc.service.order;

import com.kgc.dao.order.OrderDao;
import com.kgc.dao.order.OrderDaoImpl;
import com.kgc.pojo.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    OrderDao od = new OrderDaoImpl();

    @Override
    public int insertOrder(Order order) {
        return od.insertOrder(order);
    }

    @Override
    public Order select_order_by_id(String eo_id) {
        return od.select_order_by_id(eo_id);
    }

    @Override
    public List<Order> selectAll(String name) {
        return od.selectAll(name);
    }
}
