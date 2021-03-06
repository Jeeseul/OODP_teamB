package oodp_collaborationApp;

import oodp_task.*;
import oodp_notice.*;
import oodp_reservation.*;
import oodp_user.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;
import oodp_meetRecord.*;
import oodp_meetSchedule.scheduleDAO;
import oodp_meetSchedule.scheduleList;
import oodp_meetSchedule.scheduleMain;
import oodp_meetSchedule.scheduleRecord;


public class AppRunner 
{
	public void run() 
	{
		Scanner sc = new Scanner(System.in);
		
        TeamDAO userList = new TeamDAO();
        TaskManageRunner taskRun = new TaskManageRunner();
        NoticeRunner noticeRun = new NoticeRunner();
        MeetingRoomRunner meetingroomRun = new MeetingRoomRunner();
        //This is just ininialization
        NoticeDAO previousIteration = new NoticeDAO();
        NoticeReadChecker nReadChecker;
        
        UserDAO cursor = null;
        
        boolean appExit = true;
        boolean loginExit = true;
        boolean userExit = true;
        boolean quitTheRunner = false;
		
        int runInput;
        int loginInput;
        int checkInterationCount = 0;

        //Test Data - user account
        AdminUser user1 = new AdminUser("John", "admin00", "Ad!1q2w3e", 0);
        AdminUser user2 = new AdminUser("Jake", "admin01", "Ad@4r5t6y", 0);
        AdminUser user3 = new AdminUser("Jane", "admin02", "Ad#123qwe", 0);
        NormalUser user4 = new NormalUser("Hadaf", "zetq516", "Ur!psalm516", 1);
        NormalUser user5 = new NormalUser("Simon", "fish153", "Ur@unrchd1040", 1);
        NormalUser user6 = new NormalUser("David", "luv82bty", "Ur#Jeru8291", 1);
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);
        userList.addUser(user6);
        userList.setTeamName("test1");
        // Initialize the NoticeReadChecker
        nReadChecker = new NoticeReadChecker(userList);

        
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
                TodoUser.toprintMenu(cursor);
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
                    case 3: //edit user - only administrator
                    	if(cursor.getType().equals("0")) {
                            System.out.println("\n\n***Show current userlist***\n");
                            System.out.println(userList.toString());
                            //TODO: add an "edit User" feature later
                        } else {
                    		System.out.println("Sorry. You are not able to edit users."); 
                    	}
                    	System.out.println("Return to User page.");	
                    	break;
                    default: //input error, retry an entry.
                    	System.out.println("Error: Invalid input. Please try again.");
                		break;
                }
            }
            
            //main page
            while(!appExit) {
            	TodoAppRunner.toprintMainPage();
            	//????????? schedule list ?????? ??????????????? ?????? 
            	LocalDate now = LocalDate.now();
            	File file1 = new File("./Schedulelist.txt");
                if (file1.exists()) {
                	System.out.println("===You have meet schedule! Let's check :)===");
                	scheduleList l = new scheduleList();
                	scheduleRecord.loadList(l, "Schedulelist.txt");
                	int count =0;
                	l.sortByDate();
                	//?????? ?????? ???????????? ????????? ?????? 
                	for(scheduleDAO one : l.getList()) {
                		if(one.getDue_date().toLocalDate().equals(now)) {
                			System.out.println(++count + " - "+one.toString());
                		}
                	}
                	if(count>0)System.out.print("=====Remind today's meeting!=====\n\nSelect the menu number : ");
                	else System.out.print("==You don't have meeting today! Have a good day~==\n\nSelect the menu number : ");
                }
            	
            	
            	runInput= Integer.parseInt(sc.nextLine());
                switch(runInput) {
                	case 0: //Exit Program 
                		appExit = true;
                		cursor = null;
                		break;
                	case 1: //notice
                        if(checkInterationCount <= 0){
                            noticeRun.run(userList.getTeamName(), userList, cursor, nReadChecker);
                            previousIteration = noticeRun.getNoticeDAO();
                            break;
                        }
                        else{
                            noticeRun.run(userList.getTeamName(), userList, cursor, nReadChecker, previousIteration);
                            break;
                        }
                	case 2: //task
                		taskRun.run(userList, cursor);
                		break;
                	case 3: //meeting room
                		meetingroomRun.run();
                		break;
                	case 4: //meeting record
                        recordMain.start();
                        break;
                	case 5: //meeting schedule record and manage
                        scheduleMain.run();
                        break;
                	case 6: //logout
                		TodoUser.toLogoutUser(cursor, sc);
                    	if(cursor.getLogincheck().equals("0")) cursor = null;
                        appExit = true;
                        break;
                	default: //input error. retry entry. 
                		System.out.println("Error: Invalid input. Please try again."); 
                		break;
                }
                checkInterationCount++;
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
