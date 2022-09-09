package dev.itboot.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.todo.model.Task;
import dev.itboot.todo.model.User;
import dev.itboot.todo.repository.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
	private final UserMapper mapper;
	
	public List<User> selectAll(){
		return mapper.selectAll();
	}

	public User selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	public void insert(User user) {
		mapper.insert(user);
	}
	
	public int updateByPrimaryKey(User user) {
		if(user.getId() != null) {
			return -1;
		}
		return mapper.updateByPrimaryKey(user);
	}
	
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	public List<Task> showTasks(User user){
		return mapper.showTasks(user);
	}
}
