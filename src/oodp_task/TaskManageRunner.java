package oodp_task;
import java.util.Scanner;
import oodp_user.*;

public class TaskManageRunner 
{
	private TaskListDAO taskList;
	
	public void run(TeamDAO userList, UserDAO cursor) 
	{
		Scanner sc = new Scanner(System.in);
		taskList = new TaskListDAO();
		
		//Observer pattern
		TaskListView taskView = new TaskListView(taskList.getList());
		//MainTaskView mainView = new MainTaskView(taskList.getList());
		
		taskList.attach(taskView); 
		//taskList.attach(mainView);
		
		boolean exitTaskManage = false;
		int taskInput;
		
		
		
		//Test Bench
		TaskDAO task1 = new TaskDAO("Project1. New game with JAVA.");
		TaskDAO task2 = new TaskDAO("Project2. New game with Python.");
		
		SubtaskDAO subtask1 = new SubtaskDAO("Implement a player class", 1);
		SubtaskDAO subtask2 = new SubtaskDAO("add a level design to Stage class", 2);
		SubtaskDAO subtask3 = new SubtaskDAO("Implement an enemy class", 1);
		SubtaskDAO subtask4 = new SubtaskDAO("Implement scoreboard screens by observers", 3);
		
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
				case 2: //add main task (admin)
					TodoTaskManage.toaddMainTask(taskList, cursor, sc);
					break;
				case 3: //add subtask (admin, user)
					TodoTaskManage.toaddSubTask(taskList, sc);
					break;
				case 4: //add member to subtask (admin, user) - later
				    TodoTaskManage.toassignMembertoTask(taskList, userList, cursor, sc);
				    break;
				default: //input error, retry an entry. 
            		System.out.println("Error: Invalid input. Please try again.");
            		break;
			}
			
		} while(!exitTaskManage);
		
	}
}
