package com.java.ssm.service;

import com.java.ssm.pojo.Product;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface ProductService {

    /**
     * 获取所用的商品信息
     * @return
     */
    List<Product> getList();

    /**
     * 根据id获取商品信息
     * @param id
     * @return
     */
    Product getProduct(Integer id);

    /**
     * 根据id修改
     * @param product
     * @return
     */
    Integer productUpload(Product product);

    /**
     * 展示商品信息
     * @return
     */
    List<Product> getListToUser();

    /**
     * 库存-1
     * @param productId
     * @return
     */
    Integer removeById(Integer productId);

    /**
     * 根据id添加库存
     * @param productId
     * @param productQuantity
     * @return
     */
    Integer addProductByShopping(Integer productId, Integer productQuantity);

    /**
     * 删除商品
     * @param id
     */
    Integer delteProductByid(Integer id);

    /**
     * 上传商品
     * @param product
     * @return
     */
    Integer addProduct(Product product);
    
    /**
     * 批量查询
     * @param name
     * @return
     */
    List<Product> likeProduct(String name);
}
