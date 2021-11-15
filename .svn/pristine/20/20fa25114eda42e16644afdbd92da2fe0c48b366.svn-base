package kr.or.ddit.vo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class AttatchVO {
	
	private MultipartFile file;
	
	public AttatchVO(MultipartFile file) {
		super();
		this.file = file;
		this.realName = file.getOriginalFilename();
		this.saveName = UUID.randomUUID().toString();
		this.fileMime = file.getContentType();
		this.fileSize = file.getSize();
	}
	
	public void saveTo(File saveFolder) throws IOException{
		if(file != null) {
			file.transferTo(new File(saveFolder,saveName));
		}
	}
	
	//Attach
	private String fileCode;
	private String realName;
	private String saveName;
	private String fileMime;
	private Long fileSize;
	
	//Attach_Relation (테이블 삭제 및 통합)
	private String pCode;
	private String postCode;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getFileMime() {
		return fileMime;
	}

	public void setFileMime(String fileMime) {
		this.fileMime = fileMime;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getPCode() {
		return pCode;
	}

	public void setPCode(String pCode) {
		this.pCode = pCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public AttatchVO() {
		
	}
	
}
