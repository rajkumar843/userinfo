/*package com.mrk.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mrk.userinfo.entity.UserEntity;
import com.mrk.userinfo.repo.UserRepo;

public class CustomUserDetailsService implements UserDetailsService {

	
	    @Autowired
	    private UserRepo repo;

	    @Override
	    public UserDetails loadUserByUsername(
	            String username)
	            throws UsernameNotFoundException {

	        UserEntity user =
	                repo.findByUserName(username)
	                        .orElseThrow(() ->
	                                new UsernameNotFoundException(
	                                        "User Not Found"));

	        return User.builder()

	                .username(user.getUserName())

	                .password(user.getUserPassword())

	                .roles(user.getRole())

	                .build();
	    }
}                  */

package com.mrk.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.mrk.userinfo.entity.UserEntity;
import com.mrk.userinfo.repo.UserRepo;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        UserEntity user =
                repo.findByUserName(username)

                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        "User Not Found"));

        return User.builder()

                .username(user.getUserName())

                .password(user.getUserPassword())

                .roles(user.getRole())

                .build();
    }
}
