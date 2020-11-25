package com.kgc.dao.product;

import com.kgc.pojo.ProductCategory;

import java.util.List;

public interface CategoryDao {


    List<ProductCategory> findAllParents();

    List<ProductCategory> findAllByParentID(int pid);


}
