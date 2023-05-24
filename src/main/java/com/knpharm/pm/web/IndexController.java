package com.knpharm.pm.web;

import com.knpharm.pm.dto.BannerDto;
import com.knpharm.pm.dto.PopupDto;
import com.knpharm.pm.service.Popup.PopupService;
import com.knpharm.pm.service.banner.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private PopupService popupService;

    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = {"/", "/index"})
    public  String index(Model model) throws Exception {

        Map<String, Object> rtnObj = new HashMap<>();

        List<BannerDto> bannerList = bannerService.selectBannerList("P");

        List<PopupDto> popupList = popupService.selectPopupList("P");
        PopupDto popup = popupList.get(0);


        model.addAttribute("bannerList", bannerList);
        model.addAttribute("popup", popup);

        return "index";
    }


    @RequestMapping("/terms")
    public  String terms(Model model) {
        return "terms";
    }
}
