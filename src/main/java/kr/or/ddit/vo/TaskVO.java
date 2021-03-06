package kr.or.ddit.vo;

import java.util.List;

public class TaskVO {
	
	// WORK TABLE
	private String workCode;
	private String pCode;
	private String memId;
	private String topWorkCode;
	private String workName;
	private String workContents;
	private String workStart;
	private String workDeadline;
	private String progress;
	private String importance;
	private String workDelete;

	// WORL PROGRESS TABLE (진척도)
	private Integer progressName;
	
	//  WORK STATUS TABLE (업무 현황 )
	private String workStatus;
	
	// 멤버 이름
	private String memNickname;
	
	// 상위 업무 이름
	private String topWorkName;
	
	//업무 현황 이름
	private String workStatusName;
	
	//탈퇴 회원 코드 
	private String outStatus;

	public String getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}

	public String getWorkStatusName() {
		return workStatusName;
	}

	public void setWorkStatusName(String workStatusName) {
		this.workStatusName = workStatusName;
	}
	
	// 수정 내역 리스트
	private List<ModifyHistoryVO> modifyHistoryList;
	
	// 수정한 사람
	private String modifierId;
	

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
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

	public String getTopWorkCode() {
		return topWorkCode;
	}

	public void setTopWorkCode(String topWorkCode) {
		this.topWorkCode = topWorkCode;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkContents() {
		return workContents;
	}

	public void setWorkContents(String workContents) {
		this.workContents = workContents;
	}

	public String getWorkStart() {
		return workStart;
	}

	public void setWorkStart(String workStart) {
		this.workStart = workStart;
	}

	public String getWorkDeadline() {
		return workDeadline;
	}

	public void setWorkDeadline(String workDeadline) {
		this.workDeadline = workDeadline;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public Integer getProgressName() {
		return progressName;
	}

	public void setProgressName(Integer progressName) {
		this.progressName = progressName;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatusName) {
		this.workStatus = workStatusName;
	}
	
	public String getMemNickname() {
		return memNickname;
	}
	
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getTopWorkName() {
		return topWorkName;
	}
	
	public void setTopWorkName(String topWorkName) {
		this.topWorkName = topWorkName;
	}
	
	public List<ModifyHistoryVO> getModifyHistoryList() {
		return modifyHistoryList;
	}
	
	public void setModifyHistoryList(List<ModifyHistoryVO> modifyHistoryList) {
		this.modifyHistoryList = modifyHistoryList;
	}
	
	
	public String getModifierId() {
		return modifierId;
	}
	
	
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	
	
	public String getWorkDelete() {
		return workDelete;
	}
	
	public void setWorkDelete(String workDelete) {
		this.workDelete = workDelete;
	}
	
	


	
	
	@Override
	public String toString() {
		return "TaskVO [workCode=" + workCode + ", pCode=" + pCode + ", memId=" + memId + ", topWorkCode=" + topWorkCode
				+ ", workName=" + workName + ", workContents=" + workContents + ", workStart=" + workStart
				+ ", workDeadline=" + workDeadline + ", progress=" + progress + ", importance=" + importance
				+ ", workDelete=" + workDelete + ", progressName=" + progressName + ", workStatus=" + workStatus
				+ ", memNickname=" + memNickname + ", topWorkName=" + topWorkName + ", workStatusName=" + workStatusName
				+ ", modifyHistoryList=" + modifyHistoryList + ", modifierId=" + modifierId + "]";
	}

	
	// 해시 코드
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((workCode == null) ? 0 : workCode.hashCode());
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
		TaskVO other = (TaskVO) obj;
		if (workCode == null) {
			if (other.workCode != null)
				return false;
		} else if (!workCode.equals(other.workCode))
			return false;
		return true;
	}
	
	
	
	
	

}
