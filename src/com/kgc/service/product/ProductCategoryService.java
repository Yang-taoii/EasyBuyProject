package com.kgc.service.product;

import com.kgc.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAllParents();

    List<ProductCategory> findAllByParentID(int pid);
}
