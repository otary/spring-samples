package cn.chenzw.springboot.mybatis.modules.idkey.repository;

import cn.chenzw.springboot.mybatis.modules.idkey.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三");
        user.setIsDeleted(false);
        userMapper.insert(user);

        // 生成UUID
        List<User> users = userMapper.selectList(null);
        log.info("插入结果 => {}", users);
    }

    /**
     * 使用Lambda表达式
     */
    @Test
    public void testSelectWithLambdaQuery() {
        List<User> users = userMapper.selectList(
                new LambdaQueryWrapper<User>().eq(User::getId, "1")
        );
        log.info("users => {}", users);
    }

}
