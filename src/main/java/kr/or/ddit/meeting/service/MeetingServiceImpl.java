package kr.or.ddit.meeting.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.dao.MeetingAttatchDAO;
import kr.or.ddit.meeting.dao.MeetingDao;
import kr.or.ddit.utils.AttatchDAO;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectMemberVO;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MeetingServiceImpl implements MeetingService{
	@Inject
	private MeetingDao dao;
	
	@Inject
	private MeetingAttatchDAO attatchDAO;
	

	
	@Value("#{appInfo.attatchPath}")// 파일 경로를 연결해준다.
	private File saveFolder; //saveFolder로 지정된 파일 경로로
	
	
	
	// 파일 업로드 시 그 경로로 이동시켜주는 코드 
	private int processAttatches(MeetingVO meeting) {
		
		int rowcnt = 0;
		
		AttatchVO attatch= meeting.getAttatch();//회의록에 있는 첨부파일 VO지정
		
		if(attatch != null) {
			
			attatch.setPostCode(meeting.getMeetingCode());//첨부파일 게시글 번호 컬럼에다 회의록 코드를 넣기 위한 코드

			rowcnt = attatchDAO.insertMeetingAttatche(attatch);//다오에 있는 쿼리를 넣어서 

			log.info("파일 첨부가 수행 되는가 {}", rowcnt);//서버에서 첨부파일이 수행되는지 위한 테스트

			try {
				attatch.saveTo(saveFolder);	//실행이된다면  saveFolder에 지정되어 저장됨
			}catch (Exception e) {
				e.printStackTrace(); //수행이 되지 않으면 printStackTrace
			}
			
		}
		
		
		return rowcnt;
	}
	
	
	
	@Transactional	//원자성과 일관성으로 실패하거나 성공하거나 무조건 하나로 지정
	@Override
	public ServiceResult createMeeting(MeetingVO meeting) {
		ServiceResult result = null;								//서비스의 결과를 OK, FAILED, NOTEXIST, INVALIDPASSWORD, PKDUPLICATED지정해서 나타냄
		int rowcnt1 = dao.inser1tMeeting(meeting);					//회의록 기본 정보인 제목 글내용 결과를 입력하는 곳
		int rowcnt2 = 0;
		
		if(meeting.getMemId() !=null) {								//작성자가 아니면
			String[] memIdArr = meeting.getMemId().split(",");		//참여자들을 스플릿으로 ,로 쪼개고 memIdArr로 지정된 변수에 리스트로 값을 넣는다.
			List<MemberVO> memList = null;							
			if(memIdArr!=null) {									//memIdArr이 값이 null이라면 
				memList = new ArrayList<>();						//memList로 ArrayList를 생성한다.
				for(int i=0; i<memIdArr.length; i++) {				//반복문으로 memList에 하나씩 쪼개어 memList에 넣는다.
					MemberVO memvo = new MemberVO();
					memvo.setMemId(memIdArr[i]);
					memList.add(memvo);
				}
				meeting.setMemberList(memList);						//memList에 넣은 정보를 memberList에 넣는다.
			}
			rowcnt2 = dao.inser2tMeeting(meeting);					//회의에 참여자들을 리스트로 인서트 한다.
		}
		
		
		if(rowcnt1>0 || rowcnt2>0) {
			rowcnt1 += processAttatches(meeting);					//첨부파일이 있으면 추가한다.
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

	
	
	
	
	
	

	@Override
	public MeetingVO meetingSelect(String meetingCode){
		MeetingVO meeting = dao.selectMeeting(meetingCode);					
		if(meeting==null) {
			throw new PKNotFoundException(meetingCode + "번 글이 없음 ");		
		}
		meeting.setAttatch(attatchDAO.selectMeetingAttatch(meetingCode));
	
		return meeting;
	}

	@Override
	public List<MeetingVO> meetingPageList(PagingVO<MeetingVO> pagingVO) {
		List<MeetingVO> meetingPageList = dao.selectMeetingList(pagingVO);
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(meetingPageList);
		return meetingPageList;
	}
	
	
	@Override
	public List<ProjectMemberVO> chackmember(DataListVO<ProjectMemberVO> dataListVO) {
		List<ProjectMemberVO> projectListMember = dao.chackmember(dataListVO);//여러데이터를 가져오는것
		dataListVO.setDataList(dao.chackmember(dataListVO));//원래는 널이였지만 데이터 리스트에 n개의 값을 집어 넣음
		return projectListMember ;
	}

	public List<ProjectMemberVO> chackSelect(DataListVO<ProjectMemberVO> dataListVO){
		List<ProjectMemberVO> projectListMember = dao.chackSelect(dataListVO);
		dataListVO.setDataList(dao.chackSelect(dataListVO));
		return projectListMember;
	}
	
	@Override
	public ServiceResult meetingModify(MeetingVO meeting) throws IOException {
		ServiceResult result = null;
		
		int rowcnt1 =dao.deleteMeetingMemberList(meeting);
		int rowcnt2 = dao.updateMeeting(meeting);
		
		int rowcnt3 = 0;
		if(meeting.getMemId() !=null) {
			String[] memIdArr = meeting.getMemId().split(",");
			List<MemberVO> memList = null;
			if(memIdArr!=null) {
				memList = new ArrayList<> ();
				for(int i=0; i<memIdArr.length; i++) {
					MemberVO memvo = new MemberVO();
					memvo.setMemId(memIdArr[i]);
					memList.add(memvo);
				}
				meeting.setMemberList(memList);
			}
			//새롭게 유입된 숫자
			rowcnt3 = dao.inser2tMeeting(meeting);
		}
		
		if(rowcnt1 > 0 || rowcnt2 >=0 || rowcnt3 >=0) {
			//삭제 파일 처리
			if(meeting.getMeetigFile() != null) {
				FileUtils.deleteQuietly(new File(saveFolder,meeting.getAttatch().getSaveName()));
				attatchDAO.deleteMeetingAttatche(meeting.getMeetingCode());
				log.info("안나오지롱");
			}
			log.info("***************************************************************************");
			
			// 파일 처리
			processAttatches(meeting);
			
			result = ServiceResult.OK;
			
		}else {
			//검증 통과 실패(회원의 아이디가글쓴 회원)
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
	
	@Transactional
	@Override
	public ServiceResult meetingDelete(MeetingVO meeting) throws IOException {
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt1 = dao.deleteMeetingMemberList(meeting);
		int cnt2 = dao.deleteMeeting(meeting.getMeetingCode());
//		attatchDAO.deleteAttatChes(meeting.getAttatch());
//		FileUtils.deleteDirectory(new File(saveFolder, meeting.getAttatch().getSaveName()));
		if(cnt1 > 0 && cnt2 > 0) result = ServiceResult.OK;
			
		return result;
	}

	@Override
	public AttatchVO download(String meetingCode) {
		
		AttatchVO attatch = attatchDAO.selectMeetingAttatch(meetingCode);
		
		if(attatch == null) {
			throw new PKNotFoundException(meetingCode+ "파일이 존재하지 않음");
		}
		
		return attatch;
	}

	
}
