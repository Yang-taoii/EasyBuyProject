package com.kgc.service.product;

import com.kgc.pojo.Product;

import java.util.List;

public interface ProductService {

    //查询所有商品，按产品库存降序查询
    List<Product> findALlProduct();


    List<Product> findALlProductById(int id);//通过父类id查找商品


    Product findProductById(int id);//通过产品id查找对应商品

    List<Product> findProduct(int ep_id,int ep_father_id);//商品id 或者 商品父类id

    int addProduct(Product product);
}
