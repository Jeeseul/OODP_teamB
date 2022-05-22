package oodp_meetRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class recordDAO 
{
	   private String title;
	   private String desc;
	   private String current_date;
	   private String category;
	   private String due_date;


	   public recordDAO(String title, String desc, String category, String due_date){
	       this.title=title;
	       this.desc=desc;
	       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	       Date date1 = new Date();        
	       this.current_date= dateFormat.format(date1);
	       this.setCategory(category);
	       this.setDue_date(due_date);
	   }
	    
	   public recordDAO(String title, String desc, String date, String category, String due_date){
	        this.title=title;
	        this.desc=desc;
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date1 = new Date();        
	        this.current_date= dateFormat.format(date1);
	        this.setCategory(category);
	        this.setDue_date(due_date);
	    }
	    
	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }

	    public String getCurrent_date() {
	        return current_date;
	    }

	    public void setCurrent_date(String current_date) {
	        this.current_date = current_date;
	    }

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getDue_date() {
			return due_date;
		}

		public void setDue_date(String due_date) {
			this.due_date = due_date;
		}
		
		public String toSaveString() {
	    	return title + "##" + desc + "##" + current_date + "##" + category + "##" + due_date + "\n";
	    }

}
