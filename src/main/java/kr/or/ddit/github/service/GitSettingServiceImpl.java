package kr.or.ddit.github.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.github.dao.GitSettingDAO;
import kr.or.ddit.vo.GitVO;

@Service
public class GitSettingServiceImpl implements GitSettingService {
	
	@Inject
	private GitSettingDAO gitDao;

	@Override
	public GitVO retrieveGit(GitVO git) {
		
		GitVO gitSetting = gitDao.selectGitSetting(git);
		
		return gitSetting;
		
	}

	@Transactional
	@Override
	public ServiceResult createGitRepo(GitVO git) {
		
		ServiceResult result = null;
		
		int rowcnt = gitDao.insertGitRepo(git);
				
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else
			result = ServiceResult.FAILED;
		
		return result;
	}

	@Override
	public ServiceResult removeGitRepo(String pCode) {
		
		ServiceResult result = null;
		
		int rowcnt = gitDao.deleteGitRepo(pCode);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else
			result = ServiceResult.FAILED;
		
		return result;
	}
}
