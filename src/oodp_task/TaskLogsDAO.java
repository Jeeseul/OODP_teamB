package oodp_task;

import java.util.ArrayList;

public class TaskLogsDAO 
{
	//a list of done(passed) tasks
	private static ArrayList<ArrayList<TaskDAO>> taskLogs;

	//constructor
	public TaskLogsDAO() {
		TaskLogsDAO.taskLogs = new ArrayList<ArrayList<TaskDAO>>();
		for(int i=0; i<4; i++) TaskLogsDAO.taskLogs.add(new ArrayList<TaskDAO>());
	}
	
	//save logs - add by type(only for subtask)
	public int saveLog(SubtaskDAO task) {
		TaskLogsDAO.taskLogs.get(task.getTaskType().ordinal()).add(task);
		return 1;
	}
	//delete a specific log
	public int deleteLog(SubtaskDAO task) {
		TaskLogsDAO.taskLogs.get(task.getTaskType().ordinal()).remove(task);
		return 1;
	}
	//clear entire logs
	public int clearLog() {
		TaskLogsDAO.taskLogs.clear();
		return 1;
	}
	
	//get & set
	public static ArrayList<ArrayList<TaskDAO>> getTaskLogs() {
		return taskLogs;
	}
	public static void setTaskLogs(ArrayList<ArrayList<TaskDAO>> doneTasks) {
		TaskLogsDAO.taskLogs = doneTasks;
	}
}
