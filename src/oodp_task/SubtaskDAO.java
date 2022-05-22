package oodp_task;

import oodp_user.UserDAO;

public class SubtaskDAO extends TaskDAO 
{
	/* TaskType - integer (1~3)
	 * 1: type1
	 * 2: type2
	 * 3: type3
	 * */
	private int taskType;
	private TaskDAO mainTask;

	
	//constructor
	public SubtaskDAO() {
		super();
	}
	public SubtaskDAO(String initialName) {
		super(initialName);
	}
	public SubtaskDAO(String initialName, int type) {
		super(initialName);
		this.setTaskType(type);
	}
	public SubtaskDAO(String initialName, int type, TaskDAO maintask) {
		super(initialName);
		this.setTaskType(type);
		this.setMainTask(maintask);
	}
	
	
	//get & set
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int type) {
		this.taskType = type;
	}
	public TaskDAO getMainTask() {
		return mainTask;
	}
	
	//add(setter)
	public void setMainTask(TaskDAO maintask) {
		this.mainTask = maintask;
		for(UserDAO mem:this.getGroup())
			maintask.addMember(mem);
	} //add subtask's members to maintask's group automatically
	
	//delete
	public int deleteMainTask() {
		for(UserDAO mem:this.getGroup())
			this.mainTask.deleteMember(mem);
		this.mainTask = null;
		return 1;
	}
}
