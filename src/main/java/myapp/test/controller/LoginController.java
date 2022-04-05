package myapp.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import myapp.test.service.MembersService;
import myapp.test.vo.LoginDto;

@SessionAttributes("user")
@Controller
public class LoginController {
	
	@Autowired
	MembersService mservice;
	//세션에 같은 이름으로 저장이 되어있는 경우 동작하지 않는다.
	//세션에 저장되지 않는 경우 실행 후 리턴값을 세션에 저장한다. 
	@ModelAttribute("user")
	public LoginDto getLoginDto() {
		System.out.println("getLoginDto()실행");
		return new LoginDto(); 
	}
	
	@GetMapping("/loginForm")
	public String form() {
		return "login/loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@Valid LoginDto dto, BindingResult result, Model m) {
		//위: 디스패처 서블릿이 로그인dto만듦. //dto, result는 모델데이터로 추가함. 
		if(result.hasErrors()) {
			return "login/loginForm";
		}
		
		String dbpw = mservice.login(dto.getId());
		
		if(dbpw ==null ) {
			result.reject("nocode","아이디 틀림"); //2번째는 디폴트메시지
			return "login/loginForm";
		}else if(dbpw != null && !dbpw.equals(dto.getPw())) {
			result.reject("nocode","비밀번호 틀림");
			return "login/loginForm";
		}else if(dbpw.equals(dto.getPw())) {
			m.addAttribute("user", dto);
		}
		/*//members테이블의 userid와 password가 입력한 값과 폼에 입력한 값과 일치할때 로그인 성공
		//매퍼 dao service까지 만들어줘야 함. 
		if(dto.getId().equals(dto.getId())) { //나중에 db연동할 부분임
			//로그인 성공 => 세션에 저장
			m.addAttribute("user", dto);//m(모델)에 "user"라는 이름으로 저장. 
		}else {
			result.reject("nocode","fail to login");//에러 코드 추가
			return "login/loginForm";
		}*/
		return "login/login"; //뷰네임. 
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete(); //세션안에 저장되어있는 것 제거 
		return "redirect:/";
	}
	
	// @ModelAttribute("user") : session에 user라는 이름으로 저장된 데이터 가져옴
	@GetMapping("/checklogin")
	public String check(@ModelAttribute("user") LoginDto dto) {
		if(dto.getId() != null) {
			return "login/logincheck";
		}else {
			return "redirect:/loginForm"; 
		}
	}
	
}