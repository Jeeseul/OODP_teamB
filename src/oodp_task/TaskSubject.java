package oodp_task;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskSubject 
{
	//observers List
	private List<TaskObserver> observers = new ArrayList<TaskObserver>();
	
	//add, delete observers
	public void attach(TaskObserver observer) { observers.add(observer);}
	public void detach(TaskObserver observer) { observers.remove(observer);}
	
	//notify changes to observers
	public void notifyObservers(ArrayList<TaskDAO> taskList) { 
		for(TaskObserver observer:observers) observer.update(taskList);
	}
}
