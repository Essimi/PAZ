package kr.or.ddit.github.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.GitVO;

public interface GitSettingService {
	
	/**
	 * 로그인한 회원의 정보를 토대로 깃허브 정보 불러오기
	 * @param git
	 * @return
	 */
	public GitVO retrieveGit(GitVO git);
	
	/**
	 * GitRepo 정보 저장
	 * @param git
	 * @return
	 */
	public ServiceResult createGitRepo(GitVO git);
	
	/**
	 * Git 연결 해제
	 * @param pCode
	 * @return
	 */
	public ServiceResult removeGitRepo(String pCode);

}
