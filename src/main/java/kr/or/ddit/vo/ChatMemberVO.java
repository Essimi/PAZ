package kr.or.ddit.vo;

import org.springframework.web.socket.WebSocketSession;

public class ChatMemberVO {
	
	private String memId;
	private String memNickname;
	private String saveName;
	
	// 웹소켓 세션 자체를 가지고 있어야 한다.
	private WebSocketSession session;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
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
		ChatMemberVO other = (ChatMemberVO) obj;
		if (memId == null) {
			if (other.memId != null)
				return false;
		} else if (!memId.equals(other.memId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChatMemberVO [memId=" + memId + ", memNickname=" + memNickname + ", saveName=" + saveName + ", session="
				+ session + "]";
	}
	
}
