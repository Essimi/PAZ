package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.InsertGroup;
import lombok.NonNull;

public class NoticeVO {
	
	private String partCode;
	private String memId;
	private String noticeCode;
	
	@NotBlank
	private String noticeTitle;
	@NotBlank
	private String noticeContents;
	
	private String noticeDate;
	private int rnum;
	
	private MultipartFile noticeFile;
	
	private AttatchVO attatch;
	
	public MultipartFile getNoticeFile() {
		return noticeFile;
	}
	
	public void setNoticeFile(MultipartFile noticeFile) {
		
		if(noticeFile==null || noticeFile.isEmpty()) return;
		
		this.noticeFile = noticeFile;
		this.attatch = new AttatchVO(noticeFile);
		
	}

	public AttatchVO getAttatch() {
		return attatch;
	}

	public void setAttatch(AttatchVO attatch) {
		this.attatch = attatch;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noticeCode == null) ? 0 : noticeCode.hashCode());
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
		NoticeVO other = (NoticeVO) obj;
		if (noticeCode == null) {
			if (other.noticeCode != null)
				return false;
		} else if (!noticeCode.equals(other.noticeCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NoticeVO [partCode=" + partCode + ", memId=" + memId + ", noticeCode=" + noticeCode + ", noticeTitle="
				+ noticeTitle + ", noticeContents=" + noticeContents + ", noticeDate=" + noticeDate + ", rnum=" + rnum
				+ ", noticeFile=" + noticeFile + ", attatch=" + attatch + "]";
	}
	
}
