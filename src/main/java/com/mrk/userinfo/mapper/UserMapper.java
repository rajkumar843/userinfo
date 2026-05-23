package com.mrk.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mrk.userinfo.dto.UserDTO;
import com.mrk.userinfo.entity.UserEntity;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserEntity mapUserDTOToUserEntity(UserDTO userDTo);

	UserDTO mapUserToUserDTo(UserEntity userEntity);

}
