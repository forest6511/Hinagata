package jp.hinagata.config;

import jp.hinagata.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void shouldGetValueFromRedisTest() {
        redisTemplate.opsForValue().set("key111", "123456789");
        assertThat(redisTemplate.opsForValue().get("key111"), is("123456789"));
    }

}
