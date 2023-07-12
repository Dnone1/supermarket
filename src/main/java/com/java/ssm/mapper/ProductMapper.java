package com.java.ssm.mapper;

import com.java.ssm.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    /**
     * 查询所用商品信心
     * @return
     */
    List<Product> getList();

    /**
     * 根据id获取商品信息
     * @param id
     * @return
     */
    Product getProduct(@Param("id") Integer id);

    /**
     * 根据id修改商品信息
     * @param product
     * @return
     */
    Integer productUpload( Product product);

    /**
     * 获取商品信息
     * @return
     */
    List<Product> getListToUser();

    /**
     * 库存-1
     * @param productId
     * @return
     */
    Integer removeById(@Param("productId") Integer productId);

    /**
     * 根据id添加库存
     * @param productId
     * @param productQuantity
     * @return
     */
    Integer addProductByShopping(@Param("productId") Integer productId, @Param("productQuantity") Integer productQuantity);

    /**
     * 删除商品
     * @param id
     * @return
     */
    Integer delteProductByid(@Param("id") Integer id);

    /**
     * 添加商品
     * @param product
     * @return
     */
    Integer addProduct(Product product);
    
    /**
     * 根据商品名模糊查询
     * @param name
     * @return
     */
    List<Product> likeProduct(@Param("name")String name);
}
