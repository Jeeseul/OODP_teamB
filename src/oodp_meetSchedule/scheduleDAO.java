package oodp_meetSchedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class scheduleDAO {
	   private String title;
	   private String team;
	   private String current_date;
	   private String due_date;


	   public scheduleDAO(String title, String team, String due_date){
	       this.title=title;
	       this.team=team;
	       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	       Date date1 = new Date();        
	       this.current_date= dateFormat.format(date1);
	       this.setDue_date(due_date);
	   }
	    
	   public scheduleDAO(String title, String team, String date, String due_date){
	        this.title=title;
	        this.team=team;
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date1 = new Date();        
	        this.current_date= dateFormat.format(date1);
	        this.setDue_date(due_date);
	    }
	    
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getTeam() {
	        return team;
	    }

	    public void setTeam(String team) {
	        this.team = team;
	    }

	    public String getCurrent_date() {
	        return current_date;
	    }

	    public void setCurrent_date(String current_date) {
	        this.current_date = current_date;
	    }

		public String getDue_date() {
			return due_date;
		}

		public void setDue_date(String due_date) {
			this.due_date = due_date;
		}
		
		public String toSaveString() {
	    	return title + "##" + team + "##" + current_date + "##" + due_date + "\n";
	    }
}
