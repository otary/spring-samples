package cn.chenzw.springboot.mapstruct.mapper;

import cn.chenzw.springboot.mapstruct.dto.UserDTO;
import cn.chenzw.springboot.mapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // @Mapping(target = "name", source = "name")
    // @Mapping(target = "id", source = "id")
    User toEntity(UserDTO userDTO);

    @Mapping(target = "name", source = "name")
    UserDTO toDTO(User user);

}
