package com.java.ssm.pojo;

//购物车
public class Shopping {
    private Integer id ;
    private Integer userId ;
    private Integer productId ;
    private Integer quantity ;
    private double price ;
    private String path ;

    private User user ;

    private Product product;

    public Shopping() {
    }

    public Shopping(Integer id, Integer userId, Integer productId, Integer quantity, double price, String path, User user, Product product) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.path = path;
        this.user = user;
        this.product = product;
    }

    public Shopping(Integer id, Integer userId, Integer productId, Integer quantity, double price, User user, Product product) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.user = user;
        this.product = product;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", path='" + path + '\'' +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
