package kr.or.ddit.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;


@Repository
public interface ProjectDAO {
	
	/**
	 * pro_no는 입력받지 않는다 
	 * @param myProject
	 * @return
	 */
	public int insertMyProject(ProjectVO myProject);
	
	/**
	 * 
	 * @param myProject
	 * @return
	 */
	public List<ProjectVO> selectMyProjectList(ProjectVO projectVO);

	/**
	 * 
	 * @param myProject
	 * @return 없으면 null값이 들어감 
	 */
	public ProjectVO selectMyproject(ProjectVO myProject);
	
	/**
	 * 회원이 PL로 등록된 프로젝트 리스트 조회
	 * @param memberVO
	 * @return List<ProjectVO>
	 */
	public List<ProjectVO> listMyProjectPl (MemberVO memberVO); 
	
	
	/**
	 * 프로젝트 삭제 
	 * @param projectVO
	 * @return
	 */
	public int deleteProject (ProjectVO projectVO);
	
	/**
	 * 프로젝트 상세 정보 조회
	 * @param projectVO
	 * @return
	 */
	public ProjectVO selectProject (ProjectVO projectVO);
	
	
	/**
	 * 	프로젝트 정보 수정
	 * @param projectVO
	 * @return
	 */
	public int updateProject (ProjectVO projectVO); 
	
	
	/**
	 * PL 권한 확인
	 * @param projectVO
	 * @return
	 */
	public ProjectVO selectPosition (ProjectVO projectVO);
	
	
	/**
	 * 해당 프로젝트 멤버 리스트 출력 
	 * @param projectVO
	 * @return
	 */
	public List<ProjectVO> listProjectMember (ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 멤버 삭제 
	 * @param projectVO
	 * @return
	 */
	public int deleteProjectMember (ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 PL 권한 이양 - p_mem postion 변경
	 * @param projectVO
	 * @return
	 */
	public int updatePosition(ProjectVO projectVO);
	
	
	/**
	 * 프로젝트 PL 권한 이양 - mem_mapping role_code 변경 
	 * @param projectVO
	 * @return
	 */
	public int updateMemMapping (ProjectVO projectVO);

}
