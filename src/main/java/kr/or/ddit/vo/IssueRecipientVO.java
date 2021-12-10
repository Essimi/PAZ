package kr.or.ddit.vo;

public class IssueRecipientVO {
	private String memId;
	private String issueCode;
	private String saveName;
	private String memNickname;
	private String position;
	
	// 프로젝트 탈퇴여부
	private String outStatus;
	
	public String getOutStatus() {
		return outStatus;
	}
	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getIssueCode() {
		return issueCode;
	}
	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issueCode == null) ? 0 : issueCode.hashCode());
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
		IssueRecipientVO other = (IssueRecipientVO) obj;
		if (issueCode == null) {
			if (other.issueCode != null)
				return false;
		} else if (!issueCode.equals(other.issueCode))
			return false;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}
	
	
}
