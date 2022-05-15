package oodp_task;
import java.util.ArrayList;
import oodp_user.UserDAO;


public class TaskDAO 
{
	private String MainTask;
	private ArrayList<String> SubTasks;
	private ArrayList<UserDAO> Group;
	// + private ArrayList<String> files;
	// + private ArrayList<String> Tags;
	
	
	//constructor
	public TaskDAO() {
		setMainTask("Please set TODO");
		SubTasks = new ArrayList<String>();
		Group = new ArrayList<UserDAO>();
		// Tags = new ArrayList<String>();
		// files = new ArrayList<String>(); 
	}
	public TaskDAO(String initTask) {
		setMainTask(initTask);
		SubTasks = new ArrayList<String>();
		Group = new ArrayList<UserDAO>();
		// Tags = new ArrayList<String>();
		// files = new ArrayList<String>(); 
	}
	
	
	//getter & setter
	public String getMainTask() {
		return MainTask;
	} 
	public ArrayList<String> getSubTasks() {
		return SubTasks;	
	} 
	public ArrayList<UserDAO> getGroup() {
		return Group;
	} 
	public void setMainTask(String mainTask) {
		MainTask = mainTask;
	} 
	public void setSubTasks(ArrayList<String> subTasks) {
		SubTasks = subTasks;
	} 
	public void setGroup(ArrayList<UserDAO> group) {
		Group = group;
	} 
	
	
	//add,delete,update subtask
	public int addSubTask(String subtask) {
		SubTasks.add(subtask);
		return 1; //success
	}
	public int updateSubTask(String subtask, String updated) {
		int index = SubTasks.indexOf(subtask);
        SubTasks.remove(index);
        SubTasks.add(updated);
		return 1; //success
	}
	public int deleteSubTask(String subtask){
        SubTasks.remove(subtask);
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
	
	
	//return user names that subtask has
	public String assignedMembersNames(String subtask) {
		String name = "None";
		boolean hasChecked = false;
		for(UserDAO user:Group) { 
			for(String st:user.getTasks()) {
				if(st.equals(subtask) && !hasChecked) {
					name = user.getName();
					hasChecked = true;
				}
				else if(st.equals(subtask) && hasChecked) 
					name += ", " + user.getName();
			}
		}
		return " [" + name + "]";
		//printing: " [John, Peter]" or " [None]"
	}
	
	
	//toString
	public String toString() {
		//printing: "= main task to do <Group: John, Peter, ...>" or "<Group: Empty>"
		String main = "= " + this.MainTask + " <Group: ";
		if(!this.Group.isEmpty()) {
			for(UserDAO member:this.Group) { 
				if(this.Group.indexOf(member)>0) main += ", ";
				main += member.getName();
			}
		} else main += "Empty";
		main += ">";
		
		/* printing: 
		 *     "(\t) * subtask to do [John]"
		 *     "(\t) * subtask to do [Peter]" 
		 *     "(\t) * subtask to do [None]" etc. */
		String subtask = "";
		if(!this.Group.isEmpty()) 
			for(String subts:this.SubTasks) 
				subtask += "\n\t* " + subts + this.assignedMembersNames(subts);
		else for(String subts:this.SubTasks) subtask += "\n\t* " + subts;
		
		return main + subtask;
    }   //should be tested
	
	
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

	
