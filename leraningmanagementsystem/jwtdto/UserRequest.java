package com.te.leraningmanagementsystem.jwtdto;

import lombok.Data;

@Data
public class UserRequest {

	private String username;

	private String password;
	
	private String role;
}

