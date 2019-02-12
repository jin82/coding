package cn.jin.spring.bean;

import cn.jin.spring.BaseTest;
import cn.jin.spring.bean.simple.Java;
import cn.jin.spring.bean.simple.JavaProject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by jin on 2019/1/31.
 */
public class XmlBeanFactoryTest extends BaseTest {

    private BeanFactory beanFactory;

    @Before
    public void initBefaFactory() {
        Resource resource = new ClassPathResource("XmlBeanFactoryDemo.xml",this.getClass());
        this.beanFactory = new XmlBeanFactory(resource);
    }

    @Test
    public void testSimpleXmlBeanFactory(){
        Java java = beanFactory.getBean(Java.class);
        Assert.assertSame(java.name(), "JAVA");
        Assert.assertTrue(java.isStaticLanguage());
        Assert.assertTrue(java.isType());
    }

    @Test
    public void testConstructorRefBean(){
        JavaProject javaProject = beanFactory.getBean(JavaProject.class);
        Java java = beanFactory.getBean(Java.class);
        Assert.assertSame(javaProject.useLanguageName(),java.name());
    }
}
