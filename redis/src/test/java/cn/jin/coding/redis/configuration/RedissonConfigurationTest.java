package cn.jin.coding.redis.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jin on 2019/1/15.
 */
@SpringBootTest(classes = RedissonConfiguration.class)
@RunWith(SpringRunner.class)

public class RedissonConfigurationTest {

    @Autowired
    private RedissonClient redissonClient;


    @Test
    public void testRedis() {
        String key = "cn.jin.coding.redis.configuration___key";
        String value = "value";
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.delete();

        Assert.assertFalse(bucket.isExists());
        bucket.set(value);
        Assert.assertTrue(bucket.isExists());
        Assert.assertEquals(value, bucket.get());
        bucket.delete();
        Assert.assertFalse(bucket.isExists());
    }

    @Test
    public void testLock() {
        RLock lock = redissonClient.getLock("cn.jin.coding.redis.configuration_test_lock");

        try{

            if (lock.tryLock()) {
                Assert.assertTrue(lock.isLocked());
            }
        }finally {
            lock.unlock();
            Assert.assertFalse(lock.isLocked());

        }

    }


}