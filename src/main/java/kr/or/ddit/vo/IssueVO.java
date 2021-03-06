package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.UpdateGroup;

public class IssueVO {
	
	@NotBlank(groups=UpdateGroup.class)
	private String issueCode;
	@NotBlank
	private String pCode;
	@NotBlank
	private String memId;
	@NotBlank(message="※관련업무는 반드시 선택해야합니다.")
	private String workCode;
	@NotBlank(message="※이슈유형은 반드시 선택해야합니다.")
	private String issueTypeCode;
	@NotBlank(message="※이슈제목은 반드시 입력해야합니다.")
	private String issueName;
	private String issueContents;
	@NotBlank(message="※이슈중요도는 반드시 선택해야합니다.")
	private String importance;
	private String issueDate; // 메인페이지 사용
	
	private List<IssueVO> issueList;
	
	//작성자 
	private String memNickname;
	private String saveName;
	private String workName;
	private String position; // 메인페이지 사용
	
	//수신자
	private List<IssueRecipientVO> issueRecipients;
	
	
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public List<IssueRecipientVO> getIssueRecipients() {
		return issueRecipients;
	}
	public void setIssueRecipients(List<IssueRecipientVO> issueRecipients) {
		this.issueRecipients = issueRecipients;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getIssueCode() {
		return issueCode;
	}
	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
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
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	public String getIssueTypeCode() {
		return issueTypeCode;
	}
	public void setIssueTypeCode(String issueTypeCode) {
		this.issueTypeCode = issueTypeCode;
	}
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	public String getIssueContents() {
		return issueContents;
	}
	public void setIssueContents(String issueContents) {
		this.issueContents = issueContents;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<IssueVO> getIssueList() {
		return issueList;
	}
	public void setIssueList(List<IssueVO> issueList) {
		this.issueList = issueList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueCode == null) ? 0 : issueCode.hashCode());
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
		IssueVO other = (IssueVO) obj;
		if (issueCode == null) {
			if (other.issueCode != null)
				return false;
		} else if (!issueCode.equals(other.issueCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IssueVO [issueCode=" + issueCode + ", pCode=" + pCode + ", memId=" + memId + ", workCode=" + workCode
				+ ", issueTypeCode=" + issueTypeCode + ", issueName=" + issueName + ", issueContents=" + issueContents
				+ ", importance=" + importance + ", issueDate=" + issueDate + ", issueRecipients=" + issueRecipients
				+ ", issueList=" + issueList + ", memNickname=" + memNickname + ", saveName=" + saveName + ", workName="
				+ workName + ", position=" + position + "]";
	}
}
