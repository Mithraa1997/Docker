package com.mindtree.docker.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginModel {

	@NotNull(message = "userName cannot be blank")
	@Size(min = 5, max = 10, message = "userName should be between 5 to 10 char length")
	private String password;
	@NotBlank(message = " email should not be blank")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "invalid email id format")
	private String emailId;

	public LoginModel() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
