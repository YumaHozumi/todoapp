package dev.itboot.todo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Option {
	private Long optionId;
	
	@NotBlank
	@Size(max = 32, min = 5)
	private String userId;
	
	@NotBlank
	@Size(max = 32)
	private String bgColor = "bg-light";
}
