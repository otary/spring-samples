package cn.chenzw.springboot.mybatis.plus.modules.idkey.service;

import cn.chenzw.springboot.mybatis.plus.modules.idkey.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testGetById() {
        User user = userService.getById(1);
        log.info(" => {}", user);
    }

}
