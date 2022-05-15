package oodp_task;
import java.util.ArrayList;
import oodp_user.UserDAO;


public class TaskListDAO 
{
	private static ArrayList<TaskDAO> TaskList;

	//constructor
	public TaskListDAO() {
		TaskList = new ArrayList<TaskDAO>();
	}
	
	
	//add
	public int addTask(TaskDAO task) {
        TaskList.add(task);
        return 1; //success
    }
	public int addSubTask(TaskDAO task, String subtask) {
		int index = TaskList.indexOf(task);
		TaskList.get(index).addSubTask(subtask);
		return 1; //success
	}
	
	
	//assign - to assign User as one of a team
	public int assignTask(TaskDAO task, UserDAO member, String subtask) {
		int index = TaskList.indexOf(task);
		if(!TaskList.get(index).isDuplicated(member.getName()))
			TaskList.get(index).addMember(member);
		member.addTask(subtask);
		return 1; //success
	}
	
	
	//update
    public int updateTask(TaskDAO task, TaskDAO updated){
        int index = TaskList.indexOf(task);
        TaskList.remove(index);
        TaskList.add(updated);
        return 1; //success
    }
    public int updateSubTask(TaskDAO task, String subtask, String updated) {
    	int index = TaskList.indexOf(task);
    	TaskList.get(index).updateSubTask(subtask, updated);
    	return 1; //success
    }

    
    //delete
    public int deleteTask(TaskDAO task){
        TaskList.remove(task);
        return 1; //success
    }
    public int deleteSubTask(TaskDAO task, String subtask) {
    	int index = TaskList.indexOf(task);
    	TaskList.get(index).deleteSubTask(subtask);
    	return 1; //success
    }

    
    //referencing
    public int indexOf(TaskDAO task){
        return TaskList.indexOf(task);
    }
    public int size(){
        return TaskList.size();
    }
    public ArrayList<TaskDAO> getList(){
        return new ArrayList<TaskDAO>(TaskList);
    }
    public boolean isEmpty() {
    	if(TaskList.isEmpty()) return true;
    	else return false;
    }
    
    
    //show list ALL
    public void listALL(){
        for(TaskDAO task : TaskList){
            System.out.println(task.toString());
        }
    }
}
