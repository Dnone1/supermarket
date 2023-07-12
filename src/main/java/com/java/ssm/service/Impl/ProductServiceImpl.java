package com.java.ssm.service.Impl;

import com.java.ssm.mapper.ProductMapper;
import com.java.ssm.pojo.Product;
import com.java.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper ;

    @Override
    public List<Product> getList() {
        return productMapper.getList();
    }

    @Override
    public Product getProduct(Integer id) {
        return productMapper.getProduct(id);
    }

    @Override
    public Integer productUpload(Product product) {
        return productMapper.productUpload(product);
    }

    @Override
    public List<Product> getListToUser() {
        return productMapper.getListToUser();
    }

    @Override
    public Integer removeById(Integer productId) {
        return productMapper.removeById(productId);
    }

    @Override
    public Integer addProductByShopping(Integer productId, Integer productQuantity) {
        return productMapper.addProductByShopping(productId , productQuantity);
    }

    @Override
    public Integer delteProductByid(Integer id) {
        return productMapper.delteProductByid(id);
    }

    @Override
    public Integer addProduct(Product product) {
        return productMapper.addProduct(product);
    }

	@Override
	public List<Product> likeProduct(String name) {
		return productMapper.likeProduct(name);
	}
}
