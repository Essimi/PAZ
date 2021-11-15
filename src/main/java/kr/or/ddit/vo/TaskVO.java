package kr.or.ddit.vo;

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

	// WORL PROGRESS TABLE (진척도)
	private Integer progressName;
	
	//  WORK STATUS TABLE (업무 현황 )
	private String workStatusName;

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

	public String getWorkStatusName() {
		return workStatusName;
	}

	public void setWorkStatusName(String workStatusName) {
		this.workStatusName = workStatusName;
	}

	@Override
	public String toString() {
		return "TaskVO [workCode=" + workCode + ", pCode=" + pCode + ", memId=" + memId + ", topWorkCode=" + topWorkCode
				+ ", workName=" + workName + ", workContents=" + workContents + ", workStart=" + workStart
				+ ", workDeadline=" + workDeadline + ", progress=" + progress + ", importance=" + importance
				+ ", progressName=" + progressName + ", workStatusName=" + workStatusName + "]";
	}
	
	

}
