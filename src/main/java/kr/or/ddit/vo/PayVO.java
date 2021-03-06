package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 
 * ValueObject(DataTransferObject, Model, Bean) JavaBean 규약
 *
 * 1. 값을 가질 수 있는 property 정의 2. property encpsulation 3. 캡슐화된 property에 접근할 수 있는
 * 인터페이스 제공 (getter/setter) 4. property 의 상태를 비교할 수 있는 방법 제공 5. 정렬의 기준을 제공 6.
 * property의 상태 확인 방법 제공 7. Serializable 선언
 */

public class PayVO implements Comparable<PayVO>, Serializable {

	public PayVO() {
		super();
	}

	@NotBlank
	private String payCode;

	private String memId;

	private String payDate;
	@NotBlank
	private String payAmount;
	@NotBlank
	private String payMonth;
	@NotBlank
	private String payProvider;
	@NotBlank
	private String payMerUid;
	@NotBlank
	private String payPgSuccess;

	private PayRefundVO refundInfo;
	
	private String refund;

	
	
	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public PayRefundVO getRefundInfo() {
		return refundInfo;
	}

	public void setRefundInfo(PayRefundVO refundInfo) {
		this.refundInfo = refundInfo;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getPayProvider() {
		return payProvider;
	}

	public void setPayProvider(String payProvider) {
		this.payProvider = payProvider;
	}

	public String getPayMerUid() {
		return payMerUid;
	}

	public void setPayMerUid(String payMerUid) {
		this.payMerUid = payMerUid;
	}

	public String getPayPgSuccess() {
		return payPgSuccess;
	}

	public void setPayPgSuccess(String payPgSuccess) {
		this.payPgSuccess = payPgSuccess;
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
		PayVO other = (PayVO) obj;
		if (payCode == null) {
			if (other.payCode != null)
				return false;
		} else if (!payCode.equals(other.payCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(PayVO pay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "PayVO [payCode=" + payCode + ", memId=" + memId + ", payDate=" + payDate + ", payAmount=" + payAmount
				+ ", payMonth=" + payMonth + ", payProvider=" + payProvider + ", payMerUid=" + payMerUid
				+ ", payPgSuccess=" + payPgSuccess + ", refundInfo=" + refundInfo + "]";
	}

}
