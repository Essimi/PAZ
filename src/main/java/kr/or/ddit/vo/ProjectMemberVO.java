package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ProjectMemberVO {

	@NotNull
	private String memId;
	
	@NotNull
	private String pCode;
	
	private Integer workTime;
	
	private String memNickname;
	
	
	
	
	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

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

	public Integer getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memId == null) ? 0 : memId.hashCode());
		result = prime * result + ((pCode == null) ? 0 : pCode.hashCode());
		result = prime * result + ((workTime == null) ? 0 : workTime.hashCode());
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
		ProjectMemberVO other = (ProjectMemberVO) obj;
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
		if (workTime == null) {
			if (other.workTime != null)
				return false;
		} else if (!workTime.equals(other.workTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectMemberVO [memId=" + memId + ", pCode=" + pCode + ", workTime=" + workTime + ", memberSelectList="
			 + "]";
	}
	

}
