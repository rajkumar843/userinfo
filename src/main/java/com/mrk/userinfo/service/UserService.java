package com.mrk.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mrk.userinfo.dto.UserDTO;
import com.mrk.userinfo.entity.UserEntity;
import com.mrk.userinfo.mapper.UserMapper;
import com.mrk.userinfo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public UserDTO adduser(UserDTO dto){
		UserEntity savedUser =repo.save(UserMapper.INSTANCE.mapUserDTOToUserEntity(dto));  //saving user dto to entity
		return UserMapper.INSTANCE.mapUserToUserDTo(savedUser);
	}
	
	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId){
		  Optional<UserEntity> fetchUser =repo.findById(userId);
		  if(fetchUser.isPresent()) {
			  return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTo(fetchUser.get()),HttpStatus.OK);
		  }
		return ResponseEntity.notFound().build();
	}

}
