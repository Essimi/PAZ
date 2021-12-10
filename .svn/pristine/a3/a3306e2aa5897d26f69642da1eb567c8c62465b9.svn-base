package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ValueObject(DataTransferObject, Model, Bean) JavaBean 규약
 *
 * 1. 값을 가질 수 있는 property 정의 2. property encpsulation 3. 캡슐화된 property에 접근할 수 있는
 * 인터페이스 제공 (getter/setter) 4. property 의 상태를 비교할 수 있는 방법 제공 5. 정렬의 기준을 제공 6.
 * property의 상태 확인 방법 제공 7. Serializable 선언
 */

public class TimerVO implements Comparable<TimerVO>, Serializable {

	private String memId;

	private String pCode;

	private String onOff;

	private String whCode;

	private String whStart;

	private String whEnd;

	private String ptitle;

	@Override
	public int compareTo(TimerVO TimerVO) {
		return 0;
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

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getWhStart() {
		return whStart;
	}

	public void setWhStart(String whStart) {
		this.whStart = whStart;
	}

	public String getWhEnd() {
		return whEnd;
	}

	public void setWhEnd(String whEnd) {
		this.whEnd = whEnd;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
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
		TimerVO other = (TimerVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimerVO [memId=" + memId + ", pCode=" + pCode + ", onOff=" + onOff + ", whCode=" + whCode + ", whStart="
				+ whStart + ", whEnd=" + whEnd + ", ptitle=" + ptitle + "]";
	}

}
