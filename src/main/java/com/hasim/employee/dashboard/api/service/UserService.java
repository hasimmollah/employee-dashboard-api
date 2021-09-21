package com.hasim.employee.dashboard.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hasim.employee.dashboard.api.model.UserVO;
@Service
public interface UserService {
	
	public List<UserVO> fetchUsers();

	public UserVO createUser(UserVO userVO, String userEmail);

}
