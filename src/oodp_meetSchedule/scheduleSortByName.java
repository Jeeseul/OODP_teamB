package oodp_meetSchedule;

import java.util.Comparator;

public class scheduleSortByName implements Comparator<scheduleRecord>{
	 @Override
	    public int compare(scheduleRecord o1, scheduleRecord o2) {
	        //return o1.getTitle().compareTo(o2.getTitle());
	        return 0;
	    }
}
