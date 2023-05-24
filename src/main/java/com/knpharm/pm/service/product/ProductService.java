package com.knpharm.pm.service.product;

import com.knpharm.pm.dto.ProductDto;

import java.util.List;

public interface ProductService {
    abstract List<ProductDto> selectProductList(String brandCode) throws Exception;

    ProductDto selectProduct(String productName) throws Exception;

}
