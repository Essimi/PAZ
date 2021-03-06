package kr.or.ddit.vo;

public class PMemVO {
	
	private String memId;
	private String pCode;
	private String workTime;
	private String position;
	private String outStatus;
	
	private MemberVO memberInfo;

	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public MemberVO getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberVO memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	public String getOutStatus() {
		return outStatus;
	}
	
	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}
	

	
	
	
	@Override
	public String toString() {
		return "PMemVO [memId=" + memId + ", pCode=" + pCode + ", workTime=" + workTime + ", position=" + position
				+ ", outStatus=" + outStatus + ", memberInfo=" + memberInfo + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((pCode == null) ? 0 : pCode.hashCode());
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
		PMemVO other = (PMemVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		if (pCode == null) {
			if (other.pCode != null)
				return false;
		} else if (!pCode.equals(other.pCode))
			return false;
		return true;
	}
	
	

}
