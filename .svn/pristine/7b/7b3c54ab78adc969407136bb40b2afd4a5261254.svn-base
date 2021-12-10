package kr.or.ddit.vo;

public class GanttChartWrapper implements GanttChartEvent {
	
	private TaskVO task;
	
	

	public GanttChartWrapper(TaskVO task) {
		super();
		this.task = task;
	}

	@Override
	public String pName() {
		// TODO Auto-generated method stub
		return task.getTopWorkName();
	}
	
	@Override
	public String gName() {
		// TODO Auto-generated method stub
		return task.getWorkName();
	}
	

	@Override
	public String pRes() {
		// TODO Auto-generated method stub
		return task.getMemNickname();
	}

	@Override
	public String getpStart() {
		// TODO Auto-generated method stub
		return task.getWorkStart();
	}

	@Override
	public String getpEnd() {
		// TODO Auto-generated method stub
		return task.getWorkDeadline();
	}

	@Override
	public String getpComp() {
		// TODO Auto-generated method stub
		return task.getProgress();
	}

	

}
