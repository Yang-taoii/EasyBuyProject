package com.kgc.pojo;

import java.util.List;

public class ProductCategory {//产品分类实体类
    private int epc_id;
    private String epc_name;
    private int epc_parent_id;

    private List<ProductCategory> list;

    public ProductCategory() {
    }

    public int getEpc_id() {
        return epc_id;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public int getEpc_parent_id() {
        return epc_parent_id;
    }

    public void setEpc_parent_id(int epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }

    public List<ProductCategory> getList() {
        return list;
    }

    public void setList(List<ProductCategory> list) {
        this.list = list;
    }
}
