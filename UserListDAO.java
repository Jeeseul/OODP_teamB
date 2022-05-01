import java.util.ArrayList;

public class UserListDAO{
    private static ArrayList<UserDAO> UserList;
    
    public UserListDAO(){
        UserList = new ArrayList<UserDAO>();
    }

    public int addUser(UserDAO user){
        UserList.add(user);
        return 1; //success
    }

    public int updateUser(UserDAO user, UserDAO updated){
        int index = UserList.indexOf(user);
        UserList.remove(index);
        UserList.add(updated);
        return 1; //success
    }

    public int deleteUser(UserDAO user){
        UserList.remove(user);
        return 1; //success
    }

    public int indexOf(UserDAO user){
        return UserList.indexOf(user);
    }

    public int size(){
        return UserList.size();
    }

    public ArrayList<UserDAO> getList(){
        return new ArrayList<UserDAO>(UserList);
    }

    public void listAll(){
        System.out.println("**list all ***");
        for(UserDAO user : UserList){
            System.out.println(user.toString());
        }
    }

    public Boolean usDuplicate(String id){
        for(UserDAO user : UserList){
            if (id.equals(user.getID()) ) return true;
        }
        return false;
    }
}