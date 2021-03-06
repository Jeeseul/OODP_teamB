package oodp_user;

import java.util.ArrayList;
import oodp_task.SubtaskDAO;

public abstract class UserDAO {
    abstract public String getName();
    abstract public String getID();
    abstract public String getPassword();
    abstract public String getType();
    abstract public String getLogincheck();
    abstract public TagState getAttandance();
    abstract public ArrayList<SubtaskDAO> getTasks();
    
    //MUST BE IMPLEMENTED - not updated yet to GitHub
    abstract public int addTask(SubtaskDAO task);
    abstract public int updateTask(SubtaskDAO task, SubtaskDAO updated);
    abstract public int deleteTask(SubtaskDAO task);
    
    abstract public int indexOf(SubtaskDAO task);
    abstract public int size();
    
    abstract public int login();
    abstract public int logout();
    abstract public String toString();
    public void setState(AbsentState absentState) {
    }
    public void setState(AttandState attandState) {
    }
    public void on_attand_pushed() {
    }
    public void on_absent_pushed() {
    }
    public Object getTaskType() {
        return null;
    }
}