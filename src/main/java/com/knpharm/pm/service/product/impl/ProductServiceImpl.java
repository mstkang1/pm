package com.knpharm.pm.service.product.impl;

import com.knpharm.pm.dto.ProductDto;
import com.knpharm.pm.mapper.ProductMapper;
import com.knpharm.pm.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> selectProductList(String brandCode) throws Exception {
        return productMapper.selectProductList(brandCode);
    }
    @Override
    public ProductDto selectProduct(String productName) throws Exception {
        return productMapper.selectProduct(productName);
    }
}
