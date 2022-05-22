package oodp_task;

import java.util.ArrayList;

public interface TaskObserver 
{
	public abstract void update(ArrayList<TaskDAO> taskList);
}
