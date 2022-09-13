package dev.itboot.todo.repository;

import java.util.List;

import dev.itboot.todo.model.Sort;

public interface SortMapper {
	List<Sort> selectAll();
	
	Sort selectByPrimaryKey(int sortId);
	
	int insert(Sort record);
	
	int updateByPrimaryKey(Sort record);
	
	int deleteByPrimaryKey(int sortId);
}
