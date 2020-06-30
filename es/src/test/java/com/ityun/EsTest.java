package com.ityun;

import com.ityun.dao.EsUser;
import com.ityun.repository.EsUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsTest {

    @Autowired
    private EsUserRepository esUserRepository;

    @Before
    public void before() {
        esUserRepository.deleteAll();
        esUserRepository.save(new EsUser("1", "chang", "yy"));
        esUserRepository.save(new EsUser("2", "changyy", "yy"));
        esUserRepository.save(new EsUser("3", "changcc", "yy"));
    }

    @Test
    public void testAdd() {
        EsUser esUser = new EsUser("1", "chang", "yy");
        esUserRepository.save(esUser);
    }

    @Test
    public void testFind() {
        Optional<EsUser> result = esUserRepository.findById("1");
        if (result.isPresent()) {
            EsUser esUser = result.get();
            System.out.println(esUser.getId());
            System.out.println(esUser.getUsername());
            System.out.println(esUser.getDescribe());
        }
    }

    @Test
    public void testFindAll() {
        Iterable<EsUser> result = esUserRepository.findAll();
        for (EsUser esUser : result) {
            System.out.println(esUser);
        }
    }

    @Test
    public void testUpdateById() {
        EsUser save = esUserRepository.save(new EsUser("1", "chang-change", "yy-change"));
        System.out.println(save);
    }

    @Test
    public void testDeleteById() {
        esUserRepository.deleteById("1");
    }

    @Test
    public void testDeleteAll() {
        esUserRepository.deleteAll();
    }

    public void testLike() {

    }
}
