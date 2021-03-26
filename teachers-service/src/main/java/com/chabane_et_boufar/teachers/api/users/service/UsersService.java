package com.chabane_et_boufar.teachers.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chabane_et_boufar.teachers.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService{
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
	UserDto getUserByUserId(String userId);
}
