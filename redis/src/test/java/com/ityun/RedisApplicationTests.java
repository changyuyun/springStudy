package com.ityun;

import com.ityun.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test1() {
        User user = new User(1, "changyuyun", "nan");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("fdd", user);
        Boolean exists = redisTemplate.hasKey("fdd");
        System.out.println(exists);
        User getUser = (User)redisTemplate.opsForValue().get("fdd");
        System.out.println(getUser);
    }
}
