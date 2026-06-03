package com.mrk.userinfo.dto;

import lombok.Data;

@Data
public class AuthRequest {                 //login
	
	private String userName;
    private String userPassword;

}
