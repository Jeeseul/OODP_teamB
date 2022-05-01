import java.util.Scanner;

public class TodoUser {
    public static void toprintLogin(){
        System.out.println("\n***login page***");
        System.out.println("to login, press 1");
        System.out.println("to add user, press 2");
        System.out.println("to exit, press 0\n");
    }

    public static void toprintMenu(){
        System.out.println("\n***login page***");
        System.out.println("to logout press 1");
        // 다른 메뉴 추가
        System.out.println("to exit, press 0\n");
    }

    public static UserDAO toLoginUser(UserListDAO u){
        Scanner sc = new Scanner(System.in);
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

    public static void toAddUser(UserListDAO u){
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
            UserDAO user = new UserDAO(name, id, password, type);
            System.out.println(user.toString());
            u.addUser(user);
    }

    public static void toLogoutUser(UserDAO user){
        Scanner sc = new Scanner(System.in);
        System.out.println("logout user? (yes = 1, no = 0)");
        int res = sc.nextInt();
        if(res==1) user.logout();
        else System.out.println("logout failed");
        
    }
}