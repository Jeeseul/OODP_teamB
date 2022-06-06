package oodp_user;

import java.util.ArrayList;
import oodp_task.*; //needs to update

public abstract class UserDAO {    
    
	private ArrayList<SubtaskDAO> Tasks;
    private TaskTypes taskType;
	
    
    //get & set
    public ArrayList<SubtaskDAO> getTasks() {
		return Tasks;
	}
    public void setTasks(ArrayList<SubtaskDAO> tasks) {
		Tasks = tasks;
	}
    public TaskTypes getTaskType() {
		return taskType;
	}
	public void setTaskType(int type) {
		this.taskType = TaskTypes.setTypeByNum(type);
	}

	
    //add, update, delete task to Tasks
    public int addTask(SubtaskDAO task) {
		Tasks.add(task);
		return 1; //success
	}
	public int updateTask(SubtaskDAO task, SubtaskDAO updated) {
		int index = Tasks.indexOf(task);
        Tasks.remove(index);
        Tasks.add(updated);
		return 1; //success
	}
	public int deleteTask(SubtaskDAO task){
        Tasks.remove(task);
        return 1; //success
    }
	
	
	//referencing Tasks
	public int indexOf(SubtaskDAO task){
        return Tasks.indexOf(task);
    }
    public int size(){
        return Tasks.size();
    }
    
    
    //abstract methods
    abstract public String getName();
    abstract public String getID();
    abstract public String getPassword();
    abstract public String getType();
    abstract public String getLogincheck();
      
    abstract public int login();
    abstract public int logout();
    abstract public String toString();
}