package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;

public class CalendarVO {
	
	private String scheduleCode;
	
	@NotBlank(message="제목을 입력해주세요", groups= {InsertGroup.class})
	private String scheduleName;
	@NotBlank(message="내용을 입력해주세요", groups= {InsertGroup.class})
	private String scheduleContent;
	
	
	@NotBlank(message="시작일을 입력해주세요", groups= {InsertGroup.class})
	private String scheduleStart;
	@NotBlank(message="마감일을 입력해주세요", groups= {InsertGroup.class})
	private String scheduleDeadline;
	private String pCode;
	
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public String getScheduleContent() {
		return scheduleContent;
	}
	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public String getScheduleStart() {
		return scheduleStart;
	}
	public void setScheduleStart(String scheduleStart) {
		this.scheduleStart = scheduleStart;
	}
	public String getScheduleDeadline() {
		return scheduleDeadline;
	}
	public void setScheduleDeadline(String scheduleDeadline) {
		this.scheduleDeadline = scheduleDeadline;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	@Override
	public String toString() {
		return "CalendarVO [scheduleCode=" + scheduleCode + ", scheduleName=" + scheduleName + ", scheduleContent="
				+ scheduleContent + ", scheduleStart=" + scheduleStart + ", scheduleDeadline=" + scheduleDeadline
				+ ", pCode=" + pCode + "]";
	}
	
	
	
}
