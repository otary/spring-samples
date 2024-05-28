package cn.chenzw.springboot.liteflow.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTests {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.test();
    }
}
