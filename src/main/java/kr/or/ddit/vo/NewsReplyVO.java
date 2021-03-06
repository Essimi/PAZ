package kr.or.ddit.vo;

import java.util.List;

public class NewsReplyVO<T> {
	
	private String commentCode;
	private String newsCode;
	private String commentContent;
	private String commentDate;
	private String memId;
	private String memNickname;
	private String saveName;
	
	
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	public String getNewsCode() {
		return newsCode;
	}
	public void setNewsCode(String newsCode) {
		this.newsCode = newsCode;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentCode == null) ? 0 : commentCode.hashCode());
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
		NewsReplyVO other = (NewsReplyVO) obj;
		if (commentCode == null) {
			if (other.commentCode != null)
				return false;
		} else if (!commentCode.equals(other.commentCode))
			return false;
		return true;
	}



private List<T> dataList;
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	@Override
	public String toString() {
		return "NewsReplyVO [commentCode=" + commentCode + ", newsCode=" + newsCode + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", memId=" + memId + ", dataList=" + dataList + "]";
	}
	
	


}
