import java.util.Scanner;

public class TodoUser {
    public static void toprintMenu(){
        System.out.println("***login page***");
        System.out.println("to login, press 1");
        System.out.println("to add user, press 2");
        System.out.println("to exit, press 0");
    }

    public static void toAddUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*** add user ***");
            System.out.print("user id : ");
            String id = sc.next();
            System.out.print("user password : ");
            String password = sc.next();
            int res;
            for(UserDAO User : User.getList()){
                if (id.equals(User.getID() && password.equals(User.getPassword()){
                    res = User.login();
                    break;
                }
            }
            if(res==0) System.out.println("try again");
    }

    public static void toLoginUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*** add user ***");
            System.out.print("user id : ");
            String id = sc.next();
            System.out.print("user name : ");
            String name = sc.next();
            System.out.print("user password : ");
            String password = sc.next();
            System.out.print("user type (admin 0, normal 1) : ");
            int type = sc.nextInt();
            User user = new User(name, password, id, type);
            UserList.addUser(user);
    }

    public static void toLogoutUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("logout user? (yes = 1, no = 0)");
        int res = sc.nextInt();
        if(res==1) User.logout(user);
        else System.out.println("logout failed");
        
    }
}