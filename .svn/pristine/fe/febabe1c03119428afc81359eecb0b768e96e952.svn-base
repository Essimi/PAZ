package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.InsertGroup;

public class MemberVO {
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	
	@NotBlank(groups=InsertGroup.class)
	private String memId;
	@NotBlank(groups=InsertGroup.class)
	private String memPass;
	@NotBlank(groups=InsertGroup.class)
	private String memNickname;
	private String memMail;
	private Integer memTel;
	private String memBirth;
	@NotBlank(groups=InsertGroup.class)
	private String memGender;
	@NotBlank(groups=InsertGroup.class)
	private String memCompany;
	private String joinDate;
	private String outDate;
	private String surveyStatus;
	private String outCode;
	
	// 한 회원이 가진 역할들
	List<String> memRoles;
	
	public List<String> getMemRoles() {
		return memRoles;
	}
	public void setMemRoles(List<String> memRoles) {
		this.memRoles = memRoles;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public Integer getMemTel() {
		return memTel;
	}
	public void setMemTel(Integer memTel) {
		this.memTel = memTel;
	}
	public String getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemCompany() {
		return memCompany;
	}
	public void setMemCompany(String memCompany) {
		this.memCompany = memCompany;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getSurveyStatus() {
		return surveyStatus;
	}
	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}
	public String getOutCode() {
		return outCode;
	}
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memNickname=" + memNickname + ", memMail="
				+ memMail + ", memTel=" + memTel + ", memBirth=" + memBirth + ", memGender=" + memGender
				+ ", memCompany=" + memCompany + ", joinDate=" + joinDate + ", outDate=" + outDate + ", surveyStatus="
				+ surveyStatus + ", outCode=" + outCode + "]";
	}
	
	
}
