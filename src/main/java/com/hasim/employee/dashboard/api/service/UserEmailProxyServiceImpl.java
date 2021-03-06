package com.hasim.employee.dashboard.api.service;

import static com.hasim.employee.dashboard.api.constant.CommonConstant.CIRCUIT_BREAKER_USER_EMAIL_ADDRESS;
import static com.hasim.employee.dashboard.api.constant.CommonConstant.FALLBACK_USER_EMAIL_ADDRESS;
import static com.hasim.employee.dashboard.api.constant.CommonConstant.REST_TEMPLATE;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hasim.employee.dashboard.api.data.UserEmailResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserEmailProxyServiceImpl implements UserEmailProxyService {
	private static final Logger logger = LogManager.getLogger(UserEmailProxyServiceImpl.class);
	@Autowired
	@Qualifier(REST_TEMPLATE)
	public RestTemplate restTemplate;

	@Value("${retrieve.email.httpRequestEndpoint}")
	private String endpoint;

	@Value("${retrieve.email.httpRequestHostContext}")
	private String hostContext;

	@CircuitBreaker(name = CIRCUIT_BREAKER_USER_EMAIL_ADDRESS, fallbackMethod = FALLBACK_USER_EMAIL_ADDRESS)
	public UserEmailResponse getUserEmailDetails(String userId) {
		logger.info("getUserEmailDetails started");
		UserEmailResponse userEmailResponse = null;
		String url = new StringBuilder().append(hostContext).append(endpoint).toString();
		logger.info("calling url::"+url);
		final ResponseEntity<UserEmailResponse> response = restTemplate.exchange(
				url, HttpMethod.GET,
				new HttpEntity(new MultiValueMap()), UserEmailResponse.class, userId);
		if (HttpStatus.OK == response.getStatusCode()) {
			userEmailResponse = response.getBody();
		}
		logger.info("getUserEmailDetails finished");
		return userEmailResponse;
	}

	public UserEmailResponse fallbackGetUserEmailDetails(String userId, Throwable t) {
		logger.error("Error while calling downstream api", t);
		return null;
	}

}
