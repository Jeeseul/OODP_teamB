package oodp_meetSchedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class scheduleDAO extends abstractDAO {
	   private String title;
	   private String team;
	   private String current_date;
	   private LocalDateTime due_date;


	   public scheduleDAO(String title, String team, LocalDateTime due_date){
	       this.title=title;
	       this.team=team;
	       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	       Date date1 = new Date();        
	       this.current_date= dateFormat.format(date1);
	       this.setDue_date(due_date);
	   }
	    
	   public scheduleDAO(String title, String team, String date, LocalDateTime due_date){
	        this.title=title;
	        this.team=team;
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date1 = new Date();        
	        this.current_date= dateFormat.format(date1);
	        this.setDue_date(due_date);
	    }
	   @Override
	    public String getTitle() {
	        return title;
	    }
	   @Override
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getTeam() {
	        return team;
	    }

	    public void setTeam(String team) {
	        this.team = team;
	    }
	    @Override
	    public String getCurrent_date() {
	        return current_date;
	    }
	    @Override
	    public void setCurrent_date(String current_date) {
	        this.current_date = current_date;
	    }

		public LocalDateTime getDue_date() {
			return due_date;
		}

		public void setDue_date(LocalDateTime due_date) {
			this.due_date = due_date;
		}
		@Override
		public String toSaveString() {
	    	return title + "##" + team + "##" + current_date + "##" + due_date + "\n";
	    }
		
		public String toString() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			return title + " : " + team + " : " + due_date.format(formatter) ;
		}
}
