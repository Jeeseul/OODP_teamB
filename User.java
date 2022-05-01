import java.util.*;

public class User{
    private String name;
    private String ID;
    private String password;
    private int type;
    private int logincheck;
    private UserDAO userdao;
    //private AddTaskDAO addtaskdao;

    public User(String name, String id, String password, int type) {
        this.name = name;
        this.ID = id;
        this.password = password;
        this.type = type;
        this.logincheck = 0;
    }

    public int login(){
        this.logincheck = 1;
        return 1; //success
    }

    public int logout(){
        this.logincheck = 0;
        return 1; //success
    }

    public String getID(){
        return this.ID;
    }

    public String getPassword(){
        return this.password;
    }

    public UserDAO getList(){
        return this.userdao;
    }
}