package oodp_task;

import java.util.ArrayList;

public class TaskListView implements TaskObserver {

	private static ArrayList<TaskDAO> listCopy = new ArrayList<TaskDAO>();
	
	/* TODO: Must debug TaskListView & MainTaskView 
	 * 제일 첫번째 업무가 추가 되었을 때에만 업데이트를 통보하고 그 이후에는 작동이 안됨.
	 * TaskListView 에서 해결이 안되면 MainTaskView debugging이 의미가 없음. 먼저 해결해야 함.
	 * */

	//constructor
	public TaskListView(TaskListDAO taskList) {
		TaskListView.setListCopy(taskList.getList());
	}
	
	//get & set
	public static ArrayList<TaskDAO> getListCopy() {
		return listCopy;
	}
	public static void setListCopy(ArrayList<TaskDAO> updatedCopy) {
		TaskListView.listCopy = updatedCopy;
	}
	
	//update
	@Override
	public void update(TaskListDAO taskList) {
		//if task list has been changed, do update and notify updating
		if(!taskList.taskListEquals(TaskListView.getListCopy())) {
			TaskListView.setListCopy(taskList.getList());
			updateDisplay();
		}
	}	//내일 전체 다 다운받아서 합쳐보고 돌려보기
	
	//display
	public void updateDisplay() {
		System.out.println("\nList Updated !!");
	}
}
