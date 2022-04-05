package myapp.test.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class) //B.N.E과 B.E.은 상속관계, 만약 얘가 없었으면 아래 익셉션.class가 처리하고 있었을 것.
	public String handlerCustomException(BoardException ex, Model m) {
		m.addAttribute("exception",ex);
		return "errors/boardError"; //어떤 제이에스피 페이지로 가는지 확인.
	}
	@ExceptionHandler(Exception.class) 
	public String handlerException(Exception ex, Model m) {
		m.addAttribute("exception",ex);
		return "errors/boardError";
	}
	
}
