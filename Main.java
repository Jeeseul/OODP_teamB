import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        UserListDAO UserList = new UserListDAO();
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
            TodoUser.toprintMenu();
            input = sc.nextInt();
            switch (input){
                case 0 : userexit = 0;
                         break;
                case 1 : TodoUser.toLogoutUser(curuser, sc);
                         userexit = 0;
                         break;
                //case n : 다른 활동
            }
        }
        sc.close();
        System.out.println("System exit! bye!");
    }
}
