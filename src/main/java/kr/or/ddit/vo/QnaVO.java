package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import kr.or.ddit.validate.groups.InsertGroup;

/**
 * 
 * ValueObject(DataTransferObject, Model, Bean)
 * JavaBean 규약
 *
 * 1. 값을 가질 수 있는 property 정의
 * 2. property encpsulation
 * 3. 캡슐화된 property에 접근할 수 있는 인터페이스 제공 (getter/setter)
 * 4. property 의 상태를 비교할 수 있는 방법 제공
 * 5. 정렬의 기준을 제공
 * 6. property의 상태 확인 방법 제공
 * 7. Serializable 선언
 */
public class QnaVO implements Comparable<QnaVO>, Serializable{

	public QnaVO() {
		super();
	}
	
	
	private String qandaCode;
	
	private String parentCode;
	
	@NotBlank(message = "제목을 입력해주세요", groups = InsertGroup.class)
	private String qandaTitle;
	@NotBlank(message = "내용을 입력해주세요")
	private String qandaContent;
	
	private String qandaDate;
	
	private String qandaCheck;
	
	private Integer rnum;
	
	private String memId;
	
	private String qandaDateSelect;
	
	

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getQandaCheck() {
		return qandaCheck;
	}

	public void setQandaCheck(String qandaCheck) {
		this.qandaCheck = qandaCheck;
	}

	public String getQandaCode() {
		return qandaCode;
	}

	public void setQandaCode(String qandaCode) {
		this.qandaCode = qandaCode;
	}

	public String getQandaTitle() {
		return qandaTitle;
	}

	public void setQandaTitle(String qandaTitle) {
		this.qandaTitle = qandaTitle;
	}

	public String getQandaContent() {
		return qandaContent;
	}

	public void setQandaContent(String qandaContent) {
		this.qandaContent = qandaContent;
	}

	public String getQandaDate() {
		return qandaDate;
	}

	public void setQandaDate(String qandaDate) {
		this.qandaDate = qandaDate;
	}

	public Integer getRnum() {
		return rnum;
	}

	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qandaCode == null) ? 0 : qandaCode.hashCode());
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
		QnaVO other = (QnaVO) obj;
		if (qandaCode == null) {
			if (other.qandaCode != null)
				return false;
		} else if (!qandaCode.equals(other.qandaCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(QnaVO qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getQandaDateSelect() {
		return qandaDateSelect;
	}

	public void setQandaDateSelect(String qandaDateSelect) {
		this.qandaDateSelect = qandaDateSelect;
	}

	@Override
	public String toString() {
		return "QnaVO [qandaCode=" + qandaCode + ", parentCode=" + parentCode + ", qandaTitle=" + qandaTitle
				+ ", qandaContent=" + qandaContent + ", qandaDate=" + qandaDate + ", qandaCheck=" + qandaCheck
				+ ", rnum=" + rnum + ", memId=" + memId + ", qnadaDateSelect=" + qandaDateSelect + "]";
	}
	
}
