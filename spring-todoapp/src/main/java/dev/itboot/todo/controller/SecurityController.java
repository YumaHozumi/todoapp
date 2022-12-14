package dev.itboot.todo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.itboot.todo.model.RegisterForm;
import dev.itboot.todo.model.User;
import dev.itboot.todo.service.UserService;
import dev.itboot.todo.util.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class SecurityController {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin/list")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute RegisterForm registerForm, @ModelAttribute User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String process(@Validated @ModelAttribute RegisterForm registerForm, BindingResult result, @Validated @ModelAttribute User user,
			BindingResult resultUser) {
		if(result.hasErrors() || resultUser.hasErrors()) {
			return "register";
		}
		if(user.getNickname() == "") user.setNickname("ななし");
		user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
		if(user.isAdmin()) {
			user.setRole(Role.ADMIN.name());
		}else {
			user.setRole(Role.USER.name());
		}
		//ユーザ登録に失敗
		if(!userService.insert(user)) {
			return "redirect:/login?unique";
		}
		//ここまで来たら成功している
		return "redirect:/login?register";
		
	}
}
