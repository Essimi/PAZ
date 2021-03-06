package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * ValueObject(DataTransferObject, Model, Bean) JavaBean 규약
 *
 * 1. 값을 가질 수 있는 property 정의 2. property encpsulation 3. 캡슐화된 property에 접근할 수 있는
 * 인터페이스 제공 (getter/setter) 4. property 의 상태를 비교할 수 있는 방법 제공 5. 정렬의 기준을 제공 6.
 * property의 상태 확인 방법 제공 7. Serializable 선언
 */
public class DashBoardVO implements Comparable<DashBoardVO>, Serializable {

	public DashBoardVO() {
		super();
	}

	private String rnum;

	private String pCode;

	private String memId;

	private Integer myWork;

	private String workCode;

	private String workName;

	private String workStatus;

	private String progressName;

	private Integer myWorkDone;

	private Integer totalWorkCount;

	private Integer weekWorkCount;

	private Integer issueDate;

	private Integer issueCount;

	private List<DashBoardVO> dashList;

	private String importanceName;

	private Integer importanceCount;

	private String workStatusName;

	private Integer workStatusCount;
	
//	프로젝트 메인페이지 관련 Code 입니다.
	
	private String workCount;
	
	private String process;
	
	private String done;
	
	private String memNickName;
	
	private String position;
	
	private String saveName;
	
	private String memMail;
	
	private String memTel;
	
	private String memBirth;

	@Override
	public int compareTo(DashBoardVO dashBoardVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
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

	public Integer getMyWork() {
		return myWork;
	}

	public void setMyWork(Integer myWork) {
		this.myWork = myWork;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getProgressName() {
		return progressName;
	}

	public void setProgressName(String progressName) {
		this.progressName = progressName;
	}

	public Integer getMyWorkDone() {
		return myWorkDone;
	}

	public void setMyWorkDone(Integer myWorkDone) {
		this.myWorkDone = myWorkDone;
	}

	public Integer getTotalWorkCount() {
		return totalWorkCount;
	}

	public void setTotalWorkCount(Integer totalWorkCount) {
		this.totalWorkCount = totalWorkCount;
	}

	public Integer getWeekWorkCount() {
		return weekWorkCount;
	}

	public void setWeekWorkCount(Integer weekWorkCount) {
		this.weekWorkCount = weekWorkCount;
	}

	public Integer getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Integer issueDate) {
		this.issueDate = issueDate;
	}

	public Integer getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(Integer issueCount) {
		this.issueCount = issueCount;
	}

	public List<DashBoardVO> getDashList() {
		return dashList;
	}

	public void setDashList(List<DashBoardVO> dashList) {
		this.dashList = dashList;
	}

	public String getImportanceName() {
		return importanceName;
	}

	public void setImportanceName(String importanceName) {
		this.importanceName = importanceName;
	}

	public Integer getImportanceCount() {
		return importanceCount;
	}

	public void setImportanceCount(Integer importanceCount) {
		this.importanceCount = importanceCount;
	}

	public String getWorkStatusName() {
		return workStatusName;
	}

	public void setWorkStatusName(String workStatusName) {
		this.workStatusName = workStatusName;
	}

	public Integer getWorkStatusCount() {
		return workStatusCount;
	}

	public void setWorkStatusCount(Integer workStatusCount) {
		this.workStatusCount = workStatusCount;
	}

	public String getWorkCount() {
		return workCount;
	}

	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public String getMemNickName() {
		return memNickName;
	}

	public void setMemNickName(String memNickName) {
		this.memNickName = memNickName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
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
		DashBoardVO other = (DashBoardVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DashBoardVO [rnum=" + rnum + ", pCode=" + pCode + ", memId=" + memId + ", myWork=" + myWork
				+ ", workCode=" + workCode + ", workName=" + workName + ", workStatus=" + workStatus + ", progressName="
				+ progressName + ", myWorkDone=" + myWorkDone + ", totalWorkCount=" + totalWorkCount
				+ ", weekWorkCount=" + weekWorkCount + ", issueDate=" + issueDate + ", issueCount=" + issueCount
				+ ", dashList=" + dashList + ", importanceName=" + importanceName + ", importanceCount="
				+ importanceCount + ", workStatusName=" + workStatusName + ", workStatusCount=" + workStatusCount
				+ ", workCount=" + workCount + ", process=" + process + ", done=" + done + ", memNickName="
				+ memNickName + ", position=" + position + ", saveName=" + saveName + ", memMail=" + memMail
				+ ", memTel=" + memTel + ", memBirth=" + memBirth + "]";
	}
}
