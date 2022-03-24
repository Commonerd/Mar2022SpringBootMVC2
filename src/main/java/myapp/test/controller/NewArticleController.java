package myapp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import myapp.test.service.ArticleService;
import myapp.test.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle")
public class NewArticleController {

	@Autowired
	private ArticleService articleService;

	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "article/newArticleForm";
	}

	@PostMapping
	public String submit(NewArticleCommand command) {
		articleService.writeArticle(command);
		return "article/newArticleSubmit";
	}//뉴아티클 커맨드 객체를 만들고, 주소값 전달받고, 그 안에는 타이틀 컨텐트 패런츠 세 개 변수. 이 객체 만들고 객체 주소값 넘겨준다.(뉴아티클커맨드)
	//NewArticle.Coomand는 디스패처 서블릿이 해당객체 만들어서 저장 -> 리퀘스트 매핑 어노테이션 3번 모델ㅇ데이터로 추가. 모델데이터에 저장되는 순간 모델데이터는 어떻게 생김? 이름, 값, 

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
