package com.kgc.service.product;

import com.kgc.dao.product.CategoryDao;
import com.kgc.dao.product.CategoryDaoImpl;
import com.kgc.pojo.ProductCategory;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService{
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<ProductCategory> findAllParents() {
        return categoryDao.findAllParents();
    }

    @Override
    public List<ProductCategory> findAllByParentID(int pid) {
        return categoryDao.findAllByParentID(pid);
    }
}
