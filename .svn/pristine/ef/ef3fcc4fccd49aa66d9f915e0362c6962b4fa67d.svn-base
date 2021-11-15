package kr.or.ddit.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResourceVO {
	
	public ResourceVO() {
		super();
	}

	private Integer level;
	private String resCode;
	private String resourceName;
	private String resourcePattern;
	private String description;
	private String resourceType;
	private Integer sortOrder;
	private String createDate;
	private String modifyDate;
	private String parentCode;
	
	@JsonIgnore
	private List<AuthorityVO> authorities;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcePattern() {
		return resourcePattern;
	}

	public void setResourcePattern(String resourcePattern) {
		this.resourcePattern = resourcePattern;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public List<AuthorityVO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityVO> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "ResourceVO [level=" + level + ", resCode=" + resCode + ", resourceName=" + resourceName
				+ ", resourcePattern=" + resourcePattern + ", description=" + description + ", resourceType="
				+ resourceType + ", sortOrder=" + sortOrder + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + ", parentCode=" + parentCode + ", authorities=" + authorities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resCode == null) ? 0 : resCode.hashCode());
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
		ResourceVO other = (ResourceVO) obj;
		if (resCode == null) {
			if (other.resCode != null)
				return false;
		} else if (!resCode.equals(other.resCode))
			return false;
		return true;
	}
	
	
}
