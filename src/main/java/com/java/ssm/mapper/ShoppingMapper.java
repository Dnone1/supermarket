package com.java.ssm.mapper;

import com.java.ssm.pojo.Shopping;
import com.java.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingMapper {

    /**
     * 根据用户及进行加入购物车
     * @param userId
     * @param productId
     * @param productPrice
     * @return
     */
    Integer addShoppingByUserId(@Param("userId") Integer userId, @Param("productId") Integer productId , @Param("productPrice") double  productPrice) ;

    /**
     * 根据客户id获取所用购物车
     * @param id
     * @return
     */
    List<User> getShoopingList(@Param("id") Integer id);

    /**
     * 根据id删除购物车
     * @param shoppingId
     * @return
     */
    Integer removeShopping(@Param("shoppingId") Integer shoppingId);

    /**
     * 先进性判断
     * @param userId
     * @param productId
     * @return
     */
    Shopping IFShopping(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 库存+1
     * @param productId
     * @return
     */
    Integer shoppingProduct(@Param("productId") Integer productId , @Param("productPrice") double productPrice);

    /**
     * 根据shopping查询购物车，将它展示
     * @param shoppingId
     * @return
     */
    Shopping addOrderByShoppingId( @Param("shoppingId") Integer shoppingId);

    /**
     * 批量查询
     * @param split
     * @return
     */
    List<Shopping> getShoppingByArr(@Param("split") String[] split);
}
