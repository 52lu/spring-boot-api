package com.hui.springbootapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisUseTests {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void cacheTest() {
        redisTemplate.opsForValue().set("aabc","1234878",60, TimeUnit.SECONDS);
        System.out.println(1);
    }
}
