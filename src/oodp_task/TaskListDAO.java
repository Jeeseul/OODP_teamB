package oodp_task;
import java.util.ArrayList;
import oodp_user.UserDAO;


public class TaskListDAO extends TaskSubject
{
	private static ArrayList<TaskDAO> TaskList;

	//constructor
	public TaskListDAO() {
		TaskList = new ArrayList<TaskDAO>();
	}
	
	
	//add (& assign)
	public int addTask(TaskDAO task) {
        TaskList.add(task);
        notifyObservers(this);
        return 1; //success
    }
	public int addSubTask(TaskDAO task, SubtaskDAO subtask) {
		int index = TaskList.indexOf(task);
		TaskList.get(index).addSubtask(subtask);
		notifyObservers(this);
		return 1; //success
	}
	public int assignTask(TaskDAO task, SubtaskDAO subtask, UserDAO member) {
		if(!task.isDuplicated(member.getName())) task.addMember(member);
		subtask.addMember(member);
		member.addTask(subtask);
		notifyObservers(this);
		return 1; //success
	} //assign - to assign User as one of a team
	
	
	//update
    public int updateTask(TaskDAO task, TaskDAO updated){
        int index = TaskList.indexOf(task);
        TaskList.remove(index);
        TaskList.add(updated);
        notifyObservers(this);
        return 1; //success
    }
    public int updateSubTask(TaskDAO task, SubtaskDAO subtask, SubtaskDAO updated) {
    	int index = TaskList.indexOf(task);
    	TaskList.get(index).updateSubtask(subtask, updated);
    	notifyObservers(this);
    	return 1; //success
    }

    
    //delete
    public int deleteTask(TaskDAO task){
        TaskList.remove(task);
        notifyObservers(this);
        return 1; //success
    }
    public int deleteSubTask(TaskDAO task, SubtaskDAO subtask) {
    	int index = TaskList.indexOf(task);
    	TaskList.get(index).deleteSubtask(subtask);
    	notifyObservers(this);
    	return 1; //success
    }

    
    //referencing
    public int indexOf(TaskDAO task){
        return TaskList.indexOf(task);
    }
    public int size(){
        return TaskList.size();
    }
    public boolean isEmpty() {
    	if(TaskList.isEmpty()) return true;
    	else return false;
    }
    public boolean taskListEquals(ArrayList<TaskDAO> taskList) {
    	boolean isEquals = false;
    	if(TaskList.size() == taskList.size()) {
    		isEquals = true;
    		for(int i=0; i<TaskList.size(); i++) 
    			if(!TaskList.get(i).taskEquals(taskList.get(i))) isEquals = false;
    	}
    	return isEquals;
    }
    
    
    //get & set
    public ArrayList<TaskDAO> getList(){
        return new ArrayList<TaskDAO>(TaskList);
    }
    public void setList(ArrayList<TaskDAO> newTaskList){
    	TaskListDAO.TaskList = newTaskList;
    }
    
    //show list ALL
    public void listALL(){
        for(TaskDAO task : TaskList) {
            System.out.println(task.toString());
        }
    }
}
