package com.kgc.dao.product;

import com.kgc.dao.BaseDao;
import com.kgc.pojo.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public List<Product> findALlProduct() {//查询所有商品，按产品库存降序查询
        List<Product> list = new ArrayList<>();
        String sql = "select * from easybuy_product GROUP BY EP_STOCK desc";
        rs = this.query(sql,null);
        try{
            while (rs.next()){
                Product product = new Product();
                product.setEp_id(rs.getInt("EP_ID"));
                product.setEp_description(rs.getString("EP_DESCRIPTION"));
                product.setEP_FILE_NAME(rs.getString("EP_FILE_NAME"));
                product.setEp_name(rs.getString("EP_NAME"));
                product.setEp_price(rs.getDouble("EP_PRICE"));
                product.setEP_STOCK(rs.getInt("EP_STOCK"));
                product.setEPC_CHILD_ID(rs.getInt("EPC_CHILD_ID"));
                product.setEPC_ID(rs.getInt("EPC_ID"));
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return list;
    }

    @Override
    public List<Product> findALlProductById(int id) { //根据父类id查询子类所有商品
        List<Product> list = new ArrayList<>();
        String sql = "select * from easybuy_product \n" +
                "inner join easybuy_product_category\n" +
                "on easybuy_product_category.EPC_ID = easybuy_product.EPC_ID\n" +
                "where easybuy_product.EPC_ID = ?";
        Object[] objects = {id};
        rs = this.query(sql,objects);
        try{
            while (rs.next()){
                Product product = new Product();
                product.setEp_id(rs.getInt("EP_ID"));
                product.setEp_description(rs.getString("EP_DESCRIPTION"));
                product.setEP_FILE_NAME(rs.getString("EP_FILE_NAME"));
                product.setEp_name(rs.getString("EP_NAME"));
                product.setEp_price(rs.getDouble("EP_PRICE"));
                product.setEP_STOCK(rs.getInt("EP_STOCK"));
                product.setEPC_CHILD_ID(rs.getInt("EPC_CHILD_ID"));
                product.setEPC_ID(rs.getInt("EPC_ID"));
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return list;
    }

    @Override
    public Product findProductById(int id) {
        String sql = "select * from easybuy_product where EP_ID = ?";
        Object[] objects = {id};
        Product product1 = new Product();
        rs = this.query(sql,objects);
        try{
            while (rs.next()){
                product1.setEp_id(rs.getInt("EP_ID"));
                product1.setEp_description(rs.getString("EP_DESCRIPTION"));
                product1.setEP_FILE_NAME(rs.getString("EP_FILE_NAME"));
                product1.setEp_name(rs.getString("EP_NAME"));
                product1.setEp_price(rs.getDouble("EP_PRICE"));
                product1.setEP_STOCK(rs.getInt("EP_STOCK"));
                product1.setEPC_CHILD_ID(rs.getInt("EPC_CHILD_ID"));
                product1.setEPC_ID(rs.getInt("EPC_ID"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeAll(con,ps,rs);
        }
        return product1;
    }

    @Override
    public List<Product> findProduct(int ep_id, int epc_id) { //商品id 或者 商品父类id
        String sql = "select * from easybuy_product where 1=1 ";
        List<Product> list_products = new ArrayList<>();
        if (ep_id != 0){
            sql += " and EP_ID = "+ep_id+"";
        }
        if (epc_id != 0){
            sql += " and EPC_ID = "+epc_id+"";
        }
        rs = this.query(sql,null);
        try{
            while (rs.next()){
                Product p = new Product();
                p.setEp_id(rs.getInt("EP_ID"));
                p.setEp_description(rs.getString("EP_DESCRIPTION"));
                p.setEP_FILE_NAME(rs.getString("EP_FILE_NAME"));
                p.setEp_name(rs.getString("EP_NAME"));
                p.setEp_price(rs.getDouble("EP_PRICE"));
                p.setEP_STOCK(rs.getInt("EP_STOCK"));
                p.setEPC_CHILD_ID(rs.getInt("EPC_CHILD_ID"));
                p.setEPC_ID(rs.getInt("EPC_ID"));
                list_products.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list_products;
    }
}
