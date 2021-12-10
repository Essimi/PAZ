package kr.or.ddit.common.noticeAdmin.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.vo.AttatchVO;

public class DownloadView extends AbstractView {
	
	
	@Value("#{appInfo.attatchPath}")
	private String saveFolderPath;
	@Value("#{appInfo.attatchPath}")
	private File saveFolder;

	
	@Override
	protected void renderMergedOutputModel(
			
			Map<String, Object> model
			,HttpServletRequest request
			,HttpServletResponse resp) throws Exception {
		
		AttatchVO attatch =  (AttatchVO) model.get("attatch");
		
		File saveFile = new File(saveFolder, attatch.getSaveName());
		
		if(!saveFile.exists()) {
			throw new FileNotFoundException("저장위치에 파일이 존재하지 않습니다.");
		}
		
		String filename = URLEncoder.encode(attatch.getRealName(), "UTF-8").replaceAll("\\+", " ");
		resp.setHeader("Content-Length", attatch.getFileSize().toString());
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");
		try(
			OutputStream os = resp.getOutputStream();
		){
			FileUtils.copyFile(saveFile, os);
		}
		
	}

}
