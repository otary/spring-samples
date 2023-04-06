package cn.chenzw.springboot.web.formatter;

import cn.chenzw.springboot.web.domain.dto.UserDTO;
import cn.chenzw.springboot.web.repository.UserMapper;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * String => UserDTO 转换器
 *
 * @author chenzw
 */
public class UserFormatter implements Formatter<UserDTO> {

    private UserMapper userMapper;

    public UserFormatter(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO parse(String id, Locale locale) throws ParseException {
        return userMapper.queryById(Long.valueOf(id));
    }

    @Override
    public String print(UserDTO userDto, Locale locale) {
        return String.valueOf(userDto.getId());
    }
}
