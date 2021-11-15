package kr.or.ddit.github.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.GitVO;

// 깃허브 연동을 위한 DAO

@Repository
public interface GitSettingDAO {

	/**
	 * 로그인한 회원의 정보를 토대로 깃허브 정보 불러오기
	 * @param git
	 * @return
	 */
	public GitVO selectGitSetting(GitVO git);
	
	/**
	 * Git Repo 정보 저장
	 * @param git
	 * @return
	 */
	public int insertGitRepo(GitVO git);
	
	/**
	 * Git Repo 연결 해제
	 * @param pCode
	 * @return
	 */
	public int deleteGitRepo(String pCode);
	
	
	
	
	
	
	
	
	
	
	
	
}
