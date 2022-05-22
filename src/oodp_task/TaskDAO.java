package oodp_task;
import java.util.ArrayList;
import oodp_user.UserDAO;


public class TaskDAO 
{
	private String taskName;
	private ArrayList<SubtaskDAO> subtasks;
	private ArrayList<UserDAO> Group;
	// + private ArrayList<String> files;
	// + private ArrayList<String> Tags;
	
	
	//constructor
	public TaskDAO() {
		setTaskName("Please set TODO");
		setGroup(new ArrayList<UserDAO>());
		setSubtasks(new ArrayList<SubtaskDAO>());
		// Tags = new ArrayList<String>();
		// files = new ArrayList<String>(); 
	}
	public TaskDAO(String initTask) {
		setTaskName(initTask);
		setGroup(new ArrayList<UserDAO>());
		setSubtasks(new ArrayList<SubtaskDAO>());
		// Tags = new ArrayList<String>();
		// files = new ArrayList<String>(); 
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
	
	
	//check duplication of Member in Group
	public Boolean isDuplicated(String name) {
		for(UserDAO mem : Group) 
	    	if(name.equals(mem.getName())) return true;
	    return false;
	}
	
	
	/* toString: printing template 
	 * e.g.)
	 * = main task to do <Group: John, Peter>" or "<Group: Empty>"
	 *   (\t) * subtask to do [John]
	 *   (\t) * subtask to do [Peter] 
	 *   (\t) * subtask to do [None]   */
	
	//toString
	public String toString() {
		//main task
		String main = "= " + this.taskName + " <Group: ";
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
			sub += "\n\t* " + st.getTaskName();
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
	
	
	
	/* append later - Tags, Files
	public ArrayList<String> getTags() {
		return Tags;
	}
	public ArrayList<String> getFiles() {
		return files;
	}
	
	public void setTags(ArrayList<String> tags) {
		Tags = tags;
	}
	public void setFiles(ArrayList<String> files) {
		this.files = files;
	}
	
	public void addTag(String tag) {
		Tags.add(tag);
	} 
	public void addFiles(String file) {
		files.add(file);
	} */
}

	
