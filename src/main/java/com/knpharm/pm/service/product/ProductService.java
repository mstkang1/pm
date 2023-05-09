package com.knpharm.pm.service.product;

import com.knpharm.pm.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> selectProductList(ProductDto productDto) throws Exception;

}
