package kr.or.ddit.vo;

import java.util.List;

public class DataListVO<T> {
	private String pCode;

	private String meetingCode;
	private List<T> dataList;

	
	public String getMeetingCode() {
		return meetingCode;
	}

	public void setMeetingCode(String meetingCode) {
		this.meetingCode = meetingCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataList == null) ? 0 : dataList.hashCode());
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
		DataListVO other = (DataListVO) obj;
		if (dataList == null) {
			if (other.dataList != null)
				return false;
		} else if (!dataList.equals(other.dataList))
			return false;
		if (pCode == null) {
			if (other.pCode != null)
				return false;
		} else if (!pCode.equals(other.pCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataListVO [pCode=" + pCode + ", dataList=" + dataList + "]";
	}
	
	
}
