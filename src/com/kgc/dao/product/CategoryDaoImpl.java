package com.kgc.dao.product;

import com.kgc.dao.BaseDao;
import com.kgc.pojo.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao{
    public List<ProductCategory> findAllParents(){
        List<ProductCategory> list = new ArrayList<>();
        String sql = "select * from easybuy_product_category where EPC_PARENT_ID = 0";
        ResultSet rs = this.query(sql,null);
        try{
            while (rs.next()){
                ProductCategory pc = new ProductCategory();
                pc.setEpc_id(rs.getInt("EPC_ID"));
                pc.setEpc_name(rs.getString("EPC_NAME"));
                pc.setEpc_parent_id(rs.getInt("EPC_PARENT_ID"));
                pc.setList(findAllByParentID(pc.getEpc_id()));
                list.add(pc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return list;
    }


    //根据父分类id查询子分类
    public List<ProductCategory> findAllByParentID(int pid){
        List<ProductCategory> list = new ArrayList<>();
        String sql = "select * from easybuy_product_category WHERE EPC_PARENT_ID =?";
        Object[] objects = {pid};
        rs = this.query(sql,objects);
        try{
           while (rs.next()){
               ProductCategory pc = new ProductCategory();
               pc.setEpc_id(rs.getInt("EPC_ID"));
               pc.setEpc_name(rs.getString("EPC_NAME"));
               pc.setEpc_parent_id(rs.getInt("EPC_PARENT_ID"));
               list.add(pc);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //新增产品分类
    public int insertCategory(ProductCategory category) {
        String sql = "insert into easybuy_product_category values (?,?,?)";
        Object[] objects = {category.getEpc_id(),category.getEpc_name(),category.getEpc_parent_id()};
        return this.update(sql,objects);
    }

    //删除产品分类
    public int deleteCategory(int epc_id) {
        String sql = "delete from easybuy_product_category where EPC_ID = ? ";
        Object[] objects = {epc_id};
        return this.update(sql,objects);
    }

    //修改产品分类
    public int updateCategory(ProductCategory category) {
        String sql = "update easybuy_product_category set EPC_ID = ?,EPC_NAME= ? ,EPC_PARENT_ID=? where EPC_ID = ?";
        Object[] objects = {category.getEpc_id(),category.getEpc_name(),category.getEpc_parent_id(),category.getEpc_id()};
        return this.update(sql,objects);
    }

    @Override
    public ProductCategory findCategoryById(int epc_id) {
        String sql = "select * from easybuy_product_category where EPC_ID = ?";
        Object[] objects = {epc_id};
        ProductCategory pc = new ProductCategory();
        try{
            rs = this.query(sql,objects);
            while (rs.next()){

                pc.setEpc_id(rs.getInt("EPC_ID"));
                pc.setEpc_name(rs.getString("EPC_NAME"));
                pc.setEpc_parent_id(rs.getInt("EPC_PARENT_ID"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pc;
    }


    public static void main(String[] args) {
        CategoryDaoImpl cd = new CategoryDaoImpl();
        List<ProductCategory> list = cd.findAllParents();
        List<ProductCategory> list1 = cd.findAllByParentID(545);
        for (ProductCategory pc:list1) {
            System.out.println(pc.getEpc_id()+pc.getEpc_name());
        }
    }

}
