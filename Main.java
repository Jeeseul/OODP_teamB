import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        UserDAO UserList = new UserDAO();
        Scanner sc = new Scanner(System.in);
        int input;

        while(true){
            TodoUser.toprintMenu();
            input = sc.nextInt();
            switch (input){
                case 0 : break;
                case 1 : TodoUser.toAddUser();
                case 2 : TodoUser.toLoginUser();
                case 3 : TodoUser.toLogoutUser();
            }
        }
    }
}
