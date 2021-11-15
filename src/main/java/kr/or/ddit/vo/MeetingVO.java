package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.UpdateGroup;

//@Data
//@EqualsAndHashCode(of="meetingCode")
//@ToString

public class MeetingVO implements Serializable {
	
	@NotNull(groups=UpdateGroup.class)
	private String meetingCode;
	@NotNull(groups=UpdateGroup.class)
	private String pCode;
//	@NotBlank
	private String memId;
	@NotBlank
	private String meetingTopic;
	@NotBlank
	private String meetingContent;
	@NotBlank
	private String meetingResult;
//	@NotBlank
	private String meetingDate;

	private List<MemberVO> memberList;
	
	
	
	private MultipartFile[] meeFiles;
	public void setBoFiles(MultipartFile[] meeFiles) {
		if(meeFiles ==null) return;
		this.meeFiles = meeFiles;
		this.attatch = attatch;
		for(MultipartFile tmp : meeFiles){
			if(tmp.isEmpty())continue;
			attatch = new AttatchVO(tmp);
		}
		
		
	}
	 
	
	private AttatchVO attatch;
	
	private String startAttCode;
	
	private String dellAttCode;
	
	private int repCnt;
	public String getMeetingCode() {
		return meetingCode;
	}

	public void setMeetingCode(String meetingCode) {
		this.meetingCode = meetingCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMeetingTopic() {
		return meetingTopic;
	}

	public void setMeetingTopic(String meetingTopic) {
		this.meetingTopic = meetingTopic;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	public String getMeetingResult() {
		return meetingResult;
	}

	public void setMeetingResult(String meetingResult) {
		this.meetingResult = meetingResult;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}


	public MultipartFile[] getMeeFiles() {
		return meeFiles;
	}

	public void setMeeFiles(MultipartFile[] meeFiles) {
		this.meeFiles = meeFiles;
	}

	public AttatchVO getAttatch() {
		return attatch;
	}

	public void setAttatch(AttatchVO attatch) {
		this.attatch = attatch;
	}

	public String getStartAttCode() {
		return startAttCode;
	}

	public void setStartAttCode(String startAttCode) {
		this.startAttCode = startAttCode;
	}

	public String getDellAttCode() {
		return dellAttCode;
	}

	public void setDellAttCode(String dellAttCode) {
		this.dellAttCode = dellAttCode;
	}

	public int getRepCnt() {
		return repCnt;
	}

	public void setRepCnt(int repCnt) {
		this.repCnt = repCnt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meetingCode == null) ? 0 : meetingCode.hashCode());
		return result;
	}
	
	public List<MemberVO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberVO> memberList) {
		this.memberList = memberList;
	}

	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingVO other = (MeetingVO) obj;
		if (meetingCode == null) {
			if (other.meetingCode != null)
				return false;
		} else if (!meetingCode.equals(other.meetingCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeetingVO [meetingCode=" + meetingCode + ", pCode=" + pCode + ", memId=" + memId + ", meetingTopic="
				+ meetingTopic + ", meetingContent=" + meetingContent + ", meetingResult=" + meetingResult
				+ ", meetingDate=" + meetingDate + ", mem_list=" + memberList + ", meeFiles=" + Arrays.toString(meeFiles)
				+ ", startAttCode=" + startAttCode + ", dellAttCode=" + dellAttCode + ", repCnt=" + repCnt + "]";
	}
	
	
	
	
	
}
