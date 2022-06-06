package oodp_task;

import java.util.ArrayList;

public class MainTaskView implements TaskObserver {
	
	private static ArrayList<TaskDAO> mainCopy = new ArrayList<TaskDAO>();

	//constructor
	public MainTaskView(TaskListDAO taskList) {
		TaskListView.setListCopy(taskList.getList());
	}
		
	//get & set
	public static ArrayList<TaskDAO> getMainCopy() {
		return mainCopy;
	}
	public static void setMainCopy(ArrayList<TaskDAO> updatedCopy) {
		MainTaskView.mainCopy = updatedCopy;
	}
		
	//update
	@Override
	public void update(TaskListDAO taskList) {
		
		ArrayList<TaskDAO> saveOld = mainCopy;
		ArrayList<String> saveTasks = new ArrayList<String>();
		for(TaskDAO ts:saveOld) saveTasks.add(ts.getTaskName());
		
		//if task list has been changed, do update and notify updating
		if(!taskList.taskListEquals(MainTaskView.getMainCopy())) {
			MainTaskView.setMainCopy(taskList.getList());
			//if new main task was added
			if(saveOld.size() < MainTaskView.getMainCopy().size()) {
				//start index from the end of saveOld
				for(int i=saveOld.size();i<MainTaskView.getMainCopy().size();i++)
					System.out.println("new! " + MainTaskView.getMainCopy().get(i).getTaskName());
			} 
			// else if size of saveOld > size of mainCopy: print deleted tasks
		}		
	}
}
