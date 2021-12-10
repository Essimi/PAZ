package kr.or.ddit.chat.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberProfileVO;

@Repository
public interface ChattingDAO {
	
	/**
	 * 메인화면에 표시되는 프로젝트 멤버 조회
	 * @param 
	 * @return 
	 */
	public List<MemberProfileVO> selectProjectMember(Map<String, String> info);
	
	
	/**
	 * 메인화면에 표시되는 채팅방 조회
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
	 * 채팅방 코드 생성과 조회
	 * @param 
	 * @return
	 */
	public String selectChatroomCode();
	
	
	/**
	 * 채팅방 등록
	 * @param
	 * @return
	 */
	public int insertChatroom(ChatRoomVO chat);
	
	
	/**
	 * 채팅방 멤버 등록
	 * @param
	 * @return
	 */
	public int insertChatMem(Map<String, Object> memList);
	
	
	/**
	 * VO 생성을 위한 채팅방 조회
	 * @param 
	 * @return 
	 */
	public ChatRoomVO selectChatroomForConstructor(String chatroomCode);

}
