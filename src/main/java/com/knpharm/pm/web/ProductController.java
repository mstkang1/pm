package com.knpharm.pm.web;

import com.knpharm.pm.mapper.ProductMapper;
import com.knpharm.pm.dto.ProductDto;
import com.knpharm.pm.service.product.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @ResponseBody
    @RequestMapping(value = "/productList", method = RequestMethod.POST)
    public Map<String, Object> productList(@RequestBody ProductDto productDto) throws Exception {

        Map<String, Object> rtnObj = new HashMap<>();

        List<ProductDto> productList = productService.selectProductList(productDto.getBrandCode());
        //logger.info("productList -> " + productList.toString());

        rtnObj.put("productList", productList);
        return rtnObj;
    }

    @RequestMapping("/download/{productName}")
    public void process(@PathVariable(name = "productName") String productName, HttpServletResponse response) throws Exception {
        try {
            // 서비스를 통해 첨부파일 가져오기
            ProductDto product = productService.selectProduct(productName);


            String originalName = "";
            String filePath = uploadPath + File.separatorChar;
            String fileName = "";

            // 파일명에 한글이 있는경우 처리
            originalName = new String(product.getProductOrgFileName().getBytes("utf-8"), "iso-8859-1");
            fileName = product.getProductSaveFileName();

            String path = filePath + fileName;

            File file = new File(path);
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

            //형식을 모르는 파일첨부용 contentType
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + originalName); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더


            //파일복사
            FileCopyUtils.copy(in, response.getOutputStream());
            in.close();
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (Exception e) {
            throw new Exception("download error");

        }
    }
}
