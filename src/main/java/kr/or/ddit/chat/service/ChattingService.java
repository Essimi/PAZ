package kr.or.ddit.chat.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberProfileVO;

public interface ChattingService {
	
	/**
	 * 메인화면에 표시되는 프로젝트 멤버 조회
	 * @param
	 * @return
	 */
	public List<MemberProfileVO> selectProjectMember(Map<String, String> info);
	
	/**
	 * 메인화면에 표시되는 채팅방 리스트에 대한 정보
	 * @param
	 * @return
	 */
	public List<ChatRoomVO> selectchatRoom(Map<String, String> info);
	
	/**
	 * 클릭 시 나타나는 멤버의 상세 조회.
	 * @param
	 * @return
	 */
	public MemberProfileVO selectMember(Map<String, String> info);
	
	/**
	 * 멤버의 리스트 사이즈가 2인 경우 조회 쿼리
	 * @param
	 * @return
	 */
	public ChatRoomVO selectChatRoomCheck(Map<String, Object> data);
	
	/**
	 * 멤버의 리스트 사이즈가 1인 경우 조회 쿼리
	 * @param
	 * @return
	 */
	public ChatRoomVO selectChatRoomOneCheck(Map<String, Object> data);
	
	/**
	 * 채팅방 생성
	 * @param
	 * @return
	 */
	public ServiceResult insertChatRoom(ChatRoomVO chat, List<String> memberList);
	
	/**
	 * 채팅방 번호 조회 및 생성
	 * @param
	 * @return
	 */
	public String selectChatroomCode();
	
	/**
	 * 채팅방 멤버 삭제
	 * @param
	 * @return
	 */
	public ServiceResult deleteChatMem(Map<String, String> info);
	

}