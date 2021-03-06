package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.KakaoGroup;

public class MemberVO {
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	
	@Pattern(groups=InsertGroup.class, regexp="^[a-z]{1}[a-z0-9_-]{4,20}$", 
			message="※5 ~ 20 자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능")
	@NotBlank(groups=InsertGroup.class)
	private String memId;
	@Pattern(groups=InsertGroup.class, regexp="^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}", 
			message="※8 ~ 16자 영문 대 소문자, 숫자, 특수문자를 사용 가능")
	@NotBlank(groups=InsertGroup.class)
	private String memPass;
	@NotBlank(groups= {InsertGroup.class, KakaoGroup.class})
	private String memNickname;
	@Email(message="※이메일을 다시확인하세요.")
	private String memMail;
	@Pattern(groups=InsertGroup.class, regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", 
			message="※핸드폰번호를 다시 확인해주세요.")
	@NotBlank(groups={InsertGroup.class, KakaoGroup.class})
	private String memTel;
	@NotBlank(groups={InsertGroup.class, KakaoGroup.class})
	private String memBirth;
	@NotBlank(groups={InsertGroup.class, KakaoGroup.class})
	private String memGender;
	@NotBlank(groups={InsertGroup.class, KakaoGroup.class})
	private String memCompany;
	private String joinDate;
	private String outDate;
	private String surveyStatus;
	private String outCode;
	private String reviewStatus;
	private String payDeadline;
	
	//상세조회 참여자 닉네임
	private String memNicknameWe;
	
	public String getMemNicknameWe() {
		return memNicknameWe;
	}

	public void setMemNicknameWe(String memNicknameWe) {
		this.memNicknameWe = memNicknameWe;
	}
	
	
	// 한 회원이 가진 역할들
	List<String> memRoles;
	
	// 회원의 프로필 아이콘
	MemberIkonVO memIkon;
	
	private MultipartFile imageFile;
	public void setImageFile(MultipartFile imageFile) {
		if(imageFile == null) return;
		this.imageFile = imageFile;
		this.memIkon = new MemberIkonVO(imageFile, this.memId);
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public MemberIkonVO getMemIkon() {
		return memIkon;
	}

	public void setMemIkon(MemberIkonVO memIkon) {
		this.memIkon = memIkon;
	}

	public List<String> getMemRoles() {
		return memRoles;
	}
	public void setMemRoles(List<String> memRoles) {
		this.memRoles = memRoles;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
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
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemCompany() {
		return memCompany;
	}
	public void setMemCompany(String memCompany) {
		this.memCompany = memCompany;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getSurveyStatus() {
		return surveyStatus;
	}
	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}
	public String getOutCode() {
		return outCode;
	}
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getPayDeadline() {
		return payDeadline;
	}
	public void setPayDeadline(String payDeadline) {
		this.payDeadline = payDeadline;
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
		MemberVO other = (MemberVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}

	
	

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memNickname=" + memNickname + ", memMail="
				+ memMail + ", memTel=" + memTel + ", memBirth=" + memBirth + ", memGender=" + memGender
				+ ", memCompany=" + memCompany + ", joinDate=" + joinDate + ", outDate=" + outDate + ", surveyStatus="
				+ surveyStatus + ", outCode=" + outCode + ", reviewStatus=" + reviewStatus + ", payDeadline="
				+ payDeadline + ", memNicknameWe=" + memNicknameWe + ", memRoles=" + memRoles + ", memIkon=" + memIkon
				+ ", imageFile=" + imageFile + "]";
	}
}
