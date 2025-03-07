package cn.chenzw.springboot.mapstruct;

import cn.chenzw.springboot.mapstruct.dto.UserDTO;
import cn.chenzw.springboot.mapstruct.entity.User;
import cn.chenzw.springboot.mapstruct.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testToDTO() {
        User user = User.builder()
                .id(1L)
                .name("zhangsan")
                .createTime(new Date())
                .build();
        UserDTO userDTO = userMapper.toDTO(user);
        log.info("userDTO => {}", userDTO);
    }

    @Test
    public void testToEntity() {
        UserDTO userDTO = UserDTO.builder()
                .id(1L)
                .name("zhangsan")
                .build();
        User user = userMapper.toEntity(userDTO);
        log.info("user => {}", user);
    }
}
