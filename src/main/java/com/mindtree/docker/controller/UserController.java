package com.mindtree.docker.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.docker.entity.User;
import com.mindtree.docker.model.LoginModel;
import com.mindtree.docker.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	private final static Logger logger = Logger.getLogger(UserController.class.getName());
	
	@GetMapping("/")
	public String showWelcomePage() {
		return "welcome";
	}

	@GetMapping("/login")
	public String showLoginPage(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}

	@PostMapping("/home")
	public String showHomePage(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult result,
	        Model model) {
		try {
			if (!result.hasErrors()) {
				User saveFlag = userService.loginUser(loginModel);
				if (saveFlag != null) {
					return "homePage";
				} else {
					model.addAttribute("failed", "incorrect email id and password. Please try again");
					return "login";
				}
			} 
		} catch (Exception e) {
			logger.log(Level.SEVERE, "exception occured: Login failed " + e.getMessage());
		}
		return "login";
	}

}
