package kr.or.ddit.vo;

public class ReviewVO {
	
	private String reviewCode;
	private String memId;
	private Integer codeGrade;
	private Integer workGrade;
	private Integer ganttchartGrade;
	private Integer kanbanGrade;
	private Integer chatGrade;
	private String feedback;
	private String gitGrade;
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Integer getCodeGrade() {
		return codeGrade;
	}
	public void setCodeGrade(Integer codeGrade) {
		this.codeGrade = codeGrade;
	}
	public Integer getWorkGrade() {
		return workGrade;
	}
	public void setWorkGrade(Integer workGrade) {
		this.workGrade = workGrade;
	}
	public Integer getGanttchartGrade() {
		return ganttchartGrade;
	}
	public void setGanttchartGrade(Integer ganttchartGrade) {
		this.ganttchartGrade = ganttchartGrade;
	}
	public Integer getKanbanGrade() {
		return kanbanGrade;
	}
	public void setKanbanGrade(Integer kanbanGrade) {
		this.kanbanGrade = kanbanGrade;
	}
	public Integer getChatGrade() {
		return chatGrade;
	}
	public void setChatGrade(Integer chatGrade) {
		this.chatGrade = chatGrade;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getGitGrade() {
		return gitGrade;
	}
	public void setGitGrade(String gitGrade) {
		this.gitGrade = gitGrade;
	}
	
	
	@Override
	public String toString() {
		return "ReviewVO [reviewCode=" + reviewCode + ", memId=" + memId + ", codeGrade=" + codeGrade + ", workGrade="
				+ workGrade + ", ganttchartGrade=" + ganttchartGrade + ", kanbanGrade=" + kanbanGrade + ", chatGrade="
				+ chatGrade + ", feedback=" + feedback + ", gitGrade=" + gitGrade + "]";
	}
	
	
	
	

}
