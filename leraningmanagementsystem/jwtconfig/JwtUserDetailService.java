package com.te.leraningmanagementsystem.jwtconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.leraningmanagementsystem.jwtrepository.UserRepository;


@Service
public class JwtUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.te.leraningmanagementsystem.jwtsecentity.User user = userRepository.findByUsername(username);
		
		if (user != null) {
			return new User(user.getUsername(),user.getPassword(),
					Arrays.asList(new SimpleGrantedAuthority("ROLE_"+ user.getRole())));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	

}


