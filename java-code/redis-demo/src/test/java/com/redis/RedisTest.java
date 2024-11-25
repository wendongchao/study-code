package com.redis;

import com.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther wendongchao
 * @date 2024/11/25 20:54
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Slf4j
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void test01() {
        redisService.set("test", "test");
        log.info(redisService.get("test").toString());
    }
}
