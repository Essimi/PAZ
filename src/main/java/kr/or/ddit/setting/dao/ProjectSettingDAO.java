package kr.or.ddit.setting.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSettingDAO {
	
	/**
	 * 프로젝트 상태를 완료로 변경합니다.
	 * @param pCode
	 * @return
	 */
	public int projectComplete(String pCode);

}
