package com.knpharm.pm.dao;

import com.knpharm.pm.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDAO {
    public List<ProductVO> listProduct(ProductVO productVO);
}
