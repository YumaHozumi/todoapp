package dev.itboot.todo.model;

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
	@Size(max = 32, min = 10)
	private String password;
	
	@NotBlank
	@Size(max = 32)
	private String nickname;
}
