package com.kgc.service.product;

import com.kgc.dao.product.ProductDao;
import com.kgc.dao.product.ProductDaoImpl;
import com.kgc.pojo.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    ProductDao pd = new ProductDaoImpl();


    @Override
    public List<Product> findALlProduct() {
        return pd.findALlProduct();
    }

    @Override
    public List<Product> findALlProductById(int id) {
        return pd.findALlProductById(id);
    }
}
