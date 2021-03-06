package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import kr.or.ddit.enumpkg.AlarmType;

public class AlarmVO {
	
	private String alarmCode; // 알람코드
	private AlarmType alarmType; // 알람유형
	private String pCode; // 프로젝트 코드
	private String alarmTitle; // 알람 타이틀
	private String alarmContents; // 알람 내용
	private Date alarmDate; // 알람 날짜
	private String memId; // 해당 알람의 원글을 등록한 회원의 아이디
	private String postCode; // 해당 알람의 원글 코드
	
	private List<String> recipientList; // 수신자 리스트
	private int alarmCheck; // 알람 체크 (1:읽지않음 2:읽음)

	public String getAlarmCode() {
		return alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public AlarmType getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(AlarmType alarmType) {
		this.alarmType = alarmType;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getAlarmTitle() {
		return alarmTitle;
	}

	public void setAlarmTitle(String alarmTitle) {
		this.alarmTitle = alarmTitle;
	}

	public String getAlarmContents() {
		return alarmContents;
	}

	public void setAlarmContents(String alarmContents) {
		this.alarmContents = alarmContents;
	}

	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public int getAlarmCheck() {
		return alarmCheck;
	}

	public void setAlarmCheck(int alarmCheck) {
		this.alarmCheck = alarmCheck;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public List<String> getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List<String> recipientList) {
		this.recipientList = recipientList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alarmCode == null) ? 0 : alarmCode.hashCode());
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
		AlarmVO other = (AlarmVO) obj;
		if (alarmCode == null) {
			if (other.alarmCode != null)
				return false;
		} else if (!alarmCode.equals(other.alarmCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlarmVO [alarmCode=" + alarmCode + ", alarmType=" + alarmType + ", pCode=" + pCode + ", alarmTitle="
				+ alarmTitle + ", alarmContents=" + alarmContents + ", alarmDate=" + alarmDate + ", alarmCheck="
				+ alarmCheck + ", memId=" + memId + ", postCode=" + postCode + ", recipientList=" + recipientList + "]";
	}

}
