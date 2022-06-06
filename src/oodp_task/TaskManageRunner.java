package oodp_task;
import java.util.Scanner;
import oodp_user.*;

public class TaskManageRunner 
{
	private static TaskListDAO taskList;
	private static TaskLogsDAO logs;
	
	public static void run(TeamDAO userList, UserDAO cursor) 
	{
		Scanner sc = new Scanner(System.in);
		taskList = new TaskListDAO();
		logs = new TaskLogsDAO();
		
		//Observer applied
		TaskListView taskView = new TaskListView(taskList);
		MainTaskView mainView = new MainTaskView(taskList);
		
		//attached observers: taskListView, mainTaskView
		taskList.attach(taskView); 
		taskList.attach(mainView);
		
		boolean exitTaskManage = false;
		int taskInput;
		
		
		
		//Test Bench
		TaskDAO task1 = new TaskDAO("Project1. New game with JAVA.");
		TaskDAO task2 = new TaskDAO("Project2. New game with Python.");
		
		SubtaskDAO subtask1 = new SubtaskDAO("Implement a player class", 1);
		SubtaskDAO subtask2 = new SubtaskDAO("Research user datas about the level design", 2);
		SubtaskDAO subtask3 = new SubtaskDAO("Implement an enemy class", 1);
		SubtaskDAO subtask4 = new SubtaskDAO("Design scoreboard screens", 3);
		
		task1.addSubtask(subtask1);
		task1.addSubtask(subtask2);
		task2.addSubtask(subtask3);
		task2.addSubtask(subtask4);
		
		taskList.addTask(task1);
		taskList.addTask(task2);
		// ...test data: task list
		
		
		
		do {
			TodoTaskManage.toprintTaskManageList();
			
			taskInput = Integer.parseInt(sc.nextLine());
			switch(taskInput) {
				case 0: //Quit program
					exitTaskManage = true;
					break;
				case 1: //show task ALL (admin, user)
					TodoTaskManage.toprintTaskALL(taskList);
					break;
				case 2:	//do the task (admin, user)
					TodoTaskManage.todoTask(taskList, logs, sc);
					break;	//updated!!
				case 3: //add main task (admin)
					TodoTaskManage.toaddMainTask(taskList, cursor, sc);
					break;
				case 4: //add subtask (admin, user)
					TodoTaskManage.toaddSubTask(taskList, sc);
					break;
				case 5: //add member to subtask (admin, user) - later
				    TodoTaskManage.toassignMembertoTask(taskList, userList, cursor, sc);
				    break;
				default: //input error, retry an entry. 
            		System.out.println("Error: Invalid input. Please try again.");
            		break;
			}
			
		} while(!exitTaskManage);
		
	}
}
