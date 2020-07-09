package com.ityun.controller;

import com.ityun.bean.User;
import com.ityun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        User user = userService.findByName("chang");
        System.out.println(user);
        return "hello";
    }

    @RequestMapping(value = "/testThymeleaf", method = RequestMethod.GET)
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "Cyy");
        return "test";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        return "update";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() {
        return "del";
    }

    @RequestMapping(value = "/noAuth", method = RequestMethod.GET)
    public String noAuth() {
        return "auth_error";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }
}
