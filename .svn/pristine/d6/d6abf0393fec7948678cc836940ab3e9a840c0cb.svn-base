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
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.dao.MeetingDao;
import kr.or.ddit.utils.AttatchDAO;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectMemberVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MeetingServiceImpl implements MeetingService{
	@Inject
	private MeetingDao dao;
//	@Inject
//	private AttatchDAO attatchDAO;
	
//	@Value("#{appInfo.attatchPath}")
//	private String saveFolderPath;
//	@Value("#{appInfo.attatchPath}")
//	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException{

	}
	
//	private int processAttatches(MeetingVO meeting) {
//		int rowcnt = 0;
//		AttatchVO attatch= meeting.getAttatch();
//		if(attatch != null) {
//			rowcnt = attatchDAO.intsertAttatches(meeting.getAttatch());
//		}
//		
//		try {
//			AttatchVO atch = attatch;
//				atch.saveTo(saveFolder);
//			
//		}catch(IOException e) {
//			throw new RuntimeException(e);
//		}
//		return rowcnt;
//	}
	
	@Transactional
	@Override
	public ServiceResult createMeeting(MeetingVO meeting) {
		ServiceResult result = null;
		int rowcnt1 = dao.inser1tMeeting(meeting);
		log.info("rowcnt1값 : {}",rowcnt1);
		String[] memIdArr = meeting.getMemId().split(",");
		List<MemberVO> memList = null;
		if(memIdArr!=null) {
			memList = new ArrayList<>();
			for(int i=0; i<memIdArr.length; i++) {
				MemberVO memvo = new MemberVO();
				memvo.setMemId(memIdArr[i]);
				memList.add(memvo);
			}
			meeting.setMemberList(memList);
		}
		
		int rowcnt2 = dao.inser2tMeeting(meeting);
		log.info("rowcnt2값 : {}",rowcnt2);
		int rowcnt = rowcnt1+rowcnt2; 
		log.info("rowcnt값 : {}",rowcnt);
		if(rowcnt>=0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}


	@Override
	public MeetingVO meetingSelect(String meetingCode){
		MeetingVO meeting = dao.selectMeeting(meetingCode);
		if(meeting==null)
			throw new PKNotFoundException(meetingCode + "번 글이 없음 ");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("meetingCode", meetingCode);
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

//	@Override-
//	public ServiceResult meetingModify(MeetingVO meeting) throws IOException {
//		int rowcnt = dao.updateMeeting(meeting);
//		ServiceResult result = null;
//		if(rowcnt > 0) {
//			// 올릴 파일 처리
//			processAttatches(meeting);
//			// 지울 파일 처리
//			String delAttNos = meeting.getDellAttCode();
//			if(delAttNos!= null) {
//				attatchDAO.deleteAttatChes(meeting.getAttatch());
//				FileUtils.deleteDirectory(new File(saveFolder, meeting.getAttatch().getSaveName()));	
//			}
//			result = ServiceResult.OK;
//		}else {
//			result = ServiceResult.FAILED;
//		}
//		return result;
//	}

//	@Override
//	public ServiceResult meetingDelete(MeetingVO meeting) throws IOException {
//		ServiceResult result = null;
//		attatchDAO.deleteAttatChes(meeting.getAttatch());
//		dao.deleteMeeting(meeting.getMeetingCode());
//		FileUtils.deleteDirectory(new File(saveFolder, meeting.getAttatch().getSaveName()));	
//		return result;
//	}

	
}
