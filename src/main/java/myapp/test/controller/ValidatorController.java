package myapp.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.test.validator.ContentValidator;
import myapp.test.vo.ContentDto;

@Controller     
public class ValidatorController {

	@RequestMapping("/valid/insertForm")
	public String insert1() {
		return "validator/createPage";
	}
       
	@RequestMapping("/valid/create")
	public String insert2(@ModelAttribute("dto") @Validated ContentDto contentDto, BindingResult result) {
												//벨리데이티드 어노테이션은 검사대상 앞에 부인다. 하고 반드시 뒤에, 
		//에러 발생시 에러 메시지 저장할 수 있는 공간인 객체 바인딩리절트 타입 변수 또는 에러즈 타입 변수 시켜야한다.
		String page = "validator/createDonePage"; //성공시 갈 곳
		System.out.println(contentDto);

		if (result.hasErrors()) {//검사를 통과하지 못한 경우

			if (result.getFieldError("writer") != null) {
				System.out.println("1:" + result.getFieldError("writer").getDefaultMessage());
			}
			if (result.getFieldError("content") != null) {
				System.out.println("2:" + result.getFieldError("content").getDefaultMessage());
			}

			page = "validator/createPage";
		}

		return page;
	}

//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		System.out.println("initBinder동작");
//		binder.setValidator(new ContentValidator());
//	}

}