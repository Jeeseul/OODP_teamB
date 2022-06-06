package oodp_user;

import java.util.ArrayList;
import oodp_task.SubtaskDAO;

public class AdminUser extends UserDAO {
    private String name;
    private String ID;
    private String password;
    private int type;
    private int logincheck;
    private TagState tagstate;
    private ArrayList<SubtaskDAO> Tasks;

    public AdminUser(String name, String id, String password, int type) {
        this.name = name;
        this.ID = id;
        this.password = password;
        this.type = type;
        this.logincheck = 0;
        this.tagstate = new AttandState();
        Tasks = new ArrayList<SubtaskDAO>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getType() {
        return Integer.toString(type);
    }
    public void setType(int type){
        this.type = type;
    }
    public String getLogincheck() {
        return Integer.toString(logincheck);
    }
    public void setLogincheck(int logincheck){
        this.logincheck = logincheck;
    }
    public TagState getAttandance() {
        return tagstate;
    }
    public void setAttandance(TagState tagstate){
        this.tagstate = tagstate;
    }

    public ArrayList<SubtaskDAO> getTasks() {
        return Tasks;
    }
    public void setTasks(ArrayList<SubtaskDAO> tasks) {
        Tasks = tasks;
    }
    
    
    //add, update, delete task to Tasks
    public int addTask(SubtaskDAO task) {
        Tasks.add(task);
        return 1; //success
    }
    public int updateTask(SubtaskDAO task, SubtaskDAO updated) {
        int index = Tasks.indexOf(task);
        Tasks.remove(index);
        Tasks.add(updated);
        return 1; //success
    }
    public int deleteTask(SubtaskDAO task){
        Tasks.remove(task);
        return 1; //success
    }

    public void on_attand_pushed() {
        tagstate.on_attand_pushed(this);
    }
    public void on_absent_pushed() {
        tagstate.on_absent_pushed(this);
    }
    
    
    //referencing Tasks
    public int indexOf(SubtaskDAO task){
        return Tasks.indexOf(task);
    }
    public int size(){
        return Tasks.size();
    }
    
    //login & logout
    public int login(){
        this.logincheck = 1;
        return 1; //success
    }
    public int logout(){
        this.logincheck = 0;
        return 1; //success
    }

    //toString
    public String toString(){
        return "id : " + this.ID + ", name : " + this.name
            + ", password : " + this.password + ", type : " + this.type + ", attandance : " + tagstate.toString();
    }

    public String toSaveString() {
        return name + "##" + ID + "##" + password + "##" + type + "##" + tagstate.toString() + "\n";
    }
}