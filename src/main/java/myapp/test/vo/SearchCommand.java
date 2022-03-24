package myapp.test.vo;

import lombok.Data;
//type=3&query=big+data
@Data
public class SearchCommand {
	private String type;
	private String query;
	private int page;

	
}