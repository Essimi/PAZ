package kr.or.ddit.vo;


public class SearchVO {
	
	private String searchType;
	private String searchWord;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((searchType == null) ? 0 : searchType.hashCode());
		result = prime * result + ((searchWord == null) ? 0 : searchWord.hashCode());
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
		SearchVO other = (SearchVO) obj;
		if (searchType == null) {
			if (other.searchType != null)
				return false;
		} else if (!searchType.equals(other.searchType))
			return false;
		if (searchWord == null) {
			if (other.searchWord != null)
				return false;
		} else if (!searchWord.equals(other.searchWord))
			return false;
		return true;
	}
	public SearchVO(String searchType, String searchWord) {
		super();
		this.searchType = searchType;
		this.searchWord = searchWord;
	}
	public SearchVO() {
		// TODO Auto-generated constructor stub
	}
	



	
}
