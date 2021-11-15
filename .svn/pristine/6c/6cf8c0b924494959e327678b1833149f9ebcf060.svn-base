package kr.or.ddit.vo;

public class CalendarWrapper implements FullCalendarEvent {

	private CalendarVO calendar;
	
	
	public CalendarWrapper(CalendarVO calendar) {
		super();
		this.calendar = calendar;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return calendar.getScheduleCode();
	}

	@Override
	public String getStart() {
		// TODO Auto-generated method stub
		return calendar.getScheduleStart();
	}

	@Override
	public String getEnd() {
		// TODO Auto-generated method stub
		return calendar.getScheduleDeadline();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return calendar.getScheduleName();
	}

}
