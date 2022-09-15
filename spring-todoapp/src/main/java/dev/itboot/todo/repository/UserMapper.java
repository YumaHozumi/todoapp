package dev.itboot.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import dev.itboot.todo.model.Sort;
import dev.itboot.todo.model.Task;
import dev.itboot.todo.model.User;

@Mapper
public interface UserMapper {
	List<User> selectAll();

	User selectByPrimaryKey(String id);
	
	int insert(User record);
	
	int updateByPrimaryKey(User record);
	
	int deleteByPrimaryKey(String id);
	
	List<Task> showTasks(@Param("user") User user, @Param("hasSort") Sort sort);
	
	Sort showSortOption(User record);
}
