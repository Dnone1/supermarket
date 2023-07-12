package com.java.ssm.service.Impl;

import com.java.ssm.mapper.OrderMapper;
import com.java.ssm.pojo.Order;
import com.java.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper ;

    @Override
    public List<Order> orderList(Integer id) {
        return orderMapper.orderList(id);
    }

    @Override
    public Integer addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public List<Order> ordersByMerchant() {
        return orderMapper.ordersByMerchant();
    }

    @Override
    public Integer removeOrder(Integer id) {
        return orderMapper.removeOrder(id);
    }

    @Override
    public Order uploadOrderByMerchantId(Integer id) {
        return orderMapper.uploadOrderByMerchantId(id);
    }

    @Override
    public Order getOrder(Integer id) {
        return orderMapper.getOrder(id);
    }

    @Override
    public Integer uploadOrderById(Order order) {
        return orderMapper.uploadOrderById(order);
    }
}
