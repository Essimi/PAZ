package kr.or.ddit.setting.service;

import kr.or.ddit.enumpkg.ServiceResult;

public interface ProjectSettingService {
	
	/**
	 * 프로젝트 상태를 완료로 변경합니다.
	 * @param pCode
	 * @return
	 */
	public ServiceResult projectComplete(String pCode);

}
