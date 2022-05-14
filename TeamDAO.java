import java.util.ArrayList;

public class TeamDAO extends UserDAO{
    private String teamName;
    // 복수 개의 UserDAO를 가리킴
    private static ArrayList<UserDAO> UserList = new ArrayList<UserDAO>();

    // override methods, list all
    public String getName(){
        String res = "";
        for( UserDAO user : UserList)
            res += user.getName() + "\t";
        res += "\n";
        return res;
    }
    public String getID(){
        String res = "";
        for( UserDAO user : UserList)
            res += user.getID() + "\t";
        res += "\n";
        return res;
    }
    public String getPassword(){
        String res = "";
        for( UserDAO user : UserList)
            res += user.getPassword() + "\t";
        res += "\n";
        return res;
    }
    public String getType(){
        String res = "";
        for( UserDAO user : UserList)
            if(user.getType().equals("0"))
                res += "admin" + "\t\t";
            else
                res += "normal" + "\t\t";
        res += "\n";
        return res;
    }
    public String getLogincheck(){
        String res = "";
        for( UserDAO user : UserList)
            if(user.getLogincheck().equals("0"))
                res += "logout" + "\t\t";
            else
                res += "login" + "\t\t";
        res += "\n";
        return res;
    }
    public String toString(){
        String res = "";
        res += getName();
        res += getID();
        res += getPassword();
        res += getType();
        res += getLogincheck();
        return res;
    }

    // User을 UserList에 추가
    public void addUser(UserDAO user){
        UserList.add(user);
    }
    // User을 수정
    public void updateUser(UserDAO user, UserDAO updated){
        int index = UserList.indexOf(user);
        UserList.remove(index);
        UserList.add(updated);
    }
    // User을 UserList에서 제거
    public void deleteUser(UserDAO user){
        UserList.remove(user);
    }

    public int indexOf(UserDAO user){
        return UserList.indexOf(user);
    }
    public int size(){
        return UserList.size();
    }
    public Boolean usDuplicate(String id){
        for(UserDAO user : UserList){
            if (id.equals(user.getID()) ) return true;
        }
        return false;
    }
    public ArrayList<UserDAO> getList(){
        return UserList;
    }
    public int login(){
        return 0;
    }
    public int logout(){
        return 0;
    }
}