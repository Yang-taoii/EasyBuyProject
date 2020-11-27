package com.kgc.service.shoppingcar;

import com.kgc.pojo.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {
    //新增购物车商品
    int insertProduct(ShoppingCar shoppingCar);

    //删除购物车商品
    int deleteProduct(int id);

    //通过用户名查询购物车商品
    List<ShoppingCar> selectProductByName(String name);

    //修改购买同一件商品数
    int updateProduct(ShoppingCar sc);
}
