package kr.or.ddit.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.v2.management.OperationKey;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.dao.RequestProjectDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;

@Service
public class RequestProjectServiceImpl implements RequestProjectService {
	
	@Inject
	RequestProjectDAO requestProjectDao;

	@Override
	public List<RequestProjectVO> selectRequestList(MemberVO memberVO) {
		
		// List<RequestProjectVO> requestProjectList = requestProjectDao.selectRequestList(memberVO);
		
		return requestProjectDao.selectRequestList(memberVO);
	}

	
	/**
	 * p_mem에 회원 추가 , req_history 상태코드 업데이트, mem_mapping 회원 - 역할코드 추가 
	 */
	@Override
	@Transactional
	public ServiceResult updateRequestProjecOk(RequestProjectVO requestProjectVO){
		
		ServiceResult result = ServiceResult.FAILED;
		
		// req_history에 상태 코드 업데이트
		int updateStatus = requestProjectDao.updateRequestProjecStatus(requestProjectVO);
		
		// p_mem에 회원 추가
		int insertPmem = requestProjectDao.InsertProjectMember(requestProjectVO);
		
//		// mem_mapping에 아이디, 역할코드추가 
//		int insertMapping = requestProjectDao.InsertMemberMapping(requestProjectVO);
		
		// 업데이트,회원 추가, 역할코드 추가 모두 성공 시 OK
		if(updateStatus > 0 && insertPmem > 0 ) {
			result = ServiceResult.OK;
		}
		
		// 모두 성공하지 않았을 시 FAILD
		
		return result;
	}


	@Override
	public ServiceResult InsertRequstProjectHistory(RequestProjectVO requestProjectVO) {
		
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt = requestProjectDao.InsertRequstProjectHistory(requestProjectVO);
		
		if(cnt > 0) {
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Override
	public List<MemberVO> SelectProjectMemberList(RequestProjectVO requestProjectVO) {
		
		
		return requestProjectDao.SelectProjectMemberList(requestProjectVO);
	}


	@Override
	public ServiceResult updateRequestProjectStatus(RequestProjectVO requestProjectVO) {
		
		ServiceResult result = null;
		int cnt = requestProjectDao.updateRequestProjecStatus(requestProjectVO);
		
		if (cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}


	@Override
	public ServiceResult selectMemberInfo(String nickName) {
		
		ServiceResult result = null;
		
//		MemberVO member = new MemberVO();
		
		String member = requestProjectDao.selectMemberInfo(nickName);
		
		//String realNickName = member.getMemNickname();
		
		System.out.println("testttttt" + member);
		
		if(member == null) {
			result = ServiceResult.FAILED;
		}else {
			result = ServiceResult.OK;
		}
		
		System.out.println("result?" + result);
		
		return result;
	}


	@Override
	public List<RequestProjectVO> listRequestProjectHistory(ProjectVO projectVO) {
		
		return requestProjectDao.listRequestProjectHistory(projectVO);
	}


	/**
	 * 탈퇴 회원 초대 수락 시 outCode 변경
	 */
	@Override
	@Transactional
	public ServiceResult updatePmemOutCode(ProjectVO projectVO) {
		
		ServiceResult result = null;
		
		RequestProjectVO requestProjectVO = new RequestProjectVO();
		requestProjectVO.setReqCode(projectVO.getReqCode());
		requestProjectVO.setStatusCode(projectVO.getStatusCode());
		
		int cnt1 = requestProjectDao.updatePmemOutCode(projectVO);
		
		int cnt2 = requestProjectDao.updateRequestProjecStatus(requestProjectVO);
		
		if(cnt1 > 0 && cnt2 > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

}
