package kr.or.ddit.vo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatRoomVO {
	
	private String chatroomCode; // 채팅방의 번호
	private String pCode; // 프로젝트 번호
	private String chatroomTitle; // 채팅방 이름
	private String chatroomDate; // 채팅방 생성 날짜
	
	private Set<ChatMemberVO> memberSet; // 1 대 다 관계 
	private Queue<ChatMessageVO> messageList; // 1 대 다 관계
	
	public ChatRoomVO() {
		
	}
	
	// 이 VO를 생성 할 때 chatroomCode pCode chatroomTitle chatroomDate를 생성자로 반드시 받아야한다.
	public ChatRoomVO(String chatroomCode, String pCode, String chatroomTitle, String chatroomDate) {
		
		this.chatroomCode = chatroomCode;
		this.pCode = pCode;
		this.chatroomTitle = chatroomTitle;
		this.chatroomDate = chatroomDate;
		
		this.memberSet = new HashSet<>();
		this.messageList = new LinkedList<>();
		
	}

	public String getChatroomCode() {
		return chatroomCode;
	}


	public void setChatroomCode(String chatroomCode) {
		this.chatroomCode = chatroomCode;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getChatroomTitle() {
		return chatroomTitle;
	}


	public void setChatroomTitle(String chatroomTitle) {
		this.chatroomTitle = chatroomTitle;
	}


	public String getChatroomDate() {
		return chatroomDate;
	}


	public void setChatroomDate(String chatroomDate) {
		this.chatroomDate = chatroomDate;
	}

	
	// get
	public Set<ChatMemberVO> getMemberSet() {
		return memberSet;
	}
	
	public void setMemberSet(Set<ChatMemberVO> memberSet) {
		this.memberSet = memberSet;
	}

	public void enterChatroom(WebSocketSession session) {
		
		log.info("세션{}",session);
		
		Authentication auth = (Authentication) session.getPrincipal();
		MemberVOWrapper memberData = (MemberVOWrapper)auth.getPrincipal();
		MemberVO memberinfo = memberData.getAuthMember();
		
		log.info("memberinfo{}",memberinfo);
		
		ChatMemberVO member = new ChatMemberVO();
		
		member.setMemId(memberinfo.getMemId());
		member.setMemNickname(memberinfo.getMemNickname());
		member.setSaveName(memberinfo.getMemIkon().getSaveName());
		member.setSession(session);
		
		this.memberSet.add(member);
		
	}
	
	public void outChatroom(WebSocketSession session) {
		
		log.info("세션{}",session);
		
		Authentication auth = (Authentication) session.getPrincipal();
		MemberVOWrapper memberData = (MemberVOWrapper)auth.getPrincipal();
		MemberVO memberinfo = memberData.getAuthMember();
		
		log.info("memberinfo{}",memberinfo);
		
		ChatMemberVO member = new ChatMemberVO();
		
		member.setMemId(memberinfo.getMemId());
		member.setMemNickname(memberinfo.getMemNickname());
		member.setSaveName(memberinfo.getMemIkon().getSaveName());
		member.setSession(session);
		
		this.memberSet.remove(member);
		
	}
	
	public void setMessageList(ChatMessageVO message) {
		messageList.add(message);
	}

	public Queue<ChatMessageVO> getMessageList() {
		return messageList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chatroomCode == null) ? 0 : chatroomCode.hashCode());
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
		ChatRoomVO other = (ChatRoomVO) obj;
		if (chatroomCode == null) {
			if (other.chatroomCode != null)
				return false;
		} else if (!chatroomCode.equals(other.chatroomCode))
			return false;
		return true;
	}
	
}