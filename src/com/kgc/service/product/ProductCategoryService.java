package com.kgc.service.product;

import com.kgc.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAllParents();

    List<ProductCategory> findAllByParentID(int pid);

    //新增产品分类
    int insertCategory(ProductCategory category);

    //删除产品分类
    int deleteCategory(int epc_id);

    //修改产品分类
    int updateCategory(ProductCategory category);
    ProductCategory findCategoryById(int epc_id);
}
