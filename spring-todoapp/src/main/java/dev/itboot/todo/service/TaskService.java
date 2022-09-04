package dev.itboot.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.todo.model.Task;
import dev.itboot.todo.repository.TaskMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class TaskService {
	private final TaskMapper mapper;
	
	public List<Task> selectAll(){
		return mapper.selectAll();
	}
	
	public Task selectByPrimaryKey(Long taskId) {
		return mapper.selectByPrimaryKey(taskId);
	}
	
	public void save(Task task) {
		if(task.getTaskId() == null) {
			mapper.insert(task);
		}else {
			mapper.updateByPrimaryKey(task);
		}
	}
	
	public void deleteByPrimaryKey(Long taskId) {
		mapper.deleteByPrimaryKey(taskId);
	}
}
