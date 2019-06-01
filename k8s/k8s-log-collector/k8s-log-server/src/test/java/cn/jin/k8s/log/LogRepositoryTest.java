package cn.jin.k8s.log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by jin on 2019-05-23.
 */
@DataRedisTest
@RunWith(SpringRunner.class)
public class LogRepositoryTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private LogRepository logRepository = new LogRepository();


    @Test
    public void save() {
        String id = "someNode-";
        String content = "this is log content-";
        for (int i = 0; i < 5; i++) {
            logRepository.save(id + i, content + i);
            logRepository.save(id + i, content + i);
            logRepository.save(id + i, content + i);
        }
        List<Log> list = logRepository.list(null);
        try{
            Assert.assertNotNull(list);
            Assert.assertEquals(list.size(), 15);
        }finally {
            for (int i = 0; i < 5; i++) {
                logRepository.clear(id + i);
            }
        }


    }

    @Test
    public void list() {
    }

    @Before
    public void init() {
        logRepository.setStringRedisTemplate(stringRedisTemplate);
    }
}