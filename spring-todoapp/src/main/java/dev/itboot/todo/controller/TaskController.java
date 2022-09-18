package dev.itboot.todo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.itboot.todo.model.Sort;
import dev.itboot.todo.model.Task;
import dev.itboot.todo.model.User;
import dev.itboot.todo.service.SortService;
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
	private final SortService sortService;
	
	@GetMapping("/")
	public String index(Authentication loginUser, Model model) {
		User user = userService.selectByPrimaryKey(loginUser.getName());
		Sort sort = userService.showSortOption(user);
		if(user == null) return "/login";
		model.addAttribute("tasks", userService.showTasks(user, sort));
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
	
	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable Long id, Model model) {
		model.addAttribute("task", taskService.selectByPrimaryKey(id));
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteByPrimaryKey(id);
		return "redirect:/";
	}
	
	@GetMapping("/sort")
	public String sort(Authentication loginUser, Model model) {
		User user = userService.selectByPrimaryKey(loginUser.getName());
		model.addAttribute("sort", userService.showSortOption(user));			
		return "sortingForm";
	}
	
	@PostMapping("/sort")
	public String setSort(@Validated @ModelAttribute Sort sort, BindingResult result) {
		if(result.hasErrors()) {
			return "sortingForm";
		}
		sortService.save(sort);
		return "redirect:/";
	}
}
