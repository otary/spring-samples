package cn.chenzw.springboot.mybatis.plus.modules.idkey.repository;

import cn.chenzw.springboot.mybatis.plus.modules.idkey.entity.User;
import cn.chenzw.toolkit.mybatis.core.support.MyBatisRepository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@MyBatisRepository
public interface UserMapper extends BaseMapper<User> {


}

