package kr.or.ddit.news.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;



@Controller
public class UploadSummernoteImageFile {
	
	@PostMapping(value="/news/uploadSummernoteImageFile.do", produces = "application/json")
	@ResponseBody
	public Map<String, String> uploadSummernoteImageFile(
			@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject jsonObject = new JsonObject();
		Map<String, String> jsonMap = new HashMap<String, String>();
		
		String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonMap.put("url", "/PAZ/news/summernoteImage.do?filename="+savedFileName);
			jsonMap.put("responseCode", "success");
//			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
//			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonMap.put("responseCode", "error");
//			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/news/summernoteImage.do")
	public void imageView(
			@RequestParam("filename") String filename,
			HttpServletResponse resp) throws IOException {
		
		System.out.println("-------------------------------------------"+filename);
		String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로s
		FileInputStream fis = new FileInputStream(fileRoot + filename);
		// 한번에 불러올 수 있는 byte크기를 지정
		byte[] buffer = new byte[1024];
		
		// count : 읽어들여온 데이터의 포인터
		int count = -1;
		OutputStream os = resp.getOutputStream();
		while((count = fis.read(buffer)) != -1){
			// 읽어온 데이터는 buffer에 있고 이미 보낸데이터와 
			// 중복되지 않게 0~count 포인터까지 읽게 위치를 지정해준다. 
			os.write(buffer, 0, count);
		}
		os.close();
		fis.close();
		
		
	}
}
