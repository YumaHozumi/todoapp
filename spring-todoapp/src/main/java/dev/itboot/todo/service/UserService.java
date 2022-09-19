package dev.itboot.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.todo.model.Option;
import dev.itboot.todo.model.Sort;
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
	
	public boolean insert(User user) {
		//既に同じIDのユーザがいる場合は使用不可に
		if(mapper.selectByPrimaryKey(user.getId()) != null) {
			return false;
		}
		mapper.insert(user);
		return true;
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
	
	public List<Task> showTasks(User user, Sort sort){
		return mapper.showTasks(user, sort);
	}
	
	public Sort showSortOption(User user) {
		if(mapper.showSortOption(user) != null) {
			return mapper.showSortOption(user);			
		}
		//まだ一度もソートの設定行ってなかったら新しく作成
		return new Sort();
	}
	
	public Option getOption(User user) {
		if(mapper.getOption(user) != null) {
			return mapper.getOption(user);
		}
		return new Option();
	}
}
