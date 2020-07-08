package com.ityun.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value = "toLogin")
    public String toLogin(Model model) {
        model.addAttribute("msg", "无信息");
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(String name, String password, Model model) {
        //获取Subject
        Subject subject = SecurityUtils.getSubject();

        //封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        System.out.println(123);
        System.out.println(123);
        //执行登陆
        try {
            subject.login(token);
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }

    }
}
