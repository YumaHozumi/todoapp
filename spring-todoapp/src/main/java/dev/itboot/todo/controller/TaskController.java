package dev.itboot.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dev.itboot.todo.service.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TaskController {
	private final TaskService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
