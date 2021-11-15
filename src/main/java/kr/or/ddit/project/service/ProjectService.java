package kr.or.ddit.project.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;

public interface ProjectService {
	/**
	 * pro_no는 입력받지 않는다 
	 * @param myProject
	 * @return
	 */
	public ServiceResult insertMyProject(ProjectVO myProject);
	
	/**
	 * 
	 * @param myProject
	 * @return
	 */
	public List<ProjectVO> selectMyProjectList(ProjectVO projectVO);

	/**
	 * 
	 * @param pCode
	 * @return 없으면 null값이 들어감 
	 */
	public ProjectVO selectMyProject(ProjectVO myProject);

	/**
	 * 회원이 PL로 등록된 프로젝트 리스트 조회
	 * @param memberVo
	 * @return
	 */
	public List<ProjectVO> listMyProjectPl (MemberVO memberVO); 
	
	
	/**
	 * 프로젝트 삭제 
	 * @param projectVO
	 * @return
	 */
	public ServiceResult deletProject(ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 상세 조회
	 * @param projectVO
	 * @return
	 */
	public ProjectVO selectProject (ProjectVO projectVO);
	
	/**
	 * 프로젝트 정보 수정 
	 * @param projectVO
	 * @return
	 */
	public ServiceResult updateProject (ProjectVO projectVO);
	
	/**
	 * PL 권한 확인
	 * @param projectVO
	 * @return
	 */
	public ProjectVO selectPosition (ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 멤버 정보 리스트 출력
	 * @param projectVO
	 * @return
	 */
	public List<ProjectVO> listProjectMember (ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 멤버 삭제
	 * @param projectVO
	 * @return
	 */
	public ServiceResult deleteProjectMember (ProjectVO projectVO);
}




