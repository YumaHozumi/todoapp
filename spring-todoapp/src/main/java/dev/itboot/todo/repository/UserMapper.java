package dev.itboot.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.itboot.todo.model.User;

@Mapper
public interface UserMapper {
	List<User> selectAll();

	User selectByPrimaryKey(String id);
	
	int insert(User record);
	
	int updateByPrimaryKey(User record);
	
	int deleteByPrimaryKey(String id);
}
