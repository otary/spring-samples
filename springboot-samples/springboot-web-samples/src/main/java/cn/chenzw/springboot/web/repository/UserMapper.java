package cn.chenzw.springboot.web.repository;

import cn.chenzw.springboot.web.domain.dto.UserDTO;

public interface UserMapper {

    UserDTO queryById(Long id);
}
