package oodp_meetRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import oodp_meetSchedule.abstractDAO;

public class recordDAO extends abstractDAO
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
	    @Override
	    public String getTitle() {
	        return title;
	    }
	    @Override
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }
	    @Override
	    public String getCurrent_date() {
	        return current_date;
	    }
	    @Override
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
		@Override
		public String toSaveString() {
	    	return title + "##" + desc + "##" + current_date + "##" + category + "##" + due_date + "\n";
	    }


}
