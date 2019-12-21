package com.ms.controller;

import com.ms.dao.AdminMapper;
import com.ms.dao.UserMapper;
import com.ms.entity.Admin;
import com.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/admin/login" , method = RequestMethod.POST)
    public String login(Model model,
                        HttpServletRequest request,
                        String username,
                        String password){

        Admin admin  = adminMapper.selectAdminByUsernameAndPassword(username, password);
        List<User> list = userMapper.selectAll();

        request.getSession().setAttribute("admin",admin);
        model.addAttribute("list",list);

        return "/admin/userList";
    }

    @RequestMapping(value = "/admin/logout" , method = RequestMethod.GET)
    public String logout(HttpServletRequest request){

        request.getSession().removeAttribute("admin");

        return "redirect:/";
    }

}
