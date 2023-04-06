package cn.chenzw.springboot.web.core;

import cn.chenzw.springboot.web.controller.ContextController;
import cn.chenzw.springboot.web.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 获取方法参数
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalVariableTableParameterNameDiscovererTests {


    @Test
    public void testGetParameterNames() {
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

        Method[] methods = ContextController.class.getMethods();
        for (Method method : methods) {
            String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
            log.info("{} => {}", method, parameterNames);
        }
    }
}
