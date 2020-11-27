package com.kgc.service.shoppingcar;

import com.kgc.dao.shoppingCar.ShoppingCarDao;
import com.kgc.dao.shoppingCar.ShoppingCarDaoImpl;
import com.kgc.pojo.ShoppingCar;

import java.util.List;

public class ShoppingCarServiceImpl implements ShoppingCarService{

    ShoppingCarDao scd = new ShoppingCarDaoImpl();

    @Override
    public int insertProduct(ShoppingCar shoppingCar) {
        return scd.insertProduct(shoppingCar);
    }

    @Override
    public int deleteProduct(int id) {
        return scd.deleteProduct(id);
    }

    @Override
    public List<ShoppingCar> selectProductByName(String name) {
        return scd.selectProductByName(name);
    }

    @Override
    public int updateProduct(ShoppingCar sc) {
        return scd.updateProduct(sc);
    }
}
