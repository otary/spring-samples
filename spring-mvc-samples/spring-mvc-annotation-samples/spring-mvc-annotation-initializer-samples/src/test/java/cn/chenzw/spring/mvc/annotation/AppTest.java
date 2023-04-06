package cn.chenzw.spring.mvc.annotation;

import cn.chenzw.spring.mvc.annotation.config.AppConfig;
import cn.chenzw.spring.mvc.annotation.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class AppTest {

    @Test
    public void test(){

    }
}
