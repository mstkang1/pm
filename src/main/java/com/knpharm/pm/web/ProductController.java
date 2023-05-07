package com.knpharm.pm.web;

import com.knpharm.pm.dao.ProductDAO;
import com.knpharm.pm.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDAO productDAO;

    @ResponseBody
    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public Map<String, Object> productList(@RequestBody ProductVO productVO){

        Map<String, Object> rtnObj = new HashMap<>();

        List<ProductVO> productList = productDAO.listProduct(productVO);
        logger.info("productList -> " + productList.toString());

        rtnObj.put("productList", productList);
        return rtnObj;
    }
}
