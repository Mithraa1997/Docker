package com.mindtree.docker.serviceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.docker.entity.User;
import com.mindtree.docker.model.LoginModel;
import com.mindtree.docker.repository.LoginRepo;
import com.mindtree.docker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	LoginRepo loginRepo;
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User loginUser(LoginModel loginModel) {
		try {
			User user = loginRepo.findByEmailId(loginModel.getEmailId());
			if (user != null && user.getEmailId().equals(loginModel.getEmailId())
					&& user.getPassword().equals(loginModel.getPassword())) {
				return user;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "exception occured: incorrect username or password " + e.getMessage());
		}
		return null;
	}
}