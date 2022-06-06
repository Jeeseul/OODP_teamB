package oodp_meetSchedule;

public abstract class abstractDAO {
	public abstract String getTitle();
	public abstract void setTitle(String title);
	public abstract String getCurrent_date();
	public abstract void setCurrent_date(String current_date);
	public abstract String toSaveString();
}
