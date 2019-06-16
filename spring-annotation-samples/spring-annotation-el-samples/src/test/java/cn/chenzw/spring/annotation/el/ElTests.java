package cn.chenzw.spring.annotation.el;

import cn.chenzw.spring.annotation.el.config.ElConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ElConfig.class})
public class ElTests {


    @Test
    public void testEl() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig bean = applicationContext.getBean(ElConfig.class);

        Assert.assertEquals(bean.getName(), "张三");
        Assert.assertEquals(String.valueOf(bean.getAge()), "25");
        Assert.assertNotNull(bean.getOsName());
        Assert.assertNotNull(bean.getRandomNumber());
        Assert.assertNotNull(bean.getResourceFile());
        Assert.assertNotNull(bean.getResourceUrl());
        Assert.assertEquals(bean.getPassword(), "12345");

        System.out.println(bean);
    }
}
