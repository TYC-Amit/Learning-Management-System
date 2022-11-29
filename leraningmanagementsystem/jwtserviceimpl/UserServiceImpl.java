package com.te.leraningmanagementsystem.jwtserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.jwtdto.UserRequest;
import com.te.leraningmanagementsystem.jwtsecentity.User;

@Service
public class UserServiceImpl {

	@Autowired
	private com.te.leraningmanagementsystem.jwtrepository.UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public User saveUser(UserRequest user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());

		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userRepository.save(newUser);
	}

}

