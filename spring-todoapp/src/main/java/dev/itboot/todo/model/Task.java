package dev.itboot.todo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@Size(max = 128)
	private String content;
	
	@NotBlank
	@Size(max = 32)
	private String title;
	
	@NotBlank
	@Size(max = 32, min = 5)
	private String userId;

	@DateTimeFormat(pattern = "yyyy-MM-dd") //入力時の期待フォーマット
	@JsonFormat(pattern = "yyyy/MM/dd") //出力
	private LocalDate schedule;
	
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern ="HH:mm")
	private LocalTime timeSche;
	
	private int priority;
}
