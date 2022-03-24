package myapp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import myapp.test.scott.dto.Dept;
import myapp.test.scott.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService dservice;
	
	@GetMapping("/deptAll")
	public String deptAll(Model m) {
		 List<Dept> dlist = dservice.deptAll();
		 m.addAttribute("deptAll",dlist);
		
		return "dept/deptAll";
	}
	
	@GetMapping("/dept")
	public String deptForm(Model m) {
		List<Dept> dlist = dservice.deptAll();
		m.addAttribute("deptAll",dlist);
		return "dept/deptOne";
	}
	
	@RequestMapping("/dept/{no}")
	@ResponseBody
	public String deptOne(@PathVariable int no) {
		Dept d = dservice.deptOne(no);
		
		Gson gson = new Gson();
		String d_text = gson.toJson(d);
		System.out.println(d_text);
		return d_text;
	}
	@GetMapping("/insert")
	public String insertDept(Model m) {
		int no = dservice.maxNo()+10;
		m.addAttribute("no",no);
		return "dept/insertForm"; 
	}
	@PostMapping("/insert")
	public String insert(Dept dept) {
		int i = dservice.addDept(dept);
		if(i != 0) {
			System.out.println(dept.getDeptno()+"부서 추가");
		}else {
			System.out.println(dept.getDeptno()+"부서 추가 못함");
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") int deptno) {
		//컨트롤러에서 리턴타입 모르겠으면 그냥 스트링으로 걸어라.
		System.out.print("delete수행");
		dservice.deleteDept(deptno);
		return "redirect:/deptAll";
	}
	
	@GetMapping("/update/{no}")
	public String updateForm(@PathVariable("no") int deptno, Model m) {
	//뷰에게 보낼 게 있으면 모델타입 변수도 선언시켜준다.
		Dept dept = dservice.deptOne(deptno);
		m.addAttribute("dept",dept); //해당데이터블 모델데이터에 추가한다.
		return "dept/updateForm"; //jsp는 해당 데이터 꺼내옴.
}
	@PostMapping("/update")
	public String update(Dept dept) { //3개 변수 한번에 받는 dept객체
		dservice.updateDept(dept);
		return "redirect:/";
}
}