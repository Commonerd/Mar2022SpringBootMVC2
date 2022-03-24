package myapp.test.controller;

import java.io.*;


import javax.servlet.http.HttpServletResponse;
  
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DownloadController {
	
	@GetMapping("/download")
	public void fileDownload(HttpServletResponse response) throws IOException {
		
		File file = new File("c:\\upload\\1647936152665_.png");
		
		String fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		
		response.setContentType("application/octet-stream; charset=utf-8"); //어플리통해 파일이 다운롣된다는 의미.
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");//다운로드 받을 파일명 지정. 현재는 원본이름으로 됨.

		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();

		FileInputStream fis = new FileInputStream(file);{
			FileCopyUtils.copy(fis, out);
		}
		out.flush();
	}
	
		/*try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		out.flush();
	}*/
	
}
