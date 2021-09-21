package com.hasim.employee.dashboard.api.service;

import org.springframework.stereotype.Service;

import com.hasim.employee.dashboard.api.data.UserEmailResponse;

@Service
public interface UserEmailProxyService {
	
	public UserEmailResponse getUserEmailDetails(String userId);

}
