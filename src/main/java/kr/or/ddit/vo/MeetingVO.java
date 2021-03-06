package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;

//@Data
//@EqualsAndHashCode(of="meetingCode")
//@ToString

public class MeetingVO implements Serializable {
//	@NotNull(groups=UpdateGroup.class) 업데이트만 검사한다.
	private String meetingCode;
	@NotNull
	private String pCode;
//	@NotBlank
	private String write;
	@NotBlank(message="※주제를 입력해주세요" ,groups= {InsertGroup.class})
	private String meetingTopic;
	@NotBlank(message="※내용을 입력해주세요" ,groups= {InsertGroup.class})
	private String meetingContent;
	@NotBlank(message="※결론을 입력해주세요" ,groups= {InsertGroup.class})
	private String meetingResult;
//	@NotBlank
	private String meetingDate;

	//글쓴이 닉네임
	private String memNickname;
	//상세조회 글쓴이 닉네임
	private String memNicknameTo;

	
	//미가공 참여차 리스트 
	private String memId;

	//가공 참여자 리스트
	private List<MemberVO> memberList;
	
	
	
	private MultipartFile meetingFile;
	
	private AttatchVO attatch;
	
	
	
	public String getMemNicknameTo() {
		return memNicknameTo;
	}

	public void setMemNicknameTo(String memNicknameTo) {
		this.memNicknameTo = memNicknameTo;
	}


	
	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public MultipartFile getMeetigFile() {
		return meetingFile;
	}
	 
	public void setMeetingFile(MultipartFile meetingFile) {
		
		if(meetingFile == null || meetingFile.isEmpty()) return;
		
		this.meetingFile =meetingFile;
		this.attatch = new AttatchVO(meetingFile);
	}
	
	
	
	public MultipartFile getMeetingFile() {
		return meetingFile;
	}



	private int repCnt;
	public String getMeetingCode() {
		return meetingCode;
	}
	
	
	
	
	
	
	
	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
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


	public AttatchVO getAttatch() {
		return attatch;
	}

	public void setAttatch(AttatchVO attatch) {
		this.attatch = attatch;
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
				+ ", meetingDate=" + meetingDate + ", memberList=" + memberList + ", meetingFile=" + meetingFile
				+ ", attatch=" + attatch + ", repCnt=" + repCnt + "]";
	}


	
	
	
}
