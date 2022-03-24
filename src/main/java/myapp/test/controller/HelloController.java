package myapp.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController { 

		@GetMapping("/hello") 
		//컨트롤러일 떄 실행. 매핑정보 지정. 겟방식 실행, 포스트면 포스트로 요청시 실행. 
		//서버스타트하며 컨트롤러 > 매핑하며 대기 
		public String hello(Model m) {
			m.addAttribute("hello","hello,spring!!");
			return "hello"; //이 문자열이 view정보가 된다. 
		}
}
