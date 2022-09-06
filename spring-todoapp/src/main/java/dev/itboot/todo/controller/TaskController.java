package dev.itboot.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.itboot.todo.model.Task;
import dev.itboot.todo.model.User;
import dev.itboot.todo.service.TaskService;
import dev.itboot.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class TaskController {
	private final UserService userService;
	private final TaskService taskService;
	
	@GetMapping("/")
	public String index(Model model) {
		User user = userService.selectByPrimaryKey("aaaaaaa");
		model.addAttribute("tasks", userService.showTasks(user));
		return "index";
	}
	
	@GetMapping("/add")
	public String addTask(@ModelAttribute Task task) {
		return "form";
	}
	
	@PostMapping("/process")
	public String process(@Validated @ModelAttribute Task task, BindingResult result) {
		if(result.hasErrors()) {
			return "form";
		}
		taskService.save(task);
		return "redirect:/";
	}
}
