package com.ityun.service;

import com.ityun.entity.Person;

public interface PersonService {
    Person save(Person person);

    void remove(Integer id);

    Person findOne(Person person);
}
