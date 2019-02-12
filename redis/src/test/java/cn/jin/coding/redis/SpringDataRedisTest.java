package cn.jin.coding.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by jin on 2019/1/7.
 */
@RunWith(SpringRunner.class)
@DataRedisTest
public class SpringDataRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testGetValue() {

        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String key = "test_foo" + new Random().nextInt(10);
        System.out.println("key is " + key);
        String value = "test_bar";
        operations.set(key, value);
        String foo = operations
                .get(key);
        Assert.assertEquals(foo, value);


    }
}
