package com.ityun.impl;

import com.ityun.dao.PersonRepository;
import com.ityun.entity.Person;
import com.ityun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"myCache"})
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @CachePut(key = "#person.id")
    @Override
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id，key为：" + p.getId() + "数据做了缓存");
        return p;
    }

    @CacheEvict
    @Override
    public void remove(Integer id) {
        personRepository.deleteById(id);
        System.out.println("删除了id，key为" + id + "的数据缓存");
    }

    @Cacheable(key = "#person.id")
    @Override
    public Person findOne(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        System.out.println("为id，key为：" + p.orElse(null) + "数据做了缓存");
        return p.get();
    }
}
