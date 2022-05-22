package oodp_task;

import java.util.ArrayList;

public class TaskListView implements TaskObserver {

	private static ArrayList<TaskDAO> viewingList = new ArrayList<TaskDAO>();
	
	/* TODO: Must debug TaskListView & MainTaskView 
	 * ���� ù��° ������ �߰� �Ǿ��� ������ ������Ʈ�� �뺸�ϰ� �� ���Ŀ��� �۵��� �ȵ�.
	 * TaskListView ���� �ذ��� �ȵǸ� MainTaskView debugging�� �ǹ̰� ����. ���� �ذ��ؾ� ��.
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
