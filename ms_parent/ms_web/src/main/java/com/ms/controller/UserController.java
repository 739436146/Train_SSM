package com.ms.controller;

import com.ms.dao.UserMapper;
import com.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST,value = "/user/login")
    public String login(HttpServletRequest request,
                        @RequestParam("username") String username ,
                        @RequestParam("password") String password){

        User user = userMapper.selectByUsernameAndPassword(username, password);

        if (user != null){
            request.getSession().setAttribute("user",user);
            request.getSession().removeAttribute("errorMsg");
            return "user/user";
        }else {
            request.getSession().setAttribute("errorMsg","登录失败");
            return "redirect:/";
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/user/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id")Integer id,Model model){
        model.addAttribute("usermsg",userMapper.selectUserById(id));

        return "user/addPage";
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    public String register(){
        return "user/register";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request,User user){
        userMapper.updateUser(user);
        request.getSession().setAttribute("user",user);
        return "user/user";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String addUser(User user,HttpServletRequest request){
        userMapper.insertUser(user);

        return "redirect:/";
    }

}
