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
		
		boolean exitTaskManage = false;
		int taskInput;
		
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
					TodoTaskManage.toaddMainTask(taskList, cursor);
					break;
				case 3: //add subtask (admin, user)
					TodoTaskManage.toaddSubTask(taskList);
					break;
				
				case 4: //add member to subtask (admin, user) - later
				    TodoTaskManage.toassignMembertoTask(taskList, userList, cursor);
				    break;
				
				default: //input error, retry an entry. 
            		System.out.println("Error: Invalid input. Please try again.");
            		break;
			}
			
		} while(!exitTaskManage);
		
	}
	
	/*
	public static void main(String[] args) {
		TaskManageRunner taskRun = new TaskManageRunner();
		taskRun.run();
	} */

}
