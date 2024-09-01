package com.nyeong.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyeong.spring.ex.mvc.domain.User;
import com.nyeong.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	// 가장 최근에 등록된 사용자 정보 리턴하는 기능
	public User getLastUser(){
		User lastUser = userRepository.selectLastUser();
		return lastUser;
	}
}
