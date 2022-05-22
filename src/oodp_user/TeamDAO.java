package oodp_user;

import java.util.ArrayList;
import oodp_task.SubtaskDAO;

public class TeamDAO extends UserDAO implements NoticeObserver {
    private String teamName;
    // 복수 개의 UserDAO를 가리킴
    private static ArrayList<UserDAO> UserList = new ArrayList<UserDAO>();

    public TeamDAO() {
    	this.setTeamName("no named team");
    }
    public TeamDAO(String name) {
    	this.setTeamName(name);
    }
    
    //team name
    public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
    
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
            res += user.getType() + "\t";
        res += "\n";
        return res;
    }
    public String getLogincheck(){
        String res = "";
        for( UserDAO user : UserList)
            res += user.getLogincheck() + "\t";
        res += "\n";
        return res;
    }
    
	//toString
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
    public void setType(int type){}
    
    @Override
    public void updateNotification(String updateText) {
        System.out.println("변경된 공지 확인할 것!\n" + updateText);
        
    }
    
    @Override
    public int indexOf(SubtaskDAO task) {
        return 0;
    }
	@Override
	public ArrayList<SubtaskDAO> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int addTask(SubtaskDAO task) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateTask(SubtaskDAO task, SubtaskDAO updated) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteTask(SubtaskDAO task) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}