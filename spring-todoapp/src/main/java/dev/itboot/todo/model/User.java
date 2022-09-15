package dev.itboot.todo.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザを表すクラス
 * @author YumaHozumi
 *
 */
@Setter
@Getter
public class User {
	@NotBlank
	@Size(max = 32, min = 5)
	private String id;
	
	@NotBlank
	@Size(max = 20, min = 8)
	private String password;
	
	@NotBlank
	@Size(max = 32)
	private String nickname;
	
	private List<Task> tasks;
	private Sort sort;
	
	private boolean admin;
	private String role;
	
}
