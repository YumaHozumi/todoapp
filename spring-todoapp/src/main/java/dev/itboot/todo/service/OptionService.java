package dev.itboot.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.itboot.todo.model.Option;
import dev.itboot.todo.repository.OptionMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class OptionService {
	private final OptionMapper mapper;
	
	public List<Option> selectAll(){
		return mapper.selectAll();
	}
	
	public Option selectByPrimaryKey(Long optionId) {
		return mapper.selectByPrimaryKey(optionId);
	}
	
	public void save(Option option) {
		if(option.getOptionId() == null) {
			mapper.insert(option);
		}else {
			mapper.updateByPrimaryKey(option);
		}
	}
	
	public int deleteByPrimaryKey(Long optionId) {
		return mapper.deleteByPrimaryKey(optionId);
	}
}
