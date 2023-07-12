package com.java.ssm.service;

import com.java.ssm.mapper.OrderMapper;
import com.java.ssm.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    /**
     * 根据用户id查询所用用户订单
     * @param id
     * @return
     */
    List<Order> orderList(Integer id);

    /**
     * 下单
     * @param order
     * @return
     */
    Integer addOrder(Order order);

    /**
     * 查询所用订单
     * @return
     */
    List<Order> ordersByMerchant();

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    Integer removeOrder(Integer id);

    /**
     * 根据订单id查询订单编号
     * @return
     */
    Order uploadOrderByMerchantId(Integer id);

    /**
     * 根据id查询订单
     * @return
     */
    Order getOrder(Integer id);

    /**
     * 根据id修改订单
     * @param order
     * @return
     */
    Integer uploadOrderById(Order order);
}
