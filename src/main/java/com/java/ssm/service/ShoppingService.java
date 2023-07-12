package com.java.ssm.service;

import com.java.ssm.pojo.Product;
import com.java.ssm.pojo.Shopping;
import com.java.ssm.pojo.User;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface ShoppingService {

    /**
     * 根据userid来加入购物车
     * @param userId
     * @param productId
     * @param productPrice
     * @return
     */
    Integer addShoppingByUserId(Integer userId, Integer productId , double  productPrice);

    /**
     * 根据客服id查询所用客服购物车
     * @param id
     * @return
     */
    List<User> getShoppingList(Integer id);

    /**
     * 删除购物车
     * @param shoppingId
     * @return
     */
    Integer removeShopping(Integer shoppingId);

    /**
     * 先进行判断是否已经加入购物车
     * @param userId
     * @param productId
     * @return
     */
    Shopping IFShopping(Integer userId, Integer productId);

    /**
     * 如果购物车存在就让库存加1
     * @param productId
     * @return
     */
    Integer shoppingProduct(Integer productId , double productPrice);

    /**
     * 根据shoppid查询到shopping订单，将他展示
     * @param shoppingId
     * @return
     */
    Shopping addOrderByShoppingId(Integer shoppingId);


    /**
     * 批量查询
     * @param split
     * @return
     */
    List<Shopping> getShoppingByArr(String[] split);
    

}
