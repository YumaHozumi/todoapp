package dev.itboot.todo.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.itboot.todo.service.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TaskController {
	private final TaskService service;
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "hello";
	}
}
