package com.ms.controller;


import com.ms.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("list",userMapper.selectAll().toString());
        return "index";
    }

}
