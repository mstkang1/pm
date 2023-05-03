package com.knpharm.minol.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {
    @RequestMapping("/store")
    public  String store(Model model) {
        return "store";
    }
}
