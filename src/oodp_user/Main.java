package oodp_user;
import java.util.Scanner;

import oodp_meetRecord.recordMain;
import oodp_meetSchedule.scheduleMain;
import oodp_notice.NoticeRunner;
import oodp_reservation.MeetingRoomRunner;
import oodp_task.TaskManageRunner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TeamDAO UserList = new TeamDAO();
        int input;
        UserDAO curuser = null;
        TodoUser.loadList(UserList, "user.txt");
        int loginexit = 1;
        int userexit = 1;

        //login page
        while(loginexit==1){
            TodoUser.toprintLogin();
            input = sc.nextInt();
            switch (input){
                case 0 : loginexit=0;
                         userexit=0;
                         break;
                case 1 : curuser = TodoUser.toLoginUser(UserList, sc);
                         loginexit=0;
                         break; //login
                case 2 : TodoUser.toAddUser(UserList, sc); //adduser
                         break;
                default : System.out.println("Non-correct answer!");
                         break;
            }
        }

        //user page    
        while(userexit==1 && curuser != null) { //대상 유저가 정해졌을때 (로그인됨)
            TodoUser.toprintMenu(curuser);
            input = sc.nextInt();
            switch (input){
                case 0 : userexit = 0;
                         break;
                case 1 : TodoUser.toLogoutUser(curuser, sc);
                         userexit = 0;
                         break;
                case 2 : if(curuser.getType().equals("0")){
                            System.out.println("\n\n***Show current userlist***\n");
                            System.out.println(UserList.toString());
                          }
                         break;
                //case n : 다른 활동
                case 3 : recordMain.start();
                         break;
                case 4 : recordMain.start();
                         break;
                case 5 : scheduleMain.run();
                         break;
                case 6 : NoticeRunner.main(args);
                         break;
                case 7 : MeetingRoomRunner.main(args);
                         break;
                case 8 : TaskManageRunner.run(UserList, curuser);
                          break;
                case 9 : TodoUser.toAttandUser(curuser, sc);
                          break;
                case 10 : TodoUser.toAbsentUser(curuser, sc);
                            break;
                default : System.out.println("\nwrong answer.\n");
                          break;
            }
        }
        sc.close();
        TodoUser.saveList(UserList, "user.txt");
        System.out.println("System exit! bye!");
    }
}