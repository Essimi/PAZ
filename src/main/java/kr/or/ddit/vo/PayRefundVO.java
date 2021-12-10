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

public class PayRefundVO implements Comparable<PayRefundVO>, Serializable {

	public PayRefundVO() {
		super();
	}

	private String memId;

	private String refundMonth;

	private String payCode;

	private String refundCode;

	private String refundDetail;

	private String refundDate;

	private List<PayVO> payList;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getRefundMonth() {
		return refundMonth;
	}

	public void setRefundMonth(String refundMonth) {
		this.refundMonth = refundMonth;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getRefundCode() {
		return refundCode;
	}

	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}

	public String getRefundDetail() {
		return refundDetail;
	}

	public void setRefundDetail(String refundDetail) {
		this.refundDetail = refundDetail;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}

	public List<PayVO> getPayList() {
		return payList;
	}

	public void setPayList(List<PayVO> payList) {
		this.payList = payList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payCode == null) ? 0 : payCode.hashCode());
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
		PayRefundVO other = (PayRefundVO) obj;
		if (payCode == null) {
			if (other.payCode != null)
				return false;
		} else if (!payCode.equals(other.payCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PayRefundVO [memId=" + memId + ", refundMonth=" + refundMonth + ", payCode=" + payCode + ", refundCode="
				+ refundCode + ", refundDetail=" + refundDetail + ", refundDate=" + refundDate + ", payList=" + payList
				+ "]";
	}

	@Override
	public int compareTo(PayRefundVO payRefund) {
		// TODO Auto-generated method stub
		return 0;
	}
}
