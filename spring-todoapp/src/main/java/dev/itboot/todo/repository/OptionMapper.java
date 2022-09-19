package dev.itboot.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.itboot.todo.model.Option;

@Mapper
public interface OptionMapper {
	List<Option> selectAll();
	
	Option selectByPrimaryKey(Long optionId);
	
	int insert(Option record);
	
	int updateByPrimaryKey(Option record);
	
	int deleteByPrimaryKey(Long optionId);
}
