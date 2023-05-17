package com.knpharm.pm.mapper;

import com.knpharm.pm.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDto> selectProductList(ProductDto productDto) throws Exception;

    ProductDto selectProduct(String productName) throws Exception;
}
