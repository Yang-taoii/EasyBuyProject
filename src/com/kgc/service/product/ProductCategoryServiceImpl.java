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

    @Override
    public int insertCategory(ProductCategory category) {
        return categoryDao.insertCategory(category);
    }

    @Override
    public int deleteCategory(int epc_id) {
        return categoryDao.deleteCategory(epc_id);
    }

    @Override
    public int updateCategory(ProductCategory category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public ProductCategory findCategoryById(int epc_id) {
        return categoryDao.findCategoryById(epc_id);
    }
}
