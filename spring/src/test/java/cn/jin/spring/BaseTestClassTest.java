package cn.jin.spring;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jin on 2019/1/31.
 */
public class BaseTestClassTest extends BaseTest{
    @Test
    public void testGetCurrentPathResource() {
        String resourceName = "Base.xml";
        String currentClassPathResource = getCurrentClassPathResource(resourceName);
        Assert.assertEquals("cn/jin/spring/Base.xml", currentClassPathResource);
    }
}
