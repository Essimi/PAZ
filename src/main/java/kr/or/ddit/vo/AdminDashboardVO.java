package kr.or.ddit.vo;



public class AdminDashboardVO {
	//결제 그래프
	private String monthDate;
	private String amountSum;
	//연령대 그래프
	private String memAge;
	private String ageCount;
	//회원 소속 그래프
	private String memCompanylist;
	private String memCompanycount;
	//회원 성별 그래프
	private String memGender;
	private String countGender;
	//프로젝트 종목 리스트
	private String pPartCode;
	private String partCount;
	private String partName;
	//평점 리스트/그래프
	private String feedback;
	private String rnum;
	private String gradeAvg;
	//로그인 로그아웃 그래프
	private String loginTime;
	private String loginCount;
	private String logoutTime;
	private String logoutCount;
	//특정 단어 빈도수 조회
	private String feedbackList;
	
	
	public String getFeedbackList() {
		return feedbackList;
	}
	public void setFeedbackList(String feedbackList) {
		this.feedbackList = feedbackList;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getLogoutCount() {
		return logoutCount;
	}
	public void setLogoutCount(String logoutCount) {
		this.logoutCount = logoutCount;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getGradeAvg() {
		return gradeAvg;
	}
	public void setGradeAvg(String gradeAvg) {
		this.gradeAvg = gradeAvg;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getpPartCode() {
		return pPartCode;
	}
	public void setpPartCode(String pPartCode) {
		this.pPartCode = pPartCode;
	}
	public String getPartCount() {
		return partCount;
	}
	public void setPartCount(String partCount) {
		this.partCount = partCount;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getCountGender() {
		return countGender;
	}
	public void setCountGender(String countGender) {
		this.countGender = countGender;
	}
	public String getMemCompanylist() {
		return memCompanylist;
	}
	public void setMemCompanylist(String memCompanylist) {
		this.memCompanylist = memCompanylist;
	}
	public String getMemCompanycount() {
		return memCompanycount;
	}
	public void setMemCompanycount(String memCompanycount) {
		this.memCompanycount = memCompanycount;
	}
	public String getMonthDate() {
		return monthDate;
	}
	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}
	public String getAmountSum() {
		return amountSum;
	}
	public void setAmountSum(String amountSum) {
		this.amountSum = amountSum;
	}
	public String getMemAge() {
		return memAge;
	}
	public void setMemAge(String memAge) {
		this.memAge = memAge;
	}
	public String getAgeCount() {
		return ageCount;
	}
	public void setAgeCount(String ageCount) {
		this.ageCount = ageCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageCount == null) ? 0 : ageCount.hashCode());
		result = prime * result + ((amountSum == null) ? 0 : amountSum.hashCode());
		result = prime * result + ((countGender == null) ? 0 : countGender.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + ((gradeAvg == null) ? 0 : gradeAvg.hashCode());
		result = prime * result + ((memAge == null) ? 0 : memAge.hashCode());
		result = prime * result + ((memCompanycount == null) ? 0 : memCompanycount.hashCode());
		result = prime * result + ((memCompanylist == null) ? 0 : memCompanylist.hashCode());
		result = prime * result + ((memGender == null) ? 0 : memGender.hashCode());
		result = prime * result + ((monthDate == null) ? 0 : monthDate.hashCode());
		result = prime * result + ((pPartCode == null) ? 0 : pPartCode.hashCode());
		result = prime * result + ((partCount == null) ? 0 : partCount.hashCode());
		result = prime * result + ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((rnum == null) ? 0 : rnum.hashCode());
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
		AdminDashboardVO other = (AdminDashboardVO) obj;
		if (ageCount == null) {
			if (other.ageCount != null)
				return false;
		} else if (!ageCount.equals(other.ageCount))
			return false;
		if (amountSum == null) {
			if (other.amountSum != null)
				return false;
		} else if (!amountSum.equals(other.amountSum))
			return false;
		if (countGender == null) {
			if (other.countGender != null)
				return false;
		} else if (!countGender.equals(other.countGender))
			return false;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		if (gradeAvg == null) {
			if (other.gradeAvg != null)
				return false;
		} else if (!gradeAvg.equals(other.gradeAvg))
			return false;
		if (memAge == null) {
			if (other.memAge != null)
				return false;
		} else if (!memAge.equals(other.memAge))
			return false;
		if (memCompanycount == null) {
			if (other.memCompanycount != null)
				return false;
		} else if (!memCompanycount.equals(other.memCompanycount))
			return false;
		if (memCompanylist == null) {
			if (other.memCompanylist != null)
				return false;
		} else if (!memCompanylist.equals(other.memCompanylist))
			return false;
		if (memGender == null) {
			if (other.memGender != null)
				return false;
		} else if (!memGender.equals(other.memGender))
			return false;
		if (monthDate == null) {
			if (other.monthDate != null)
				return false;
		} else if (!monthDate.equals(other.monthDate))
			return false;
		if (pPartCode == null) {
			if (other.pPartCode != null)
				return false;
		} else if (!pPartCode.equals(other.pPartCode))
			return false;
		if (partCount == null) {
			if (other.partCount != null)
				return false;
		} else if (!partCount.equals(other.partCount))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (rnum == null) {
			if (other.rnum != null)
				return false;
		} else if (!rnum.equals(other.rnum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminDashboardVO [monthDate=" + monthDate + ", amountSum=" + amountSum + ", memAge=" + memAge
				+ ", ageCount=" + ageCount + ", memCompanylist=" + memCompanylist + ", memCompanycount="
				+ memCompanycount + ", memGender=" + memGender + ", countGender=" + countGender + ", pPartCode="
				+ pPartCode + ", partCount=" + partCount + ", partName=" + partName + ", feedback=" + feedback
				+ ", rnum=" + rnum + ", gradeAvg=" + gradeAvg + "]";
	}
	
	
	

	
	
	
	
	
	
	
	
	
}
