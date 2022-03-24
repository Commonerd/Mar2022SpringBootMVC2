package myapp.test.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NewArticleCommand {
	
	private String title;
	private String content;
	private int parentId;
	
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date regdate;
  
}
