package dev.itboot.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		for(Task task : userService.showTasks(user)) {
			log.info(task.getContent());
		}
		return "index";
	}
}
