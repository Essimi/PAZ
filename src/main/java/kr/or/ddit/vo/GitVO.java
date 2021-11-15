package kr.or.ddit.vo;

import java.io.Serializable;

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

/**
 * @author essimi
 *
 */
public class GitVO implements Comparable<GitVO>, Serializable{
	
	public GitVO() {
		super();
	}
	
	private String pCode;
	
	private String repository;
	
	private String token;
	
	private String userName;
	
	private String memId;
	
	private String gitDate;

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getGitDate() {
		return gitDate;
	}

	public void setGitDate(String gitDate) {
		this.gitDate = gitDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		GitVO other = (GitVO) obj;
		if (pCode == null) {
			if (other.pCode != null)
				return false;
		} else if (!pCode.equals(other.pCode))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(GitVO git) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "GitVO [pCode=" + pCode + ", repository=" + repository + ", token=" + token + ", userName=" + userName
				+ ", memId=" + memId + ", gitDate=" + gitDate + "]";
	}
}
