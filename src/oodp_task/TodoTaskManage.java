package oodp_task;
import java.util.Scanner;
import oodp_user.*;


public class TodoTaskManage 
{
	public static void toprintTaskManageList() {
		System.out.println("\n*** Task Manage List ***");
		System.out.println("0. Return to Manage Menu");
        System.out.println("1. Check entire task list");
        System.out.println("2. Do the task");	//updated!!
        System.out.println("3. Add main task");
        System.out.println("4. Add sub task");
        System.out.println("5. Assign group member to task\n");
        System.out.print(">> ");
	} 
	
	
	//TODO: to apply strategy 
	public static void toprintTaskALL(TaskListDAO taskList) {
		if(!taskList.isEmpty()) {
			System.out.println("\n*** List up Tasks ALL ***");
		    taskList.listALL();
		}	
		else System.out.println("\nThere's no TASK to do yet.");
	} //Authorization - all
	
	
	
	public static void toaddMainTask(TaskListDAO taskList, UserDAO cursor, Scanner sc) {
		sc = new Scanner(System.in);
		
		if(cursor.getType().equals("0")) { //type: 0 == admin, 1 == user
	        System.out.println("*** Please enter main task to add below ***");
	        System.out.print("New Task >> ");
	        String maintask = sc.nextLine();
	        TaskDAO task = new TaskDAO(maintask);
	        taskList.addTask(task); //applied observers by "notifyingObservers"
		}
		else System.out.println("You are not able to add a main task.");
	} //Authorization - administrator only
	
	
	
	public static void toaddSubTask(TaskListDAO taskList, Scanner sc) {
		sc = new Scanner(System.in);
		
		int input, taskIdx = 1;
		TaskDAO maintask = new TaskDAO("");
		
		int taskType;
		String subtaskName;
		SubtaskDAO subtask;
		
		if(!taskList.isEmpty()) {
			//TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
			System.out.println("*** Please choose main task to add subtask ***");
			for(TaskDAO task:taskList.getList()) {
				System.out.println(taskIdx + ". " + task.getTaskName());
				taskIdx++; //taskIdx: start from 1
			}
			
			taskIdx--;
			System.out.println("Enter a number of main task.");
	        System.out.print("(Range: " + "1 ~ " + taskIdx + ", 0: Quit) >> ");
			input = (Integer.parseInt(sc.nextLine()) - 1); //shown index - 1 == real index
			
			for(TaskDAO task:taskList.getList())
				if(input == taskList.getList().indexOf(task)) 
					maintask = taskList.getList().get(input);
			
			System.out.println("*** Please select task type of new subtask ***");
			System.out.println("(1.DEVELOP / 2.RESEARCH / 3.DESIGN / 4.FEEDBACK / 0: Quit)");
			System.out.print("Type >> ");
			taskType = Integer.parseInt(sc.nextLine());
			if(!(taskType>0 && taskType<5)) {
				System.out.println("Error: Out of Range. try again");
				//TODO: make error check
			}
	        System.out.println("*** Please enter subtask to add below ***");
	        System.out.print("New subtask >> ");
	        subtaskName = sc.nextLine();
	        subtask = new SubtaskDAO(subtaskName, taskType);
	        taskList.addSubTask(maintask, subtask);
	        
	        System.out.println("New subtask is added!!");
	        System.out.println(maintask.toString() + " - new!!"); 
	        //TODO: will be observer - SubtaskView
		}
		else System.out.println("\nThere's no MAINTASK to add subtask.");
	} //Authorization - all
	
	
	
	public static void toassignMembertoTask(TaskListDAO taskList, TeamDAO userList, UserDAO user, Scanner sc) 
	{	
		sc = new Scanner(System.in);
		int input, taskIdx = 1, stIdx = 1, userIdx = -1;
		TaskDAO chosenTask = new TaskDAO();
		SubtaskDAO chosenSubtask = new SubtaskDAO();
		
		//Authorizing - 0: admin, 1: user
		if(user.getType().equals("0") && (!taskList.isEmpty())) {
			//TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
			System.out.println("*** Please choose a main task to assign member ***");
	        taskIdx = TodoTaskManage.numberingTasks(taskList);
	        
	        System.out.println("Enter a number of main task.");
	        System.out.print("(Range: " + "1 ~ " + taskIdx + ", 0: Quit) >> ");
	        input = (Integer.parseInt(sc.nextLine()) - 1); //shown index - 1 == real index
	        
	        for(TaskDAO task:taskList.getList()) { 		   //search the chosen main task 
	        	if(input == taskList.getList().indexOf(task)) {
	        		System.out.println("Chosen Task: " + task.getTaskName());
	        		System.out.println("*** Please Choose a subtask to assign new member ***");
	        		chosenTask = task;			   		   //save the chosen main task
	        	}
	        }
	        stIdx = TodoTaskManage.numberingTasks(chosenTask);
	        
	        //TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
	        System.out.println("Choose a subtask to assign new member.");
	        System.out.print("(Range: " + "1 ~ " + stIdx + ", 0: Quit) >> ");
	        input = (Integer.parseInt(sc.nextLine())-1);  //shown index - 1 == real index
	        
	        for(SubtaskDAO st:chosenTask.getSubtasks()) { //search the chosen subtask
	        	if(input == chosenTask.getSubtasks().indexOf(st)) {
	        		chosenSubtask = st;               	  //save the chosen subtask
	        		System.out.println("Chosen Subtask: " + chosenSubtask.getTaskName()); //show chosen subtask
	        	}
	        }
	        
	        //TODO: add 'q: Quit' by 'do-while' (return to Task Menu) & input Error check
	        System.out.println("Enter the New Member to add >> ");
	        String inputName = sc.nextLine();
	        
	        for(UserDAO us:userList.getList()) //userIdx: initialized by '-1' 
	        	if(inputName.equals(us.getName())) userIdx = userList.indexOf(us);
	        	//if input name was found: Always userIdx >= 0
	        
	        if(userIdx>=0) { //when input name is exist
	        	taskList.assignTask(chosenTask, chosenSubtask, userList.getList().get(userIdx));
	        	System.out.println("New member: " + inputName +" is successfully added!");
	        }   //TODO: will be observer
	        else System.out.println("Error: " + inputName + " is NOT EXIST."); //when input name is not exist.
		} 
		else if(user.getType().equals("0") && taskList.isEmpty()) //when tasks are not exist.
			System.out.println("\nThere's no MAINTASK to add a member.");
		else System.out.println("You are not able to add a member to the task."); //normal user
	} //Authorization - administrator only
	
	
	
	public static void todoTask(TaskListDAO taskList, TaskLogsDAO logs, Scanner sc) {
		sc = new Scanner(System.in);
		int input, taskIdx = 1;
		
		//COP applied
		TypeSupport doDevelop = new TypeSupport("dev", 1);
		TypeSupport doResearch = new TypeSupport("sch", 2);
		TypeSupport doDesign = new TypeSupport("dsn", 3);
		TypeSupport doFeedback = new TypeSupport("fdb", 4);
		
		//chained feature of COP
		doDevelop.setNext(doResearch).setNext(doDesign).setNext(doFeedback);	
		
		//TODO: add '0: Quit' by 'do-while' (return to Task Menu) & input Error check
		if(!taskList.isEmpty()) {
			System.out.println("*** Please choose main task to do ***");
			taskIdx = TodoTaskManage.numberingTasks(taskList);
			
			System.out.println("Enter a number of main task.");
	        System.out.print("(Range: " + "1 ~ " + taskIdx + ", 0: Quit) >> ");
			input = (Integer.parseInt(sc.nextLine()) - 1); //shown index - 1 == real index
			
			for(SubtaskDAO subtask:taskList.getList().get(input).getSubtasks())
			    doDevelop.support(subtask, logs); 
		} else System.out.println("\nThere's no MAINTASK to do.");
	}

	
	
	//numbering tasks: 1. main tasks 2. subtasks
	public static int numberingTasks(TaskListDAO taskList) {
		int idx = 1;
		//show tasks of the task list
		for(TaskDAO task:taskList.getList()) {
			System.out.println(idx + ". " + task.getTaskName());
			idx++; //start from 1
		}
		return (idx-1);
	}
	public static int numberingTasks(TaskDAO task) {
		int idx = 1;
		//show subtasks of the main task
		for(SubtaskDAO st:task.getSubtasks()) {    
			System.out.println(idx + ". " + st.getTaskName());
			idx++; //start from 1
		}
		return (idx-1);
	}
}



