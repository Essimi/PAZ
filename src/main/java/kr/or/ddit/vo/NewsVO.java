package kr.or.ddit.vo;

import java.util.List;


public class NewsVO<T> {
	
	private String newsCode;
	private String newsContents;
	private String newsDate;
	private String memId;
	private String pCode;
	
	
	public String getNewsCode() {
		return newsCode;
	}
	public void setNewsCode(String newsCode) {
		this.newsCode = newsCode;
	}
	public String getNewsContents() {
		return newsContents;
	}
	public void setNewsContents(String newsContents) {
		this.newsContents = newsContents;
	}
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	@Override
	public String toString() {
		return "NewsVO [newsCode=" + newsCode + ", newsContents=" + newsContents + ", newsDate=" + newsDate + ", memId="
				+ memId + ", pCode=" + pCode + "]";
	}
	
	private String memNickname;
	
	private MemberIkonVO saveName;
	
	
	
	public MemberIkonVO getsaveName() {
		return saveName;
	}
	public void setMemIkon(MemberIkonVO saveName) {
		this.saveName = saveName;
	}

	private List<NewsReplyVO> replyList;
	
	private List<T> dataList;
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newsCode == null) ? 0 : newsCode.hashCode());
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
		NewsVO other = (NewsVO) obj;
		if (newsCode == null) {
			if (other.newsCode != null)
				return false;
		} else if (!newsCode.equals(other.newsCode))
			return false;
		return true;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public List<NewsReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<NewsReplyVO> replyList) {
		this.replyList = replyList;
	}
	
}
