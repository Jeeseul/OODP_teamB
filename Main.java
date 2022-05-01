import java.util.*;

public class Main{
    public static void main(String[] args){
        //add two admin, two normal user
        User admin1 = new User("admin1", "pw1", "id1", 1);
        User admin2 = new User("admin2", "pw2", "id2", 1);
        User user1 = new User("user1", "pw3", "id3", 0);
        User user2 = new User("user2", "pw4", "id4", 0);

        //login
        admin1.login();
        admin2.login();
        user1.login();
        user2.login();

        //print login user 
        System.out.println("***login user***");
        if(admin1.getLogincheck() == 1)
            System.out.print(admin1.toString());
        if(admin2.getLogincheck() == 1)
            System.out.print(admin2.toString());
        if(user1.getLogincheck() == 1)
            System.out.print(user1.toString());
        if(user2.getLogincheck() == 1)
            System.out.print(user2.toString());
        System.out.println("****************\n");

        //logout admin2, user2
        admin2.logout();
        user2.logout();

        //print login user 
        System.out.println("***login user***");
        if(admin1.getLogincheck() == 1)
            System.out.print(admin1.toString());
        if(admin2.getLogincheck() == 1)
            System.out.print(admin2.toString());
        if(user1.getLogincheck() == 1)
            System.out.print(user1.toString());
        if(user2.getLogincheck() == 1)
            System.out.print(user2.toString());
        System.out.println("****************");
    }
}

