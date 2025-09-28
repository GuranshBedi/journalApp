package net.journal.journalAPP.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void sendMail(){
        redisTemplate.opsForValue().set("email","guranshbedi26@gmail.com");
        redisTemplate.opsForValue().get("email");
    }

}
