package com.java.ssm.service.Impl;

import com.java.ssm.mapper.ShoppingMapper;
import com.java.ssm.pojo.Shopping;
import com.java.ssm.pojo.User;
import com.java.ssm.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper ;

    @Override
    public Integer addShoppingByUserId(Integer userId, Integer productId , double  productPrice) {
        return shoppingMapper.addShoppingByUserId(userId , productId , productPrice) ;
    }

    @Override
    public List<User> getShoppingList(Integer id) {
        return shoppingMapper.getShoopingList(id);
    }

    @Override
    public Integer removeShopping(Integer shoppingId) {
        return shoppingMapper.removeShopping(shoppingId);
    }

    @Override
    public Shopping IFShopping(Integer userId, Integer productId) {
        return shoppingMapper.IFShopping(userId , productId);
    }

    @Override
    public Integer shoppingProduct(Integer productId , double productPrice) {
        return shoppingMapper.shoppingProduct(productId , productPrice);
    }

    @Override
    public Shopping addOrderByShoppingId(Integer shoppingId) {
        return shoppingMapper.addOrderByShoppingId(shoppingId);
    }

    @Override
    public List<Shopping> getShoppingByArr(String[] split) {
        return shoppingMapper.getShoppingByArr(split);
    }

}
