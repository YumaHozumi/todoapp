package dev.itboot.todo.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Todoを表すクラス
 * @author YumaHozumi
 *
 */
@Setter
@Getter
public class Task {
	private  Long taskId;
	
	@NotBlank
	@Size(max = 254)
	private String content;
	
	@NotBlank
	@Size(max = 32)
	private String title;
	
	@NotBlank
	@Size(max = 32, min = 10)
	private String userId;
	
	@Future
	private Date schedule;
	
	private int priority;
}
