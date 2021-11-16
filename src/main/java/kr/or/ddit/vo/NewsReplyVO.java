package kr.or.ddit.vo;

import java.util.List;

public class NewsReplyVO<T> {
	
	private String commentCode;
	private String newsCode;
	private String commentContent;
	private String commentDate;
	private String memId;
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
	
private List<T> dataList;
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


}
