package com.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping({"/",""," "})
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin/login";
    }

}
