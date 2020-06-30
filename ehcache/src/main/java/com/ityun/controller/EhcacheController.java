package com.ityun.controller;

import com.ityun.entity.Person;
import com.ityun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class EhcacheController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/put")
    public Person put(Person person) {
        return personService.save(person);
    }

    @RequestMapping("/cacheable")
    public Person cacheable(Person person) {
        return personService.findOne(person);
    }

    @RequestMapping("/evict")
    public String evict(Integer id) {
        personService.remove(id);
        return "ok";
    }
}
