package com.hasim.employee.dashboard.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO {
	@JsonProperty("name")
	String name;
	@JsonProperty("id")
	long id;
	@JsonProperty("userId")
	String userId;
	@JsonProperty("userEmail")
	String userEmail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
