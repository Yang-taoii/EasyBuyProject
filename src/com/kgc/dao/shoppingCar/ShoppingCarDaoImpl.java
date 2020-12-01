package com.kgc.dao.shoppingCar;

import com.kgc.dao.BaseDao;
import com.kgc.pojo.Product;
import com.kgc.pojo.ShoppingCar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCarDaoImpl extends BaseDao implements ShoppingCarDao {
    @Override
    public int insertProduct(ShoppingCar shoppingCar) {
       String sql = "insert into shoppingcar (ep_id,ep_name,ep_price,subtotal,amount,user_name,ep_file_name) values(?,?,?,?,?,?,?);";
       Object[] objects = {shoppingCar.getProduct().getEp_id(),shoppingCar.getProduct().getEp_name(),shoppingCar.getProduct().getEp_price(),shoppingCar.getSubtotal(),shoppingCar.getAmount(),shoppingCar.getUser_name(),shoppingCar.getProduct().getEP_FILE_NAME()};
        return this.update(sql,objects);
    }

    @Override
    public int deleteProduct(int id) {
        String sql = "delete from shoppingcar where goods_id = ?";
        Object[] objects = {id};
        return this.update(sql,objects);
    }

    @Override
    public List<ShoppingCar> selectProductByName(String name) {
        String sql = " select * from shoppingcar where user_name = ? order by goods_id desc";
        Object[] objects = {name};
        List<ShoppingCar> list = new ArrayList<>();
        rs = this.query(sql,objects);
        try{
            while (rs.next()){
                ShoppingCar sc = new ShoppingCar();
                Product pp = new Product();
                pp.setEp_price(rs.getDouble("ep_price"));
                pp.setEp_name(rs.getString("ep_name"));
                pp.setEp_id(rs.getInt("ep_id"));
                pp.setEP_FILE_NAME(rs.getString("ep_file_name"));
                sc.setUser_name(rs.getString("user_name"));
                sc.setAmount(rs.getInt("amount"));
                sc.setSubtotal(rs.getDouble("subtotal"));
                sc.setGoods_id(rs.getInt("goods_id"));
                sc.setProduct(pp);
                list.add(sc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return list;
    }



    public int updateProduct(ShoppingCar sc){// 更新商品数
        String sql = "update shoppingcar set amount = ? where goods_id = ? ";
        Object[] params = new Object[] {sc.getAmount(),sc.getGoods_id()};
        return this.update(sql, params);
    }
}
