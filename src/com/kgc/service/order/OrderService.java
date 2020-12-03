package com.kgc.service.order;

import com.kgc.pojo.Order;

import java.util.List;

public interface OrderService {
    //新增订单
    int insertOrder(Order order);
    //通过订单号查询订单
    Order select_order_by_id(String eo_id);
    List<Order> selectAll(String name);
}
