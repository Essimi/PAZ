package kr.or.ddit.vo;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class MemberIkonVO {
	
	private String imgCode;
	private String memId;
	private String realName;
	private String saveName;
	private String imgMime;
	private Long imgSize;
	
	public MemberIkonVO() {
		super();
	}

	public MemberIkonVO(MultipartFile file, String memId) {
		this.realName = file.getOriginalFilename();
		int idx = file.getContentType().indexOf("/");
		this.imgMime = file.getContentType().substring(idx+1);
		this.imgSize = file.getSize();
		this.saveName = UUID.randomUUID().toString() + "." + this.imgMime;
		this.memId = memId;
	}
	
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
	public String getImgMime() {
		return imgMime;
	}
	public void setImgMime(String imgMime) {
		this.imgMime = imgMime;
	}
	public Long getImgSize() {
		return imgSize;
	}
	public void setImgSize(Long imgSize) {
		this.imgSize = imgSize;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imgCode == null) ? 0 : imgCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberIkonVO other = (MemberIkonVO) obj;
		if (imgCode == null) {
			if (other.imgCode != null)
				return false;
		} else if (!imgCode.equals(other.imgCode))
			return false;
		return true;
	}
	
	
}
