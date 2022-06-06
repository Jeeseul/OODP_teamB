package oodp_task;

import oodp_user.UserDAO;

public class TypeSupport extends TaskSupport 
{
	public TypeSupport(String name, int type) {
		super(name, type);
	}

	@Override
	protected boolean resolve(SubtaskDAO subtask) {
		boolean isResolved = false;
		if(this.getTaskType().equals(subtask.getTaskType()))
			for(UserDAO mem:subtask.getGroup())
				if(mem.getTaskType().equals(subtask.getTaskType())) isResolved = true;
		return isResolved;
	}
	
	@Override
	protected void done(SubtaskDAO subtask, TaskLogsDAO logs) {
		logs.saveLog(subtask);	//save logs of done subtask by type
		subtask.getMainTask().deleteSubtask(subtask);
		System.out.println(subtask.getTaskName() + " was done.");
		//TODO: will be observer
	}
}
