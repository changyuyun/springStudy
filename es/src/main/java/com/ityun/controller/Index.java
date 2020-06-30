package com.ityun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Index {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }
}
