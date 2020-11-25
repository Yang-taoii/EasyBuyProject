package com.kgc.dao.product;

import com.kgc.dao.BaseDao;
import com.kgc.pojo.ProductCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao {
    public List<ProductCategory> findAllParents(){
        List<ProductCategory> list = new ArrayList<>();
        String sql = "select * from easybuy_product_category where EPC_PARENT_ID = 0";
        rs = this.query(sql,null);
        try{
            while (rs.next()){
                
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    //根据父分类id查询子分类
    public List<ProductCategory> findAllByParentID(int pid){
        List<ProductCategory> list = new ArrayList<>();
        String sql = "select * from easybuy_product_category where EPC_PARENT_ID = ?";
        return null;
    }

}
