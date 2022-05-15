import java.util.Scanner;
import meetrecord.recordMain;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TeamDAO UserList = new TeamDAO();
        int input;
        UserDAO curuser = null;
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
                case 1 : if(TodoUser.toLogoutUser(curuser, sc) == 1){
                         userexit = 0;
                         break;
                         }
                case 2 : if(curuser.getType().equals("0")){
                            TodoUser.toEditUser(UserList, sc);
                          }
                         break;
                case 3 : recordMain.start();
                        break;
            }
        }
        sc.close();
        System.out.println("System exit! bye!");
    }
}
