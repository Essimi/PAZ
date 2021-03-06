package kr.or.ddit.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.dao.ProjectDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
   
   @Inject
   private ProjectDAO projectDAO;
   


   @Transactional
   @Override
   public ServiceResult insertMyProject(ProjectVO myProject) {
      ServiceResult result = null;
      
      int rowcnt = projectDAO.insertMyProject(myProject);
      if(rowcnt > 0) {
         result = ServiceResult.OK;
      }else {
         result = ServiceResult.FAILED;
      }
      
      return result;
   }

   @Override
   public List<ProjectVO> selectMyProjectList(ProjectVO projectVO) {
      return projectDAO.selectMyProjectList(projectVO);
   }

   @Override
   public ProjectVO selectMyProject(ProjectVO myProject) {
      ProjectVO projectOne = projectDAO.selectMyproject(myProject);
      if(projectOne == null) {
         throw new PKNotFoundException(myProject + " 에 해당하는 번호의 게시물이 없음 ");
      }
      
      return projectOne;
   }
	
	@Override
	public List<ProjectVO> listMyProjectPl(MemberVO memberVO) {
		
		return projectDAO.listMyProjectPl(memberVO);
	}
	
	@Transactional
	@Override
	public ServiceResult deletProject(ProjectVO projectVO) {
		
		ServiceResult result = null;
		
		int cnt = projectDAO.deleteProject(projectVO);
		
		if(cnt > 0) { 
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
	
		return result;
	}
	
	@Override
	public ProjectVO selectProject(ProjectVO projectVO) {
		
		return projectDAO.selectProject(projectVO);
	}
	
	@Override
	public ServiceResult updateProject(ProjectVO projectVO) {
		
		ServiceResult result = null;
		
		int cnt = projectDAO.updateProject(projectVO);
		
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}
	
	@Override
	public ProjectVO selectPosition(ProjectVO projectVO) {
		
		return projectDAO.selectPosition(projectVO);
	}
	
	@Override
	public List<ProjectVO> listProjectMember(ProjectVO projectVO) {
		
		return projectDAO.listProjectMember(projectVO);
	}
	
	@Override
	public ServiceResult deleteProjectMember(ProjectVO projectVO) {
		
		ServiceResult result = null;
		
		int cnt = projectDAO.deleteProjectMember(projectVO);
		
		if (cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	
	@Override
	public ServiceResult updatePosition(List<ProjectVO> project) {
		
		ServiceResult result = null;
		// 첫번째 정보 - pl로 지정한 멤버의 정보
		
		int cnt = 0;
		
		// 파라미터 리스트에 들어있는 projectVO를 하나씩 꺼내서 쿼리 실행
		for(ProjectVO pro : project) {
			
			String roleCode = pro.getPosition() + pro.getpCode().substring(7);
			
			pro.setRoleCode(roleCode);
			
			int positionRes = projectDAO.updatePosition(pro);
			int memMappingRes = projectDAO.updateMemMapping(pro);
			
			if(positionRes > 0 && memMappingRes > 0) {
				cnt = 0 ;
			}else {
				cnt ++ ;
			}
		}
		
		if(cnt > 0) {
			result = ServiceResult.FAILED;
		}else {
			result = ServiceResult.OK;
		}
		
		return result;
	}
}