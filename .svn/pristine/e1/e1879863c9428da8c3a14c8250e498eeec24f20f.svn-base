package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketSession;

public class ChatMessageVO {
	
	private ChatMemberVO sender; // 보내는 사람
	private Date chatTime; // 메시지 전송 시간
	private String content; // 메시지 내용
	
	public ChatMemberVO getSender() {
		return sender;
	}
	public void setSender(ChatMemberVO sender) {
		this.sender = sender;
	}
	
	public void enterSender(WebSocketSession session) {
		
		Authentication auth = (Authentication) session.getPrincipal();
		MemberVOWrapper memberData = (MemberVOWrapper)auth.getPrincipal();
		MemberVO memberinfo = memberData.getAuthMember();
		
		ChatMemberVO member = new ChatMemberVO();
		
		member.setMemId(memberinfo.getMemId());
		member.setMemNickname(memberinfo.getMemNickname());
		
		if(memberinfo.getMemIkon() == null) {
			member.setSaveName("BMO-1.jpg");
		} else {
			member.setSaveName(memberinfo.getMemIkon().getSaveName());
		}
		member.setSession(session);
		
		this.setSender(member);
		
	}
	
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ChatMessageVO [sender=" + sender + ", chatTime=" + chatTime + ", content=" + content + "]";
	}
	
}
