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
    public List<Product> findALlProductById(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from easybuy_product where EP_ID = ?";
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
}
