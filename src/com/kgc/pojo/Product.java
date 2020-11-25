package com.kgc.pojo;

public class Product {//产品信息实体类
    private int ep_id;
    private String ep_name;
    private String ep_description;
    private double ep_price;
    private int EP_STOCK;
    private int EPC_ID;
    private int EPC_CHILD_ID;
    private String EP_FILE_NAME;

    private ProductCategory productCategory;

    public Product() {
    }

    public int getEp_id() {
        return ep_id;
    }

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public String getEp_name() {
        return ep_name;
    }

    public void setEp_name(String ep_name) {
        this.ep_name = ep_name;
    }

    public String getEp_description() {
        return ep_description;
    }

    public void setEp_description(String ep_description) {
        this.ep_description = ep_description;
    }

    public double getEp_price() {
        return ep_price;
    }

    public void setEp_price(double ep_price) {
        this.ep_price = ep_price;
    }

    public int getEP_STOCK() {
        return EP_STOCK;
    }

    public void setEP_STOCK(int EP_STOCK) {
        this.EP_STOCK = EP_STOCK;
    }

    public int getEPC_ID() {
        return EPC_ID;
    }

    public void setEPC_ID(int EPC_ID) {
        this.EPC_ID = EPC_ID;
    }

    public int getEPC_CHILD_ID() {
        return EPC_CHILD_ID;
    }

    public void setEPC_CHILD_ID(int EPC_CHILD_ID) {
        this.EPC_CHILD_ID = EPC_CHILD_ID;
    }

    public String getEP_FILE_NAME() {
        return EP_FILE_NAME;
    }

    public void setEP_FILE_NAME(String EP_FILE_NAME) {
        this.EP_FILE_NAME = EP_FILE_NAME;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
