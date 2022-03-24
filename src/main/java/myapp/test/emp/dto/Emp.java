package myapp.test.emp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data //게터세터생성자 대신 만들어주는 어노테이션(롬복)
public class Emp {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
}
