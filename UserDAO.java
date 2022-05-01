import java.util.ArrayList;

public class UserDAO{
    private ArrayList<User> UserList;
    
    public UserDAO(){
        this.UserList = new ArrayList<User>();
    }

    public int addUser(User user){
        UserList.add(user);
        return 1; //success
    }

    public int updateUser(User user, User updated){
        int index = UserList.indexOf(user);
        UserList.remove(index);
        UserList.add(updated);
        return 1; //success
    }

    public int deleteUser(User user){
        UserList.remove(user);
        return 1; //success
    }

    public int indexOf(User user){
        return UserList.indexOf(user);
    }

    public int size(){
        return UserList.size();
    }
}