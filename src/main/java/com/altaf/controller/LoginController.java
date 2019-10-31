package com.altaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.altaf.dto.LoginDTO;
import com.altaf.dto.SignupDTO;
import com.altaf.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/")
	public String homepage() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(SignupDTO signupDTO) {
		loginService.signup(signupDTO);
		return "login";
	}

	@PostMapping("/login")
	public String login(LoginDTO loginDTO, Model model) {
		boolean isLoginSuccess = loginService.login(loginDTO);
		model.addAttribute("isLoginSuccess", isLoginSuccess);
		if (isLoginSuccess)
			return "dashboard";
		else
			return "login";
	}
}
