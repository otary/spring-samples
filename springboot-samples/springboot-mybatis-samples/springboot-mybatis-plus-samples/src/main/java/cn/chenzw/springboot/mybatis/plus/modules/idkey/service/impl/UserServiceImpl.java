package cn.chenzw.springboot.mybatis.plus.modules.idkey.service.impl;

import cn.chenzw.springboot.mybatis.plus.modules.idkey.entity.User;
import cn.chenzw.springboot.mybatis.plus.modules.idkey.repository.UserMapper;
import cn.chenzw.springboot.mybatis.plus.modules.idkey.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author chenzw
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
