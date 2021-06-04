package com.example.laboratory;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
@Slf4j
public class MyTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test()
    public void myTest1() {
        redisTemplate.opsForValue().set("c",555);
    }
}