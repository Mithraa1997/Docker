package com.mindtree.docker.service;

import com.mindtree.docker.entity.User;
import com.mindtree.docker.model.LoginModel;

public interface UserService {

	User loginUser(LoginModel loginModel);

}
