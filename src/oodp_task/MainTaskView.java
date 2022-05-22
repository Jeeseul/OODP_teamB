package oodp_task;

import java.util.ArrayList;

public class MainTaskView implements TaskObserver {
	
	private static ArrayList<TaskDAO> viewingList = new ArrayList<TaskDAO>();

	//constructor
	public MainTaskView(ArrayList<TaskDAO> taskList) {
		TaskListView.setViewingList(taskList);
	}
		
	//get & set
	public static ArrayList<TaskDAO> getViewingList() {
		return viewingList;
	}
	public static void setViewingList(ArrayList<TaskDAO> viewList) {
		MainTaskView.viewingList = viewList;
	}
		
	//update
	@Override
	public void update(ArrayList<TaskDAO> taskList) {
			
		ArrayList<TaskDAO> saveOld = new ArrayList<TaskDAO>();
		ArrayList<String> saveTasks = new ArrayList<String>();
		for(TaskDAO ts:saveOld) 
			saveTasks.add(ts.getTaskName());
			
		//if task list has been changed, do update and notify updating
		if(!MainTaskView.getViewingList().equals(taskList)) {
			MainTaskView.setViewingList(taskList);
			//if new main task was added
			if(saveOld.size() != MainTaskView.getViewingList().size()) {
				int num=0;
				//when saveOld.size()!=0, start index from the end of saveOld 
				if(saveOld.size()>0) num=saveOld.size()-1;
				//when saveOld.size()==0, start index from 0
				for(int i=num;i<MainTaskView.getViewingList().size();i++)
					System.out.println("new! " + MainTaskView.getViewingList().get(i).getTaskName());
			}
		}		
	}
}
