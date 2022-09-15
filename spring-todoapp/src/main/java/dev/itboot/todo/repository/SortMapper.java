package dev.itboot.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.itboot.todo.model.Sort;

@Mapper
public interface SortMapper {
	List<Sort> selectAll();
	
	Sort selectByPrimaryKey(Long sortId);
	
	int insert(Sort record);
	
	int updateByPrimaryKey(Sort record);
	
	int deleteByPrimaryKey(Long sortId);
}
