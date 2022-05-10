import java.util.Scanner;

public class TodoUser {
    public static void toprintLogin(){
        System.out.println("\n***login page***");
        System.out.println("to login, press 1");
        System.out.println("to add user, press 2");
        System.out.println("to exit, press 0\n");
        
    }

    public static void toprintMenu(UserDAO user){
        System.out.println("\n***login page***");
        System.out.println("to logout press 1");
        if(user.getType().equals("0"))
            System.out.println("to edit users press 2");
        // 다른 메뉴 추가
        System.out.println("to exit, press 0\n");
    }

    public static UserDAO toLoginUser(TeamDAO u, Scanner sc){
        System.out.println("*** login user ***");
            System.out.print("user id : ");
            String id = sc.next();
            System.out.print("user password : ");
            String password = sc.next();
            for(UserDAO user : u.getList()){
                if (id.equals(user.getID()) && password.equals(user.getPassword()) ){
                    user.login();
                    return user;
                }
            }
            System.out.println("try again");
            return null;
    }

    public static void toAddUser(TeamDAO u, Scanner sc){
        System.out.println("*** add user ***");
            System.out.print("user id : ");
            String id = sc.next();
            System.out.print("user name : ");
            String name = sc.next();
            String password;
            while(true){
                System.out.print("user password : ");
                password = sc.next();
                if(password.length() < 8)
                    System.out.println("password's length should be longer than 7!");
                else if(!IsAllChar(password))
                    System.out.println("password should have all number, capital and non-capital");
                else break;
            }
            System.out.print("user type (admin 0, normal 1) : ");
            int type = sc.nextInt();
            if(type==1) {
                NormalUser user = new NormalUser(name, id, password, type);
                u.addUser(user);
            }
            else {
                AdminUser user = new AdminUser(name, id, password, type);
                u.addUser(user);
            }
    }

    public static int toLogoutUser(UserDAO user, Scanner sc){
        System.out.println("logout user? (yes = 1, no = 0)");
        int res = sc.nextInt();
        if(res==1) {
            user.logout();
            return 1;
        }
        else System.out.println("logout failed");
        return 0;
    }

    public static boolean IsAllChar(String password){
        int[] havetype = {0, 0, 0}; //number(0), capital(1), non-capital(2)
        for(int i=0; i<password.length(); i++){
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9') havetype[0] = 1;
            else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') havetype[1] = 1;
            else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') havetype[2] = 1;
        }
        for(int i=0; i<3; i++)
            if(havetype[i] == 0) return false;
        return true;
    }
}