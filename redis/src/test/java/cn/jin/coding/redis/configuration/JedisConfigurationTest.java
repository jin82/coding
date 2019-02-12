package cn.jin.coding.redis.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

/**
 * Created by jin on 2019/1/15.
 */
@SpringBootTest(classes = JedisConfiguration.class)
@RunWith(SpringRunner.class)
public class JedisConfigurationTest {

    @Autowired
    private JedisCluster jedisCluster;


    @Test
    public void testRedis() {
        String key = JedisConfigurationTest.class.getName() + "_key";
        String value = "value";
        jedisCluster.del(key);
        Assert.assertFalse(jedisCluster.exists(key));
        jedisCluster.set(key, value);
        Assert.assertTrue(jedisCluster.exists(key));
        Assert.assertEquals(value, jedisCluster.get(key));
        jedisCluster.del(key);
        Assert.assertFalse(jedisCluster.exists(key));
    }
}