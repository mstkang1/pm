package com.knpharm.pm.web;

import com.knpharm.pm.dao.StoreDAO;
import com.knpharm.pm.domain.StoreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreController {

    private Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreDAO storeDAO;
    @RequestMapping("/store")
    public  String store(Model model) {
        return "store";
    }

    @ResponseBody
    @RequestMapping(value = "/storeList", method = RequestMethod.POST)
    public Map<String, Object> storeList(@RequestBody StoreVO storeVO){

        Map<String, Object> rtnObj = new HashMap<>();

        List<StoreVO> storeList = storeDAO.listStore(storeVO);
        logger.info("storeList -> " + storeList.toString());

        rtnObj.put("storeList", storeList);
        return rtnObj;
    }
}
