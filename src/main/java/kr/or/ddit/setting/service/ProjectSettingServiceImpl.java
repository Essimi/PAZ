package kr.or.ddit.setting.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.setting.dao.ProjectSettingDAO;

@Service
public class ProjectSettingServiceImpl implements ProjectSettingService {
	
	@Inject
	ProjectSettingDAO projectSettingDao;

	@Override
	public ServiceResult projectComplete(String pCode) {
		
		ServiceResult result = null;
		
		int rowcnt = projectSettingDao.projectComplete(pCode);
		
		if(rowcnt  > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

}
