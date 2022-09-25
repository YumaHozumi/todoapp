package dev.itboot.todo.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
	@NotBlank
	@Size(max = 20, min = 8)
	@Pattern(regexp="[0-9a-zA-Z!_,.@~`!#^\\-*()+={}\\[\\]|:;]+")
	private String password;

	@NotBlank
	@Size(max = 20, min = 8)
	@Pattern(regexp="[0-9a-zA-Z!_,.@~`!#^\\-*()+={}\\[\\]|:;]+")
	private String passwordConfirm;
	
	@AssertTrue(message = "パスワードが一致しません")
	public boolean isPasswordValid() {
		if(password == null || password.isEmpty()) {
			return true;
		}
		return password.equals(passwordConfirm);
	}
}
