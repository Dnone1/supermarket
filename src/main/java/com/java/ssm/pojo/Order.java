package com.java.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//订单
public class Order {
    private Integer id ;
    private Integer userId ;
    private Integer productId ;
    private Integer quantity ;
    private double price ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubtime ;
    private Integer status ;
    private String address ;

    private User user ;
    private Shopping shopping ;
    private Product product ;

    public Order() {
    }

    public Order(Integer id, Integer userId, Integer productId, Integer quantity, double price, Date pubtime, Integer status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.pubtime = pubtime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Integer getStatus() {
        return status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", pubtime=" + pubtime +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", shopping=" + shopping +
                ", product=" + product +
                '}';
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }

}
