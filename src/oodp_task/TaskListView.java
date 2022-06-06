package oodp_task;

import java.util.ArrayList;

public class TaskListView implements TaskObserver {

	private static ArrayList<TaskDAO> listCopy = new ArrayList<TaskDAO>();
	
	/* TODO: Must debug TaskListView & MainTaskView 
	 * ���� ù��° ������ �߰� �Ǿ��� ������ ������Ʈ�� �뺸�ϰ� �� ���Ŀ��� �۵��� �ȵ�.
	 * TaskListView ���� �ذ��� �ȵǸ� MainTaskView debugging�� �ǹ̰� ����. ���� �ذ��ؾ� ��.
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
	}	//���� ��ü �� �ٿ�޾Ƽ� ���ĺ��� ��������
	
	//display
	public void updateDisplay() {
		System.out.println("\nList Updated !!");
	}
}
