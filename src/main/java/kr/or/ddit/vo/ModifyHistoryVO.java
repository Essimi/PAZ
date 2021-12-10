package kr.or.ddit.vo;


public class ModifyHistoryVO {
	
	private String modifyCode;
	private String workCode;
	private String modifyDate;
	private String columnKey;
	private String beforeValue;
	private String afterValue;
	private String modifierId;
	
	
	// getter, setter
	public String getModifyCode() {
		return modifyCode;
	}
	public void setModifyCode(String modifyCode) {
		this.modifyCode = modifyCode;
	}
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getBeforeValue() {
		return beforeValue;
	}
	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}
	public String getAfterValue() {
		return afterValue;
	}
	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}
	public String getModifierId() {
		return modifierId;
	}
	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}
	
	
	
	// toString
	@Override
	public String toString() {
		return "ModifyHistoryVO [modifyCode=" + modifyCode + ", workCode=" + workCode + ", modifyDate=" + modifyDate
				+ ", columnKey=" + columnKey + ", beforeValue=" + beforeValue + ", afterValue=" + afterValue
				+ ", modifierId=" + modifierId + "]";
	}
	
	
	// 해시코드
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modifyCode == null) ? 0 : modifyCode.hashCode());
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
		ModifyHistoryVO other = (ModifyHistoryVO) obj;
		if (modifyCode == null) {
			if (other.modifyCode != null)
				return false;
		} else if (!modifyCode.equals(other.modifyCode))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
