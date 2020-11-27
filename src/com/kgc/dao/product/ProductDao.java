package com.kgc.dao.product;


import com.kgc.pojo.Product;
import java.util.List;

public interface ProductDao {

    //查询所有商品，按产品库存降序查询
    List<Product> findALlProduct();


    List<Product> findALlProductById(int id);//根据父类id查询子类所有商品

    Product findProductById(int id);

}
