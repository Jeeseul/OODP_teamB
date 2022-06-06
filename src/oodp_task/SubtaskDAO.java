package oodp_task;

import oodp_user.UserDAO;

public class SubtaskDAO extends TaskDAO 
{
	/* TaskType - enum (1~4)
	 * 1: DEVELOP, 2: RESEARCH, 3: DESIGN, 4: FEEDBACK */
	private TaskTypes taskType;
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
	
	
	//get & set
	public TaskTypes getTaskType() {
		return taskType;
	}
	public void setTaskType(int type) {
		this.taskType = TaskTypes.setTypeByNum(type);
	}
	public TaskDAO getMainTask() {
		return mainTask;
	}
	
	//add(setter)
	public void setMainTask(TaskDAO maintask) {
		this.mainTask = maintask;
		for(UserDAO mem:this.getGroup())
			if(!maintask.isDuplicated(mem.getName())) 
				maintask.addMember(mem);
	} //add subtask's members to maintask's group automatically
	
	//delete
	public int deleteMainTask() {
		for(UserDAO mem:this.getGroup()) 
			for(SubtaskDAO st:mem.getTasks()) 
				if(!st.getMainTask().equals(this.mainTask))
					this.mainTask.deleteMember(mem);	
		this.mainTask = null;
		return 1;
	}
}
