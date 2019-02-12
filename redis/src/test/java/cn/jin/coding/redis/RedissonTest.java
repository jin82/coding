package cn.jin.coding.redis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jin on 2019/1/7.
 */
public class RedissonTest {

    private static Properties properties;

    private static InputStream inputStream;

    @BeforeClass
    public static void initConfig() throws Exception{
        Resource resource = new ClassPathResource("application.properties");
        if (!resource.exists()) {
            throw new RuntimeException("application.properties not found");
        }
        properties = new Properties();
        inputStream = resource.getInputStream();
        properties.load(inputStream);
    }

    @AfterClass
    public static void after() throws Exception{
        inputStream.close();
    }


    @Test
    public void testRedisson() {
        System.out.println(properties);
    }


}
