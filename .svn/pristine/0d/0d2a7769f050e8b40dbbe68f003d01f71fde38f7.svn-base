package kr.or.ddit.vo;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityVO implements GrantedAuthority {

	public AuthorityVO(String roleCode) {
		super();
		this.roleCode = roleCode;
	}
	
	public AuthorityVO() {
		super();
	}

	private String roleCode;
	private String roleName;
	private String description;
	private String createDate;
	private String modifyDate;
	
	private String[] resCode;
	
	public String[] getResCode() {
		return resCode;
	}

	public void setResCode(String[] resCode) {
		this.resCode = resCode;
	}

	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
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
		AuthorityVO other = (AuthorityVO) obj;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AuthorityVO [roleCode=" + roleCode + "]";
	}
	
	@Override
	public String getAuthority() {
		return getRoleCode();
	}
	
	
}
