package com.kgc.dao.order;

import com.kgc.dao.BaseDao;
import com.kgc.pojo.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int insertOrder(Order order) {
        String sql = "insert into easybuy_order (EO_ID,EO_USER_NAME,EO_CREATE_TIME,EO_COST,EO_STATUS,EO_TYPE) values (?,?,default,?,default,default)";
        Object[] objects = {order.getEo_id(),order.getEo_user_name(),order.getEo_cost()};
        return this.update(sql,objects);
    }

    @Override
    public Order select_order_by_id(String eo_id) {
        String sql = "select * from easybuy_order where EO_ID = ?";
        Object[] objects = {eo_id};
        Order order = new Order();
        rs = this.query(sql,objects);
        try{
            while (rs.next()){

                order.setEo_id(rs.getString("EO_ID"));
                order.setEo_user_id(rs.getString("EO_USER_ID"));
                order.setEo_user_name(rs.getString("EO_USER_NAME"));
                order.setEo_user_address(rs.getString("EO_USER_ADDRESS"));
                order.setEo_create_time(rs.getTimestamp("EO_CREATE_TIME"));
                order.setEo_cost(rs.getDouble("EO_COST"));
                order.setEo_status(rs.getInt("EO_STATUS"));
                order.setEo_type(rs.getInt("EO_TYPE"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return order;
    }

    @Override
    public List<Order> selectAll(String user_name) {
        List<Order> list_order = new ArrayList<>();
        Order order = new Order();
        String sql = "select * from easybuy_order where EO_USER_NAME = ?";
        Object[] objects = {user_name};
        rs = this.query(sql,objects);
        try{
            while (rs.next()){
                order.setEo_id(rs.getString("EO_ID"));
                order.setEo_user_id(rs.getString("EO_USER_ID"));
                order.setEo_user_name(rs.getString("EO_USER_NAME"));
                order.setEo_user_address(rs.getString("EO_USER_ADDRESS"));
                order.setEo_create_time(rs.getTimestamp("EO_CREATE_TIME"));
                order.setEo_cost(rs.getDouble("EO_COST"));
                order.setEo_status(rs.getInt("EO_STATUS"));
                order.setEo_type(rs.getInt("EO_TYPE"));
                list_order.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return list_order;
    }
}
