package oodp_task;

import java.util.ArrayList;

public class TaskListView implements TaskObserver {

	private static ArrayList<TaskDAO> viewingList = new ArrayList<TaskDAO>();
	
	/* TODO: Must debug TaskListView & MainTaskView 
	 * 제일 첫번째 업무가 추가 되었을 때에만 업데이트를 통보하고 그 이후에는 작동이 안됨.
	 * TaskListView 에서 해결이 안되면 MainTaskView debugging이 의미가 없음. 먼저 해결해야 함.
	 * */

	//constructor
	public TaskListView(ArrayList<TaskDAO> taskList) {
		TaskListView.setViewingList(taskList);
	}
	
	//get & set
	public static ArrayList<TaskDAO> getViewingList() {
		return viewingList;
	}
	public static void setViewingList(ArrayList<TaskDAO> viewList) {
		TaskListView.viewingList = viewList;
	}
	
	//update
	@Override
	public void update(ArrayList<TaskDAO> taskList) {
		//if task list has been changed, do update and notify updating
		if(!TaskListView.getViewingList().equals(taskList)) {
			TaskListView.setViewingList(taskList);
			updateDisplay();
		}
	}
	
	//display
	public void updateDisplay() {
		System.out.println("List Updated : ");
	}
}
