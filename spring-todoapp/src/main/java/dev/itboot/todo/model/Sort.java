package dev.itboot.todo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sort {
	private int sortId;
	
	@NotBlank
	@Size(max = 32, min = 5)
	private String userId;
	
	@Size(max=32)
	private String name;
	
	@Size(max=16)
	private String orderStr;
}
