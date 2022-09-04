package dev.itboot.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.itboot.todo.model.Task;

@Mapper
public interface TaskMapper {
	List<Task> selectAll();
	
	Task selectByPrimaryKey(Long taskId);
	
	int insert(Task record);
	
	int updateByPrimaryKey(Task record);
	
	int deleteByPrimaryKey(Long taskId);
}
