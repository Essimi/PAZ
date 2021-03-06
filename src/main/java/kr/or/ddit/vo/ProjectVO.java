package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectVO {

	// 프로젝트 코드

	@NotNull
	private String pCode;

	@NotBlank
	private String pTitle;

	private String pContent;

	// 프로젝트 생성날짜
	@NotBlank
	private String pCreateDate;

	// 프로젝트 시작날짜
	@NotBlank
	private String pStartDate;

	// 프로젝트 마감날짜
	@NotBlank
	
	private String pEndDate;

	// 분류코드
	private String pPartCode;
	
	private String partName;

	// 상태코드
	private String statusCode;

	private String statusName;

	private String monthTerm;

	private String dayTerm;

	private List<MemberVO> projectMember;

	private String position;

	// 역할 코드 RoleCode
	private String roleCode;

	// memId
	private String memId;

	private String memMail;

	private String workTime;

	private String memNickname;
	
	private String outStatus;
	
	private String reqCode;
	

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCreateDate() {
		return pCreateDate;
	}

	public void setpCreateDate(String pCreateDate) {
		this.pCreateDate = pCreateDate;
	}

	public String getpStartDate() {
		return pStartDate;
	}

	public void setpStartDate(String pStartDate) {
		this.pStartDate = pStartDate;
	}

	public String getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(String pEndDate) {
		this.pEndDate = pEndDate;
	}

	public String getpPartCode() {
		return pPartCode;
	}

	public void setpPartCode(String pPartCode) {
		this.pPartCode = pPartCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMonthTerm() {
		return monthTerm;
	}

	public void setMonthTerm(String monthTerm) {
		this.monthTerm = monthTerm;
	}

	public String getDayTerm() {
		return dayTerm;
	}

	public void setDayTerm(String dayTerm) {
		this.dayTerm = dayTerm;
	}

	public List<MemberVO> getProjectMember() {
		return projectMember;
	}

	public void setProjectMember(List<MemberVO> projectMember) {
		this.projectMember = projectMember;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	
	public String getOutStatus() {
		return outStatus;
	}
	
	
	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}
	
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}

	
	public String getReqCode() {
		return reqCode;
	}
	
	public void setReqCode(String reqCode) {
		this.reqCode = reqCode;
	}

	@Override
	public String toString() {
		return "ProjectVO [pCode=" + pCode + ", pTitle=" + pTitle + ", pContent=" + pContent + ", pCreateDate="
				+ pCreateDate + ", pStartDate=" + pStartDate + ", pEndDate=" + pEndDate + ", pPartCode=" + pPartCode
				+ ", partName=" + partName + ", statusCode=" + statusCode + ", statusName=" + statusName
				+ ", monthTerm=" + monthTerm + ", dayTerm=" + dayTerm + ", projectMember=" + projectMember
				+ ", position=" + position + ", roleCode=" + roleCode + ", memId=" + memId + ", memMail=" + memMail
				+ ", workTime=" + workTime + ", memNickname=" + memNickname + ", outStatus=" + outStatus + ", reqCode="
				+ reqCode + "]";
	}
	

	
	
	

}
