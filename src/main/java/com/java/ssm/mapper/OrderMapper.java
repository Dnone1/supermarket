package com.java.ssm.mapper;

import com.java.ssm.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    /**
     * 根据用户id查询所用用户信息
     * @param id
     * @return
     */
    List<Order> orderList(@Param("id") Integer id);

    /**
     * 下单
     * @param order
     * @return
     */
    Integer addOrder(Order order);

    /**
     * 查询所用
     * @return
     */
    List<Order> ordersByMerchant();

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    Integer removeOrder(@Param("id") Integer id);

    /**
     * 根据id查询订单，用于修改订单
     * @param id
     * @return
     */
    Order uploadOrderByMerchantId(@Param("id") Integer id);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Order getOrder(@Param("id") Integer id);

    /**
     * 根据id修改订单
     * @param order
     * @return
     */
    Integer uploadOrderById(Order order);
}
