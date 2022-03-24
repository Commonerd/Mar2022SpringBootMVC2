package myapp.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import myapp.test.vo.ReportCommand;

@Controller
public class ReportSubmissionController {

	@RequestMapping("/report/submission")
	public String form() {
		return "report/submissionForm";
	}

	//C:/upload폴더로 업로드
	private String upload(MultipartFile tempfile) {
		//중복이 안되려면? 밀리세컨드를 쓴다.
		long currentTime = System.currentTimeMillis(); 
		Random random = new Random(); 
		int r = random.nextInt(50); //0~49
		
		String oName = tempfile.getOriginalFilename();
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index+1);
		
		String fileName = currentTime+"_"+"."+ext;
		
		File newFile = new File("c:/upload/"+fileName);
		
		try {
			tempfile.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newFile.getPath();
	}
	
	@RequestMapping(value = "/report/submitReport1", method = RequestMethod.POST)
	public String submitReport1(String studentNumber, MultipartFile report) {
		printInfo(studentNumber, report);
		System.out.println(upload(report));
		return "report/submissionComplete";
	}

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());

	}

	@RequestMapping(value = "/report/submitReport2", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request, Model m) {
		String studentNumber = request.getParameter("studentNumber");//이름맞춰서 꺼내오기
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String path = request.getServletContext().getRealPath("/mainimg");
		try {
			report.transferTo(new File(path + "/" + report.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("path", report.getOriginalFilename());
		return "report/submissionComplete";
		
	
	}


	@RequestMapping(value = "/report/submitReport3", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand, HttpServletRequest request) {
		
			printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		
		return "report/submissionComplete";
	}
}