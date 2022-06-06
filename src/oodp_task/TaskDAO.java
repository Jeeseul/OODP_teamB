package oodp_task;
import java.util.ArrayList;
import oodp_user.UserDAO;


public class TaskDAO 
{
	private String taskName;
	private ArrayList<SubtaskDAO> subtasks;
	private ArrayList<UserDAO> Group;
	
	
	//constructor
	public TaskDAO() {
		setTaskName("Please set TODO");
		setGroup(new ArrayList<UserDAO>());
		setSubtasks(new ArrayList<SubtaskDAO>());
	}
	public TaskDAO(String initTask) {
		setTaskName(initTask);
		setGroup(new ArrayList<UserDAO>());
		setSubtasks(new ArrayList<SubtaskDAO>());
	}
	
	
	//getter & setter
	public String getTaskName() {
		return taskName;
	} 
	public ArrayList<SubtaskDAO> getSubtasks() {
		return subtasks;
	}
	public ArrayList<UserDAO> getGroup() {
		return Group;
	} 
	public void setTaskName(String mainTaskName) {
		taskName = mainTaskName;
	} 
	public void setSubtasks(ArrayList<SubtaskDAO> subtaskList) {
		subtasks = subtaskList;
	}
	public void setGroup(ArrayList<UserDAO> group) {
		Group = group;
	}
	
	
	//add, update, delete Subtask
	public int addSubtask(SubtaskDAO task) {
		subtasks.add(task);
		task.setMainTask(this);
		return 1;
	}
	public int updateSubtask(SubtaskDAO task, SubtaskDAO updated) {
		int index = subtasks.indexOf(task);
        subtasks.remove(index);
        subtasks.add(updated);
        task.deleteMainTask();
        updated.setMainTask(this);
		return 1; //success
	}
	public int deleteSubtask(SubtaskDAO task){
        subtasks.remove(task);
        task.deleteMainTask();
        return 1; //success
    }
	
	
	//add,delete,update Member in Group
	public int addMember(UserDAO member) {
		Group.add(member);
		return 1; //success
	}
	public int updateMember(UserDAO member, UserDAO updated) {
		int index = Group.indexOf(member);
        Group.remove(index);
        Group.add(updated);
		return 1; //success
	}
	public int deleteMember(UserDAO member) {
        Group.remove(member);
        return 1; //success
    }
	
	
	//referencing
	public boolean taskEquals(TaskDAO task) {
		boolean isEquals = false;
		if(this.getTaskName().equals(task.getTaskName())
				&& (this.getSubtasks().size()==task.getSubtasks().size())
				&& (this.getGroup().size()==task.getGroup().size())) {
			isEquals = true;
			if(!this.getSubtasks().containsAll(task.getSubtasks())) isEquals = false;
			if(!this.getGroup().containsAll(task.getGroup())) isEquals = false;
		}
		return isEquals;
	} //check task equals
	public boolean isDuplicated(String name) {
		for(UserDAO mem : Group) 
	    	if(name.equals(mem.getName())) return true;
	    return false;
	} //check duplication of Member in Group
	
	
	/* toString: printing template
	 * = main task to do <Group: John, Peter>" or "<Group: Empty>"
	 *   (\t) * subtask to do [John]
	 *   (\t) * subtask to do [Peter] 
	 *   (\t) * subtask to do [None]   */
	
	public String toString() {
		//main task
		String main = "= " + this.taskName + " <Team: ";
		if(!this.Group.isEmpty()) {
			for(UserDAO member:this.Group) { 
				if(this.Group.indexOf(member)>0) main += ", ";
				main += member.getName();
			}
		} else main += "Empty";
		main += ">";
		
		//subtask
		String sub = "";
		for(SubtaskDAO st:this.subtasks) {
			sub += "\n\t* " + st.getTaskType() +": " + st.getTaskName();
			if(!st.getGroup().isEmpty()) {
				sub += " [";
				for(UserDAO mem:st.getGroup()) {
					if(st.getGroup().indexOf(mem)!=0) sub +=", ";
					sub += mem.getName();
				}
				sub += "]";
			} else sub += " (none.)";
		}
		
		//entire toString
		return main + sub;
    }   
}

	
