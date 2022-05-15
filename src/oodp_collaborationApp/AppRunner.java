package oodp_collaborationApp;

import oodp_task.*;
import oodp_notice.*;
import oodp_reservation.*;
import oodp_user.*;
import java.util.Scanner;


public class AppRunner 
{
	public void run() 
	{
		Scanner sc = new Scanner(System.in);
		
        TeamDAO userList = new TeamDAO();
        TaskManageRunner taskRun = new TaskManageRunner();
        NoticeRunner noticeRun = new NoticeRunner();
        MeetingRoomRunner meetingroomRun = new MeetingRoomRunner();
        
        UserDAO cursor = null;
        
        boolean appExit = true;
        boolean loginExit = true;
        boolean userExit = true;
        boolean quitTheRunner = false;
		
        int runInput;
        int loginInput;
        
        //Test Data - user account
        AdminUser user1 = new AdminUser("John", "admin00", "1001234", 0);
        AdminUser user2 = new AdminUser("Jake", "admin01", "2001234", 0);
        NormalUser user3 = new NormalUser("Hadaf", "zetq516", "3001234", 1);
        NormalUser user4 = new NormalUser("Simon", "fish153", "4001234", 1);
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        
        do {
        	//FrontPage
        	TodoAppRunner.toprintFrontPage();
            runInput = Integer.parseInt(sc.nextLine());
            
            switch(runInput) {
            	case 0: //Exit Program 
            		quitTheRunner = true;
            		break;
            	case 1: 
            		loginExit = false;
            		break;
            	default: //input error, retry an entry. 
            		System.out.println("Error: Invalid input. Please try again.");
            		break;
            }
            
            //login page
            while(!loginExit) {
                TodoUser.toprintLogin();
                loginInput = Integer.parseInt(sc.nextLine());
                switch (loginInput) {
                    case 0: //quit loginPage
                    	loginExit = true;
                        userExit = true;
                        break;
                    case 1: //login
                    	cursor = TodoUser.toLoginUser(userList, sc);
                        loginExit = true;
                        userExit = false;
                        break; 
                    case 2: //add user
                    	TodoUser.toAddUser(userList, sc); 
                        break;
                    default: //input error, retry an entry.
                    	System.out.println("Error: Invalid input. Please try again.");
                		break;
                }
            }
            
            //user page    
            while((!userExit) && cursor != null) { //cursor == login user
                TodoUser.toprintMenu(userList);
                loginInput = Integer.parseInt(sc.nextLine());
                switch (loginInput) {
                    case 0: //quit program
                    	userExit = true;
                    	appExit = true;
                    	cursor = null;
                    	System.out.println("Return to FrontPage.");
                        break;
                    case 1: //logout
                    	TodoUser.toLogoutUser(cursor, sc);
                    	if(cursor.getLogincheck().equals("0")) cursor = null;
                        userExit = true;
                        appExit = true;
                        break;
                    case 2: //proceed program
                    	userExit = true;
                    	appExit = false;
                    	break;
                    default: //input error, retry an entry.
                    	System.out.println("Error: Invalid input. Please try again.");
                		break;
                }
            }
            
            //main page
            while(!appExit) {
            	TodoAppRunner.toprintMainPage();
            	runInput= Integer.parseInt(sc.nextLine());
                switch(runInput) {
                	case 0: //Exit Program 
                		appExit = true;
                		cursor = null;
                		break;
                	case 1: //notice
                		noticeRun.run();
                		break;
                	case 2: //task
                		taskRun.run(userList, cursor);
                		break;
                	case 3: //meeting room
                		meetingroomRun.run();
                		break;
                	case 4: //logout
                		TodoUser.toLogoutUser(cursor, sc);
                    	if(cursor.getLogincheck().equals("0")) cursor = null;
                        appExit = true;
                        break;
                	default: //input error. retry entry. 
                		System.out.println("Error: Invalid input. Please try again."); 
                		break;
                }
            }
        } while(!quitTheRunner);
        
        sc.close();
        TodoAppRunner.toExitApp();
	}
	
	public static void main(String[] args) {
		AppRunner runner = new AppRunner();
		runner.run();
	}

}
