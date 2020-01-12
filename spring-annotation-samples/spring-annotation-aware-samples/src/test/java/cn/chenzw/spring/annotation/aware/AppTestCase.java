package cn.chenzw.spring.annotation.aware;

import cn.chenzw.spring.annotation.aware.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class AppTestCase {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testAware() {

    }

    @Test
    public void testEvent() {
        // 发布事件
        applicationContext.publishEvent(new ApplicationEvent("hello") {
        });
    }
}
