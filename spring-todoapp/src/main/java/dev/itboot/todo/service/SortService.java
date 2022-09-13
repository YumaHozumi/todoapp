package dev.itboot.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.itboot.todo.model.Sort;
import dev.itboot.todo.repository.SortMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class SortService {
	private final SortMapper mapper;
	
	public List<Sort> selectAll(){
		return mapper.selectAll();
	}
	
	public Sort selectByPrimaryKey(Long sortId) {
		return mapper.selectByPrimaryKey(sortId);
	}
	
	public void save(Sort sort) {
		if(sort.getSortId() == null) {
			mapper.insert(sort);
		}else {
			mapper.updateByPrimaryKey(sort);
		}
	}
	
	public int deleteByPrimaryKey(Long sortId) {
		return mapper.deleteByPrimaryKey(sortId);
	}
}
