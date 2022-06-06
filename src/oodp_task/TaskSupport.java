package oodp_task;

public abstract class TaskSupport 
{
	private String name;
	private TaskSupport next;
	private TaskTypes taskType;
	
	//Constructors
	public TaskSupport(String name) {
		this.setName(name);
	}
	public TaskSupport(String name, int type) {
		this.setName(name);
		this.setTaskType(type);
	}
	
	
	/* major feature set of COR pattern */
	public TaskSupport setNext(TaskSupport next) {
		this.next = next;
		return next;
	}	// 1.setNext
	public final void support(SubtaskDAO subtask, TaskLogsDAO logs) {
		if(resolve(subtask)) done(subtask, logs);
		else if(next != null) next.support(subtask, logs);
		else fail(subtask);
	}	// 2.support
	
	/* features in "support": resolve, done, fail */
	protected abstract boolean resolve(SubtaskDAO subtask);
	protected void done(SubtaskDAO subtask, TaskLogsDAO logs) {
		System.out.println(subtask.getTaskName() + "was done.");
	}	//just selected(will do various feature in extended class)
	protected void fail(SubtaskDAO subtask) {
		System.out.println("Remain task: " + subtask.getTaskName());
	}
	
	
	//get & set
	public TaskTypes getTaskType() {
		return taskType;
	}
	public void setTaskType(int type) {
		this.taskType = TaskTypes.setTypeByNum(type);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
