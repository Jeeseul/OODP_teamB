package oodp_user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TodoUser {
    public static void toprintLogin(){
        System.out.println("\n*** [login page] ***");
        System.out.println("to login, press 1");
        System.out.println("to add user, press 2");
        System.out.println("to exit, press 0\n");
    }

    //changed
    public static void toprintMenu(UserDAO user) {
    	if(user.getType().equals("0"))
    		System.out.println("\n*** login succeed! Welcome, [Admin] " 
    				+ user.getName() + " ***");
    	else 
    		System.out.println("\n*** login succeed! Welcome, [User] " 
    				+ user.getName() + " ***" );
        System.out.println("to logout press 1");
        // 다른 메뉴 추가
        System.out.println("to continue, press 2");
        if(user.getType().equals("0"))
            System.out.println("to edit users, press 3");
                System.out.println("to meetRedord 4");
        System.out.println("to meetSchedule 5");
        System.out.println("to notice 6");
        System.out.println("to reservation 7");
        System.out.println("to task 8");
        System.out.println("to exit, press 0\n");
    }

    public static UserDAO toLoginUser(TeamDAO u, Scanner sc){
        System.out.println("*** login user ***");
        sc.nextLine();
            System.out.print("user id : ");
            String id = sc.nextLine();
            System.out.print("user password : ");
            String password = sc.nextLine();
            for(UserDAO user : u.getList()){
                if (id.equals(user.getID()) && password.equals(user.getPassword())){
                    user.login();
                    return user;
                }
            }
            System.out.println("try again");
            return null;
    }

    public static void toAddUser(TeamDAO u, Scanner sc){
        System.out.println("*** add user ***");
            sc.nextLine();
            System.out.print("user id : ");
            String id = sc.nextLine();
            System.out.print("user name : ");
            String name = sc.nextLine();
            String password;
            while(true){
                System.out.print("user password : ");
                password = sc.nextLine();
                if(password.length() < 8)
                    System.out.println("password's length should be longer than 7!");
                else if(!IsAllChar(password))
                    System.out.println("password should have all number, capital and non-capital");
                else break;
            }
            System.out.print("user type (admin 0, normal 1) : ");
            int type = Integer.parseInt(sc.nextLine());
            if(type==1) {
                NormalUser user = new NormalUser(name, id, password, type);
                u.addUser(user);
            }
            else {
                AdminUser user = new AdminUser(name, id, password, type);
                u.addUser(user);
            }
    }

    public static void toLogoutUser(UserDAO user, Scanner sc){
        System.out.println("Do you want to log out now? (yes = 1, no = 0)");
        int res = Integer.parseInt(sc.nextLine());
        if(res==1) user.logout();
        else System.out.println("logout failed");
    }
    
    //validation method
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

    public static void saveList(TeamDAO userList, String filename) {
		//filewriter�
		try {
			Writer w = new FileWriter(filename);
			
			for (UserDAO item : userList.getList()) {
                if(item.getType()=="1"){
                    NormalUser i = new NormalUser(item.getName(), item.getID(), item.getPassword(), 1);
                    w.write(i.toSaveString());
                }
				else{
                    AdminUser i = new AdminUser(item.getName(), item.getID(), item.getPassword(), 0);
                    w.write(i.toSaveString());
                }
			}
			w.close();
			
			System.out.println("sucess save list");
		} catch (FileNotFoundException e) {
			System.out.println("file no exist\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void loadList(TeamDAO userList, String filename) {
        //bufferedreader, filereader, string tokenize
		try {
			BufferedReader  br = new BufferedReader(new FileReader(filename));
			String oneline;
			while((oneline = br.readLine()) != null) {
				// System.out.print((char) oneline);
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String name = st.nextToken();
				String id = st.nextToken();
				String password = st.nextToken();
				String type = st.nextToken();
				if(type.equals("1")) {
                    NormalUser user = new NormalUser(name, id, password, 1);
                    userList.addUser(user);
                }
                else {
                    AdminUser user = new AdminUser(name, id, password, 0);
                    userList.addUser(user);
                }
			}
			System.out.println("\n sucess loading data");
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("file no exist\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}