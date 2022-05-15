package oodp_task;
import java.util.Scanner;
import oodp_user.*;


public class TodoTaskManage 
{
	public static void toprintTaskManageList() {
		System.out.println("\n*** Task Manage List ***");
		System.out.println("0. Return to Manage Menu");
        System.out.println("1. Check entire task list");
        System.out.println("2. Add main task");
        System.out.println("3. Add sub task");
        System.out.println("4. Assign group member to task\n");
        System.out.print(">> ");
	} 
	
	public static void toprintTaskALL(TaskListDAO taskList) {
		if(!taskList.isEmpty()) {
			System.out.println("\n*** List up Tasks ALL ***");
		    taskList.listALL();
		}	//TODO: will be observer
		else System.out.println("\nThere's no TASK to do yet.");
	} //Authorization - all
	
	public static void toaddMainTask(TaskListDAO taskList, UserDAO cursor) {
		Scanner sc = new Scanner(System.in);
		
		if(cursor.getType()==0) { //type: 0 == admin, 1 == user
	        System.out.println("*** Please enter main task to add below ***");
	        System.out.print("New Task >> ");
	        String maintask = sc.nextLine();
	        TaskDAO task = new TaskDAO(maintask);
	        
	        System.out.println("New task is added!!");
	        System.out.println(task.toString() + " - new!!"); //TODO: will be observer
	        taskList.addTask(task);
		}
		else System.out.println("You are not able to add a main task.");
	} //Authorization - administrator only
	
	public static void toaddSubTask(TaskListDAO taskList) {
		Scanner sc = new Scanner(System.in);
		
		int input, taskIdx = 1;
		TaskDAO maintask = new TaskDAO("");
		String subtask;
		
		if(!taskList.isEmpty()) {
			//TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
			System.out.println("*** Please choose main task to add subtask ***");
			for(TaskDAO task:taskList.getList()) {
				System.out.println(taskIdx + ". " + task.getMainTask());
				taskIdx++; //taskIdx: start from 1
			}
			
			taskIdx--;
			System.out.println("Enter a number of main task.");
	        System.out.print("(Range: " + "1 ~ " + taskIdx + ", 0: Quit) >> ");
			input = (Integer.parseInt(sc.nextLine()) - 1); //shown index - 1 == real index
			
			for(TaskDAO task:taskList.getList())
				if(input == taskList.getList().indexOf(task)) 
					maintask = taskList.getList().get(input);
			
	        System.out.println("*** Please enter subtask to add below ***");
	        System.out.print("New subtask >> ");
	        subtask = sc.nextLine();
	        maintask.addSubTask(subtask);
	        
	        System.out.println("New subtask is added!!");
	        System.out.println(maintask.toString() + " - new!!"); //TODO: will be observer
		}
		else System.out.println("\nThere's no MAINTASK to add subtask.");
	} //Authorization - all
	
	
	public static void toassignMembertoTask(TaskListDAO taskList, TeamDAO userList, UserDAO user) 
	{	
		Scanner sc = new Scanner(System.in);
		int input, taskIdx = 1, stIdx = 1, userIdx = -1;
		TaskDAO chosenTask = new TaskDAO();
		String chosenSubTask = "";
		
		//Authorizing - 0: admin, 1: user
		if(user.getType()==0 && (!taskList.isEmpty())) {
			//TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
			System.out.println("*** Please choose main task to assign member ***");
			//TODO: will be observer
	        for(TaskDAO task:taskList.getList()) {
				System.out.println(taskIdx + ". " + task.getMainTask());
				taskIdx++; //taskIdx: start from 1
			}
	        
	        taskIdx--;
	        System.out.println("Enter a number of main task.");
	        System.out.print("(Range: " + "1 ~ " + taskIdx + ", 0: Quit) >> ");
	        input = (Integer.parseInt(sc.nextLine()) - 1); //shown index - 1 == real index
	        
	        for(TaskDAO task:taskList.getList()) { 		   //search the chosen main task 
	        	if(input == taskList.getList().indexOf(task)) {
	        		System.out.println("Chosen Task: " + task.getMainTask());
	        		System.out.println("*** Please Choose a subtask to assign new member ***");
	        		chosenTask = task;			   		   //save the chosen main task
	        		for(String st:task.getSubTasks()) {    //show subtasks of the chosen main task
	        			System.out.println(stIdx + ". " + st);
	        			stIdx++; //stIdx: start from 1
	        		}
	        		stIdx--;
	        	}	
	        }
	        
	        //TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
	        System.out.println("Choose a subtask to assign new member.");
	        System.out.print("(Range: " + "1 ~ " + stIdx + ", 0: Quit) >> ");
	        input = (Integer.parseInt(sc.nextLine())-1); //shown index - 1 == real index
	        
	        for(String st:chosenTask.getSubTasks()) { //search the chosen subtask
	        	if(input == chosenTask.getSubTasks().indexOf(st)) {
	        		chosenSubTask = st;               //save index of the chosen subtask
	        		System.out.println("Chosen Subtask: " + chosenSubTask); //show chosen subtask
	        	}
	        }
	        
	        //TODO: add 'q: Quit' by 'do-while' (return to Task Menu) & input Error check
	        System.out.println("Enter the New Member to add >> ");
	        String inputName = sc.nextLine();
	        
	        for(UserDAO us:userList.getList()) //userIdx: initialized by '-1' 
	        	if(inputName.equals(us.getName())) userIdx = userList.indexOf(us);
	        	//if input name was found: Always userIdx >= 0
	        
	        if(userIdx>=0) { //when input name is exist
	        	userList.getList().get(userIdx).addTask(chosenSubTask);
	        	if(!chosenTask.isDuplicated(inputName)) 
	        		chosenTask.addMember(userList.getList().get(userIdx));
	        	System.out.println("New member: " + inputName +" is successfully added!");
	        }   //TODO: will be observer
	        else System.out.println("Error: " + inputName + " is NOT EXIST."); //when input name is not exist.
		} 
		else if(user.getType()==0 && taskList.isEmpty()) //when tasks are not exist.
			System.out.println("\nThere's no MAINTASK to add a member.");
		else System.out.println("You are not able to add a member to the task."); //normal user
	} //Authorization - administrator only
	
	
}



