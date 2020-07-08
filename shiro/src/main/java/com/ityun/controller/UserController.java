package com.ityun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping(value = "/testThymeleaf", method = RequestMethod.GET)
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "Cyy");
        return "test";
    }
}
